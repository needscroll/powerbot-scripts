package needscroll.PotatoGrabber.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.GroundItem;
import org.powerbot.script.rt4.Interactive;
import org.powerbot.script.rt4.Item;
import org.powerbot.script.rt4.Npc;

import needscroll.PotatoGrabber.Task;

public class Action extends Task{

	public Action(ClientContext ctx) {
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
	
	protected boolean object_valid(int id)
	{
		return ctx.objects.select().id(id).nearest().poll().valid();
	}
	
	protected boolean object_valid(int[] id)
	{
		return ctx.objects.select().id(id).nearest().poll().valid();
	}
	

	
	protected void use_object(int id, String use)
	{
		GameObject thing = ctx.objects.select().id(id).nearest().poll();

		if (thing.valid())
		{
			if (!thing.inViewport())
			{
				ctx.camera.turnTo(thing.tile());
			}
			if (thing.interact(use))
			{
				wait_sleep();
			}
		}
	}
	
	protected void use_object(int id, String use, int[] bounds)
	{
		GameObject thing = ctx.objects.select().id(id).each(Interactive.doSetBounds(bounds)).nearest().poll();

		if (thing.valid())
		{
			if (!thing.inViewport())
			{
				ctx.camera.turnTo(thing.tile());
			}
			if (thing.interact(use))
			{
				wait_sleep();
			}
		}
	}
	
	protected void use_object(int[] id, String use, int[] bounds)
	{
		GameObject thing = ctx.objects.select().id(id).each(Interactive.doSetBounds(bounds)).nearest().poll();

		if (thing.valid())
		{
			if (!thing.inViewport())
			{
				ctx.camera.turnTo(thing.tile());
			}
			if (thing.interact(use))
			{
				wait_sleep();
			}
		}
	}
	
	protected void use_object(int[] id, String use)
	{
		GameObject thing = ctx.objects.select().id(id).nearest().poll();

		if (thing.valid())
		{
			if (!thing.inViewport())
			{
				ctx.camera.turnTo(thing.tile());
			}
			if (thing.interact(use))
			{
				wait_sleep();
			}
		}
	}
	
	protected void step_use_object(Tile tile, int thing_id, String use)
	{
		GameObject thing = ctx.objects.select().id(thing_id).nearest().poll();
		ctx.movement.step(tile);
		Condition.sleep(1500);
		while (ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
		
		if (thing.valid())
		{
			if (!thing.inViewport())
			{
				ctx.camera.turnTo(thing.tile());
			}
			if (thing.interact(use))
			{
				wait_sleep();
			}
		}
	}
	
	protected void step_use_object(Tile tile, int[] thing_id, String use)
	{
		GameObject thing = ctx.objects.select().id(thing_id).nearest().poll();
		ctx.movement.step(tile);
		Condition.sleep(1500);
		while (ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
		
		if (thing.valid())
		{
			if (!thing.inViewport())
			{
				ctx.camera.turnTo(thing.tile());
			}
			if (thing.interact(use))
			{
				wait_sleep();
			}
		}
	}
	
	protected void step_use_object(Tile tile, int thing_id, String use, int[] bounds)
	{
		GameObject thing = ctx.objects.select().id(thing_id).each(Interactive.doSetBounds(bounds)).nearest().poll();
		ctx.movement.step(tile);
		Condition.sleep(1500);
		while (ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
		
		if (thing.valid())
		{
			if (!thing.inViewport())
			{
				ctx.camera.turnTo(thing.tile());
			}
			if (thing.interact(use))
			{
				wait_sleep();
			}
		}
	}
	
	protected void use_npc(int id, String use)
	{
		Npc npc = ctx.npcs.select().id(id).nearest().poll();
		if (npc.valid())
		{
			if (!npc.inViewport())
			{
				ctx.camera.turnTo(npc.tile());
			}
			if (npc.interact(use))
			{
				wait_sleep();
			}
		}
	}
	
	protected void use_npc(int[] id, String use)
	{
		Npc npc = ctx.npcs.select().id(id).nearest().poll();
		if (npc.valid())
		{
			if (!npc.inViewport())
			{
				ctx.camera.turnTo(npc.tile());
			}
			if (npc.interact(use))
			{
				wait_sleep();
			}
		}
	}
	
	protected void use_npc(String name, String use)
	{
		Npc npc = ctx.npcs.select().name(name).nearest().poll();
		if (npc.valid())
		{
			if (!npc.inViewport())
			{
				ctx.camera.turnTo(npc.tile());
			}
			if (npc.interact(use))
			{
				wait_sleep();
			}
		}
	}
	
	protected void step_use_npc(Tile tile, int thing_id, String use)
	{
		Npc npc = ctx.npcs.select().id(thing_id).nearest().poll();
		ctx.movement.step(tile);
		Condition.sleep(1500);
		while (ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
		
		if (npc.valid())
		{
			if (!npc.inViewport())
			{
				ctx.camera.turnTo(npc.tile());
			}
			if (npc.interact(use))
			{
				wait_sleep();
			}
		}
	}
	
	protected boolean component_valid(int widget, int component)
	{
		Component thing = ctx.widgets.widget(widget).component(component);
		return thing.valid() && thing.visible();
	}
	
	protected boolean component_valid(int widget, int component, int component2)
	{
		Component thing = ctx.widgets.widget(widget).component(component).component(component2);
		return thing.valid() && thing.visible();
	}
	
	protected void use_component(int widget, int component)
	{
		ctx.widgets.widget(widget).component(component).click(true);
		Condition.sleep(2000);
	}
	
	protected void use_component(int widget, int component, int component2)
	{
		ctx.widgets.widget(widget).component(component).component(component2).click(true);
		Condition.sleep(2000);
	}
	
	protected boolean grounditem_valid(int id)
	{
		return ctx.groundItems.select().id(id).nearest().poll().valid();
	}
	
	protected void step_use_grounditem(Tile tile, int thing_id, String use)
	{
		GroundItem thing = ctx.groundItems.select().id(thing_id).nearest().poll();
		ctx.movement.step(tile);
		Condition.sleep(1500);
		while (ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
		
		if (thing.valid())
		{
			if (!thing.inViewport())
			{
				ctx.camera.turnTo(thing.tile());
			}
			if (thing.interact(use))
			{
				wait_sleep();
			}
		}
	}
	
	protected void use_grounditem(int id, String use)
	{
		GroundItem thing = ctx.groundItems.select().id(id).nearest().poll();

		if (thing.valid())
		{
			if (!thing.inViewport())
			{
				ctx.camera.turnTo(thing.tile());
			}
			if (thing.interact(use))
			{
				wait_sleep();
			}
		}
	}
	
	protected void use_grounditem(int id, String use, int[] bounds)
	{
		GroundItem thing = ctx.groundItems.select().id(id).each(Interactive.doSetBounds(bounds)).nearest().poll();

		if (thing.valid())
		{
			if (!thing.inViewport())
			{
				ctx.camera.turnTo(thing.tile());
			}
			if (thing.interact(use))
			{
				wait_sleep();
			}
		}
	}
	
	protected boolean item_valid(int id)
	{
		return ctx.inventory.select().id(id).poll().valid();
	}
	
	protected boolean item_valid(String name)
	{
		return ctx.inventory.select().name(name).poll().valid();
	}
	
	protected void use_item(int id, String use)
	{
		Item thing = ctx.inventory.select().id(id).poll();

		if (thing.valid())
		{
			if (thing.interact(use))
			{
				wait_sleep(750);
			}
		}
	}
	
	protected void use_item(int[] id, String use)
	{
		Item thing = ctx.inventory.select().id(id).poll();

		if (thing.valid())
		{
			if (thing.interact(use))
			{
				wait_sleep(750);
			}
		}
	}
	
	protected void use_item(String name, String use)
	{
		Item thing = ctx.inventory.select().name(name).poll();

		if (thing.valid())
		{
			if (thing.interact(use))
			{
				wait_sleep(750);
			}
		}
	}
	
	protected void open_bank()
	{
		if (ctx.bank.opened())
		{
			return;
		}
		
		if (!ctx.bank.opened())
		{
			ctx.bank.open();
			wait_sleep();
		}
	}
	
	protected void bank_inv()
	{
		if (!ctx.bank.opened())
		{
			open_bank();
		}
		else
		{
			ctx.bank.depositInventory();
			Condition.sleep(1500);
			ctx.bank.close();
			Condition.sleep(1500);
		}
	}
	
	protected void bank_inv(int item_id)
	{
		if (!ctx.bank.opened())
		{
			open_bank();
		}
		else
		{
			ctx.bank.deposit(item_id, 99999);
			Condition.sleep(1500);
			ctx.bank.close();
			Condition.sleep(1500);
		}
	}
	
	protected void bank_all(int[] item_ids)
	{
		if (!ctx.bank.opened())
		{
			open_bank();
		}
		else
		{
			for (int counter = 0; counter < item_ids.length; counter++)
			{
				ctx.bank.deposit(item_ids[counter], 99999);
				Condition.sleep(750);
			}
			ctx.bank.close();
			Condition.sleep(1500);
		}
	}
	
	protected void swap_bank(int item_id, int amount)
	{
		if (!ctx.bank.opened())
		{
			open_bank();
		}
		else
		{
			ctx.bank.depositInventory();
			Condition.sleep(1500);
			ctx.bank.withdraw(item_id, amount);
			Condition.sleep(1500);
			ctx.bank.close();
			Condition.sleep(1500);
		}
	}
	
	protected void swap_bank(String item_name, int amount)
	{
		if (!ctx.bank.opened())
		{
			open_bank();
		}
		else
		{
			Item item = ctx.bank.select().name(item_name).poll();
			ctx.bank.depositInventory();
			Condition.sleep(1500);
			ctx.bank.withdraw(item, amount);
			Condition.sleep(1500);
			ctx.bank.close();
			Condition.sleep(1500);
		}
	}
	
	protected boolean idling()
	{
		for (int counter = 0; counter < 5; counter++)
		{	
			if (ctx.players.local().inCombat() || ctx.players.local().animation() != -1 || ctx.players.local().inMotion())
			{
				return false;
			}
			Condition.sleep(300);
		}
		return true;
	}
	
	protected boolean idling(int times, int duration)
	{
		for (int counter = 0; counter < times; counter++)
		{	
			if (ctx.players.local().inCombat() || ctx.players.local().animation() != -1 || ctx.players.local().inMotion())
			{
				return false;
			}
			Condition.sleep(duration);
		}
		return true;
	}
	
	protected void wait_sleep()
	{
		Condition.sleep(1500);
		while (ctx.players.local().inMotion() || ctx.players.local().animation() != -1)
		{
			Condition.sleep(1000);
		}
	}
	
	protected void wait_sleep(int time)
	{
		Condition.sleep(time);
		while (ctx.players.local().inMotion() || ctx.players.local().animation() != -1)
		{
			Condition.sleep(1000);
		}
	}
}
