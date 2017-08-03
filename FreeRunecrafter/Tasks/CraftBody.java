package Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.Item;

import needscroll.FreeRunecrafter.Task;

public class CraftBody extends Task{

	final static int BODY_ALTER_R = 2457;
	final static int BODY_ALTER_I = 2483;
	final static int PORTAL = 2470;
	final static int[] BANK = {42377, 42378, 42217};
	final static int BODY_RUNE = 559;
	final static int ECCENCE = 7936;
	public static int RUNES_MADE = 0;

	public CraftBody(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		return true;
	}

	@Override
	public void execute() 
	{
		Tile body_a = new Tile(3055, 3444, 0); // area check if next to alter
		Tile body_a1 = new Tile(3048, 3450, 0);
		Tile body_a2 = new Tile(3060, 3438, 0);
		Area alter_area = new Area(body_a1, body_a2);
		
		Tile body_I = new Tile(2521, 4847, 0); // area for place inside alter to check if in alter
		Tile body_I1 = new Tile(2512, 4855, 0);
		Tile body_I2 = new Tile(2528, 4836, 0);
		Area alter_inside = new Area(body_I1, body_I2);
		
		Tile body_b = new Tile(3094, 3494, 0); // area for inside bank
		Tile body_b1 = new Tile(3089, 3501, 0);
		Tile body_b2 = new Tile(3099, 3486, 0);
		Area bank_area = new Area(body_b1, body_b2);
		
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
		Tile body_a = new Tile(3055, 3444, 0);
		
		ctx.movement.step(body_a);
		Condition.sleep(1000);
		while(ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
		
	}
	
	private void enter_alter()
	{
		GameObject alter_r = ctx.objects.select().id(BODY_ALTER_R).nearest().poll();
		
		alter_r.interact("Enter");
		Condition.sleep(5000);
		while(ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
	}

	private void craft()
	{
		GameObject alter_i = ctx.objects.select().id(BODY_ALTER_I).nearest().poll();
		ctx.camera.turnTo(alter_i.tile());
		
		alter_i.interact("Craft-rune");
		Condition.sleep(1000);
		while(ctx.players.local().inMotion() || ctx.players.local().animation() == 23250)
		{
			Condition.sleep(1000);
		}
		
		Item body_rune = ctx.backpack.select().id(BODY_RUNE).poll();
		RUNES_MADE += body_rune.stackSize();
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
		Tile body_b = new Tile(3094, 3494, 0);
		
		ctx.movement.step(body_b);
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
