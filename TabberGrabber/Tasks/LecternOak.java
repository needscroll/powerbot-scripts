package needscroll.TabberGrabber.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.Item;

import needscroll.TabberGrabber.Task;

public class LecternOak extends Task{
	
	final static int LECTERN = 13642; // need change()
	final static int CLAY = 1761;
	public static String STATUS = "";
	
	public LecternOak(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() 
	{
		Component create = ctx.widgets.widget(1371).component(5);
		Item clay = ctx.backpack.select().id(CLAY).poll();
		
		boolean sleep_pass = sleepwait();
		boolean clay_exists = clay.id() == CLAY;
		boolean craft_not_open = !create.valid();
		
		return clay_exists && craft_not_open && sleep_pass;
	}

	@Override
	public void execute()
	{
		STATUS = "Lectern";
		GameObject lectern = ctx.objects.select().id(LECTERN).nearest().poll();
		
		lectern.interact("Study");
		Condition.sleep(3000);
		while (ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
		STATUS = "";
	}
	
	private boolean sleepwait()
	{
		boolean pass = true;
		
		for (int counter = 0; counter < 8; counter++)
		{
			if (ctx.players.local().animation() != -1)
			{
				pass = false;
			}
				Condition.sleep(600);
		}
		
		return pass;
	}
	
	public String get_status()
	{
		return STATUS;
	}

}