package needscroll.BowstringGrabber.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Item;

import needscroll.BowstringGrabber.Task;

public class Spinning extends Task{

	public Spinning(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		Item flax = ctx.inventory.select().id(CONSTANTS.flax_id).poll();
		return flax.valid() && CONSTANTS.wheel_area.contains(ctx.players.local()) && idling();
	}

	@Override
	public void execute() {
		GameObject wheel = ctx.objects.select().id(CONSTANTS.wheel_id).nearest().poll();
		Component bowstring = ctx.widgets.widget(CONSTANTS.spinning_widget).component(CONSTANTS.spinning_component1).component(CONSTANTS.spinning_component2);
		
		if (!bowstring.valid() && !bowstring.visible())
		{
			ctx.camera.turnTo(wheel.tile());
			Condition.sleep(500);
			wheel.interact(CONSTANTS.wheen_interact);
			Condition.sleep(500);
			while (ctx.players.local().inMotion())
			{
				Condition.sleep(500);
			}
		}
		if (bowstring.valid())
		{
			bowstring.click(true);
		}
	}
	
	private boolean idling()
	{
		boolean idle = true;
		
		for (int counter = 0; counter < 7; counter++)
		{	
			if (ctx.players.local().animation() == 894)
			{
				idle = false;
			}
			Condition.sleep(300);
		}
		
		return idle;
	}

}
