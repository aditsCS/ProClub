import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
	
	private final int FPS = 30;

	private World world;
	static boolean leftPressed, rightPressed, upPressed, downPressed, spacePressed;
	
	public GamePanel() {
		super();
		setFocusable(true);
		setPreferredSize(new Dimension(800, 600));
		addKeyListener(this);

		world = new World();
		
		// Game loop
		Timer clock = new Timer(1000 / FPS, this);
		clock.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		world.draw(g2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		world.keyPressed();
		world.act();
		repaint();
	}

	/**
	 * Runs once when a key is pressed down.
	 * getKeyCode() checks which key is pressed.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			leftPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rightPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			upPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			downPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			spacePressed = true;
		}
	}

	/**
	 * Runs when a key is released
	 * getKeyCode() checks which key is pressed
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			leftPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rightPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			upPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			downPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			spacePressed = false;
		}
	}

	// Unneeded method
	@Override
	public void keyTyped(KeyEvent e) { }
		
}
