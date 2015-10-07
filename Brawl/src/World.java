import java.awt.Graphics2D;
import java.util.ArrayList;

public class World {
	
	private Player player;
	private Enemy enemy; 
	// Try making an ArrayList of Enemies, like below
	private ArrayList<Block> blocks;
	private ArrayList<Projectile> fireballs;
	
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
		
		// blocks! The two numbers are x, y
		blocks = new ArrayList<Block>();
		blocks.add(new Block(100, 100));
		blocks.add(new Block(100, 200));
		blocks.add(new Block(100, 300));
		blocks.add(new Block(200, 400));
		blocks.add(new Block(300, 400));
		blocks.add(new Block(400, 400));
		// try adding more blocks!
		
		// fireballs
		fireballs = new ArrayList<Projectile>();
		fireballs.add(new Projectile(0, 0, 1));
	
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
		
		// loop through each fireball and draw it		
		for (Projectile fireball : fireballs) {
			fireball.draw(g);
		}
	}

	/**
	 * Call act() on everything
	 */
	public void act() {
		// Loops through each block
		for (Block b : blocks) {
			// example of using isPointInImage for collision detection
			if (b.isPointInImage(player.getX(), player.getY()) ||
					player.isPointInImage(b.getX(), b.getY())) {
				System.out.println("Mario hit a block");
			}
		}
		
		// Loop through Projectiles
		for (Projectile fireball : fireballs) {
			// take a look in the act() method of Projectile
			fireball.act(); 
			// example of using isPointInImage for collision detection
			if (fireball.isPointInImage(player.getX(), player.getY()) ||
				player.isPointInImage(fireball.getX(), fireball.getY())) {
				System.out.println("Fireball hit Mario");
			}
			
		}
	}
	
	/**
	 * Specify what should happen when keys are pressed
	 */
	public void keyPressed() {
		/*
		 * Do the same thing as below for downPressed and 
		 * upPressed so that Mario can move properly!
		 */
		if (GamePanel.leftPressed) {
			// Move left
			player.moveBy(-10, 0);
		}
		if (GamePanel.rightPressed) {
			// Move right
			player.moveBy(10, 0);
		}
		if (GamePanel.spacePressed) {
			GamePanel.spacePressed = false;
			// Shoot a fireball!
		}
	}
	
}
