package needscroll.GraniteGrabber.Tasks;


import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.Item;

import needscroll.GraniteGrabber.Task;

public class Mine extends Task{
	
	final static int MINING_ANIMATION = 626;

	public Mine(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
	
	protected void mine(int id[])
	{
		GameObject rock = ctx.objects.select().id(id).nearest().poll();
		int old_i = ctx.backpack.select().count();
		int new_i = old_i;
		int counter = 0;
		
		rock.interact("Mine");
		Condition.sleep(1000);
		
		while(old_i == new_i && counter < 15)
		{
			Condition.sleep(1000);
			counter++;
			new_i = ctx.backpack.select().count();
		}
	}
	
	protected void drop (int id)
	{
		Item ore = ctx.backpack.select().id(id).poll();
		int drop_time = (int) (Math.random() * 500) + 800;
		int between_time = (int) (Math.random() * 100) + 100;
		int drop_amount = (int) (Math.random() * 8) + 20;
		
		for (int counter = 0; counter < drop_amount; counter++)
		{
			ctx.input.send("1");
			Condition.sleep(between_time);
		}
		
		//ore.interact("Drop");
		//Condition.sleep(drop_time);
	}
	
	protected boolean idling()
	{
		boolean idle = true;
		
		for (int counter = 0; counter < 3; counter++)
		{
			if (ctx.players.local().inMotion() || ctx.players.local().animation() == 627)
			{
				idle = false;
			}
		}
		
		return idle;
	}

}
