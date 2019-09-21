package needscroll.LimpwurtGrabber.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Equipment;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.Item;
import org.powerbot.script.rt6.Npc;

import needscroll.LimpwurtGrabber.Task;

public class Banking extends Task{
	
	final static int BANKER = 3293;
	final static int KEY = 983;
	final static int[] WEALTH = {20659, 20657, 20655, 20653, 2572};
	public static String STATUS = "";
	final static int GE_BANK = 87989;

	public Banking(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		
		return CONSTANTS.bank_area.contains(ctx.players.local()) && ctx.backpack.select().count() == 28;
	}

	@Override
	public void execute() 
	{	
		STATUS = "Banking";
		if (!ctx.bank.opened())
		{
			open_bank();	
		}
		if (ctx.bank.opened())
		{
			use_bank();
		}
		STATUS = "";
	}
	
	private void open_bank()
	{
		if (ctx.bank.opened())
		{
			return;
		}
		
		//Tile bank_tile = new Tile(3149, 3474, 0);
		//Npc banker = ctx.npcs.select().id(BANKER).nearest().poll();
		Tile bank_tile = new Tile(3162, 3456, 0);
		GameObject banker = ctx.objects.select().id(CONSTANTS.well).nearest().poll();
		
		ctx.camera.turnTo(banker.tile());
		
		if (banker.interact("Open Bank"))
		{
			Condition.sleep(1000);
			while(ctx.players.local().inMotion())
			{
				Condition.sleep(1000);
			}
		}
		else
		{
			ctx.movement.step(bank_tile);
			while(ctx.players.local().inMotion())
			{
				Condition.sleep(1000);
			}
			banker.interact("Bank");
			Condition.sleep(1000);
			while(ctx.players.local().inMotion())
			{
				Condition.sleep(1000);
			}
		}
	}
	
	private void use_bank()
	{
		if (ctx.bank.opened())
		{
			Item ring_w = ctx.equipment.itemAt(Equipment.Slot.RING);
			boolean ring_fail = ring_w.id() == WEALTH[4];
			
			ctx.bank.depositInventory();
			Condition.sleep(2000);
			
			if (ring_fail)
			{
				ctx.bank.withdraw(WEALTH[0], 1);
				Condition.sleep(2000);
				
				Item ring = ctx.backpack.select().id(WEALTH[0]).poll();
				ring.interact("Wear");
				Condition.sleep(2000);
				ctx.bank.depositInventory();
				Condition.sleep(2000);
			}
			ctx.bank.withdraw(KEY, 1);
			Condition.sleep(2000);
			
			ctx.bank.close();
		}
	}
	
	public String get_status()
	{
		return STATUS;
	}

}
