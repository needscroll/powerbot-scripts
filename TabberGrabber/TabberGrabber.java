package needscroll.TabberGrabber;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.powerbot.script.*;
import org.powerbot.script.PollingScript;
import org.powerbot.script.PaintListener;
import org.powerbot.script.rt6.ClientContext;

import needscroll.TabberGrabber.Tasks.Antiban;
import needscroll.TabberGrabber.Tasks.Butler;
import needscroll.TabberGrabber.Tasks.Clay;
import needscroll.TabberGrabber.Tasks.CraftHouse;
import needscroll.TabberGrabber.Tasks.CraftVarr;
import needscroll.TabberGrabber.Tasks.FailLobby;
import needscroll.TabberGrabber.Tasks.LecternEagle;
import needscroll.TabberGrabber.Tasks.LecternOak;

@Script.Manifest(name = "Tabber Grabber", description = "Collects Tabs", properties = "author=needscroll; topic=999; client=6; hidden=true;")

public class TabberGrabber extends PollingScript<ClientContext> implements PaintListener{

	List<Task> taskList = new ArrayList<Task>();
	Butler butler = new Butler(ctx);
	Antiban antiban = new Antiban(ctx);
	Clay clay = new Clay(ctx);
	CraftHouse craft = new CraftHouse(ctx);
	LecternEagle lectern = new LecternEagle(ctx);
	
	@Override
	public void start()
	{
		log.info("tabber grabber has started");
		
		String tabs [] = {"house", "varrock"};
		String tabs_choice = (String) JOptionPane.showInputDialog(null, "Where do you wish to bank?","Bank",JOptionPane.PLAIN_MESSAGE, null, tabs,tabs[0]);
		
		//taskList.add(new FailLobby(ctx));
		
		
		//taskList.add(new Antiban(ctx));
		
		if (tabs_choice == "house")
		{
			taskList.add(new LecternEagle(ctx));
			taskList.add(new CraftHouse(ctx));
		}
		if (tabs_choice == "varrock")
		{
			taskList.add(new LecternOak(ctx));
			taskList.add(new CraftVarr(ctx));
		}
		
		taskList.add(new Clay(ctx));
		taskList.add(new Butler(ctx));
		//need add area check for outside house
	}
	
	@Override
	public void stop()
	{
		log.info("bananna grabber has stopped");
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
        g.drawString("Tabber Grabber", 50, 50);
        g.drawString("Status = " + (butler.get_status() + antiban.get_status() + clay.get_status() + craft.get_status() + lectern.get_status()), 50, 65);
	}

}
