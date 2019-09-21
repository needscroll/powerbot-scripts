package needscroll.ChickenGrabber.Tasks;

import org.powerbot.script.rt4.ClientContext;

public class WalkBank extends Action{

	public WalkBank(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		return ctx.inventory.select().count() == 28 && !CONSTANTS.bank_deposit_area.contains(ctx.players.local());
	}

	@Override
	public void execute() 
	{
		if (CONSTANTS.back_store_area.contains(ctx.players.local()))
		{
			use_object(CONSTANTS.back_door, CONSTANTS.back_door_interact);
		}
		if (!CONSTANTS.bank_deposit_area.contains(ctx.players.local()))
		{
			step_use_object(CONSTANTS.bank_deposit_tile, CONSTANTS.bank_deposit, CONSTANTS.bank_deposit_interact);
		}
		
			
	}

}
