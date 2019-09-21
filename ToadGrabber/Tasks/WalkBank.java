package needscroll.ToadGrabber.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;

import needscroll.ToadGrabber.Task;

public class WalkBank extends Task{

	public WalkBank(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() 
	{
		Tile tree = new Tile(2444, 3433, 0); // area for tree bank stairs
		Tile tree1 = new Tile(2441, 3437, 0);
		Tile tree2 = new Tile(2450, 3429, 0);
		Area tree_area = new Area(tree1, tree2);
		
		Tile bank1 = new Tile(2440, 3423, 1);
		Tile bank2 = new Tile(2450, 3443, 1);
		Area bank_area = new Area(bank1, bank2);
		
		return ctx.backpack.select().count() == 28 && !tree_area.contains(ctx.players.local()) && !bank_area.contains(ctx.players.local());
	}

	@Override
	public void execute() 
	{
		Tile tree = new Tile(2444, 3433, 0); // area for tree bank stairs
		
		ctx.movement.step(tree.tile());
		Condition.sleep(1000);
		while(ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
	}
}
