package needscroll.SpadeGrabber.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Npc;

import needscroll.SpadeGrabber.Task;

public class Walking extends Task{

	public Walking(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
	
	protected void step_use(Tile tile, int thing_id, String use)
	{
		GameObject thing = ctx.objects.select().id(thing_id).nearest().poll();
		ctx.movement.step(tile);
		Condition.sleep(1000);
		while (ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
		if (thing.valid())
		{
			ctx.camera.turnTo(thing.tile());
			if (thing.interact(use))
			{
				Condition.sleep(1000);
				while (ctx.players.local().inMotion())
				{
					Condition.sleep(1000);
				}
			}
		}
	}
	
	protected void use(int id, String use)
	{
		GameObject thing = ctx.objects.select().id(id).nearest().poll();

		if (thing.valid())
		{
			if (!thing.inViewport())
			{
				ctx.camera.turnTo(thing.tile());
			}
			if (thing.interact(use))
			{
				Condition.sleep(1000);
				while (ctx.players.local().inMotion())
				{
					Condition.sleep(1000);
				}
			}
		}
	}
	
	protected void use_npc(int id, String use)
	{
		Npc npc = ctx.npcs.select().id(id).nearest().poll();
		if (npc.valid())
		{
			if (!npc.inViewport())
			{
				ctx.camera.turnTo(npc.tile());
			}
			if (npc.interact(use))
			{
				Condition.sleep(1000);
				while (ctx.players.local().inMotion())
				{
					Condition.sleep(1000);
				}
			}
		}
	}

}
