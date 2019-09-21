package needscroll.CursedGrabber.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;

import needscroll.CursedGrabber.Task;

public class FallyTele extends Task{

	public FallyTele(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() 
	{
		Tile party1 = new Tile(3039, 3383, 0);
		Tile party2 = new Tile(3055, 3372, 0);
		Area party_area = new Area(party1, party2);
		return !party_area.contains(ctx.players.local());
	}

	@Override
	public void execute() 
	{
		Tile fally1 = new Tile(2954, 3413, 0);
		Tile fally2 = new Tile(3059, 3366, 0);
		Tile party = new Tile(3049, 3376, 0);
		Tile party1 = new Tile(3039, 3383, 0);
		Tile party2 = new Tile(3055, 3372, 0);
		
		Area fally_area = new Area(fally1, fally2);
		Area party_area = new Area(party1, party2);
		
		if (!fally_area.contains(ctx.players.local()))
		{
			go_lodestone();
		}
		if (fally_area.contains(ctx.players.local()) && !party_area.contains(ctx.players.local()));
		{
			ctx.movement.step(party);
			Condition.sleep(1000);
			while (ctx.players.local().inMotion())
			{
				Condition.sleep(1000);
			}
		}
		
	}
	
	private void go_lodestone()
	{
		ctx.input.send("t");
		Condition.sleep(4000);
		ctx.input.send("f");
		Condition.sleep(20000);
	}

}
