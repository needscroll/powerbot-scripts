package needscroll.GrapeGrabber;

import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;

public class banking extends ClientAccessor{
	
	private int BANK_ID = 87989;
	
	public banking(ClientContext ctx)
	{
		super(ctx);
	}
	
	public void use_bank()
	{
		GameObject bank = ctx.objects.select().id(BANK_ID).nearest().poll();
		bank.interact("Open Bank");
		
		Condition.sleep(1000);
		while (ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
		
		ctx.bank.depositInventory();
		Condition.sleep(1000);
		ctx.bank.close();
	}

}
