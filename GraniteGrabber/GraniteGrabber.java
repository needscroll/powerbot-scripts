package needscroll.GraniteGrabber;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.*;

import needscroll.GraniteGrabber.Tasks.Antiban;
import needscroll.GraniteGrabber.Tasks.Banking;
import needscroll.GraniteGrabber.Tasks.MineGranite;
import needscroll.GraniteGrabber.Tasks.Portant;
import needscroll.GraniteGrabber.Tasks.PowerCopper;
import needscroll.GraniteGrabber.Tasks.PowerIron;
import needscroll.GraniteGrabber.Tasks.PowerTin;
import needscroll.GraniteGrabber.Tasks.Split2KG;
import needscroll.GraniteGrabber.Tasks.Split5KG;
import needscroll.GraniteGrabber.Tasks.Walking;

@Script.Manifest(name = "granite grabber", description = "Collects granite", properties = "author=needscroll; topic=1336760; client=6; hidden=true;")

public class GraniteGrabber extends PollingScript<ClientContext> implements PaintListener{

	List<Task> taskList = new ArrayList<Task>();
	MineGranite minegranite = new MineGranite(ctx);
	
	@Override
	public void start()
	{
		log.info("granite grabber has started");
		
		String act [] = {"Power Copper", "Power Tin", "Power Iron", "Portant", "Mine Granite", "Split Granite 2kg", "Split Granite 5kg"};
		String act_choice = (String) JOptionPane.showInputDialog(null, "What do you wish to do?","Bank",JOptionPane.PLAIN_MESSAGE, null, act,act[0]);
		
		taskList.add(new Antiban(ctx));
		
		if (act_choice == "Power Copper")
		{
			taskList.add(new PowerCopper(ctx));
		}
		if (act_choice == "Power Tin")
		{
			taskList.add(new PowerTin(ctx));
		}
		if (act_choice == "Power Iron")
		{
			taskList.add(new PowerIron(ctx));
		}
		if (act_choice == "Portant")
		{
			taskList.add(new Portant(ctx));
		}
		if (act_choice == "Mine Granite")
		{
			taskList.add(new MineGranite(ctx));
			taskList.add(new Banking(ctx));
			taskList.add(new Walking(ctx));
		}
		if (act_choice == "Split Granite 2kg")
		{
			taskList.add(new Split2KG(ctx));
		}
		if (act_choice == "Split Granite 5kg")
		{
			taskList.add(new Split5KG(ctx));
		}
	}
	
	@Override
	public void stop()
	{
		log.info("granite grabber has stopped");
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
	public void repaint(Graphics g1) {
		Graphics2D g = (Graphics2D)g1;
        g.setColor(Color.RED);
        g.drawString("Granite Grabber", 50, 50);
        g.drawString("Collected = " + minegranite.get_collected(), 50, 65);
	}

}
