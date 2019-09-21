package needscroll.BowstringGrabber.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Item;

import needscroll.BowstringGrabber.Task;

public class Banking extends Task{
	
	public static int amount = 0;

	public Banking(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		Item flax = ctx.inventory.select().id(CONSTANTS.flax_id).poll();
		return CONSTANTS.bank_area.contains(ctx.players.local()) && !flax.valid() && CONSTANTS.fails < 5;
	}

	@Override
	public void execute() {

		if (!ctx.bank.opened())
		{
			open_bank();
		}
		if (ctx.bank.opened())
		{
			get_items();
		}
	}
	
	private void open_bank()
	{
		GameObject bank = ctx.objects.select().id(CONSTANTS.bank_booth).nearest().poll();
		
		ctx.camera.turnTo(bank.tile());
		Condition.sleep(500);
		bank.interact(CONSTANTS.bank_interact);
		Condition.sleep(500);
		while (ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
	}
	
	private void get_items()
	{
		Item flax = ctx.bank.select().id(CONSTANTS.flax_id).poll();
		if (!flax.valid())
		{
			CONSTANTS.fails += 1;
		}
		else
		{
			CONSTANTS.fails = 0;
		}
		
		int amount1 = ctx.inventory.select().id(CONSTANTS.bowstring).count();
		ctx.bank.depositInventory();
		Condition.sleep(500);
		ctx.bank.withdraw(CONSTANTS.flax_id, 28);
		Condition.sleep(500);
		ctx.bank.close();
		Condition.sleep(1500);
		amount += amount1;
	}

	public static int get_amount()
	{
		return amount;
	}
}
