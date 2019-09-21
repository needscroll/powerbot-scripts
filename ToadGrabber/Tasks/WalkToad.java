package needscroll.ToadGrabber.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;

import needscroll.ToadGrabber.Task;

public class WalkToad extends Task{

	public WalkToad(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		Tile whole1 = new Tile(2471, 3409, 0); // tree stronghold area
		Tile whole2 = new Tile(2396, 3523, 0);
		Area whole_area = new Area(whole1, whole2);
		
		Tile toad = new Tile(2419, 3510, 0); // area for toads
		Tile toad1 = new Tile(2430, 3506, 0);
		Tile toad2 = new Tile(2406, 3521, 0);
		Area toad_area = new Area(toad1, toad2);
		
		return whole_area.contains(ctx.players.local()) && ctx.backpack.select().count() != 28 && !toad_area.contains(ctx.players.local());
	}

	@Override
	public void execute() 
	{
		Tile toad = new Tile(2419, 3510, 0); // area for toads
		
		ctx.movement.step(toad.tile());
		Condition.sleep(1000);
		while(ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
	}

}
