package needscroll.StarterPack2;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.GroundItem;
import org.powerbot.script.rt4.Interactive;
import org.powerbot.script.rt4.Item;
import org.powerbot.script.rt4.ItemQuery;
import org.powerbot.script.rt4.Npc;

public interface Action{
	

	default boolean object_valid(ClientContext ctx, int id)
	{
		return ctx.objects.select().id(id).nearest().poll().valid();
	}
	
	default boolean object_valid(ClientContext ctx, int[] id)
	{
		return ctx.objects.select().id(id).nearest().poll().valid();
	}
	

	
	default void use_object(ClientContext ctx, int id, String use)
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
				wait_sleep(ctx);
			}
		}
	}
	
	default void use_object(ClientContext ctx, int id, String use, int[] bounds)
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
				wait_sleep(ctx);
			}
		}
	}
	
	default void use_object(ClientContext ctx, int[] id, String use, int[] bounds)
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
				wait_sleep(ctx);
			}
		}
	}
	
	default void use_object(ClientContext ctx, int[] id, String use)
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
				wait_sleep(ctx);
			}
		}
	}
	
	default void step_use_object(ClientContext ctx, Tile tile, int thing_id, String use)
	{
		GameObject thing = ctx.objects.select().id(thing_id).nearest().poll();
		step_tile(ctx, tile);
		
		if (thing.valid())
		{
			if (!thing.inViewport())
			{
				ctx.camera.turnTo(thing.tile());
			}
			if (thing.interact(use))
			{
				wait_sleep(ctx);
			}
		}
	}
	
	default void step_use_object(ClientContext ctx, Tile tile, int[] thing_id, String use)
	{
		GameObject thing = ctx.objects.select().id(thing_id).nearest().poll();
		step_tile(ctx, tile);

		
		if (thing.valid())
		{
			if (!thing.inViewport())
			{
				ctx.camera.turnTo(thing.tile());
			}
			if (thing.interact(use))
			{
				wait_sleep(ctx);
			}
		}
	}
	
	default void step_use_object(ClientContext ctx, Tile tile, int thing_id, String use, int[] bounds)
	{
		GameObject thing = ctx.objects.select().id(thing_id).each(Interactive.doSetBounds(bounds)).nearest().poll();
		step_tile(ctx, tile);

		if (thing.valid())
		{
			if (!thing.inViewport())
			{
				ctx.camera.turnTo(thing.tile());
			}
			if (thing.interact(use))
			{
				wait_sleep(ctx);
			}
		}
	}
	
	default void use_npc(ClientContext ctx, int id, String use)
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
				wait_sleep(ctx);
			}
		}
	}
	
	default void use_npc(ClientContext ctx, int[] id, String use)
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
				wait_sleep(ctx);
			}
		}
	}
	
	default void use_npc(ClientContext ctx, String name, String use)
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
				wait_sleep(ctx);
			}
		}
	}
	
	default void step_use_npc(ClientContext ctx, Tile tile, int thing_id, String use)
	{
		Npc npc = ctx.npcs.select().id(thing_id).nearest().poll();
		step_tile(ctx, tile);
		
		if (npc.valid())
		{
			if (!npc.inViewport())
			{
				ctx.camera.turnTo(npc.tile());
			}
			if (npc.interact(use))
			{
				wait_sleep(ctx);
			}
		}
	}
	
	default boolean component_valid(ClientContext ctx, int widget, int component)
	{
		Component thing = ctx.widgets.widget(widget).component(component);
		return thing.valid() && thing.visible();
	}
	
	default boolean component_valid(ClientContext ctx, int widget, int component, int component2)
	{
		Component thing = ctx.widgets.widget(widget).component(component).component(component2);
		return thing.valid() && thing.visible();
	}
	
	default void use_component(ClientContext ctx, int widget, int component)
	{
		ctx.widgets.widget(widget).component(component).click(true);
		Condition.sleep(2000);
	}
	
	default void use_component(ClientContext ctx, int widget, int component, int component2)
	{
		ctx.widgets.widget(widget).component(component).component(component2).click(true);
		Condition.sleep(2000);
	}
	
	default boolean component_valid(Component component)
	{
		return component.valid() && component.visible();
	}
	
	default void use_component(Component component)
	{
		component.click(true);
		Condition.sleep(2000);
	}
	
	default boolean grounditem_valid(ClientContext ctx, int id)
	{
		return ctx.groundItems.select().id(id).nearest().poll().valid();
	}
	
	default void step_use_grounditem(ClientContext ctx, Tile tile, int thing_id, String use)
	{
		GroundItem thing = ctx.groundItems.select().id(thing_id).nearest().poll();
		step_tile(ctx, tile);
		
		if (thing.valid())
		{
			if (!thing.inViewport())
			{
				ctx.camera.turnTo(thing.tile());
			}
			if (thing.interact(use))
			{
				wait_sleep(ctx);
			}
		}
	}
	
	default void use_grounditem(ClientContext ctx, int id, String use)
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
				wait_sleep(ctx);
			}
		}
	}
	
	default void use_grounditem(ClientContext ctx, int id, String use, int[] bounds)
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
				wait_sleep(ctx);
			}
		}
	}
	
	default boolean item_valid(ClientContext ctx, int id)
	{
		return ctx.inventory.select().id(id).poll().valid();
	}
	
	default boolean item_valid(ClientContext ctx, String name)
	{
		return ctx.inventory.select().name(name).poll().valid();
	}
	
	default void use_item(ClientContext ctx, int id, String use)
	{
		Item thing = ctx.inventory.select().id(id).poll();

		if (thing.valid())
		{
			if (!ctx.game.tab().equals(ctx.game.tab().INVENTORY))
			{
				ctx.game.tab(ctx.game.tab().INVENTORY);
			}
			if (thing.interact(use))
			{
				wait_sleep(ctx, 500);
			}
		}
	}
	
	default void use_item(ClientContext ctx, int id, String use, int sleep_time)
	{
		Item thing = ctx.inventory.select().id(id).poll();

		if (thing.valid())
		{
			if (!ctx.game.tab().equals(ctx.game.tab().INVENTORY))
			{
				ctx.game.tab(ctx.game.tab().INVENTORY);
			}
			if (thing.interact(use))
			{
				Condition.sleep(sleep_time);
			}
		}
	}
	
	default void use_item(ClientContext ctx, int[] id, String use)
	{
		Item thing = ctx.inventory.select().id(id).poll();

		if (thing.valid())
		{
			if (!ctx.game.tab().equals(ctx.game.tab().INVENTORY))
			{
				ctx.game.tab(ctx.game.tab().INVENTORY);
			}
			if (thing.interact(use))
			{
				wait_sleep(ctx, 500);
			}
		}
	}
	
	default void use_item(ClientContext ctx, String name, String use)
	{
		Item thing = ctx.inventory.select().name(name).poll();

		if (thing.valid())
		{
			if (!ctx.game.tab().equals(ctx.game.tab().INVENTORY))
			{
				ctx.game.tab(ctx.game.tab().INVENTORY);
			}
			if (thing.interact(use))
			{
				wait_sleep(ctx, 500);
			}
		}
	}
	
	default int item_amount(ClientContext ctx, int id)
	{
		Item thing = ctx.inventory.select().id(id).poll();
		int amount = 0;
		
		if (!thing.valid())
		{
			return 0;
		}
		if (thing.stackable())
		{
			amount = thing.stackSize();
		}
		else
		{
			Item[] inv = ctx.inventory.items();
			for (int counter = 0; counter < inv.length; counter++)
			{
				if (thing.id() == inv[counter].id())
				{
					amount++;
				}
			}
		}
		return amount;
	}
	
	default void drop_items(ClientContext ctx, int[] ids) 
	{		
		  ItemQuery<Item> items = ctx.inventory.select().id(ids);

		  if((ctx.varpbits.varpbit(1055) & 131072) > 0) 
		  {
			  ctx.input.send("{VK_SHIFT down}");
			  for (Item i : items)
			  {
				  i.click(true);
				  rand_sleep(100, 250);
			  }
			  ctx.input.send("{VK_SHIFT up}");
		  }
		  else
		  {
			  for (Item i : items)
			  {
				  i.interact(CONSTANTS.drop_interact);
				  rand_sleep(100, 250);
			  }
		  }

		  
	}
	
	default void open_bank(ClientContext ctx)
	{
		if (ctx.bank.opened())
		{
			return;
		}
		
		if (!ctx.bank.opened())
		{
			ctx.bank.open();
			wait_sleep(ctx);
		}
	}
	
	default void bank_inv(ClientContext ctx)
	{
		if (!ctx.bank.opened())
		{
			open_bank(ctx);
		}
		else
		{
			ctx.bank.depositInventory();
			Condition.sleep(1500);
			ctx.bank.close();
			Condition.sleep(1500);
		}
	}
	
	default void bank_all_item(ClientContext ctx, int item_id)
	{
		if (!ctx.bank.opened())
		{
			open_bank(ctx);
		}
		else
		{
			ctx.bank.deposit(item_id, 99999);
			Condition.sleep(1500);
			ctx.bank.close();
			Condition.sleep(1500);
		}
	}
	
	default void deposit_all(ClientContext ctx, int[] item_ids)
	{
		if (!ctx.bank.opened())
		{
			open_bank(ctx);
		}
		else
		{
			for (int counter = 0; counter < item_ids.length; counter++)
			{
				if (ctx.bank.deposit(item_ids[counter], 99999))
				{
					Condition.sleep(750);
				}
			}
		}
	}
	
	default void bank_items(ClientContext ctx, int[] item_ids)
	{
		if (!ctx.bank.opened())
		{
			open_bank(ctx);
		}
		else
		{
			for (int counter = 0; counter < item_ids.length; counter++)
			{
				if (ctx.bank.deposit(item_ids[counter], 99999))
				{
					Condition.sleep(750);
				}
			}
			ctx.bank.close();
			Condition.sleep(1500);
		}
	}
	
	default void exchange_bank(ClientContext ctx, int item_id, int amount)
	{
		if (!ctx.bank.opened())
		{
			open_bank(ctx);
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
	
	default void exchange_bank(ClientContext ctx, String item_name, int amount)
	{
		if (!ctx.bank.opened())
		{
			open_bank(ctx);
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
	
	default void withdraw_preset(ClientContext ctx, int[] items, int[] amount)
	{
		if (items.length != amount.length)
		{
			return;
		}
		if (!ctx.bank.opened())
		{
			open_bank(ctx);
		}
		
		ctx.bank.depositAllExcept(items);
		for (int i = 0; i < items.length; i++)
		{
			if (item_amount(ctx, items[i]) < amount[i])
			{
				ctx.bank.withdraw(items[i], amount[i] - item_amount(ctx, items[i]));
			}
		}
		ctx.bank.close();
	}
	
	default void withdraw(ClientContext ctx, int item, int amount)
	{
		if (!ctx.bank.opened())
		{
			open_bank(ctx);
		}
		ctx.bank.withdraw(item,  amount);
		ctx.bank.close();
	}
	
	default void withdraw(ClientContext ctx, int[] items, int[] amount)
	{
		if (items.length != amount.length)
		{
			return;
		}
		if (!ctx.bank.opened())
		{
			open_bank(ctx);
		}
		
		for (int i = 0; i < items.length; i++)
		{
			ctx.bank.withdraw(items[i],  amount[i]);
		}
		ctx.bank.close();
	}
	
	default void step_tile(ClientContext ctx, Tile tile)
	{
		ctx.movement.step(tile);
		Condition.sleep(1500);
		while (ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
	}
	
	default boolean idling(ClientContext ctx)
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
	
	default boolean idling(ClientContext ctx, int duration, int times)
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
	
	default void wait_sleep(ClientContext ctx)
	{
		Condition.sleep(1500);
		while (ctx.players.local().inMotion() || ctx.players.local().animation() != -1)
		{
			Condition.sleep(1000);
		}
	}
	
	default void wait_sleep(ClientContext ctx, int time)
	{
		Condition.sleep(time);
		while (ctx.players.local().inMotion() || ctx.players.local().animation() != -1)
		{
			Condition.sleep(1000);
		}
	}
	
	default void rand_sleep(int time1, int time2)
	{
		int a = (int) (Math.random() * time1);
		int b = (int) (Math.random() * time2);
		int wait = (a + b);
		Condition.sleep(wait);
	}
	
	default boolean valid_inv(ClientContext ctx, int[] items)
	{
		for (int i = 0; i < items.length; i++)
		{
			if ((!item_valid(ctx, items[i])))
			{
				return false;
			}
		}
		
		return true;
	}
	
	default void heal(ClientContext ctx)
	{
		Item[] inv = ctx.inventory.items();
		boolean ate = false;
		
		for (int i = 0; i < inv.length && !ate; i++)
		{
			for (int j = 0; j < inv[i].inventoryActions().length; j++)
			{
				if (inv[i].inventoryActions()[j] != null && inv[i].inventoryActions()[j].equals("Eat"))
				{
					inv[i].interact(CONSTANTS.food_interact);
					ate = true;
					Condition.sleep(3600);
				}
			}
		}
	}
	
	default boolean full_inv(ClientContext ctx)
	{
		return ctx.inventory.select().count() == 28;
	}

}
