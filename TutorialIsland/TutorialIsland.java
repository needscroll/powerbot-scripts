package needscroll.TutorialIsland;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import org.powerbot.script.*;
import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.rt4.BasicQuery;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

import needscroll.TutorialIsland.Tasks.Antiban;
import needscroll.TutorialIsland.Tasks.Chatting;
import needscroll.TutorialIsland.Tasks.Island3;


@Script.Manifest(description = "Completes Tutorial Island", name = "Tutorial Island", properties = "author=needscroll; topic=1348340; client=4; hidden=false")

public class TutorialIsland extends PollingScript<ClientContext> implements PaintListener{
	List<Task> taskList = new ArrayList<Task>();

	@Override
	public void start()
	{
		log.info("Tutorial Island has started");
		
		taskList.add(new Chatting(ctx));
		taskList.add(new Antiban(ctx));
		taskList.add(new Island3(ctx));
	}
	
	@Override
	public void stop()
	{
		log.info("Tutorial Island has stopped");
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
        g.drawString("Tutorial Island", 50, 50);
	}

}
