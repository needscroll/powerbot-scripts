package needscroll.PotatoGrabber.Tasks;

import org.powerbot.script.rt4.ClientContext;

public class Antiban extends Action{

	public Antiban(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean activate() {
		return ctx.movement.energyLevel() > 60 && !ctx.movement.running();
	}

	@Override
	public void execute() {
		if (ctx.movement.energyLevel() > 60 && !ctx.movement.running())
		{
			ctx.movement.running(true);
		}
	}

}
