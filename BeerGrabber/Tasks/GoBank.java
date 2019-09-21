package needscroll.BeerGrabber.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

import needscroll.BeerGrabber.Task;

public class GoBank extends Task{

	public GoBank(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		return ctx.inventory.select().size() == 28 && !CONSTANTS.bank_area.contains(ctx.players.local());
	}

	@Override
	public void execute() {
		if (CONSTANTS.hall_area.contains(ctx.players.local()))
		{
			ctx.movement.step(CONSTANTS.hall);
			Condition.sleep(1000);
			while (ctx.players.local().inMotion())
			{
				Condition.sleep(500);
			}
			GameObject door = ctx.objects.select().id(CONSTANTS.door_c).nearest().poll();
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
		}
		
		ctx.movement.step(CONSTANTS.bank);
		Condition.sleep(4000);
	}

}
