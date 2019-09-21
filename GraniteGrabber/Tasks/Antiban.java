package needscroll.GraniteGrabber.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;

import needscroll.GraniteGrabber.Task;

public class Antiban extends Task{

	public Antiban(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		int random_chance = (int) (Math.random() * 5000);
		
		return ctx.camera.pitch() > 75 || ctx.camera.pitch() < 45 || random_chance < 50;
	}

	@Override
	public void execute() {
		ctx.camera.angle('n');
		ctx.camera.pitch(60);
		
		int random_sleep = (int) (Math.random() * 10000);
		Condition.sleep(random_sleep);
	}

}
