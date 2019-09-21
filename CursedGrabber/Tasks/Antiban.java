package needscroll.CursedGrabber.Tasks;

import org.powerbot.script.rt6.ClientContext;

import needscroll.CursedGrabber.Task;

public class Antiban extends Task{

	public Antiban(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		int random_chance = (int) (Math.random() * 5000);
		
		return ctx.camera.pitch() > 55 || ctx.camera.pitch() < 25 || random_chance < 20;
	}

	@Override
	public void execute() {
		ctx.camera.angle('n');
		ctx.camera.pitch(40);
	}
}
