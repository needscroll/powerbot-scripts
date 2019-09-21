package needscroll.TabberGrabber.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;

import needscroll.TabberGrabber.Task;

public class Clay extends Task{
	
	public static String STATUS = "";

	public Clay(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		Component first = ctx.widgets.widget(1188).component(0);
		
		return first.valid();
	}

	@Override
	public void execute() 
	{
		STATUS = "Clay";
		//widget for dialogue is 1188
		Component first = ctx.widgets.widget(1188).component(0);
		
		if (first.text().contains("clay"))
		{
			first.click(true);
		}
		if (first.text().contains("Wooden"))
		{
			Component more = ctx.widgets.widget(1188).component(36);
			Component more1 = ctx.widgets.widget(1188).component(38);
			
			if (more1.text().contains("More"))
			{
				more1.click(true);
				Condition.sleep(1500);
			}
			if (more.text().contains("More"))
			{
				more.click(true);
				Condition.sleep(1500);
			}
		}
		if (first.text().contains("Mahogany"))
		{
			Component soft_clay = ctx.widgets.widget(1188).component(32);
			soft_clay.click(true);
			Condition.sleep(1500);
			ctx.input.sendln("20");
			Condition.sleep(12000);
		}
		if (first.text().contains("Cloth"))
		{
			Component more1 = ctx.widgets.widget(1188).component(38);
			more1.click(true);
			Condition.sleep(1500);
		}
		STATUS = "";
	}
	
	public String get_status()
	{
		return STATUS;
	}

}
