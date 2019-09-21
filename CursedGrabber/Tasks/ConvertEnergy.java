package needscroll.CursedGrabber.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;
import org.powerbot.script.rt6.GameObject;

import needscroll.CursedGrabber.Task;

public class ConvertEnergy extends Task{
	
	public static int RIFT = 87306;
	final static int[] HARVESTING_A = {21231, 21228};
	final static int CONVERT_A = 21232;
	final static int MEMORY = 37946;
	final static int CONVERT_EN = 21232;
	final static int CONVERT_EX = 21234;

	public ConvertEnergy(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() 
	{
		Tile volc_o = new Tile(0, 0, 0);
		Tile volc_o1 = new Tile(3190, 3628, 0);
		Tile volc_o2 = new Tile(3114, 3736, 0);
		Area volc_o_area = new Area(volc_o1, volc_o2);
		
		
		
		return ctx.backpack.select().id(MEMORY).count() > 9 && volc_o_area.contains(ctx.players.local()) && idling();
	}

	@Override
	public void execute() 
	{
		Tile volc_i = new Tile(3143, 3711, 0);
		Tile volc_i1 = new Tile(3135, 3718, 0);
		Tile volc_i2 = new Tile(3152, 3705, 0);
		Area volc_i_area = new Area(volc_i1, volc_i2);
		
		if (!volc_i_area.contains(ctx.players.local()))
		{
			ctx.movement.step(volc_i);
			Condition.sleep(1800);
		}
		if (volc_i_area.contains(ctx.players.local()))
		{
			rift();
		}
	}
	
	private void rift()
	{
		GameObject rift = ctx.objects.select().id(RIFT).nearest().poll();
		Component energy_option = ctx.widgets.widget(131).component(1);

		if (!energy_option.valid())
		{
			ctx.camera.turnTo(rift.tile());
			rift.interact("Convert");
			Condition.sleep(1800);
			while (ctx.players.local().inMotion())
			{
				Condition.sleep(2000);
			}
		}
		if (energy_option.valid())
		{
			energy_option.click(true);
		}
	}
	
	private boolean idling()
	{
		boolean idle = true;
		
		for (int counter = 0; counter < 7; counter++)
		{	
			if (ctx.players.local().inMotion() || ctx.players.local().animation() == HARVESTING_A[0] || ctx.players.local().animation() == HARVESTING_A[1] || ctx.players.local().animation() == CONVERT_EN || ctx.players.local().animation() == CONVERT_EX)
			{
				idle = false;
			}
			if (ctx.players.local().inCombat())
			{
				return false; // this causes hellhound bug
			}
			Condition.sleep(300);
		}
		
		return idle;
	}
}
