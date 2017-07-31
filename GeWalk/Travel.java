package needscroll.GeWalk;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;

public class Travel extends ClientAccessor{
	
	private final int CLOSED_GATE = 28691;
	
	public Travel(ClientContext ctx)
	{
		super(ctx);
	}
	
	public void run_walk()
	{
		walk_gate();
		open_gate();
		walk_dwarf();
		walk_edge();
		walk_ge();
	}
	
	private void walk_gate()
	{
		Tile[] pathToGate = new Tile[] {
				new Tile(2878, 3411, 0),
				new Tile(2891, 3414, 0),
				new Tile(2909, 3417, 0),
				new Tile(2920, 3425, 0),
				new Tile(2924, 3436, 0),
				new Tile(2938, 3439, 0)
				};
		
		for (int counter = 0; counter < pathToGate.length; counter++)
		{
			ctx.movement.step(pathToGate[counter]);
			Condition.sleep(1000);
			
			while(ctx.players.local().inMotion())
			{
				Condition.sleep(1000);
			}
		}
	}
	
	private void walk_dwarf()
	{
		Tile[] pathToDwarf = new Tile[] {
				new Tile(2949, 3432, 0),
				new Tile(2964, 3429, 0),
				new Tile(2979, 3428, 0),
				new Tile(2995, 3433, 0),
				new Tile(3010, 3432, 0),
				};
		
		for (int counter = 0; counter < pathToDwarf.length; counter++)
		{
			ctx.movement.step(pathToDwarf[counter]);
			Condition.sleep(1000);
			
			while(ctx.players.local().inMotion())
			{
				Condition.sleep(1000);
			}
		}
	}
	
	private void walk_edge()
	{
		Tile[] pathToEdge = new Tile[] {
				new Tile(3025, 3439, 0),
				new Tile(3037, 3449, 0),
				new Tile(3046, 3457, 0),
				new Tile(3059, 3469, 0),
				new Tile(3074, 3475, 0),
				new Tile(3083, 3485, 0),
				new Tile(3099, 3486, 0),
				new Tile(3109, 3494, 0),
				new Tile(3120, 3504, 0),
				};
		
		for (int counter = 0; counter < pathToEdge.length; counter++)
		{
			ctx.movement.step(pathToEdge[counter]);
			Condition.sleep(1000);
			
			while(ctx.players.local().inMotion())
			{
				Condition.sleep(1000);
			}
		}
	}
	
	private void walk_ge()
	{
		Tile[] pathToGE = new Tile[] {
				new Tile(3135, 3507, 0),
				new Tile(3135, 3499, 0),
				new Tile(3135, 3491, 0),
				new Tile(3135, 3483, 0),
				new Tile(3135, 3475, 0),
				new Tile(3149, 3469, 0),
				new Tile(3164, 3472, 0),
				};
		
		for (int counter = 0; counter < pathToGE.length; counter++)
		{
			ctx.movement.step(pathToGE[counter]);
			Condition.sleep(1000);
			
			while(ctx.players.local().inMotion())
			{
				Condition.sleep(1000);
			}
		}
	}
	
	private void open_gate()
	{

		if (gate_closed())
		{
			GameObject gate = ctx.objects.select().id(CLOSED_GATE).nearest().poll(); //need get gate id
			gate.interact("Open");
			Condition.sleep(1000);
			while (ctx.players.local().inMotion())
			{
				Condition.sleep(1000);
			}
		}
	}
	
	private boolean gate_closed()
	{
		boolean closed = false;
		
		GameObject gate = ctx.objects.select().id(CLOSED_GATE).nearest().poll();
		
		if (gate.id() == CLOSED_GATE)
		{
			closed = true;
		}
		
		return closed;
	}
}