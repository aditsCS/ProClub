
public class Projectile extends MovingImage {

	private int direction; //0 is north, clockwise from there
	
	public Projectile(int x, int y, int dir) {
		super("mario.png", x, y, 100, 132);
		direction = dir;
	}
	
	public void act() {
		// Projectiles should continue moving
		moveBy(1, 0);
	}
	
}
