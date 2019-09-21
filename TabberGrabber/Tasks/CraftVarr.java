package needscroll.TabberGrabber.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;
import org.powerbot.script.rt6.Item;

import needscroll.TabberGrabber.Task;

public class CraftVarr extends Task{
	
	final static int CLAY = 1761;
	final static int MAKING_A = 14175;
	final static int HOUSE = 8007; // need change to varr
	public static String STATUS = "";

	public CraftVarr(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		Component create = ctx.widgets.widget(1371).component(5);
		return create.valid();
	}

	@Override
	public void execute() 
	{
		STATUS = "Craft";
		Component varrock = ctx.widgets.widget(1371).component(44).component(25); //need change (fixed)
		Component create = ctx.widgets.widget(1371).component(5);
		Item clay = ctx.backpack.select().id(CLAY).poll(); 
		
		if(clay.id() == CLAY && create.valid())
		{
			while (!varrock.inViewport())
			{
				Component bar = ctx.widgets.widget(1371).component(47).component(4);
				bar.click(true);
				Condition.sleep(200);
			}
			
			varrock.click(true);
			Condition.sleep(1000);
			
			create.click(true);
			Condition.sleep(2000);
			while(ctx.players.local().animation() == MAKING_A)
			{
				Condition.sleep(1000);
				
			}
		}	
		STATUS = "";
	}

}
