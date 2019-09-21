package needscroll.BeerGrabber.Tasks;


import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

import needscroll.BeerGrabber.Task;

public class Banking extends Task{
	
	public static int total_amount = 0;

	public Banking(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		return ctx.inventory.select().size() > 0 && CONSTANTS.bank_area.contains(ctx.players.local());
	}

	@Override
	public void execute() {
		
		if (!ctx.bank.opened())
		{
			GameObject banker = ctx.objects.select().id(CONSTANTS.bank_booth).nearest().poll();
			banker.interact(CONSTANTS.banker_interact);
			Condition.sleep(1000);
			while (ctx.players.local().inMotion())
			{
				Condition.sleep(500);
			}
		}
		
		if (ctx.bank.opened())
		{
			ctx.bank.depositInventory();
			Condition.sleep(500);
			ctx.bank.close();
			Condition.sleep(500);
			total_amount += 28;
		}
		
	}

}
