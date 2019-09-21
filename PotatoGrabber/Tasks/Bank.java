package needscroll.PotatoGrabber.Tasks;

import org.powerbot.script.rt4.ClientContext;

public class Bank extends Action{
	
	public Bank(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		return CONSTANTS.draynor_bank_area.contains(ctx.players.local()) && ctx.inventory.select().size() == 28;
	}

	@Override
	public void execute() {
		bank_inv();
	}

}
