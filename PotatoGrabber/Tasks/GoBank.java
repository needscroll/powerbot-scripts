package needscroll.PotatoGrabber.Tasks;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

public class GoBank extends Action{

	public GoBank(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean activate() {
		return ctx.inventory.select().size() == 28 && !CONSTANTS.draynor_bank_area.contains(ctx.players.local()) && !ctx.players.local().inMotion();
	}

	@Override
	public void execute() {
		GameObject gate = ctx.objects.select().id(CONSTANTS.gate_c).nearest().poll();

		if (CONSTANTS.potato_area.contains(ctx.players.local()))
		{
			ctx.movement.step(CONSTANTS.gate_i_tile);
		}
		else if (gate.valid() && CONSTANTS.gate_area.contains(gate.tile()))
		{
			if (object_valid(CONSTANTS.gate_c))
			{
				use_object(CONSTANTS.gate_c, CONSTANTS.gate_interact, CONSTANTS.gate_bounds);
			}
			else
			{
				ctx.movement.step(CONSTANTS.draynor_bank);
			}
		}
		else
		{
			ctx.movement.step(CONSTANTS.draynor_bank);
		}
	}

}
