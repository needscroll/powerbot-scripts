package needscroll.SpadeGrabber.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;

public class WalkSpade extends Walking{

	public WalkSpade(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean activate() {
		return ctx.inventory.select().count() < 28 && !CONSTANTS.spade_area.contains(ctx.players.local());
	}

	@Override
	public void execute() {
		try
		{
			if (CONSTANTS.sarim_area.contains(ctx.players.local()))
			{
				step_use(CONSTANTS.sarim_gangplank_tile, CONSTANTS.gangplank, CONSTANTS.gangplank_interact);
			}
			if (CONSTANTS.sarim_ship_area.contains(ctx.players.local()))
			{
				use_npc(CONSTANTS.captain_tock_ship, CONSTANTS.captain_tock_interact2);
				Condition.sleep(4000);
			}
			if (CONSTANTS.island_ship_area.contains(ctx.players.local()))
			{
				use(CONSTANTS.gangplank, CONSTANTS.gangplank_interact);
			}
			if (CONSTANTS.island_area.contains(ctx.players.local()))
			{
				step_use(CONSTANTS.spade_tile, CONSTANTS.spade_object, CONSTANTS.spade_interact);
			}
		}
		catch (Exception ex)
		{
			System.out.println("exception found spade walk");
		}
	}
}
