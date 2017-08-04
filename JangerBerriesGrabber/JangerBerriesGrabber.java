package needscroll.JangerBerriesGrabber;

import org.powerbot.script.*;
import org.powerbot.script.rt6.ClientContext;

import Tasks.Antiban;
import Tasks.Banking;
import Tasks.Gather;
import Tasks.WalkIsland;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;


@Script.Manifest(description = "Grabes Berries", name = "JangerBerries Grabber")

public class JangerBerriesGrabber extends PollingScript<ClientContext> implements PaintListener{
	
	Gather berries = new Gather(ctx);
	
	List<Task> taskList = new ArrayList<Task>();
	
	@Override
	public void start()
	{
		log.info("FreeRunecrafter has started");
		
		taskList.add(new Antiban(ctx));
		taskList.add(new WalkIsland(ctx));
		taskList.add(new Gather(ctx));
		taskList.add(new Banking(ctx));
	
	}
	
	@Override
	public void stop()
	{
		log.info("FreeRunecrafter has stopped");
		ctx.controller.stop();
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
    public void repaint(Graphics g1)
    {
        Graphics2D g = (Graphics2D)g1;
        g.setColor(Color.RED);
        g.drawString("JangerBerries Grabber", 50, 50);
        g.drawString("Berries Grabbed = " + berries.get_berries(), 50, 65);
    }



}