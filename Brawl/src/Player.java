import java.awt.Image;

public class Player extends MovingImage{
	
	private int direction; //0 is north, clockwise from there
	private int maxHealth, currentHealth;
	
	public Player(Image image, int x, int y, int width, int height, int dir){
		super(image, x, y, width, height);
		direction = dir;
		maxHealth = currentHealth = 0;
	}
	
	public Player(String imageFile, int x, int y, int width, int height, int dir, int health){
		super(imageFile, x, y, width, height);
		direction = dir;
		maxHealth = currentHealth = health;
	}
	
	public void move(int x, int y){
		moveBy(x, y);
	}
	
	public void turn(int shift){
		direction += shift;
		direction %= 4;
		if(direction < 0)
			direction = 3;
	}
	public void changeHealthBy(int health){
		currentHealth += health;
	}
	public double calcHealthPercentage(){
		return (double)currentHealth/maxHealth;
	}
}
