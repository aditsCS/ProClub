import java.net.*;
import javax.swing.*;

public class Chat extends JFrame {
	private static final long serialVersionUID = 1L;

	private ChatPanel chatPanel;
	private ServerPanel serverPanel;
	
	public Chat() {
		super("Chat");
		setBounds(100, 100, 400, 400);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(false);
	    
	    JTabbedPane tabPane = new JTabbedPane();
	    tabPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	    
	    serverPanel = new ServerPanel(this);
	    serverPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	    tabPane.add("Server", serverPanel);
	    
	    chatPanel = new ChatPanel();
	    chatPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	    tabPane.add("Client", chatPanel);
	    
	    add(tabPane);
	    
	    pack();
	    setVisible(true);
	}
		
	public ChatPanel getChatPanel () {
		return chatPanel;
	}
		
	public static void main(String[] args) throws UnknownHostException {
		Chat chat = new Chat();
        InetAddress thisIp = InetAddress.getLocalHost();
        String myIP = thisIp.getHostAddress();
        
        chat.serverPanel.setIPAddress(myIP);
        chat.chatPanel.setIPAddress(myIP);
	}
	
}
