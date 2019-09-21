package needscroll.GraniteGrabber.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;
import org.powerbot.script.rt6.Item;

import needscroll.GraniteGrabber.Task;

public class Walking extends Task{
	
	final static int PORTERS[] = {29277, 29278};
	final static int BANDIT_TELE = 19476;

	public Walking(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		Tile granite = new Tile(3171, 2911, 0); // granite quarry area
		Tile granite1 = new Tile(3162, 2923, 0);
		Tile granite2 = new Tile(3181, 2900, 0);
		Area granite_area = new Area(granite1, granite2);
		
		Item porter = ctx.backpack.select().id(PORTERS).poll();
		Component porter_w = ctx.widgets.widget(1464).component(15).component(17);
		
		return !granite_area.contains(ctx.players.local()) && porter.valid();
	}

	@Override
	public void execute() 
	{
		Tile desert1 = new Tile(3143, 3005, 0);
		Tile desert2 = new Tile(3224, 2871, 0);
		Area desert_area = new Area(desert1, desert2);
		
		Tile granite1 = new Tile(3162, 2923, 0);
		Tile granite2 = new Tile(3181, 2900, 0);
		Area granite_area = new Area(granite1, granite2);
		
		if (!desert_area.contains(ctx.players.local()))
		{
			use_scroll();
		}
		if (desert_area.contains(ctx.players.local()) && !granite_area.contains(ctx.players.local()))
		{
			walk_granite();
		}
	}

	private void use_scroll()
	{
		Item scroll = ctx.backpack.select().id(BANDIT_TELE).poll();
		
		scroll.interact("Read");
		Condition.sleep(6000);
	}
	
	private void walk_granite()
	{
		Tile granite = new Tile(3171, 2911, 0); // granite quarry area
		
		ctx.movement.step(granite);
		Condition.sleep(1000);
		while(ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
	}
}
