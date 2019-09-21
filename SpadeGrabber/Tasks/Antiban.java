package needscroll.SpadeGrabber.Tasks;

import org.powerbot.script.rt4.ClientContext;

import needscroll.SpadeGrabber.Task;

public class Antiban extends Task{

	public static String STATUS = "";
	
	public Antiban(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		return ctx.camera.pitch() > 70 || ctx.camera.pitch() < 40 || (ctx.movement.energyLevel() > 60 && !ctx.movement.running());
	}

	@Override
	public void execute() 
	{
		if (ctx.movement.energyLevel() > 60 && !ctx.movement.running())
		{
			ctx.movement.running(true);
		}
		if (ctx.camera.pitch() > 70 || ctx.camera.pitch() < 40)
		{
			ctx.camera.angle('n');
			ctx.camera.pitch(55);
		}
	}

}
