import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ServerPanel extends JPanel implements ActionListener {
	
	private JLabel ipLabel;
	private JButton startBtn, closeBtn;
	
	public ServerPanel() {
		super();
		setFocusable(true);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		ipLabel = new JLabel("IP Address:");
		add(ipLabel);
		
		startBtn = new JButton("Start Server");
		add(startBtn);
		
		closeBtn = new JButton("Close Server");
		add(closeBtn);
		
		setVisible(true);
	}
	
	public void setIPAddress(String ip) {
		ipLabel.setText("IP Address: "+ip);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startBtn) {
			// start server
		}
		if (e.getSource() == closeBtn) {
			// close server
		}
	}

}
