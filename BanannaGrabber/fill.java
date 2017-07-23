package needscroll.BanannaGrabber;

import org.powerbot.script.Condition;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.Item;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.ClientAccessor;

public class fill extends ClientAccessor {
	
	private final int[] BASKETS = {5376, 5408, 5410, 5412, 5414, 5416};
	
	public fill(ClientContext ctx)
	{
		super(ctx);
	}
	
	public boolean fill_basket(Item[] inv)
	{
		boolean done = false;
		
		for (int counter = 0; counter < inv.length && done == false; counter++)
		{
			for (int counter1 = 0; counter1 < BASKETS.length - 1 && done == false; counter1++)
			{
				if (inv[counter].id() == BASKETS[counter1])
				{
					inv[counter].click("Fill");
					Condition.sleep(1000);
					done = true;
				}
			}
		}
		
		return done;
	}
	
	public void collect(int[] BANANNA_TREES, int empty, int[] BANANNAS_GRABBED)
	{
		for (int counter = 0; counter < empty; counter++)
		{
			GameObject tree = ctx.objects.select().id(BANANNA_TREES).nearest().poll();
			
			tree.interact("Pick");
			
			Condition.sleep(1000);
			while (ctx.players.local().inMotion())
			{
				Condition.sleep(1000);
			}
			BANANNAS_GRABBED[0]++;
		}
	}

}
