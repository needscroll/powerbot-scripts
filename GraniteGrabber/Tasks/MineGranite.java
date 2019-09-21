package needscroll.GraniteGrabber.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.Item;

import needscroll.GraniteGrabber.Task;

public class MineGranite extends Task{
	
	final static int GRANITE_ROCK[] = {10947};
	final static int PORTERS[] = {29277, 29278};
	final static int PORTER_W = 29278;
	public static int COLLECTED = 0;

	public MineGranite(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		Item porter = ctx.backpack.select().id(PORTERS).poll();
		Component porter_w = ctx.widgets.widget(1464).component(15).component(17);
		boolean pass = porter.valid() || porter_w.itemId() == PORTER_W;
		
		Tile granite = new Tile(3171, 2911, 0); // granite quarry area
		Tile granite1 = new Tile(3162, 2923, 0);
		Tile granite2 = new Tile(3181, 2900, 0);
		Area granite_area = new Area(granite1, granite2);
		
		return granite_area.contains(ctx.players.local()) && pass && idling();
	}
	
	@Override
	public void execute()
	{
		Item porter = ctx.backpack.select().id(PORTERS).poll();
		Component porter_w = ctx.widgets.widget(1464).component(15).component(17);
		
		if (porter_w.itemId() == PORTER_W)
		{
			mine();
		}
		if (!(porter_w.itemId() == PORTER_W) && porter.valid())
		{
			porter.interact("Wear");
			Condition.sleep(1200);
		}
	}
	
	private void mine()
	{
		GameObject rock = ctx.objects.select().id(GRANITE_ROCK).nearest().poll();
		
		if (!rock.inViewport())
		{
			ctx.camera.turnTo(rock.tile());
		}
		
		rock.interact("Mine");
		Condition.sleep(2000);
		COLLECTED++;
	}
	
	private boolean idling()
	{
		boolean idle = true;
		
		for (int counter = 0; counter < 2; counter++)
		{
			if (ctx.players.local().inMotion() || ctx.players.local().animation() == 624)
			{
				idle = false;
			}
		}
		
		return idle;
	}
	
	public int get_collected()
	{
		return COLLECTED;
	}
	
}
