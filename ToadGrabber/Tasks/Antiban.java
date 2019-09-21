package needscroll.ToadGrabber.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;

import needscroll.ToadGrabber.Task;

public class Antiban extends Task{

	public Antiban(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		int random_chance = (int) (Math.random() * 5000);
		
		return ctx.camera.pitch() < 55 || random_chance < 50;
	}

	@Override
	public void execute() {
		ctx.camera.angle('n');
		ctx.camera.pitch(75);
		
		int random_sleep = (int) (Math.random() * 10000);
		Condition.sleep(random_sleep);
	}

}
