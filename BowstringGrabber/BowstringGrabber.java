package needscroll.BowstringGrabber;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import org.powerbot.script.*;
import org.powerbot.script.PollingScript;
import org.powerbot.script.rt4.ClientContext;

import needscroll.BowstringGrabber.Tasks.Banking;
import needscroll.BowstringGrabber.Tasks.Spinning;
import needscroll.BowstringGrabber.Tasks.WalkBank;
import needscroll.BowstringGrabber.Tasks.WalkWheel;

@Script.Manifest(description = "spins flax into bowstring at lumbridge", name = "BowstringGrabber", properties = "author=needscroll; topic=1345365; client=4; hidden=false")

public class BowstringGrabber extends PollingScript<ClientContext> implements PaintListener{

	List<Task> taskList = new ArrayList<Task>();
	
	@Override
	public void start()
	{
		log.info("BowstringGrabber has started");
		taskList.add(new WalkWheel(ctx));
		taskList.add(new Spinning(ctx));
		taskList.add(new WalkBank(ctx));
		taskList.add(new Banking(ctx));
	}
	
	@Override
	public void stop()
	{
		log.info("BowstringGrabber has stopped");
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
        g.setColor(Color.YELLOW);
        g.drawString("Bowstring Grabber", 50, 50);
        g.drawString("amount collected: " + Banking.get_amount(), 50, 65);
	}
}
