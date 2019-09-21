package needscroll.GraniteGrabber.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;
import org.powerbot.script.rt6.Item;

public class Split5KG extends Split2KG{
	
	final static int SPLIT_ANIMATION = 11146;
	final static int GRANITE_ORE[] = {6981, 6983}; //5kg second (need change)
	final static int BANKER = 3293;

	public Split5KG(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return idling();
	}

	@Override
	public void execute() 
	{
		Item granite = ctx.backpack.select().id(GRANITE_ORE).poll();
		Component cut = ctx.widgets.widget(1370).component(38);
		
		if (granite_exists())
		{
			granite.interact("Craft");
			Condition.sleep(650);
		}
		if (cut.valid() && granite_exists())
		{
			cut.click(true);
			Condition.sleep(1000);
		}
		if (!granite_exists() || ctx.backpack.select().count() > 24)
		{
			open_bank();
		}
		
		if (ctx.bank.opened())
		{
			get_items(GRANITE_ORE[1], 2);
		}
		
		if (!in_place())
		{
			walk_ge();
		}
		
	}
}
