package needscroll.RopeGrabber.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Interactive;
import org.powerbot.script.rt4.Item;

import needscroll.RopeGrabber.Task;

public class Banking extends Task{

	public Banking(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		Item coins = ctx.inventory.select().id(CONSTANT.COINS).poll();
		return (ctx.inventory.select().count() > 15 || coins.stackSize() < 1000) && !ctx.bank.opened();
	}

	@Override
	public void execute() 
	{
		GameObject door = ctx.objects.select().within(7).id(CONSTANT.DOOR_C).each(Interactive.doSetBounds(CONSTANT.DOOR_BOUNDS)).nearest().poll();
		Component exit = ctx.widgets.widget(300).component(1).component(11);
		
		if (door.valid() || door.valid())
		{
			exit.click(true);
			Condition.sleep(1000);
			ctx.camera.turnTo(door.tile());
			Condition.sleep(500);
			door.interact("Open");
			Condition.sleep(1000);
			while (ctx.players.local().inMotion())
			{
				Condition.sleep(1000);
			}
		}
		
		ctx.movement.step(CONSTANT.BANK_TILE);
		Condition.sleep(1000);
		while (ctx.players.local().inMotion())
		{
			Condition.sleep(600);
		}
		
		GameObject bank = ctx.objects.select().id(CONSTANT.BANK_BOOTH).nearest().poll();
		
		bank.interact("Bank");
		Condition.sleep(1000);
		while (ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
		
	}

}
