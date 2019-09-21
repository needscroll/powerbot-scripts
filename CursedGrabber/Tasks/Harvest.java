package needscroll.CursedGrabber.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Item;
import org.powerbot.script.rt6.Npc;
import needscroll.CursedGrabber.Task;

public class Harvest extends Task{
	
	final static int[] WISP = {23159, 23160, 23161};
	final static int[] HARVESTING_A = {21231, 21228};
	final static int CONVERT_EN = 21232;
	final static int CONVERT_EX = 21234;
	final static int CURSED_E = 37941;
	final static int MEMORY = 37946;

	public Harvest(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		Tile volc_o = new Tile(0, 0, 0);
		Tile volc_o1 = new Tile(3190, 3600, 0);
		Tile volc_o2 = new Tile(3114, 3736, 0);
		Area volc_o_area = new Area(volc_o1, volc_o2);
		
		Item energy = ctx.backpack.select().id(CURSED_E).poll();
		
		return energy.stackSize() < CONSTANTS.energy_limit && ctx.backpack.select().id(MEMORY).count() <= 9 && volc_o_area.contains(ctx.players.local()) && idling();
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
		}
		if (volc_i_area.contains(ctx.players.local()) && !ctx.players.local().inCombat())
		{
			Npc wisp = ctx.npcs.select().id(WISP).nearest().poll();
			ctx.camera.turnTo(wisp.tile());
			wisp.interact("Harvest");
			Condition.sleep(600);
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
				return true;
			}
			Condition.sleep(300);
		}
		
		return idle;
	}
}
