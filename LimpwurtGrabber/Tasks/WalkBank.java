package needscroll.LimpwurtGrabber.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;

import needscroll.LimpwurtGrabber.Task;

public class WalkBank extends Task{

	public WalkBank(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return ctx.backpack.select().count() == 28 && !CONSTANTS.bank_area.contains(ctx.players.local());
	}

	@Override
	public void execute() {
		if (CONSTANTS.dungeon_area.contains(ctx.players.local()))
		{
			GameObject exit = ctx.objects.select().id(CONSTANTS.dung_door).nearest().poll();
			step_use(CONSTANTS.dungeon_exit_tile, exit, CONSTANTS.dung_exit_interact);
			Condition.sleep(3000);
		}
		if (CONSTANTS.hill_area.contains(ctx.players.local()))
		{
			GameObject exit = ctx.objects.select().id(CONSTANTS.hill_ladder).nearest().poll();
			step_use(CONSTANTS.hill_exit, exit, CONSTANTS.ladder_interact);
			Condition.sleep(3000);
		}
		if (CONSTANTS.ladder.contains(ctx.players.local()))
		{
			GameObject door = ctx.objects.select().id(CONSTANTS.DOOR).nearest().poll();
			ctx.camera.turnTo(door.tile());
			if (door.interact("Open"))
			{
				Condition.sleep(1000);
				while (ctx.players.local().inMotion())
				{
					Condition.sleep(1000);
				}
			}
			else
			{
				ctx.camera.turnTo(door.tile());
			}		
		}
		if (CONSTANTS.overworld.contains(ctx.players.local()) && !CONSTANTS.ladder.contains(ctx.players.local()))
		{
			System.out.println("bank");
			ctx.movement.step(CONSTANTS.bank_tile);
			Condition.sleep(1000);
			while (ctx.players.local().inMotion())
			{
				Condition.sleep(1000);
			}
		}
		
	}
	
	private void step_use(Tile tile, GameObject thing, String use)
	{
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

}
