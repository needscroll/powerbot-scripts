package Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.Item;

import needscroll.FreeRunecrafter.Task;

public class CraftWater extends Task{

	final static int WATER_ALTER_R = 2454;
	final static int WATER_ALTER_I = 2480;
	final static int PORTAL = 2467;
	final static int BANK = 2015;
	final static int WATER_RUNE = 555;
	final static int ECCENCE = 7936;
	public static int RUNES_MADE = 0;

	public CraftWater(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		return true;
	}

	@Override
	public void execute() 
	{
		Tile water_a = new Tile(3163, 3185, 0); // area check if next to alter
		Tile water_a1 = new Tile(3168, 3190, 0);
		Tile water_a2 = new Tile(3158, 3180, 0);
		Area alter_area = new Area(water_a1, water_a2);
		
		Tile water_I = new Tile(3493, 4832, 0); // area for place inside alter to check if in alter
		Tile water_I1 = new Tile(3503, 4842, 0);
		Tile water_I2 = new Tile(3483, 4822, 0);
		Area alter_inside = new Area(water_I1, water_I2);
		
		Tile water_b = new Tile(3093, 3243, 0); // area for inside bank
		Tile water_b1 = new Tile(3098, 3248, 0);
		Tile water_b2 = new Tile(3088, 3238, 0);
		Area bank_area = new Area(water_b1, water_b2);
		
		boolean full = ctx.backpack.select().count() == 28;
		boolean in_ruin_area = alter_area.contains(ctx.players.local().tile());
		boolean in_alter_inside = alter_inside.contains(ctx.players.local().tile());
		boolean in_bank = bank_area.contains(ctx.players.local().tile());
		
		if (full && !in_ruin_area && !in_alter_inside)
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
		Tile water_a = new Tile(3163, 3185, 0);
		
		ctx.movement.step(water_a);
		Condition.sleep(1000);
		while(ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
		
	}
	
	private void enter_alter()
	{
		GameObject alter_r = ctx.objects.select().id(WATER_ALTER_R).nearest().poll();
		
		alter_r.interact("Enter");
		Condition.sleep(5000);
		while(ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
	}

	private void craft()
	{
		GameObject alter_i = ctx.objects.select().id(WATER_ALTER_I).nearest().poll();
		ctx.camera.turnTo(alter_i.tile());
		
		alter_i.interact("Craft-rune");
		Condition.sleep(1000);
		while(ctx.players.local().inMotion() || ctx.players.local().animation() == 23250)
		{
			Condition.sleep(1000);
		}
		
		Item water_rune = ctx.backpack.select().id(WATER_RUNE).poll();
		RUNES_MADE += water_rune.stackSize();
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
		Tile water_b = new Tile(3093, 3243, 0); 
		
		ctx.movement.step(water_b);
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
