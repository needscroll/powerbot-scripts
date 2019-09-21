package needscroll.BeerGrabber.Tasks;

import org.powerbot.script.rt4.ClientContext;

import needscroll.BeerGrabber.Task;

public class Antiban extends Task{

	public Antiban(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		int random_chance = (int) (Math.random() * 2000);
		
		return random_chance < 50;
	}

	@Override
	public void execute() {
		if (!ctx.movement.running())
		{
			ctx.movement.running(true);
		}

		
	}

}
