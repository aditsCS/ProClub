import javax.swing.JFrame;

public class Main extends JFrame {

	public Main(String title) {
		super(title);
		setBounds(100, 0, 500, 500);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(false);
	    GamePanel game = new GamePanel();
	    add(game);
	    setVisible(true);
	}

	public static void main(String[] args) {
		Main w = new Main("Game");
	}

}