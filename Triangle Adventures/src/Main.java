import javax.swing.JFrame;

public class Main {

	public static final int STEP = 500;

	public static void main(String[] args) {
		final World world = new World();
		final Player player = new Player();
		final Gui gui = new Gui(world);

		// change the level number to change levels
		final Level level = new Level9();
		level.load(world, player);

		showGui(gui);
		startLoop(world, gui);

		// Player commands go here
		player.move();
		player.attack();
	}

	@SuppressWarnings("serial")
	public static JFrame showGui(final Gui gui) {
		return new JFrame("Triangle Adventures") {{
			add(gui);
			pack();
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
		}};
	}

	public static void startLoop(final World world, final Gui gui) {
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

}
