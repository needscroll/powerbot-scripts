package needscroll.RopeGrabber.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;

import needscroll.RopeGrabber.Task;

public class GetItems extends Task{

	public GetItems(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		return ctx.inventory.select().count() > 15 && ctx.bank.opened();
	}

	@Override
	public void execute() {
		Item coins = ctx.inventory.select().id(CONSTANT.COINS).poll();
		
		ctx.bank.deposit(CONSTANT.ROPE, 27);
		Condition.sleep(1000);
		if (coins.stackSize() < 1000)
		{
			ctx.bank.withdraw(CONSTANT.COINS, 5000);
			Condition.sleep(1000);
			
			if (coins.stackSize() < 1000)
			{
				ctx.bank.withdraw(CONSTANT.COINS, 5000);
				Condition.sleep(1000);
			}
		}
		ctx.bank.close();
		
	}

}
