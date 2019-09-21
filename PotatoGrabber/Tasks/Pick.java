package needscroll.PotatoGrabber.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;

public class Pick extends Action{

	public Pick(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean activate() {
		return CONSTANTS.potato_area.contains(ctx.players.local()) && ctx.inventory.select().size() < 28 && idling(2, 100);
	}

	@Override
	public void execute() {
		use_object(CONSTANTS.potato_plant, CONSTANTS.pick_interact);
		CONSTANTS.amount++;
	}

}
