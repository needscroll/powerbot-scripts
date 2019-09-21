package needscroll.CursedGrabber.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;
import org.powerbot.script.rt6.Item;
import org.powerbot.script.rt6.Npc;

import needscroll.CursedGrabber.Task;

public class Banking extends Task{
	
	final static int BANKER_ID = 1787;
	final static int CURSED_E = 37941;
	public static int AMOUNT = 0;

	public Banking(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		Tile bank1 = new Tile(3053, 3627, 0);
		Tile bank2 = new Tile(3042, 3638, 0);
		Area bank_area = new Area(bank1, bank2);
		
		Item energy = ctx.backpack.select().id(CURSED_E).poll();
		
		return bank_area.contains(ctx.players.local());
	}

	@Override
	public void execute() {
		Component deposit_component = ctx.widgets.widget(762).component(75); // new duct tape code
		if (!deposit_component.valid())//!ctx.bank.open())
		{
			open_bank();
		}
		
		if (deposit_component.valid())//ctx.bank.open())
		{
			get_items();
		}
		
	}
	
	private void open_bank()
	{
		Component deposit_component = ctx.widgets.widget(762).component(75); // new duct tape code
		if (deposit_component.valid())//ctx.bank.open()) // new duct tape code
		{
			return;
		}
		if (ctx.bank.open())
		{
			return;
		}
		
		Npc banker = ctx.npcs.select().id(BANKER_ID).nearest().poll();
		ctx.camera.turnTo(banker.tile());
		if (banker.interact("Bank"))
		{
			Condition.sleep(1000);
		}
	}
	
	private void get_items()
	{
		Component deposit_component = ctx.widgets.widget(762).component(75); // new duct tape code
		Component close_component = ctx.widgets.widget(762).component(516); // new duct tape code

		if (!deposit_component.valid())//!ctx.bank.open())
		{
			open_bank();
		}
		/*
		if (!ctx.bank.open())
		{
			open_bank();
		}*/
		
		Item energy = ctx.backpack.select().id(CURSED_E).poll();
		AMOUNT += energy.stackSize();
		
		//ctx.bank.depositInventory();
		deposit_component.click(true);
		Condition.sleep(700);
		//ctx.bank.close();
		close_component.click(true);
		Condition.sleep(700);
		go_load();
	}
	
	private void go_load()
	{
		Component cont = ctx.widgets.widget(1186).component(4);
		Component yes = ctx.widgets.widget(1188).component(6);
		
		ctx.input.send("t");
		Condition.sleep(4000);
		ctx.input.send("w");
		Condition.sleep(2000);
		cont.click(true);
		Condition.sleep(2000);
		yes.click(true);
		Condition.sleep(20000);
	}
	
	public static int get_amount()
	{
		return AMOUNT;
	}

}
