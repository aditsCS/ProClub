
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;import javax.swing.ImageIcon;
 
public class MovingImage {
	
	private int x, y;
	private int width, height;
	private Image image;
		
	public MovingImage(String imageFilename, int x, int y, int w, int h) {
		image = (new ImageIcon(imageFilename)).getImage();
		this.x = x;
		this.y = y;
		width = w;
		height = h;
	}

	/*
	 * Moves image by an amount
	 */
	public void moveBy(int x, int y) {
		this.x += x;
		this.y += y;
	}
	
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/*
	 * Draws the image
	 */
	public void draw(Graphics2D g) {
		g.drawImage(image, x, y, width, height, null);
	}
	
	/*
	 * Any actions that will continuous need to be done
	 */
	public void act() {
		
	}

	/*
	 * Collision detection
	 * Returns true if the x,y point passed in is inside of this image.
	 */
	public boolean isPointInImage(int xCoord, int yCoord) {
		if (xCoord >= x && yCoord >= y && xCoord <= x + width && yCoord <= y + height)
			return true;
		return false;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
}