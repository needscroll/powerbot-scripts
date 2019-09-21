package needscroll.ToadGrabber;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import org.powerbot.script.*;
import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.rt6.ClientContext;

import needscroll.ToadGrabber.Tasks.Antiban;
import needscroll.ToadGrabber.Tasks.Banking;
import needscroll.ToadGrabber.Tasks.Gather;
import needscroll.ToadGrabber.Tasks.Stairs;
import needscroll.ToadGrabber.Tasks.WalkBank;
import needscroll.ToadGrabber.Tasks.WalkToad;

@Script.Manifest(name = "toad grabber", description = "Collects toads", properties = "author=needscroll; topic=1336760; client=6; hidden=true;")

public class ToadGrabber extends PollingScript<ClientContext> implements PaintListener{
	
	List<Task> taskList = new ArrayList<Task>();
	Gather gather = new Gather(ctx);

	@Override
	public void start()
	{
		taskList.add(new Antiban(ctx));
		taskList.add(new Gather(ctx));
		taskList.add(new WalkBank(ctx));
		taskList.add(new Banking(ctx));
		taskList.add(new Stairs(ctx));
		taskList.add(new WalkToad(ctx));
		
		log.info("toad grabber has started");

	}
	
	@Override
	public void stop()
	{
		log.info("toad grabber has stopped");
		ctx.controller.stop();
	}
	
	@Override
	public void poll() {
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
	public void repaint(Graphics g1) 
	{
		Graphics2D g = (Graphics2D)g1;
        g.setColor(Color.RED);
        g.drawString("Toad Grabber", 50, 50);
        g.drawString("Amount Collected = " + gather.get_amount(), 50, 65);
	}
}
