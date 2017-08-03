package Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.Item;

import needscroll.FreeRunecrafter.Task;

public class CraftEarth extends Task{

	final static int EARTH_ALTER_R = 2455;
	final static int EARTH_ALTER_I = 2481;
	final static int PORTAL = 2468;
	final static int BANK = 782;
	final static int EARTH_RUNE = 557;
	final static int ECCENCE = 7936;
	public static int RUNES_MADE = 0;

	public CraftEarth(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		return true;
	}

	@Override
	public void execute() 
	{
		Tile earth_a = new Tile(3303, 3475, 0); // area check if next to alter
		Tile earth_a1 = new Tile(3300, 3479, 0);
		Tile earth_a2 = new Tile(3310, 3468, 0);
		Area alter_area = new Area(earth_a1, earth_a2);
		
		Tile earth_I = new Tile(2657, 4830, 0); // area for place inside alter to check if in alter
		Tile earth_I1 = new Tile(2667, 4845, 0);
		Tile earth_I2 = new Tile(2647, 4815, 0);
		Area alter_inside = new Area(earth_I1, earth_I2);
		
		Tile earth_b = new Tile(3254, 3421, 0); // area for inside bank
		Tile earth_b1 = new Tile(3259, 3426, 0);
		Tile earth_b2 = new Tile(3249, 3416, 0);
		Area bank_area = new Area(earth_b1, earth_b2);
		
		boolean full = ctx.backpack.select().count() == 28;
		boolean in_ruin_area = alter_area.contains(ctx.players.local().tile());
		boolean in_alter_inside = alter_inside.contains(ctx.players.local().tile());
		boolean in_bank = bank_area.contains(ctx.players.local().tile());
		
		if (full && !in_alter_inside && !in_ruin_area)
		{
			walk_alter();
			System.out.println("walk alter");
		}
		if (full && !in_alter_inside && in_ruin_area)
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
	}

	private void walk_alter()
	{	
		Tile earth_a = new Tile(3304, 3475, 9);
		
		ctx.movement.step(earth_a);
		Condition.sleep(1000);
		while(ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
		
	}
	
	private void enter_alter()
	{
		GameObject alter_r = ctx.objects.select().id(EARTH_ALTER_R).nearest().poll();
		
		alter_r.interact("Enter");
		Condition.sleep(5000);
		while(ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
	}

	private void craft()
	{
		GameObject alter_i = ctx.objects.select().id(EARTH_ALTER_I).nearest().poll();
		ctx.camera.turnTo(alter_i.tile());
		
		alter_i.interact("Craft-rune");
		Condition.sleep(1000);
		while(ctx.players.local().inMotion() || ctx.players.local().animation() == 23250)
		{
			Condition.sleep(1000);
		}
		
		Item earth_rune = ctx.backpack.select().id(EARTH_RUNE).poll();
		RUNES_MADE += earth_rune.stackSize();
	}
	
	private void leave()
	{
		GameObject exit = ctx.objects.select().id(PORTAL).nearest().poll();
		ctx.camera.turnTo(exit.tile());
		
		exit.interact("Enter");
		Condition.sleep(5000);
		while(ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
	}
	
	private void go_bank()
	{
		Tile earth_b = new Tile(3254, 3421, 0);
		
		ctx.movement.step(earth_b);
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
	
	public int get_runes()
	{
		return RUNES_MADE;
	}
}
