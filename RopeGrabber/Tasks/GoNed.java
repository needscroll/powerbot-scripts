package needscroll.RopeGrabber.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Interactive;
import org.powerbot.script.rt4.Item;

import needscroll.RopeGrabber.Task;

public class GoNed extends Task{

	public GoNed(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		Item coins = ctx.inventory.select().id(CONSTANT.COINS).poll();
		boolean in_draynor = CONSTANT.DRAYNOR_AREA.contains(ctx.players.local());
		boolean in_ned = CONSTANT.NED_HOUSE.contains(ctx.players.local());
		return ctx.inventory.select().count() < 2 && coins.stackSize() >= 1000 && !in_ned;
	}

	@Override
	public void execute() 
	{
		ctx.movement.step(CONSTANT.NED_TILE);
		Condition.sleep(1000);
		while (ctx.players.local().inMotion())
		{
			Condition.sleep(600);
		}
		
		GameObject door = ctx.objects.select().within(6).id(CONSTANT.DOOR_C).each(Interactive.doSetBounds(CONSTANT.DOOR_BOUNDS)).nearest().poll();
		
		if (door.valid() || door.valid())
		{
			door.interact("Open");
			Condition.sleep(1000);
			while (ctx.players.local().inMotion())
			{
				Condition.sleep(1000);
			}
		}
		
	}


}
