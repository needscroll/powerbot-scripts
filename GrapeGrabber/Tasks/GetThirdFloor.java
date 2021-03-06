package needscroll.GrapeGrabber.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.GroundItem;
import org.powerbot.script.rt6.Interactive;

import needscroll.GrapeGrabber.Task;

public class GetThirdFloor extends Task{
	
	final static int GRAPES = 1987;
	final static int APPLES = 1955;
	private int[] STAIRS = {24073, 24074, 24075};
	final int[] bounds = {-64, 64, -500, -400, -64, 64};
	public static int grapes_collected = 0;
	public static int apples_collected = 0;

	public GetThirdFloor(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		return ctx.backpack.select().count() != 28 && ctx.players.local().tile().floor() == 2 && (exist(GRAPES) || exist(APPLES));
	}

	@Override
	public void execute() {
		while (ctx.backpack.select().count() < 28 && (exist(APPLES) || exist(GRAPES)))
		{
			take_item(GRAPES);
			grapes_collected++;
			
			if (ctx.backpack.select().count() < 28 && (exist(APPLES) || exist(GRAPES)))
			{
				take_item(APPLES);
				apples_collected++;
			}
		}
		godown();
	}

	private void take_item(int id)
	{
		GroundItem thing = ctx.groundItems.select().id(id).each(Interactive.doSetBounds(bounds)).poll();

		thing.interact("Take");
		Condition.sleep(1500);
		while (ctx.players.local().inMotion() || ctx.players.local().animation() == 832)
		{
			Condition.sleep(1000);
		}
	}
	
	private boolean exist(int id)
	{
		boolean does = false;
		GroundItem thing = ctx.groundItems.select().id(id).nearest().poll();
		
		if (thing.inViewport())
		{
			does = true;
		}
		
		return does;
	}
	
	public void godown()
	{
		GameObject stairs = ctx.objects.select().id(STAIRS).nearest().poll();
		stairs.interact("Climb-down");
		Condition.sleep(3000);
	}
	
	public int get_grapes()
	{
		return apples_collected;
	}
	
	public int get_apples()
	{
		return grapes_collected;
	}
}
