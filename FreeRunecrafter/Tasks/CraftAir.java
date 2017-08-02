package Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;

import needscroll.FreeRunecrafter.Task;

public class CraftAir extends Task{
	
	final static int AIR_ALTER_R = 2452;
	final static int AIR_ALTER_I = 2478;
	final static int PORTAL = 2465;
	final static int BANK = 782;
	final static int ECCENCE = 7936;

	public CraftAir(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		Tile air_b1 = new Tile(3195, 3445, 0); // area check if in varrock west bank
		Tile air_b2 = new Tile(3176, 3425, 0);
		Area bank_area = new Area(air_b1, air_b2);
		
		return true;
	}

	@Override
	public void execute() 
	{
		Tile air_a = new Tile(3131, 3408, 0); // area check if next to alter
		Tile air_a1 = new Tile(3135, 3412, 0);
		Tile air_a2 = new Tile(3124, 3401, 0);
		Area alter_area = new Area(air_a1, air_a2);
		
		Tile air_I = new Tile(2841, 4830, 0); // area for place inside alter to check if in alter
		Tile air_I1 = new Tile(2851, 4840, 0);
		Tile air_I2 = new Tile(2831, 4820, 0);
		Area alter_inside = new Area(air_I1, air_I2);
		
		Tile air_b = new Tile(3186, 3435, 0); // area for inside bank
		Tile air_b1 = new Tile(3191, 3440, 0);
		Tile air_b2 = new Tile(3181, 3430, 0);
		Area bank_area = new Area(air_b1, air_b2);
		
		boolean full = ctx.backpack.select().count() == 28;
		boolean in_ruin_area = alter_area.contains(ctx.players.local().tile());
		boolean in_alter_inside = alter_inside.contains(ctx.players.local().tile());
		boolean in_bank = bank_area.contains(ctx.players.local().tile());
		
		if (full && !in_ruin_area)
		{
			walk_alter();
			System.out.println("walk alter");
		}
		if (full && !in_alter_inside)
		{
			enter_alter();
			System.out.println("enter alter");
		}
		if (full && in_alter_inside)
		{
			craft();
			System.out.println("craft stuff");
		}
		if (!full && in_alter_inside)
		{
			leave();
			System.out.println("leaving");
		}
		if (!full && !in_bank)
		{
			go_bank();
			System.out.println("walk bank");
		}
		if (!full && in_bank)
		{
			get_items();
			System.out.println("get items");
		}
		
		//walk_alter();
		//enter_alter();
		//craft();
		//leave();
		//go_bank();
		//get_items();
	}

	private void walk_alter()
	{	
		Tile air_a = new Tile(3131, 3408, 0);
		
		ctx.movement.step(air_a);
		Condition.sleep(1000);
		while(ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
		
	}
	
	private void enter_alter()
	{
		GameObject alter_r = ctx.objects.select().id(AIR_ALTER_R).nearest().poll();
		
		alter_r.interact("Enter");
		Condition.sleep(5000);
		while(ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
	}

	private void craft()
	{
		GameObject alter_i = ctx.objects.select().id(AIR_ALTER_I).nearest().poll();
		
		alter_i.interact("Craft-rune");
		Condition.sleep(1000);
		while(ctx.players.local().inMotion() || ctx.players.local().animation() == 23250)
		{
			Condition.sleep(1000);
		}
	}
	
	private void leave()
	{
		GameObject exit = ctx.objects.select().id(PORTAL).nearest().poll();
		exit.interact("Enter");
		Condition.sleep(5000);
		while(ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
	}
	
	private void go_bank()
	{
		Tile air_b = new Tile(3186, 3435, 0);
		
		ctx.movement.step(air_b);
		Condition.sleep(1000);
		while(ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
	}
	
	private void banking()
	{
		GameObject bank = ctx.objects.select().id(BANK).nearest().poll();
		Condition.sleep(1000);
		bank.interact("Bank");
		while(ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
	}
	
	private void get_items()
	{
		while (!ctx.bank.open())
		{
			banking();
		}
		
		if (ctx.bank.open())
		{
			ctx.bank.depositInventory();
			Condition.sleep(2000);
			ctx.bank.withdraw(ECCENCE, 28);
			Condition.sleep(2000);
			ctx.bank.close();
		}
	}
}
