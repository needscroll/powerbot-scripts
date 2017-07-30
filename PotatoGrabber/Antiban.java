package needscroll.PotatoGrabber;

import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Item;

public class Antiban extends ClientAccessor{
	
	public Antiban(ClientContext ctx)
	{
		super(ctx);
	}
	
	public void run_anti()
	{
		check_inv();
		anti_sleep();
	}
	
	private void anti_sleep()
	{
		int random_chance = (int) (Math.random() * 1000);
		int random_sleep = (int) (Math.random() * 10000);
		
		if (random_chance < 50)
		{
			Condition.sleep(random_sleep);
		}
	}
	
	private void check_inv()
	{
		Getstate anti = new Getstate(ctx);
		Item[] inv = ctx.backpack.items();
		
		for (int counter = 0; counter < inv.length; counter++)
		{
			if (anti.bad_item(inv[counter]))
			{
				inv[counter].interact("Drop");
			}
		}
	}
}