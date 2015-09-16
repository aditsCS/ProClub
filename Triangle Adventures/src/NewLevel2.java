/* --Info--
 * Goes before Level2.
 * 
 * Name:
 * Assassination
 * 
 * Description:
 * The circles have found a way to sneak up behind you. Look out!
 * 
 * Hint:
 * Try looking through the documentation and see what you can find.
 * 
 */
public class NewLevel2 implements Level {

	@Override
	public void load(World world, Player player) {
		world.add(player, 3, 2);
		world.add(new Enemy(), 1, 2);
		
	}

}
