package needscroll.ToadGrabber.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GroundItem;
import needscroll.ToadGrabber.Task;

public class Gather extends Task{
	
	final static int TOAD = 2150;
	public static int AMOUNT = 0;

	public Gather(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() 
	{
		Tile toad = new Tile(2419, 3510, 0); // area for toads
		Tile toad1 = new Tile(2430, 3506, 0);
		Tile toad2 = new Tile(2406, 3521, 0);
		Area toad_area = new Area(toad1, toad2);
		
		return ctx.backpack.select().count() < 28 && toad_area.contains(ctx.players.local());
	}

	@Override
	public void execute()
	{
		GroundItem toad = ctx.groundItems.select().id(TOAD).nearest().poll();
		
		if (!toad.inViewport())
		{
			ctx.camera.turnTo(toad.tile());
		}
		
		toad.interact("Take");
		Condition.sleep(1000);
		while(ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
		AMOUNT++;
	}
	
	public int get_amount()
	{
		return AMOUNT;
	}
}
