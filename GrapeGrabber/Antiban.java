package needscroll.GrapeGrabber;

import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Item;

public class Antiban extends ClientAccessor{
	
	public Antiban(ClientContext ctx)
	{
		super(ctx);
	}
	
	public void run_antiban()
	{
		int random_chance = (int) (Math.random() * 1000);
		int random_sleep = (int) (Math.random() * 10000);
		
		if (random_chance < 50)
		{
			Condition.sleep(random_sleep);
		}
		
		fix_inv();
	}
	
	private void fix_inv()
	{
		Item[] inv = ctx.backpack.items();
		Getstate anti = new Getstate(ctx);
		
		for (int counter = 0; counter < inv.length; counter++)
		{
			if (anti.baditem(inv[counter]))
			{
				inv[counter].interact("Drop");
			}
		}
	}
	
	public void reset()
	{
		Travel wipe = new Travel(ctx);
		wipe.res_floor();
	}
}
