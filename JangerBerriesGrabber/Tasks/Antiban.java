package needscroll.JangerBerriesGrabber.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;

import needscroll.JangerBerriesGrabber.Task;

public class Antiban extends Task{

	public Antiban(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		int random_chance = (int) (Math.random() * 5000);
		
		return ctx.camera.pitch() > 50 || ctx.camera.pitch() < 20 || random_chance < 50;
	}

	@Override
	public void execute() {
		ctx.camera.angle('n');
		ctx.camera.pitch(30);
		
		int random_sleep = (int) (Math.random() * 10000);
		Condition.sleep(random_sleep);
	}

}
