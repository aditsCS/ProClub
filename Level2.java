/* ---IMPORTANT, OPEN ME---
 * 
 * Goes right after Level 1.
 * 
 * Name:
 * Farther back!
 * 
 * Description:
 * The circle has moved farther back. Annihilate it!
 * 
 * Hint:
 * Do what you did last level!
 * 
 */
public class NewLevel1 implements Level {

	@Override
	public void load(World world, Player player) {
		world.add(player, 1, 2);
		world.add(new Enemy(), 6, 4);
		
	}

}
