package needscroll.CursedGrabber;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.powerbot.script.rt6.ClientContext;

import org.powerbot.script.*;

import needscroll.CursedGrabber.Tasks.Antiban;
import needscroll.CursedGrabber.Tasks.Banking;
import needscroll.CursedGrabber.Tasks.CONSTANTS;
import needscroll.CursedGrabber.Tasks.ConvertEnergy;
import needscroll.CursedGrabber.Tasks.ConvertExperience;
import needscroll.CursedGrabber.Tasks.EdgeBank;
import needscroll.CursedGrabber.Tasks.Failsafe;
import needscroll.CursedGrabber.Tasks.FallyTele;
import needscroll.CursedGrabber.Tasks.GeBank;
import needscroll.CursedGrabber.Tasks.GoBank;
import needscroll.CursedGrabber.Tasks.GoWild;
import needscroll.CursedGrabber.Tasks.Harvest;
import needscroll.CursedGrabber.Tasks.Logout;
import needscroll.CursedGrabber.Tasks.Teleport;


@Script.Manifest(name = "Cursed Grabber", description = "Everything to do with cursed energies", properties = "author=needscroll; topic=1340113; client=6; hidden=false;")

public class CursedGrabber extends PollingScript<ClientContext> implements PaintListener{

	List<Task> taskList = new ArrayList<Task>();
	Teleport teleport = new Teleport(ctx);
	Banking banking = new Banking(ctx);
	
	@Override
	public void start()
	{
		log.info("cursed grabber has started");

		String act [] = {"Experience", "Energy", "Activate"};
		String act_choice = (String) JOptionPane.showInputDialog(null, "What do you wish to do?","Bank",JOptionPane.PLAIN_MESSAGE, null, act,act[0]);
		
		if (act_choice == "Energy")
		{
			CONSTANTS.energy_limit = Integer.parseInt(JOptionPane.showInputDialog("Please enter the amount of energy to bank at"));
			taskList.add(new Failsafe(ctx));
			//taskList.add(new Antiban(ctx));
			taskList.add(new Harvest(ctx));
			taskList.add(new ConvertEnergy(ctx));
			taskList.add(new EdgeBank(ctx));
			
			taskList.add(new GoBank(ctx));
			taskList.add(new Banking(ctx));
		}
		
		if (act_choice == "Experience")
		{
			taskList.add(new Teleport(ctx));
			taskList.add(new Antiban(ctx));
			taskList.add(new Teleport(ctx));
			taskList.add(new Harvest(ctx));
			taskList.add(new ConvertExperience(ctx));
			taskList.add(new Teleport(ctx));
			taskList.add(new EdgeBank(ctx));
			taskList.add(new Teleport(ctx));
			taskList.add(new Teleport(ctx));
			taskList.add(new Failsafe(ctx));
		}
		/*
		if (act_choice == "Falador")
		{
			taskList.add(new FallyTele(ctx));
		}
		*/
		if (act_choice == "Activate")
		{
			taskList.add(new GoWild(ctx));
		}
		/*
		if (act_choice == "Energy")
		{
			taskList.add(new Teleport(ctx));
			taskList.add(new Antiban(ctx));
			taskList.add(new Teleport(ctx));
			taskList.add(new Harvest(ctx));
			taskList.add(new Teleport(ctx));
			taskList.add(new ConvertEnergy(ctx));
			taskList.add(new Teleport(ctx));
			taskList.add(new EdgeBank(ctx));
			taskList.add(new Teleport(ctx));
			taskList.add(new GeBank(ctx));
			taskList.add(new Teleport(ctx));
			taskList.add(new Failsafe(ctx));
		}*/
	}
	
	@Override
	public void stop()
	{
		log.info("cursed grabber has stopped");
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
	public void repaint(Graphics g1) {
		Graphics2D g = (Graphics2D)g1;
        g.setColor(Color.RED);
        g.drawString("Cursed Grabber V2", 50, 50);
        g.drawString("Amount Collected = " + banking.get_amount(), 50, 65);
	}

}
