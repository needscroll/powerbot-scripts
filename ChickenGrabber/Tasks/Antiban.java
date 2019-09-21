package needscroll.ChickenGrabber.Tasks;

import org.powerbot.script.rt4.ClientContext;

import needscroll.ChickenGrabber.Task;

public class Antiban extends Task{

	public Antiban(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
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
