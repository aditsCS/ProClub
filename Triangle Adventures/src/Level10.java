<<<<<<< Updated upstream

public class Level10 implements Level{
	public int[] KEY_LOC = new int[]{1 + (int)(Math.random() * ((2 - 1) + 1)), 0 + (int)(Math.random() * ((5 - 0) + 1))};
	public int[] DOOR_LOC = new int[]{3,2};
	public int[] ENEMY_LOC = new int[]{4 + (int)(Math.random() * ((7 - 4) + 1)), 0 + (int)(Math.random() * ((5 - 0) + 1))};

	@Override
	public void load(World world, Player player) {
		world.add(new Player(), 0, 3);
		for(int i = 0; i < 6; i++){
			world.add(new Wall(), 3, i);
		}
		world.add(new Door(), 3, 2);
		world.add(new Key(), KEY_LOC[0], KEY_LOC[1]);
		world.add(new Enemy(), ENEMY_LOC[0], ENEMY_LOC[1]);
=======
public class Level10 implements Level {

	@Override
	public void load(World world, Player player) {
		world.add(player, 0, 0);
		for(int i = 0; i<7; i++)
			world.add(new Wall(), i, 1);
		for(int i = 2; i < 5; i++)
			world.add(new Wall(), 6, i);
		for(int i = 1; i < 6; i++)
			world.add(new Wall(), i, 4);
		world.add(new Wall(), 1, 3);
		world.add(new Wall(), 3, 2);
		world.add(new Enemy(), 5, 2);

>>>>>>> Stashed changes
	}

}
