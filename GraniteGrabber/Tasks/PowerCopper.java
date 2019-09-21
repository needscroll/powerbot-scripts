package needscroll.GraniteGrabber.Tasks;

import org.powerbot.script.rt6.ClientContext;

public class PowerCopper extends Mine{
	
	final static int[] COPPER_ROCK = {11960, 11961, 11962};
	final static int COPPER_ORE = 436;

	public PowerCopper(ClientContext ctx) {
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
			mine(COPPER_ROCK);
		}
		if (ctx.backpack.select().count() == 28)
		{
			drop(COPPER_ORE);
		}
	}
}
