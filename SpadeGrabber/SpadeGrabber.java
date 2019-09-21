package needscroll.SpadeGrabber;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import org.powerbot.script.*;
import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.rt4.ClientContext;

import needscroll.SpadeGrabber.Tasks.Antiban;
import needscroll.SpadeGrabber.Tasks.Banking;
import needscroll.SpadeGrabber.Tasks.Grab;
import needscroll.SpadeGrabber.Tasks.SlaveTrade;
import needscroll.SpadeGrabber.Tasks.WalkBank;
import needscroll.SpadeGrabber.Tasks.WalkSpade;

@Script.Manifest(description = "grabs spades", name = "SpadeGrabber", properties = "author=needscroll; topic=1336760; client=4; hidden=true")


public class SpadeGrabber extends PollingScript<ClientContext> implements PaintListener{
	
	List<Task> taskList = new ArrayList<Task>();

	@Override
	public void start()
	{
		log.info("SpadeGrabber has started");
		
		taskList.add(new Antiban(ctx));
		//taskList.add(new SlaveTrade(ctx));
		taskList.add(new Grab(ctx));
		taskList.add(new WalkBank(ctx));
		taskList.add(new Banking(ctx));
		taskList.add(new WalkSpade(ctx));
	}
	
	@Override
	public void stop()
	{
		log.info("SpadeGrabber has stopped");
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
        g.drawString("Spade Grabber2", 50, 50);
        g.drawString("amount grabbed = " + Grab.get_total(), 50, 65);
        g.drawString("Time to next trade: " + (5000 - (System.currentTimeMillis() - SlaveTrade.old)/1000), 50, 80);
	}

}
