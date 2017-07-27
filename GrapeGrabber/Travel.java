package needscroll.GrapeGrabber;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;

public class Travel extends ClientAccessor{
	
	private int DOOR_ID = 2712;
	private int[] STAIRS = {24073, 24074, 24075};
	
	public Travel(ClientContext ctx)
	{
		super(ctx);
	}
	
	public void go_bank()
	{
		go_ground();
		open_door();
		walk_bank();
	}
	
	private void go_ground()
	{
		int floor = 0;
		Getstate level = new Getstate(ctx);
		floor = level.findfloor();
		
		if (floor == 1)
		{
			godown();
		}
		if (floor == 2)
		{
			godown();
			godown();
		}
	}
	
	public void goup()
	{
		GameObject stairs = ctx.objects.select().id(STAIRS).nearest().poll();
		stairs.interact("Climb-up");
		Condition.sleep(3000);
	}
	
	public void godown()
	{
		GameObject stairs = ctx.objects.select().id(STAIRS).nearest().poll();
		stairs.interact("Climb-down");
		Condition.sleep(3000);
	}
	
	private void open_door()
	{
		//GameObject door = ctx.objects.select().id(DOOR_ID).nearest().poll();
		GameObject door = ctx.objects.select().id(DOOR_ID).nearest().limit(1).poll();
		Getstate cam = new Getstate(ctx);
		Camera newcam = new Camera(ctx);
		
		if (door.valid())
		{
			if (cam.bad_cam_door())
			{
				newcam.fix_cam("door");
			}
			
			door.interact(false, "Open");
			Condition.sleep(1000);
			while (ctx.players.local().inMotion())
			{
				Condition.sleep(1000);
			}
		}
	}
	
	private void walk_bank()
	{
		Tile[] pathToBank = new Tile[] {new Tile(3153, 3448, 0), new Tile(3160, 3451, 0)};
		
		for (int counter = 0; counter < pathToBank.length; counter++)
		{
			ctx.movement.step(pathToBank[counter]);
			Condition.sleep(1000);
			
			while(ctx.players.local().inMotion())
			{
				Condition.sleep(1000);
			}
		}
	}
	
	public void go_guild()
	{
		walk_guild();
		open_door();
		goup();
	}
	
	private void walk_guild()
	{
		Tile[] pathToBank = new Tile[] {new Tile(3156, 3448, 0), new Tile(3147, 3444, 0), new Tile(3143, 3443, 0)};
		
		for (int counter = 0; counter < pathToBank.length; counter++)
		{
			ctx.movement.step(pathToBank[counter]);
			Condition.sleep(1000);
			
			while(ctx.players.local().inMotion())
			{
				Condition.sleep(1000);
			}
		}
	}
	
	public void res_floor()
	{
		go_ground();
		goup();
	}
	
}
