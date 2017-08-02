package needscroll.FreeRunnecrafter;

import org.powerbot.script.*;
import org.powerbot.script.rt6.ClientContext;

import Tasks.CraftAir;
import Tasks.CraftWater;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

@Script.Manifest(description = "crafts free runes", name = "Free RuneCrafter")

public class FreeRunecrafter extends PollingScript<ClientContext> implements PaintListener{
	
	
	List<Task> taskList = new ArrayList<Task>();
	
	@Override
	public void start()
	{
		log.info("bananna grabber has started");
		
		String runes [] = {"Air", "Water", "Earth", "Fire", "Mind", "Body"};
		String rune_choice = (String) JOptionPane.showInputDialog(null, "Which runes to make?","Runes",JOptionPane.PLAIN_MESSAGE, null, runes,runes[0]);
		
		if (rune_choice == "Air")
		{
			taskList.add(new CraftAir(ctx));
		}
		if (rune_choice == "Water")
		{
			taskList.add(new CraftWater(ctx));
		}
	}
	
	@Override
	public void stop()
	{
		log.info("bananna grabber has stopped");
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
        g.drawString("Free RuneCrafter", 50, 50);
    }



}