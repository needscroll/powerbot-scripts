package needscroll.PotatoGrabber;

import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.Item;

public class Getstate extends ClientAccessor{
	
	private final int[] GOOD_ITEMS = {1942, 1943};
	private final int CLOSED_GATE = 45208;
	private final int OPEN_GATE = 45207;
	
	public Getstate(ClientContext ctx)
	{
		super(ctx);
	}
	
	public boolean fullinventory()
	{
		boolean full = true;
		
		if ( ctx.backpack.select().count() != 28)
		{
			full = false;
		}
		
		return full;
	}
	
	public boolean bad_item(Item thing)
	{
		boolean bad = true;
		
		for (int counter = 0; counter < GOOD_ITEMS.length; counter++)
		{
			if (thing.id() == GOOD_ITEMS[counter])
			{
				bad = false;
			}
		}
		
		return bad;
	}
	
	public boolean gate_closed()
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