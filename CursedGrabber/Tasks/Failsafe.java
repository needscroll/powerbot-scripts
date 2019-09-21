package needscroll.CursedGrabber.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;

import needscroll.CursedGrabber.Task;

public class Failsafe extends Task{

	public Failsafe(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() 
	{
		Tile bank_o1 = new Tile(3040, 3615, 0);
		Tile bank_o2 = new Tile(3165, 3726, 0);
		Area bank_o_area = new Area(bank_o1, bank_o2);
		
		Tile volc_o1 = new Tile(3190, 3628, 0);
		Tile volc_o2 = new Tile(3114, 3736, 0);
		Area volc_o_area = new Area(volc_o1, volc_o2);
		
		Tile edge1 = new Tile(3085, 3504, 0);
		Tile edge2 = new Tile(3109, 3483, 0);
		Area edge_area = new Area(edge1, edge2);
		
		Tile ge_bank1 = new Tile(3169, 3457, 0);
		Tile ge_bank2 = new Tile(3144, 3484, 0);
		Area ge_bank_area = new Area(ge_bank1, ge_bank2);
		
		boolean volc = volc_o_area.contains(ctx.players.local());
		boolean edge = edge_area.contains(ctx.players.local());
		boolean ge = ge_bank_area.contains(ctx.players.local());
		boolean banking = bank_o_area.contains(ctx.players.local());
		
		return !volc && !edge && !ge && !banking;
	}

	@Override
	public void execute() 
	{
		Tile edge = new Tile(3094, 3494, 0);
		
		ctx.input.send("t");
		Condition.sleep(4000);
		ctx.input.send("e");
		Condition.sleep(20000);
		
		ctx.movement.step(edge);
		Condition.sleep(1000);
		while (ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
		ctx.movement.step(edge);
		Condition.sleep(1000);
		while (ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
		
	}

}
