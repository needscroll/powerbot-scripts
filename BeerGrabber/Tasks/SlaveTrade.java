package needscroll.BeerGrabber.Tasks;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.System;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Item;
import org.powerbot.script.rt4.Player;

import needscroll.BeerGrabber.Task;

public class SlaveTrade extends Task{
	
	public static double old = System.currentTimeMillis(); // last traded time

	public SlaveTrade(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		double now = System.currentTimeMillis(); // current time
		
		Player mule = ctx.players.select().name(CONSTANTS.mule_name).nearest().poll();
		return mule.valid() && CONSTANTS.bank_area.contains(ctx.players.local()) && (now - old)/1000 > 1000; //good if 1000 second pass since last trade
	}

	@Override
	public void execute() {
		Player mule = ctx.players.select().name(CONSTANTS.mule_name).nearest().poll();
		Component trade_window = ctx.widgets.widget(CONSTANTS.trade_window_widget).component(CONSTANTS.trade_window_component);
		Component trade_window2 = ctx.widgets.widget(CONSTANTS.trade_window_widget2).component(CONSTANTS.trade_window_component2);
		Component accept1 = ctx.widgets.widget(CONSTANTS.accept1_widget).component(CONSTANTS.accept1_component);
		Component accept2 = ctx.widgets.widget(CONSTANTS.accept2_widget).component(CONSTANTS.accept2_component);
		Date now = new Date();
		
		if (!has_note() && !trade_window.valid() && !trade_window2.valid())
		{
			get_note();
		}
		if (!trade_window.valid() && has_note())
		{
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
				if (!trade_window.valid() && !trade_window2.valid())
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
		
		Item beer_noted = ctx.inventory.select().id(CONSTANTS.beer_noted).poll();
		if (beer_noted.valid())
		{
			has = true;
		}
		
		return has;
	}

	private void get_note()
	{
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
			ctx.bank.withdrawModeNoted(true);
			Condition.sleep(500);
			
			for (int counter = 0; counter < CONSTANTS.items.length; counter++)
			{
				ctx.bank.withdraw(CONSTANTS.items[counter], 9999);
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
			item.interact(CONSTANTS.item_interact);
			Condition.sleep(1500);
		}
	}
}
