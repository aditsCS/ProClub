import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

public class ChatPanel extends JPanel implements ActionListener {
	
	private JTextField ipField, usernameField;
	private JButton connectBtn;
	
	private JScrollPane scrollPane; 
	private JTextPane msgPane;
	private JTextField inputField;
	private JButton sendBtn;
	
	public ChatPanel() {
		super();
		setFocusable(true);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// Input boxes to specify ip address to connect to
		ipField = new JTextField("IP Address (ex: 127.0.0.1)");
		add(ipField);
		usernameField = new JTextField("Username");
		add(usernameField);
		connectBtn = new JButton("Connect to Server");
		add(connectBtn);
			
		// Main box that displays messages
		msgPane = new JTextPane();
		msgPane.setPreferredSize(new Dimension(400, 200));
		scrollPane = new JScrollPane(msgPane);
		add(scrollPane);
		
		// Input box to send messages
		inputField = new JTextField();
		add(inputField);
		sendBtn = new JButton("Send Message");
		add(sendBtn);
	    
		setVisible(true);		
	}
	
	public void appendMessage(String username, String message) {
		StyledDocument doc = msgPane.getStyledDocument();
		int docEnd = doc.getLength();
		try {
			doc.insertString(docEnd, username+": "+message+"\n", null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == connectBtn) {
			// connect to server
		}
		if (e.getSource() == sendBtn) {
			// send message 
			
			// clear input field after sending
			inputField.setText("");
		}
	}
	
	

}
