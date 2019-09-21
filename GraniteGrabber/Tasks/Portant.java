package needscroll.GraniteGrabber.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;
import org.powerbot.script.rt6.Item;
import org.powerbot.script.rt6.Npc;

import needscroll.GraniteGrabber.Task;

public class Portant extends Task{
	
	final static int ENERGY = 29315;
	final static int PORTER = 29277;
	final static int NECKLACE = 1656;
	final static int CREATE_ANIMATION = 21248;
	final static int BANKER = 3293;

	public Portant(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return idling();
	}

	@Override
	public void execute() 
	{
		Component create = ctx.widgets.widget(1370).component(38);
		Component porter = ctx.widgets.widget(1371).component(44).component(33);
		Item energy = ctx.backpack.select().id(ENERGY).poll();
		
		if (energy.stackSize() > 35 && necklace_exists())
		{
			energy.click("Weave");
			Condition.sleep(2000);
		}
		
		if (necklace_exists() && create.valid())
		{
			porter.click(true);
			Condition.sleep(1500);
			
			create.click(true);
			Condition.sleep(1500);
		}
		
		if (!necklace_exists() && energy.stackSize() > 35)
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
		if (ctx.bank.opened())
		{
			return;
		}
		
		Npc bank = ctx.npcs.select().id(BANKER).nearest().poll();
		bank.interact("Bank");
		Condition.sleep(2000);
		
		while(ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
	}
	
	private void get_items()
	{
		if (!ctx.bank.opened())
		{
			open_bank();
		}
		
		if (ctx.bank.open())
		{
			ctx.bank.depositAllExcept(ENERGY);
			Condition.sleep(1500);
			ctx.bank.withdraw(NECKLACE, 27);
			Condition.sleep(1500);
			ctx.bank.close();
		}
	}
	
	private boolean necklace_exists()
	{
		boolean exists = false;
		Item[] inv = ctx.backpack.items();
		
		for (int counter = 0; counter < inv.length; counter++)
		{
			if (inv[counter].id() == NECKLACE)
			{
				exists = true;
			}
		}
		
		return exists;
	}
	
	private boolean idling()
	{
		boolean idle = true;
		
		for (int counter = 0; counter < 6; counter++)
		{
			if (ctx.players.local().animation() == CREATE_ANIMATION)
			{
				idle = false;
			}
			Condition.sleep(600);
		}
		
		return idle;
	}
	

}
