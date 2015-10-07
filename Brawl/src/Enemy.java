
public class Enemy extends MovingImage {

	private int direction; //0 is north, clockwise from there
	private int health;
	
	public Enemy(int x, int y, int dir) {
		super("goomba.png", x, y, 100, 119);
		direction = dir;
	}
	
	public void turn(int shift) {
		direction += shift;
		direction %= 4;
		if(direction < 0)
			direction = 3;
	}
	
	public int getHealth() {
		return health;
	}
	
}
