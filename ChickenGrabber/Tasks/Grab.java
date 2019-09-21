package needscroll.ChickenGrabber.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;

public class Grab extends Action{

	public Grab(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		return ctx.inventory.select().size() < 28 && CONSTANTS.back_store_area.contains(ctx.players.local());
	}

	@Override
	public void execute() {
		if (!component_valid(CONSTANTS.yestake_widget, CONSTANTS.yestake_component1, CONSTANTS.yestake_component2))
		{
			if (grounditem_valid(CONSTANTS.banana))
			{
				use_grounditem(CONSTANTS.banana, CONSTANTS.banana_interact, CONSTANTS.bounds);
				CONSTANTS.total++;
			}
			else
			{
				use_object(CONSTANTS.crate_to_grab, CONSTANTS.crate_interact);
				Condition.sleep(2000);
			}
		}
		if (component_valid(CONSTANTS.yestake_widget, CONSTANTS.yestake_component1, CONSTANTS.yestake_component2))
		{
			use_component(CONSTANTS.yestake_widget, CONSTANTS.yestake_component1, CONSTANTS.yestake_component2);
			CONSTANTS.total++;
		}
	}

}
