package needscroll.StarterPack2;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Interactive;

public class Obstacle {
	
	public int id;
	public String interact_string;
	public Tile tile;
	int[] bounds;
	int[] default_bounds = {-32, 32, -64, 0, -32, 32};
	
	public Obstacle(int id, Tile tile, String interact_string)
	{
		this.id = id;
		this.tile = tile;
		this.interact_string = interact_string;
		bounds = default_bounds;
	}
	
	public Obstacle(int id, Tile tile, String interact_string, int[] bounds)
	{
		this.id = id;
		this.tile = tile;
		this.interact_string = interact_string;
		this.bounds = bounds;
	}
	
	public void clear_obstacle(ClientContext ctx)
	{
		GameObject object = ctx.objects.select().id(id).each(Interactive.doSetBounds(bounds)).nearest().poll();
		object.interact(interact_string);
	}
	
	public boolean obstacle_valid(ClientContext ctx)
	{
		GameObject object = ctx.objects.select().id(id).nearest().poll();
		return object.valid() && object.tile().equals(tile);
	}
	
	

}
