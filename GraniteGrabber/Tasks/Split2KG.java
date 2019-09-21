package needscroll.GraniteGrabber.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;
import org.powerbot.script.rt6.Item;
import org.powerbot.script.rt6.Npc;

import needscroll.GraniteGrabber.Task;

public class Split2KG extends Task{
	
	final static int SPLIT_ANIMATION = 11146;
	final static int GRANITE_ORE[] = {6981, 6983};
	final static int BANKER = 3293;

	public Split2KG(ClientContext ctx) {
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
		Item granite = ctx.backpack.select().id(GRANITE_ORE).poll();
		Component cut = ctx.widgets.widget(1370).component(38);
		
		if (granite_exists())
		{
			granite.interact("Craft");
			Condition.sleep(1000);
		}
		if (cut.valid() && granite_exists())
		{
			cut.click(true);
			Condition.sleep(650);
		}
		if (!granite_exists() || ctx.backpack.select().count() > 24)
		{
			open_bank();
		}
		
		if (ctx.bank.opened())
		{
			get_items(GRANITE_ORE[0], 7);
		}
		
		if (!in_place())
		{
			walk_ge();
		}
		
	}
	
	protected void get_items(int id, int amount)
	{
		if (!ctx.bank.opened())
		{
			open_bank();
		}
		
		if (ctx.bank.opened())
		{
			ctx.input.send("1");
			Condition.sleep(650);
		}
		
		/*
		if (ctx.bank.opened())
		{
			ctx.bank.depositInventory();
			Condition.sleep(650);
			ctx.bank.withdraw(id, amount);
			Condition.sleep(650);
			ctx.bank.close();
			Condition.sleep(650);
		}
		*/
	}
	
	protected void open_bank()
	{
		if (ctx.bank.opened())
		{
			return;
		}
		
		Npc bank = ctx.npcs.select().id(BANKER).nearest().poll();
		bank.interact("Bank");
		Condition.sleep(1000);
		
		while(ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
	}
	
	protected void walk_ge()
	{
		Tile ge = new Tile(3148, 3476, 0); //area for ge sw bank
		
		ctx.movement.step(ge);
		Condition.sleep(1000);
		while(ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
	}
	
	protected boolean in_place()
	{
		boolean inplace = false;
		
		Tile ge = new Tile(3148, 3476, 0); //area for ge sw bank
		Tile ge1 = new Tile(3152, 3473, 0);
		Tile ge2 = new Tile(3144, 3481, 0);
		Area ge_area = new Area(ge1, ge2);
		
		if (ge_area.contains(ctx.players.local()))
		{
			inplace = true;
		}
		
		return inplace;
	}
	
	protected boolean granite_exists()
	{
		boolean exists = false;
		Item[] inv = ctx.backpack.items();
		
		for (int counter = 0; counter < inv.length; counter++)
		{
			if (inv[counter].id() == GRANITE_ORE[0] || inv[counter].id() == GRANITE_ORE[1])
			{
				exists = true;
			}
		}
		
		return exists;
	}

	protected boolean idling()
	{
		boolean idle = true;
		
		for (int counter = 0; counter < 2; counter++)
		{
			if (ctx.players.local().animation() == SPLIT_ANIMATION)
			{
				idle = false;
			}
			Condition.sleep(600);
		}
		
		return idle;
	}
}
