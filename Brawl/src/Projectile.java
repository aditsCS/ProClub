
public class Projectile extends MovingImage {

	// 0 = up, 1 = right, 2 = down, 3 = left
	private int direction;
	
	public Projectile(int x, int y, int dir) {
		super("fireball.png", x, y, 50, 50);
		direction = dir;
	}
	
	public void act() {
		/*
		 * Projectiles should continue moving!
		 * Right now, it always goes to the right.
		 * Try checking the direction to determine which way it should go!
		 */
		moveBy(15, 0);
	}
	
}
