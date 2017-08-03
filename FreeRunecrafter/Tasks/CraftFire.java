package Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.Item;

import needscroll.FreeRunecrafter.Task;

public class CraftFire extends Task{

	final static int FIRE_ALTER_R = 2456;
	final static int FIRE_ALTER_I = 2482;
	final static int PORTAL = 2469;
	final static int BANK = 83954;
	final static int FIRE_RUNE = 554;
	final static int ECCENCE = 7936;
	public static int RUNES_MADE = 0;

	public CraftFire(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		return true;
	}

	@Override
	public void execute() 
	{
		Tile fire_a = new Tile(3310, 3252, 0); // area check if next to alter
		Tile fire_a1 = new Tile(3320, 3262, 0);
		Tile fire_a2 = new Tile(3300, 3242, 0);
		Area alter_area = new Area(fire_a1, fire_a2);
		
		Tile fire_I = new Tile(2577, 4846, 0); // area for place inside alter to check if in alter
		Tile fire_I1 = new Tile(2587, 4856, 0);
		Tile fire_I2 = new Tile(2567, 4836, 0);
		Area alter_inside = new Area(fire_I1, fire_I2);
		
		Tile fire_b = new Tile(3347, 3238, 0); // area for inside bank
		Tile fire_b1 = new Tile(3345, 3240, 0);
		Tile fire_b2 = new Tile(3350, 3235, 0);
		Area bank_area = new Area(fire_b1, fire_b2);
		
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
		Tile fire_a = new Tile(3310, 3252, 0);
		
		ctx.movement.step(fire_a);
		Condition.sleep(1000);
		while(ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
		
	}
	
	private void enter_alter()
	{
		GameObject alter_r = ctx.objects.select().id(FIRE_ALTER_R).nearest().poll();
		
		alter_r.interact("Enter");
		Condition.sleep(5000);
		while(ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
	}

	private void craft()
	{
		GameObject alter_i = ctx.objects.select().id(FIRE_ALTER_I).nearest().poll();
		ctx.camera.turnTo(alter_i.tile());
		
		alter_i.interact("Craft-rune");
		Condition.sleep(1000);
		while(ctx.players.local().inMotion() || ctx.players.local().animation() == 23250)
		{
			Condition.sleep(1000);
		}
		
		Item fire_rune = ctx.backpack.select().id(FIRE_RUNE).poll();
		RUNES_MADE += fire_rune.stackSize();
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
		Tile fire_b = new Tile(3347, 3238, 0);
		
		ctx.movement.step(fire_b);
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
		bank.interact("Use");
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
