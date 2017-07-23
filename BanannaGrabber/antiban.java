package needscroll.BanannaGrabber;

import org.powerbot.script.Condition;
import org.powerbot.script.rt6.Item;
import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;
import org.powerbot.script.rt6.GameObject;

public class antiban extends ClientAccessor{
	
	private final int EDGE_BANK = 42378;
	
	public antiban(ClientContext ctx)
	{
		super(ctx);
	}
	
	public void run_antiban()
	{
		int random_chance = (int) (Math.random() * 1000);
		int random_sleep = (int) (Math.random() * 10000);
		
		if (random_chance < 50)
		{
			Condition.sleep(random_sleep);
		}
	}
	
	public void run_failsafe(Item[][] invstates, int[] failsafecounter, String bankchoice)
	{
		boolean stuck = false;
		check_cam();
		failsafecounter[0]++;
		
		if (failsafecounter[0] == 2)
		{
			invstates[0] = ctx.backpack.items();
			stuck = is_same(invstates);
		}
		if (failsafecounter[0] == 4)
		{
			invstates[1] = ctx.backpack.items();
			stuck = is_same(invstates);
		}
		if (failsafecounter[0] == 7)
		{
			invstates[2] = ctx.backpack.items();
			stuck = is_same(invstates);
			failsafecounter[0] = 0;
		}
		
		if (stuck)
		{
			unstick(bankchoice);
		}

	}
	
	private boolean is_same(Item[][] invstates)
	{
		boolean same = true;
		
		for (int counter = 0; counter < invstates.length - 1; counter++)
		{
			for (int counter1 = 0; counter1 < invstates[counter].length; counter1++)
			{
				if (invstates[counter][counter1] != invstates[counter + 1][counter1])
				{
					same = false;
				}
			}
			
		}
		
		return same;
	}
	
	private void unstick(String bankchoice)
	{
		Component amulet = ctx.widgets.widget(1464).component(14).component(2);
		teleport fixer = new teleport(ctx);
		fixer.fix_tele();
		
		banking fix_banking = new banking(ctx);
		GameObject bank = ctx.objects.select().id(EDGE_BANK).nearest().poll();
		
		fix_banking.bank_items(bank, "Edgeville");
		fix_banking.fix_bankwithdraw(bankchoice);
		fix_banking.wear_items(true, true, bankchoice);
		fix_banking.close();
		fixer.go_island(amulet);
	}
	
	private void check_cam()
	{
		int yaw = ctx.camera.yaw();
		int pitch = ctx.camera.pitch();
		
		if (yaw < 160 || yaw > 210)
		{
			ctx.camera.angle('s');
			Condition.sleep(1000);
		}
		
		if (pitch < 30 || pitch > 60)
		{
			ctx.camera.pitch(47);
			Condition.sleep(1000);
		}
	}

}
