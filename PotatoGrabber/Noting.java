package needscroll.PotatoGrabber;

import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Item;
import org.powerbot.script.rt6.Npc;

public class Noting extends ClientAccessor{
	
	private final int LEPRECON = 7565;
	private final int POTATO = 1942;
	
	public Noting(ClientContext ctx)
	{
		super(ctx);
	}
	
	public void go_note()
	{
		Travel go = new Travel(ctx);
		go.patch("in");
		LEP_recon();
		go.field();
	}
	
	private void LEP_recon()
	{
		Npc lep = ctx.npcs.select().id(LEPRECON).nearest().poll();
		Item[] inv = ctx.backpack.items();
		boolean done = false;
		
		for (int counter = 0; done == false && counter < inv.length; counter++)
		{
			if (inv[counter].id() == POTATO)
			{
				inv[counter].interact("Use");
				done = true;
			}
		}
		
		if (done == true)
		{
			lep.interact("Use");
		}
	}
}
