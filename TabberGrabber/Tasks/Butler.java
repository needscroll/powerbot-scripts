package needscroll.TabberGrabber.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Item;
import org.powerbot.script.rt6.Npc;
import needscroll.TabberGrabber.Task;

public class Butler extends Task{
	
	final static int BUTLER = 4241;
	final static int CLAY = 1761;
	public static String STATUS = "";

	public Butler(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		return !exists(CLAY);
	}

	@Override
	public void execute() 
	{
		STATUS = "Butler";
		Npc butler = ctx.npcs.select().id(BUTLER).nearest().poll();
		
		butler.interact("Fetch-from-bank");
		Condition.sleep(1000);
		
		while(ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
		STATUS = "";
	}
	
	private boolean exists(int id)
	{
		boolean exist = false;
		Item[] inv = ctx.backpack.items();
		
		for (int counter = 0; counter < inv.length; counter++)
		{
			if (inv[counter].id() == id)
			{
				exist = true;
			}
		}
		
		return exist;
	}
	
	public String get_status()
	{
		return STATUS;
	}

}
