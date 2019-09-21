package needscroll.RopeGrabber.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Interactive;
import org.powerbot.script.rt4.Item;
import org.powerbot.script.rt4.Npc;

import needscroll.RopeGrabber.Task;

public class Trading extends Task{
	
	public static int amount = 0;

	public Trading(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() 
	{
		Item coins = ctx.inventory.select().id(CONSTANT.COINS).poll();
		boolean in_ned = CONSTANT.NED_HOUSE.contains(ctx.players.local());
		return in_ned && ctx.inventory.select().count() < 16 && coins.stackSize() >= 500;
	}

	@Override
	public void execute() 
	{
		Component shop = ctx.widgets.widget(300).component(0);
		Component rope = ctx.widgets.widget(300).component(16).component(1);
		Npc ned = ctx.npcs.select().id(CONSTANT.NED_NPC).nearest().poll();
		
		GameObject door = ctx.objects.select().within(6).id(CONSTANT.DOOR_C).each(Interactive.doSetBounds(CONSTANT.DOOR_BOUNDS)).nearest().poll();
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
		
		if (!shop.valid())
		{
			ned.interact("Trade");
			Condition.sleep(1000);
			while (ctx.players.local().inMotion())
			{
				Condition.sleep(600);
			}
		}
		
		if (shop.valid())
		{
			rope.interact("Buy 50");
			Condition.sleep(1000);
			amount += ctx.inventory.select().id(CONSTANT.ROPE).count();
		}
	}
	
	public static int get_amount()
	{
		return amount;
	}

}
