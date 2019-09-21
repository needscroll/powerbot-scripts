package needscroll.RopeGrabber;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import org.powerbot.script.*;
import org.powerbot.script.PollingScript;
import org.powerbot.script.rt4.ClientContext;

import needscroll.RopeGrabber.Tasks.Banking;
import needscroll.RopeGrabber.Tasks.GetItems;
import needscroll.RopeGrabber.Tasks.GoNed;
import needscroll.RopeGrabber.Tasks.Trading;

@Script.Manifest(description = "grabs robe", name = "RopeGrabber", properties = "author=needscroll; topic=1336760; client=4; hidden=true")


public class RopeGrabber extends PollingScript<ClientContext> implements PaintListener{
	
	List<Task> taskList = new ArrayList<Task>();

	@Override
	public void start()
	{
		log.info("RopeGrabber has started");
		
		taskList.add(new GoNed(ctx));
		taskList.add(new Trading(ctx));
		taskList.add(new Banking(ctx));
		taskList.add(new GetItems(ctx));
	}
	
	@Override
	public void stop()
	{
		log.info("RopeGrabber has stopped");
	}
	
	@Override
	public void poll() 
	{
		for(Task task : taskList)
		{
			if (task.activate())
			{
				task.execute();
				break;
			}
		}
	}

	@Override
	public void repaint(Graphics g1) {
		Graphics2D g = (Graphics2D)g1;
        g.setColor(Color.RED);
        g.drawString("Rope Grabber", 50, 50);
        g.drawString("amount gathered: " + Trading.get_amount(), 50, 65);
	}

}
