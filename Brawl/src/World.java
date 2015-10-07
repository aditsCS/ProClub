import java.awt.Graphics2D;
import java.util.ArrayList;

public class World {
	
	private Player player;
	private Enemy enemy; 
	// You can also make an ArrayList of Enemies, like the Blocks below
	private ArrayList<Block> blocks;
	
	public World() {
		setup();
	}
	
	/**
	 * Setup everything
	 */
	public void setup() {
		// constructor arguments: x, y, direction
		player = new Player(400, 200, 2);
		enemy = new Enemy(500, 400, 2);
		
		// blocks
		blocks = new ArrayList<Block>();
		blocks.add(new Block(100, 100));
		blocks.add(new Block(100, 200));
		blocks.add(new Block(100, 300));
		blocks.add(new Block(200, 400));
		blocks.add(new Block(300, 400));
		blocks.add(new Block(400, 400));
		// try adding more blocks!
	}
	
	/**
	 * Draw everything
	 */
	public void draw(Graphics2D g) {
		player.draw(g);
		enemy.draw(g);
		
		// loop through each block and draw it
		for (Block b : blocks) {
			b.draw(g);
		}
	}

	/**
	 * Call act() on everything
	 */
	public void act() {
		// Loops through each block
		for (Block b : blocks) {
			// example of using isPointInImage for collision detection
			if (b.isPointInImage(player.getX(), player.getY())) {
				System.out.println("Mario hit a block");
			}
		}
	}
	
	/**
	 * Specify what should happen when keys are pressed
	 */
	public void keyPressed() {
		/*
		 * Do the same thing as below for downPressed, 
		 * rightPressed, and spacePressed.
		 */
		if (GamePanel.leftPressed) {
			// Move left
			player.moveBy(-10, 0);
		}
		if (GamePanel.upPressed) {
			// Move up
			player.moveBy(0, -10);
		}
	}
	
}
