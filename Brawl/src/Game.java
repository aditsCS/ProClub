import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Game extends JFrame {

	public Game(String title) {
		super(title);
		setBounds(100, 0, 500, 500);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(false);
	    GamePanel game = new GamePanel();
	    add(game);
	    setVisible(true);
	}

	public static void main(String[] args) {
		Game w = new Game("Game");
		Player test = new Player("text.png", 10, 10, 50, 100, 0, 20);
		test.changeHealthBy(-2);
		System.out.println("%" + test.calcHealthPercentage());
	}

}