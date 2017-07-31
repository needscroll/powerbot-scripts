package needscroll.GeWalk;

import org.powerbot.script.rt6.Chat;
import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Npc;
import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ChatOption;

public class Talking extends ClientAccessor{
	
	private final int GE_GUY = 6521;
	
	public Talking(ClientContext ctx)
	{
		super(ctx);
	}
	
	public void run_talk()
	{
		talk_guy();
	}
	
	private void talk_guy()
	{
		Npc guy = ctx.npcs.select().id(GE_GUY).nearest().poll();
		
		guy.interact("Talk");
		
		ctx.chat.clickContinue();
		Condition.sleep(1000);
		ctx.chat.clickContinue();
		Condition.sleep(1000);
		
		ctx.input.sendln("1");

		Condition.sleep(1000);
		
		for (int counter = 0; counter < 15; counter++)
		{
			ctx.chat.clickContinue();
			Condition.sleep(1000);
		}
	}
}