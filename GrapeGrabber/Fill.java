package needscroll.GrapeGrabber;

import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GroundItem;
import org.powerbot.script.rt6.Interactive;
import org.powerbot.script.rt6.Item;

public class Fill extends ClientAccessor{
	
	private int GRAPES = 1987;
	private int APPLES = 1955;
	final int[] bounds = {-64, 64, -500, -400, -64, 64};
	
	public Fill(ClientContext ctx)
	{
		super(ctx);
	}
	
	public void run_fill(int floor, Getstate current, int[] tracking, String itemsgrabbing)
	{
		Travel move = new Travel(ctx);
		Camera cam = new Camera(ctx);
		
		if (current.bad_cam_default())
		{
			cam.fix_cam("default");
		}
		
		if (floor == 0)
		{
			move.goup();
		}
		
		if (floor == 1)
		{
			take_second_floor(current, tracking);
			move.goup();
			take_third_floor(current, tracking);
			move.godown();
			
			while (!exist(APPLES))
			{
				Condition.sleep(10000);
			}
		}
		if (floor == 2)
		{
			take_third_floor(current, tracking);
			move.godown();
			take_second_floor(current, tracking);
			move.goup();
			
			while (!exist(APPLES) || !exist(GRAPES))
			{
				Condition.sleep(10000);
			}
		}
	}
	
	private void take_second_floor(Getstate current, int[] tracking)
	{
		Item[] inv = ctx.backpack.items();
		
		while (current.empty_spaces(inv) > 0 && exist(APPLES))
		{
			take_item(APPLES);
			inv = ctx.backpack.items();
			tracking[1]++;
			Condition.sleep(500);
		}
		System.out.println("done");
	}
	
	private void take_third_floor(Getstate current, int[] tracking)
	{
		Item[] inv = ctx.backpack.items();
		
		while (current.empty_spaces(inv) > 0 && (exist(APPLES) || exist(GRAPES)))
		{
			take_item(GRAPES);
			inv = ctx.backpack.items();
			tracking[0]++;
			
			if (current.empty_spaces(inv) > 0 && (exist(APPLES) || exist(GRAPES)))
			{
				take_item(APPLES);
				inv = ctx.backpack.items();
				tracking[1]++;
			}
		}
		System.out.println("done");
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
}