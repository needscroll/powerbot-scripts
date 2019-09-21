package needscroll.CursedGrabber.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Item;

import needscroll.CursedGrabber.Task;

public class GoBank extends Task{
	
	final static int CURSED_E = 37941;

	public GoBank(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() 
	{
		Tile bank_tile = new Tile(3049, 3630, 0);
		Tile bank_o1 = new Tile(3040, 3615, 0);
		Tile bank_o2 = new Tile(3165, 3726, 0);
		Area bank_o_area = new Area(bank_o1, bank_o2);
		
		Tile bank1 = new Tile(3053, 3627, 0);
		Tile bank2 = new Tile(3044, 3634, 0);
		Area bank_area = new Area(bank1, bank2);
		
		Item energy = ctx.backpack.select().id(CURSED_E).poll();
		
		return (energy.stackSize() >= CONSTANTS.energy_limit || ctx.players.local().inCombat()) && bank_o_area.contains(ctx.players.local()) && !bank_area.contains(ctx.players.local());
	}

	@Override
	public void execute() {
		Tile bank_tile = new Tile(3049, 3633, 0);
		Tile bank1 = new Tile(3053, 3627, 0);
		Tile bank2 = new Tile(3044, 3634, 0);
		Area bank_area = new Area(bank1, bank2);
		
		if (!bank_area.contains(ctx.players.local()))
		{
			ctx.movement.step(bank_tile);
		}
		
		
		
	}

}
