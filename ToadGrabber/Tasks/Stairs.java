package needscroll.ToadGrabber.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;

import needscroll.ToadGrabber.Task;

public class Stairs extends Task{
	
	final static int STAIR = 69505;

	public Stairs(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() 
	{
		Tile tree = new Tile(2444, 3433, 0); // area for tree bank stairs
		Tile tree1 = new Tile(2441, 3437, 0);
		Tile tree2 = new Tile(2450, 3429, 0);
		Area tree_area = new Area(tree1, tree2);
		
		return ctx.backpack.select().count() == 28 && tree_area.contains(ctx.players.local());
	}

	@Override
	public void execute() 
	{
		GameObject stairs = ctx.objects.select().id(STAIR).nearest().poll();
		
		if (!stairs.inViewport())
		{
			ctx.camera.turnTo(stairs.tile());
		}
		
		stairs.interact("Climb-up");
		Condition.sleep(1000);
		while(ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
	}

}
