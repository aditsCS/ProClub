
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Chat extends JFrame {

	private ChatPanel chatPanel;
	private ServerPanel serverPanel;
	
	public Chat() {
		super("Chat");
		setBounds(100, 100, 400, 400);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(false);
	    
	    JTabbedPane tabPane = new JTabbedPane();
	    tabPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	    
	    serverPanel = new ServerPanel();
	    serverPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	    tabPane.add("Server", serverPanel);
	    
	    chatPanel = new ChatPanel();
	    chatPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	    tabPane.add("Client", chatPanel);
	    
	    add(tabPane);
	    
	    pack();
	    setVisible(true);		
	}
	
	public static void main(String[] args) {
		Chat chat = new Chat();
		for(int i=0; i<20; i++)
			chat.chatPanel.appendMessage("Username", "message");
	}
	
}
