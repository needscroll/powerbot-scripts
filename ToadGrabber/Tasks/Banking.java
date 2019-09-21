package needscroll.ToadGrabber.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;

import needscroll.ToadGrabber.Task;

public class Banking extends Task{
	
	final static int[] BANK = {69024, 69018, 69019, 69023};
	final static int STAIR = 69504;

	public Banking(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() 
	{
		Tile bank1 = new Tile(2440, 3423, 1);
		Tile bank2 = new Tile(2450, 3443, 1);
		Area bank_area = new Area(bank1, bank2);
		
		return bank_area.contains(ctx.players.local());
	}

	@Override
	public void execute() 
	{
		boolean full = ctx.backpack.select().count() == 28;
		
		if (full)
		{
			bank();
		}
		if(!full)
		{
			leave();
		}
		if(ctx.bank.open())
		{
			get_items();
		}
	}
	
	private void bank()
	{
		if (ctx.bank.open())
		{
			return;
		}
		
		GameObject bank = ctx.objects.select().id(BANK).nearest().poll();
		
		if (!bank.inViewport())
		{
			ctx.camera.turnTo(bank.tile());
		}
		
		bank.interact("Bank");
		Condition.sleep(1000);
		while(ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
	}
	
	private void get_items()
	{
		if (!ctx.bank.open())
		{
			bank();
		}
		
		if (ctx.bank.open())
		{
			ctx.bank.depositInventory();
			Condition.sleep(2000);
			ctx.bank.close();
			Condition.sleep(1000);
		}
	}
	
	private void leave()
	{
		GameObject stairs = ctx.objects.select().id(STAIR).nearest().poll();
		
		if (!stairs.inViewport())
		{
			ctx.camera.turnTo(stairs.tile());
		}
		
		stairs.interact("Climb-down");
		Condition.sleep(1000);
		while(ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
	}

}
