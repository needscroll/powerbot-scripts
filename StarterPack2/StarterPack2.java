package needscroll.StarterPack2;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.powerbot.script.*;
import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.rt4.ClientContext;

import needscroll.StarterPack2.Tasks.*;

@Script.Manifest(name = "Ultimate Skiller Pack 2",
description = "Version 2. Collection of simple scripts to train basic skills. Includes mining, fishing, woodcutting, and combat",
properties = "author=needscroll; topic=1336760; client=4; hidden=true")

public class StarterPack2 extends PollingScript<ClientContext> implements PaintListener{
	
	List<Task> taskList = new ArrayList<Task>();
	Timer timer;

	@Override
	public void start()
	{
		timer = new Timer(0);
		String time_input = JOptionPane.showInputDialog("Please enter the time in seconds you wish the script to run");
		long time = Long.parseLong(time_input);
		timer = new Timer(time);

		log.info("Starter Pack has started");
		taskList.add(new Antiban(ctx));
		taskList.add(SkillSelector.get_action(ctx));
	}
	@Override
	public void stop()
	{
		log.info("Starter Pack has stopped");
		ctx.controller.stop();
	}
	
	@Override
	public void poll() 
	{
		
		for(Task task : taskList)
		{
			if (timer.running() && task.activate())
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
        g.drawString("Starter Pack", 50, 50);
        g.drawString("Time Remaining: " + timer.remaining_time(), 50, 65);
	}
}
