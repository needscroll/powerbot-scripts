package needscroll.SpadeGrabber.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;

public class WalkBank extends Walking{

	public WalkBank(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		return ctx.inventory.select().count() == 28 && !CONSTANTS.bank_deposit_area.contains(ctx.players.local());
	}

	@Override
	public void execute() {
		try
		{
			if (CONSTANTS.island_area.contains(ctx.players.local()))
			{
				step_use(CONSTANTS.island_gangplank_tile, CONSTANTS.gangplank, CONSTANTS.gangplank_interact);
			}
			if (CONSTANTS.island_ship_area.contains(ctx.players.local()))
			{
				use_npc(CONSTANTS.captain_tock_ship, CONSTANTS.captain_tock_interact2);
				Condition.sleep(4000);
			}
			if (CONSTANTS.sarim_ship_area.contains(ctx.players.local()))
			{
				use(CONSTANTS.gangplank, CONSTANTS.gangplank_interact);
			}
			if (CONSTANTS.sarim_area.contains(ctx.players.local()))
			{
				step_use(CONSTANTS.bank_deposit_tile, CONSTANTS.bank_deposit, CONSTANTS.bank_deposit_interact);
			}
		}
		catch (Exception ex)
		{
			System.out.println("exception found bank walk");
		}
	}

}
