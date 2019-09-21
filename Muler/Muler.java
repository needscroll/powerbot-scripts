package needscroll.Muler;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import org.powerbot.script.*;
import org.powerbot.script.PollingScript;
import org.powerbot.script.rt4.ClientContext;

import needscroll.Muler.Tasks.MuleTrade;

@Script.Manifest(description = "mules", name = "Muler", properties = "author=needscroll; topic=1336760; client=4; hidden=true")
public class Muler extends PollingScript<ClientContext> implements PaintListener{
	
	List<Task> taskList = new ArrayList<Task>();
	
	@Override
	public void start()
	{
		log.info("Muler has started");
		//ctx.properties.setProperty("lobby.disable", "true");
		//ctx.properties.setProperty("login.disable", "true");
		taskList.add(new MuleTrade(ctx));
	}
	
	@Override
	public void stop()
	{
		log.info("Muler has stopped");
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
        g.drawString("Muler", 50, 50);
	}

}


