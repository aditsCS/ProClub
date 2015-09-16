import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	public static final int STEP = 500;

	private JFrame frame;
	private JPanel cardPanel;

	public Main () {}

	public void run () {
		final World world = new World();
		final Player player = new Player();
		final Gui gui = new Gui(world);

		// change the level number to change levels
		final Level level = new Level10();
		level.load(world, player);

		frame = showGui(gui);
		startLoop(world, gui);

		commandPlayer(player);
	}

	public void commandPlayer (Player player) {
		// Player commands go here
		for(int i=0; i<6; i++){
			for(int j=0; j<7; j++){
				player.move();
			}
			player.turnRight();
		}
		

	}

	@SuppressWarnings("serial")
	public JFrame showGui(final Gui gui) {
		return new JFrame("Triangle Adventures") {{
		    cardPanel = new JPanel();
		    CardLayout cl = new CardLayout();
		    cardPanel.setLayout(cl);

		    cardPanel.add(gui, "1");

			add(cardPanel);
			pack();
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
		}};
	}

	public void changePanel(String panel) {
		((CardLayout)cardPanel.getLayout()).next(cardPanel);
		frame.requestFocus();
	}

	public void startLoop(final World world, final Gui gui) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (world.isActive()) {
					gui.repaint();

					try {
						Thread.sleep(STEP);
					} catch (InterruptedException e) { e.printStackTrace(); }

					world.step();
				}
			}
		}).start();
	}

	public static void main(String[] args) {
		final Main m = new Main();
		m.run();
	}
}
