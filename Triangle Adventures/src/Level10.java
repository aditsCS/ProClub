
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
	}

}
