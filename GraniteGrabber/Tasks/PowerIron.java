package needscroll.GraniteGrabber.Tasks;

import org.powerbot.script.rt6.ClientContext;

public class PowerIron extends Mine{
	
	final static int[] IRON_ROCK = {11954, 11955, 11956};
	final static int IRON_ORE = 440;

	public PowerIron(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		return idling();
	}
	
	@Override
	public void execute()
	{
		if (ctx.backpack.select().count() < 28)
		{
			mine(IRON_ROCK);
		}
		if (ctx.backpack.select().count() == 28)
		{
			drop(IRON_ORE);
		}
	}
}
