package needscroll.GraniteGrabber.Tasks;

import org.powerbot.script.rt6.ClientContext;

public class PowerTin extends Mine{
	
	final static int[] TIN_ROCK = {11957, 11958, 11959};
	final static int TIN_ORE = 438;

	public PowerTin(ClientContext ctx) {
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
			mine(TIN_ROCK);
		}
		if (ctx.backpack.select().count() == 28)
		{
			drop(TIN_ORE);
		}
	}
}
