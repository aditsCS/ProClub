import java.awt.Dimension;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class World {
	
	// private Player player, etc
	
	public World() {
		setup();
	}
	
	/**
	 * Setup everything
	 */
	public void setup() {
		// player = new Player(x, y), etc
	}
	
	/**
	 * Draw everything
	 */
	public void draw(Graphics2D g) {
		// player.draw(g), etc
	}

	/**
	 * Update everything
	 */
	public void update() {
		// player.update(), etc
	}
	
	/**
	 * Specify what should happen when keys are pressed
	 */
	public void keyPressed() {
		if (GamePanel.leftPressed) {
			// Move left
		}
		if (GamePanel.rightPressed) {
			// Move right
		}
		/*
		 * Do the same thing as above for upPressed, downPressed,
		 * and spacePressed.
		 */
	}
	
}
