package needscroll.CursedGrabber.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;

import needscroll.CursedGrabber.Task;

public class ConvertExperience extends Task{
	
	public static int RIFT = 87306;
	final static int[] HARVESTING_A = {21231, 21228};
	final static int CONVERT_A = 21234;

	public ConvertExperience(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		Tile volc_o = new Tile(0, 0, 0);
		Tile volc_o1 = new Tile(3190, 3628, 0);
		Tile volc_o2 = new Tile(3114, 3736, 0);
		Area volc_o_area = new Area(volc_o1, volc_o2);
		
		return ctx.backpack.select().size() == 28 && volc_o_area.contains(ctx.players.local());
	}

	@Override
	public void execute() {
		
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
		ctx.camera.turnTo(rift.tile());
		rift.interact("Convert memories");
		Condition.sleep(1800);
	}
}
