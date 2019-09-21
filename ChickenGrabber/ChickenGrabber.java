package needscroll.ChickenGrabber;

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

import needscroll.ChickenGrabber.Tasks.Antiban;
import needscroll.ChickenGrabber.Tasks.Banking;
import needscroll.ChickenGrabber.Tasks.CONSTANTS;
import needscroll.ChickenGrabber.Tasks.Grab;
import needscroll.ChickenGrabber.Tasks.SlaveTrade;
import needscroll.ChickenGrabber.Tasks.WalkBank;
import needscroll.ChickenGrabber.Tasks.WalkStore;

@Script.Manifest(description = "grabs chicken", name = "ChickenGrabber", properties = "author=needscroll; topic=1336760; client=4; hidden=true")

public class ChickenGrabber extends PollingScript<ClientContext> implements PaintListener{
	
	List<Task> taskList = new ArrayList<Task>();

	@Override
	public void start()
	{
		log.info("ChickenGrabber has started");
		
		String act [] = {"chicken", "banana"};
		String act_choice = (String) JOptionPane.showInputDialog(null, "What do you wish to do?","Bank",JOptionPane.PLAIN_MESSAGE, null, act,act[0]);

		if (act_choice == "chicken")
		{
			CONSTANTS.crate_to_grab = CONSTANTS.chicken_crate;
		}
		if (act_choice == "banana")
		{
			CONSTANTS.crate_to_grab = CONSTANTS.banana_crate;
		}
		
		taskList.add(new Antiban(ctx));
		taskList.add(new SlaveTrade(ctx));
		taskList.add(new Grab(ctx));
		taskList.add(new WalkBank(ctx));
		taskList.add(new Banking(ctx));
		taskList.add(new WalkStore(ctx));
	}
	
	@Override
	public void stop()
	{
		log.info("ChickenGrabber has stopped");
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
        g.drawString("Chicken Grabber2", 50, 50);
        g.drawString("amount grabbed = " + CONSTANTS.get_total(), 50, 65);
        g.drawString("Time to next trade: " + (5000 - (System.currentTimeMillis() - SlaveTrade.old)/1000), 50, 80);
	}

}
