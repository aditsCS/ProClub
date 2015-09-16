/*
 * Level goes after 3
 * 
 * Name: More Running Around
 * 
 * Description: The circles are hiding inside a dizzying maze.  Go find it and kill it!
 * 
 * Hint: You can have multiple loops in a single program.
 * 
 */
public class NewLevel3 implements Level {

	@Override
	public void load(World world, Player player) {
		world.add(player, 1, 1);
		world.add(new Enemy(), 5, 3);
		
		for(int i = 0; i <= 7; i++){
			world.add(new Wall(), i, 0);
		}
		
		for(int i = 0; i <= 6; i++){
			world.add(new Wall(), i, 2);
		}
		
		world.add(new Wall(), 6, 3);
		
		for(int i = 1; i <= 6; i++){
			world.add(new Wall(), i, 4);
		}
		
	}

}
