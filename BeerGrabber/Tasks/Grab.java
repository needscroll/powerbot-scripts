package needscroll.BeerGrabber.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.GroundItem;
import org.powerbot.script.rt4.Interactive;

import needscroll.BeerGrabber.Task;

public class Grab extends Task{

	public Grab(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		return CONSTANTS.hall_area.contains(ctx.players.local()) && ctx.inventory.select().size() < 28;
	}

	@Override
	public void execute() {
		GameObject door = ctx.objects.select().id(CONSTANTS.door_c).nearest().poll();
		boolean not_done = true;
		
		if (ctx.movement.energyLevel() > 60 && !ctx.movement.running())
		{
			ctx.movement.running(true);
		}
		
		if (door.valid())
		{
			if (!door.inViewport())
			{
				ctx.camera.turnTo(door.tile());
			}
			
			door.interact(CONSTANTS.door_c_interact);
			Condition.sleep(1000);
			while (ctx.players.local().inMotion())
			{
				Condition.sleep(500);
			}
		}
		
		for (int counter = 0; counter < CONSTANTS.items.length && not_done; counter++)
		{
			GroundItem item; 
			if (CONSTANTS.items[counter] == CONSTANTS.beer || CONSTANTS.items[counter] == CONSTANTS.cooked_meat)
			{
				item = ctx.groundItems.select().id(CONSTANTS.items[counter]).each(Interactive.doSetBounds(CONSTANTS.bounds)).nearest().poll();
			}
			else
			{
				item = ctx.groundItems.select().id(CONSTANTS.items[counter]).nearest().poll();
			}
			
			if (item.valid() && item.inViewport() && CONSTANTS.hall_area.contains(item.tile()))
			{
				not_done = false;
				if (item.id() == CONSTANTS.beer || item.id() == CONSTANTS.cooked_meat)
				{
					item.doSetBounds(CONSTANTS.bounds);
				}
				item.interact(CONSTANTS.take_interact);
				Condition.sleep(1000);
				while (ctx.players.local().inMotion())
				{
					Condition.sleep(250);
				}
			}
		}
		
	}
}
