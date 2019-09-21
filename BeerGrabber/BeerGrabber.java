package needscroll.BeerGrabber;

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

import needscroll.BeerGrabber.Tasks.Antiban;
import needscroll.BeerGrabber.Tasks.Banking;
import needscroll.BeerGrabber.Tasks.CONSTANTS;
import needscroll.BeerGrabber.Tasks.GoBank;
import needscroll.BeerGrabber.Tasks.GoVillage;
import needscroll.BeerGrabber.Tasks.Grab;
import needscroll.BeerGrabber.Tasks.MuleTrade;
import needscroll.BeerGrabber.Tasks.SlaveTrade;

@Script.Manifest(description = "Loots the hall in Barbarian Village for beer. Loots arrows, bones, coins, meat, runes, and others", name = "BeerGrabber", properties = "author=needscroll; topic=1344301; client=4; hidden=false")

public class BeerGrabber extends PollingScript<ClientContext> implements PaintListener{

	List<Task> taskList = new ArrayList<Task>();

	@Override
	public void start()
	{
		log.info("BeerGrabber has started");
		
		/*String act [] = {"slave", "mule"};
		String act_choice = (String) JOptionPane.showInputDialog(null, "What do you wish to do?","slave",JOptionPane.PLAIN_MESSAGE, null, act,act[0]);

		if (act_choice == "slave")
		{
			taskList.add(new SlaveTrade(ctx));*/
			taskList.add(new Antiban(ctx));
			taskList.add(new Grab(ctx));
			taskList.add(new GoBank(ctx));
			taskList.add(new Banking(ctx));
			taskList.add(new GoVillage(ctx));
		/*}
		if (act_choice == "mule")
		{
			taskList.add(new MuleTrade(ctx));
		}*/
		
	}
	
	@Override
	public void stop()
	{
		log.info("BeerGrabber has stopped");
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
        g.drawString("Beer Grabber", 50, 50);
        g.drawString("amount gathered: " + Banking.total_amount , 50, 65);
        //g.drawString("Time to next trade: " + (1000 - (System.currentTimeMillis() - SlaveTrade.old)/1000), 50, 80);
	}

}
