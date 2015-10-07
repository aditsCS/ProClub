import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Game extends JFrame {

	public Game(String title) {
		super(title);
		setBounds(100, 0, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(false);
	    GamePanel game = new GamePanel();
	    add(game);
	    setVisible(true);
	}

	public static void main(String[] args) {
		Game w = new Game("Game");
	}

}