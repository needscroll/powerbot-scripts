package needscroll.ChickenGrabber.Tasks;

import org.powerbot.script.rt4.ClientContext;

public class Banking extends Action{

	public Banking(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		return ctx.inventory.select().size() == 28 && CONSTANTS.bank_deposit_area.contains(ctx.players.local());
	}

	@Override
	public void execute() {
		if (component_valid(CONSTANTS.deposit_widget, CONSTANTS.deposit_component))
		{
			use_component(CONSTANTS.deposit_widget, CONSTANTS.deposit_component);
			use_component(CONSTANTS.exit_widget, CONSTANTS.exit_component1, CONSTANTS.exit_component2);
		}
		if (!component_valid(CONSTANTS.deposit_widget, CONSTANTS.deposit_component) && ctx.inventory.select().size() == 28)
		{
			use_object(CONSTANTS.bank_deposit, CONSTANTS.bank_deposit_interact);
			use_component(CONSTANTS.deposit_widget, CONSTANTS.deposit_component);
			use_component(CONSTANTS.exit_widget, CONSTANTS.exit_component1, CONSTANTS.exit_component2);
		}
		
		
	}

}
