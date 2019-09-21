package needscroll.ChickenGrabber.Tasks;

import org.powerbot.script.rt4.ClientContext;

public class WalkStore extends Action{

	public WalkStore(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		return ctx.inventory.select().size() < 28 && !CONSTANTS.back_store_area.contains(ctx.players.local());
	}

	@Override
	public void execute() {
		if (!CONSTANTS.back_store_area.contains(ctx.players.local()))
		{
			step_use_object(CONSTANTS.store_tile, CONSTANTS.back_door, CONSTANTS.back_door_interact);
		}
	}

}
