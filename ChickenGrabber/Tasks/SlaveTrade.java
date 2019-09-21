package needscroll.ChickenGrabber.Tasks;

import java.lang.System;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.Item;
import org.powerbot.script.rt4.Player;

public class SlaveTrade extends Action{
	
	public static double old = System.currentTimeMillis(); // last traded time

	public SlaveTrade(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		double now = System.currentTimeMillis(); // current time
		return (now - old)/1000 > 5000; //good if 3000 second pass since last trade
	}

	@Override
	public void execute() {
		Player mule = ctx.players.select().name(CONSTANTS.mule_name).nearest().poll();
		Component trade_window = ctx.widgets.widget(CONSTANTS.trade_window_widget).component(CONSTANTS.trade_window_component);
		Component trade_window2 = ctx.widgets.widget(CONSTANTS.trade_window_widget2).component(CONSTANTS.trade_window_component2);
		Component accept1 = ctx.widgets.widget(CONSTANTS.accept1_widget).component(CONSTANTS.accept1_component);
		Component accept2 = ctx.widgets.widget(CONSTANTS.accept2_widget).component(CONSTANTS.accept2_component);
		
		if (!CONSTANTS.fally_bank_area.contains(ctx.players.local()))
		{
			if (CONSTANTS.back_store_area.contains(ctx.players.local()))
			{
				use_object(CONSTANTS.back_door, CONSTANTS.back_door_interact);
			}
			else
			{
				step_use_object(CONSTANTS.fally_bank, CONSTANTS.bank_booth, CONSTANTS.bank_booth_interact);
			}
		}
		
		if (!has_note() && !trade_window.valid() && !trade_window2.valid() && CONSTANTS.fally_bank_area.contains(ctx.players.local()))
		{
			get_note();
		}
		if (!trade_window.valid() && has_note() && CONSTANTS.fally_bank_area.contains(ctx.players.local()) && mule.valid())
		{
			ctx.movement.step(mule.tile());
			Condition.sleep(1000);
			mule.interact(CONSTANTS.mule_interact);
			Condition.sleep(5000);
		}
		if (accept1.valid())
		{
			offer_all();
			accept1.click(true);
			Condition.sleep(5000);
		}
		if (accept2.valid())
		{
			if (accept2.click(true))
			{
				Condition.sleep(5000);
				if (!has_note())
				{
					old = System.currentTimeMillis();
					SlaveTrade.old = System.currentTimeMillis();
				}
			}
		}
	}
	
	private boolean has_note()
	{
		boolean has = false;
		
		for (int counter = 0; counter < CONSTANTS.noted_items.length; counter++)
		{
			if (item_valid(CONSTANTS.noted_items[counter]))
			{
				has = true;
			}
		}
		
		return has;
	}

	private void get_note()
	{
		if (!ctx.bank.opened())
		{
			use_object(CONSTANTS.bank_booth, CONSTANTS.bank_booth_interact);
		}
		if (ctx.bank.opened())
		{
			ctx.bank.depositInventory();
			Condition.sleep(500);
			ctx.bank.withdrawModeNoted(true);
			Condition.sleep(500);

			for (int counter = 0; counter < CONSTANTS.trading_items.length; counter++)
			{
				Item thing = ctx.bank.select().id(CONSTANTS.trading_items[counter]).poll();
				ctx.bank.withdraw(thing, 9999);
				Condition.sleep(700);
			}

			ctx.bank.close();
			Condition.sleep(1000);
		}
	}
	
	private void offer_all()
	{
		for (int counter = 0; counter < CONSTANTS.noted_items.length; counter++)
		{
			Item item = ctx.inventory.select().id(CONSTANTS.noted_items[counter]).poll();
			item.interact(CONSTANTS.offer_all_interact);
			Condition.sleep(1500);
		}
	}
}