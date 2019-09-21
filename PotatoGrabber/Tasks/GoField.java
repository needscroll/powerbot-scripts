package needscroll.PotatoGrabber.Tasks;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

public class GoField extends Action{

	public GoField(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean activate() {
		return ctx.inventory.select().size() < 28 && !CONSTANTS.potato_area.contains(ctx.players.local()) && !ctx.players.local().inMotion();
	}

	@Override
	public void execute() {
		GameObject gate = ctx.objects.select().id(CONSTANTS.gate_c).nearest().poll();
		
		if (CONSTANTS.gate_area.contains(ctx.players.local()))
		{
			if (gate.valid() && CONSTANTS.gate_area.contains(gate.tile()))
			{
				use_object(CONSTANTS.gate_c, CONSTANTS.gate_interact, CONSTANTS.gate_bounds);
			}
			else
			{
				ctx.movement.step(CONSTANTS.potato_tile);
			}
		}
		else
		{
			ctx.movement.step(CONSTANTS.gate_o_tile);
		}
	}

}
