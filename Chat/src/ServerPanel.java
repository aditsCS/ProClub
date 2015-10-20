import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

import networking.SchoolServer;

public class ServerPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JLabel ipLabel;
	private JButton startBtn, closeBtn;
	private SchoolServer serverHandler;
	private Chat window;
	
	public ServerPanel(Chat w) {
		super();
		setFocusable(true);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		window = w;
		
        JPanel serverPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel ipPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

		ipLabel = new JLabel("IP Address:");
		ipPanel.add(ipLabel);
		
		startBtn = new JButton("Start Server");
		closeBtn = new JButton("Close Server");
		closeBtn.setEnabled(false);
		
		serverPanel.add(startBtn);
		serverPanel.add(closeBtn);
		add(ipPanel);
		add(serverPanel);

		startBtn.addActionListener(this);
		closeBtn.addActionListener(this);
		setVisible(true);
	}
		
	public void handleConnectionChange (boolean started) {
		startBtn.setEnabled(!started);
		closeBtn.setEnabled(started);
	}
	
	public void setIPAddress(String ip) {
		ipLabel.setText("IP Address: " + ip);
	}
	
	public void runServer() {
		serverHandler = new SchoolServer();
		serverHandler.register(window.getChatPanel());
        
        try {
        	serverHandler.run();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startBtn) {
			handleConnectionChange(true);
			runServer();
		} else if (e.getSource() == closeBtn) {
			serverHandler.close();
			handleConnectionChange(false);
		}
	}

}
