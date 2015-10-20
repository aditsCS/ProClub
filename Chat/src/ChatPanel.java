import interfaces.*;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.net.Socket;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

import networking.NetworkMessage;
import networking.SchoolClient;
import networking.SchoolServer;

public class ChatPanel extends JPanel implements ActionListener, NetworkGUI {
	private static final long serialVersionUID = 1L;

	private JTextField ipField, usernameField;
	private JButton connectBtn, disconnectBtn;
	
	private JScrollPane scrollPane; 
	private JTextPane msgPane;
	private JTextField inputField;
	private JButton sendBtn;
	
	private SchoolClient clientHandler;
	private String ipAddress;

	public ChatPanel() {
		super();
		setFocusable(true);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// Input boxes to specify ip address to connect to
        JPanel connectPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
		ipField = new JTextField("IP Address (ex: 127.0.0.1)");
		add(ipField);
		usernameField = new JTextField("Username");
		add(usernameField);
		
		connectBtn = new JButton("Connect to Server");
		connectPanel.add(connectBtn);
		disconnectBtn = new JButton("Disconnect from Server");
		disconnectBtn.setEnabled(false);
		connectPanel.add(disconnectBtn);
		add(connectPanel);
			
		// Main box that displays messages
		msgPane = new JTextPane();
		msgPane.setPreferredSize(new Dimension(400, 200));
		scrollPane = new JScrollPane(msgPane);
		add(scrollPane);
		
		// Input box to send messages
		inputField = new JTextField();
		add(inputField);
		sendBtn = new JButton("Send Message");
		sendBtn.setEnabled(false);
		add(sendBtn);
	    
		sendBtn.addActionListener(this);
		connectBtn.addActionListener(this);
		disconnectBtn.addActionListener(this);
		setVisible(true);
	}
	
	public void appendMessage(String message) {
		StyledDocument doc = msgPane.getStyledDocument();
		int docEnd = doc.getLength();
		try {
			doc.insertString(docEnd, message, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void handleConnectionChange (boolean connected, String msg) {
		if (!msg.equals("")) {
			appendMessage("---- "+ msg +" ----\n");
		}

		sendBtn.setEnabled(connected);
		connectBtn.setEnabled(!connected);
		disconnectBtn.setEnabled(connected);
		usernameField.setEnabled(!connected);
		ipField.setEnabled(!connected);
	}
	
	public void receive (Serializable s) {
		NetworkMessage msg = (NetworkMessage)s;
		
		if (msg.getClose()) {
			handleConnectionChange(false, "Server Disconnected Connection!");
			return;
		}
		
		String username = msg.getName();
		String message = msg.getMessage();

		appendMessage(username +": "+message+"\n");
	}
	
	public Socket connectClient (String host) {
		clientHandler = new SchoolClient();
        Socket res = clientHandler.connect(host);
        
        return res;
	}
	
    public void runClient (Socket res, String host) {
         if (res == null) {
             appendMessage("---- Could not connect to " + host + "! ----\n");
             return;
         } else {
             appendMessage("---- Connected to " + host + "! ----\n");
                          
             clientHandler.register(this);
             clientHandler.run(res);
         }
	}
    
    public void setIPAddress (String ip) {
		ipAddress = ip;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == connectBtn) {
			// connect to server
			Socket res = connectClient(ipField.getText());
			if (res != null) {
				msgPane.setText("");
				handleConnectionChange(true, "Connected Opened!");
				
				runClient(res, ipField.getText());
			}
		} else if (e.getSource() == disconnectBtn) {
			clientHandler.close();
			
			handleConnectionChange(false, "Connection Closed!");
		} else if (e.getSource() == sendBtn) {
			// send message 
			clientHandler.send(new NetworkMessage(inputField.getText(), ipAddress, usernameField.getText()));
			//append to the chat log
			appendMessage(usernameField.getText() +": "+inputField.getText()+"\n");
			// clear input field after sending
			inputField.setText("");
		}
	}
	
	

}
