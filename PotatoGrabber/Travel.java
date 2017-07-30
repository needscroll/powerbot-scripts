package needscroll.PotatoGrabber;


import org.powerbot.script.Tile;
import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;

public class Travel extends ClientAccessor{
	
	private final int CLOSED_GATE = 45208;
	private final int OPEN_GATE = 45207;
	
	public Travel(ClientContext ctx)
	{
		super(ctx);
	}
	
	public void patch(String side)
	{
		Getstate moving = new Getstate(ctx);
		
		gate(side);
		open_gate(moving);
		go_patch();
	}
	
	public void field()
	{
		Getstate moving = new Getstate(ctx);
		
		gate("out");
		open_gate(moving);
		in_potato();
	}
	
	private void gate(String path)
	{
		if (path == "in")
		{
			go_gate_in();
		}
		if (path == "out")
		{
			go_gate_out();
		}
		
	}
	
	private void go_gate_in()
	{
		Tile[] pathToGateIn = new Tile[] {new Tile(3261, 3319, 0)};
		
		for (int counter = 0; counter < pathToGateIn.length; counter++)
		{
			ctx.movement.step(pathToGateIn[counter]);
			Condition.sleep(1000);
			
			while(ctx.players.local().inMotion())
			{
				Condition.sleep(1000);
			}
		}
	}
	
	private void go_gate_out()
	{
		Tile[] pathToGateIn = new Tile[] {new Tile(3257, 3323, 0)};
		
		for (int counter = 0; counter < pathToGateIn.length; counter++)
		{
			ctx.movement.step(pathToGateIn[counter]);
			Condition.sleep(1000);
			
			while(ctx.players.local().inMotion())
			{
				Condition.sleep(1000);
			}
		}
	}
	
	private void go_patch()
	{
		Tile[] pathToGateIn = new Tile[] {new Tile(3249, 3318, 0), new Tile(3236, 3313, 0), new Tile(3229, 3319, 0)};
		
		for (int counter = 0; counter < pathToGateIn.length; counter++)
		{
			ctx.movement.step(pathToGateIn[counter]);
			Condition.sleep(1000);
			
			while(ctx.players.local().inMotion())
			{
				Condition.sleep(1000);
			}
		}
	}
	
	private void open_gate(Getstate moving)
	{
		if (moving.gate_closed())
		{
			GameObject gate = ctx.objects.select().id(CLOSED_GATE).nearest().poll();
			gate.interact("Open");
			Condition.sleep(1000);
			while (ctx.players.local().inMotion())
			{
				Condition.sleep(1000);
			}
		}
	}
	
	public void in_potato()
	{
		Getstate moving = new Getstate(ctx);
		
		open_gate(moving);
		
		Tile[] pathToGateIn = new Tile[] {new Tile(3260, 3316, 0)};
		
		for (int counter = 0; counter < pathToGateIn.length; counter++)
		{
			ctx.movement.step(pathToGateIn[counter]);
			Condition.sleep(1000);
			
			while(ctx.players.local().inMotion())
			{
				Condition.sleep(1000);
			}
		}
	}
}
