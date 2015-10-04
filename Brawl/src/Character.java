import java.awt.Image;

public class Character extends MovingImage{
	
	private int direction; //0 is north, clockwise from there
	
	public Character(Image image, int x, int y, int width, int height, int dir){
		super(image, x, y, width, height);
		direction = dir;
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
	
}
