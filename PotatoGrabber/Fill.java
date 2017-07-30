package needscroll.PotatoGrabber;

import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;

public class Fill extends ClientAccessor{
	
	final private int POTATO_ID = 312;
	final private int PICK_ANIMATION = 827;
	
	public Fill(ClientContext ctx)
	{
		super(ctx);
	}
	
	public void pick(int[] itemsgrabbed)
	{
		GameObject potato = ctx.objects.select().id(POTATO_ID).nearest().poll();
		
		potato.interact("Pick");
		Condition.sleep(1000);
		while (ctx.players.local().inMotion() || ctx.players.local().animation() == PICK_ANIMATION)
		{
			Condition.sleep(600);
			if (!ctx.players.local().inMotion() || ctx.players.local().animation() != PICK_ANIMATION)
			{
				Condition.sleep(1000);
			}
			itemsgrabbed[0]++;
		}
	}
}