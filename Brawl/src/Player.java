import java.awt.Image;

public class Player extends MovingImage {
	
	private int direction; 	// 0 = up, 1 = right, 2 = down, 3 = left
	private int maxHealth, currentHealth;
		
	/*
	 * Basic constructor
	 */
	public Player(int x, int y, int dir) {
		super("mario.png", x, y, 100, 132);
		direction = dir;
	}
	
	/*
	 * Constructor with health
	 */
	public Player(int x, int y, int dir, int health) {
		super("mario.png", x, y, 100, 132);
		direction = dir;
		maxHealth = currentHealth = health;
	}

	public void changeHealthBy(int health){
		currentHealth += health;
	}
	
	public double calcHealthPercentage(){
		return (double)currentHealth/maxHealth;
	}
	
	public void turn(int shift) {
		direction += shift;
		direction %= 4;
		if(direction < 0)
			direction = 3;
	}
	
	
}
