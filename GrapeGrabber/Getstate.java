package needscroll.GrapeGrabber;

import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Item;

public class Getstate extends ClientAccessor{
	
	private int GRAPES = 1987;
	private int APPLES = 1955;
	
	public Getstate(ClientContext ctx)
	{
		super(ctx);
	}
	
	public boolean full_inv(Item[] inv)
	{
		boolean full = true;
		
		for (int counter = 0;counter < inv.length; counter++)
		{
			if (baditem(inv[counter]))
			{
				full = false;
			}
		}
		
		return full;
	}
	
	public int empty_spaces(Item[] inv)
	{
		int empty = 0;
		
		for (int counter = 0; counter < inv.length; counter++)
		{
			if (baditem(inv[counter]))
			{
				empty++;
			}
		}
		
		return empty;
	}
	
	public boolean baditem(Item thing)
	{
		boolean pass = false;
		
		if (thing.id() != GRAPES && thing.id() != APPLES)
		{
			pass = true;
		}
		
		return pass;
	}
	
	public int findfloor()
	{
		int floor = -1;
		floor = ctx.players.local().tile().floor();
		
		return floor;
	}
	
	public boolean bad_cam_door()
	{
		boolean bad = false;
		
		int yaw = ctx.camera.yaw();
		int pitch = ctx.camera.pitch();
		
		if (yaw < 160 || yaw > 210)
		{
			bad = true;
		}
		
		if (pitch < 56 || pitch > 45)
		{
			bad = true;
		}
		
		return bad;
	}
	
	public boolean bad_cam_default()
	{
		boolean bad = false;
		
		int yaw = ctx.camera.yaw();
		int pitch = ctx.camera.pitch();
		
		if (yaw > 40 || yaw < 300)
		{
			bad = true;
		}
		
		if (pitch < 65)
		{
			bad = true;
		}
		
		return bad;
	}

}
