package needscroll.BowstringGrabber.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Interactive;
import org.powerbot.script.rt4.Item;

import needscroll.BowstringGrabber.Task;

public class WalkBank extends Task{

	public WalkBank(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		Item flax = ctx.inventory.select().id(CONSTANTS.flax_id).poll();
		return !CONSTANTS.bank_area.contains(ctx.players.local()) && !flax.valid();
	}

	@Override
	public void execute() {
		int floor = ctx.players.local().tile().floor();
		boolean done = false;
		if (floor == 0)
		{
			use_stairs(CONSTANTS.stair0_id);
			
		}
		if (floor == 1)
		{
			GameObject door = ctx.objects.select().id(CONSTANTS.door_c_id).each(Interactive.doSetBounds(CONSTANTS.bounds)).nearest().poll();
			if (door.valid())
			{
				ctx.camera.turnTo(door.tile());
				door.interact(CONSTANTS.door_interact);
				Condition.sleep(500);
				while (ctx.players.local().inMotion())
				{
					Condition.sleep(500);
				}
			}
			
			use_stairs(CONSTANTS.stair1_id);
		}
		if (floor == 2)
		{
			ctx.movement.step(CONSTANTS.bank);
			Condition.sleep(500);
			while (ctx.players.local().inMotion())
			{
				Condition.sleep(500);
			}
		}
	}
	
	private void use_stairs(int id)
	{
		GameObject stairs = ctx.objects.select().id(id).nearest().poll();
		if (!stairs.inViewport())
		{
			ctx.camera.pitch(55);
			ctx.camera.turnTo(stairs.tile());
			ctx.movement.step(stairs.tile());
			Condition.sleep(1000);
		}
		
		stairs.interact(CONSTANTS.stair_interact_up);
		Condition.sleep(500);
		while (ctx.players.local().inMotion())
		{
			Condition.sleep(500);
		}
	}

}
