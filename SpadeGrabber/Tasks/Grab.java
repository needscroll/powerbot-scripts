package needscroll.SpadeGrabber.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Interactive;

import needscroll.SpadeGrabber.Task;

public class Grab extends Task{
	
	public static int total = 0;

	public Grab(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		return ctx.inventory.select().size() < 28 && CONSTANTS.spade_area.contains(ctx.players.local());
	}

	@Override
	public void execute() {
		GameObject spade = ctx.objects.select().id(CONSTANTS.spade_object).each(Interactive.doSetBounds(CONSTANTS.bounds)).nearest().poll();
		
		if (spade.valid() && spade.inViewport())
		{
			if (spade.interact(CONSTANTS.spade_interact))
			{
				Condition.sleep(2000);
				Grab.total++;
			}
			else if (!spade.inViewport())
			{
				ctx.camera.turnTo(spade.tile());
			}
		}
	}
	
	public static int get_total()
	{
		return total;
	}

}
