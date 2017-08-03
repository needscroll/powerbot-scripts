package needscroll.FreeRunecrafter;

import org.powerbot.script.*;
import org.powerbot.script.rt6.ClientContext;

import Tasks.Antiban;
import Tasks.CraftAir;
import Tasks.CraftBody;
import Tasks.CraftEarth;
import Tasks.CraftFire;
import Tasks.CraftMind;
import Tasks.CraftWater;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

@Script.Manifest(description = "crafts free runes", name = "Free RuneCrafter")

public class FreeRunecrafter extends PollingScript<ClientContext> implements PaintListener{
	
	CraftAir air = new CraftAir(ctx);
	CraftWater water = new CraftWater(ctx);
	CraftFire fire = new CraftFire(ctx);
	CraftEarth earth = new CraftEarth(ctx);
	CraftBody body = new CraftBody(ctx);
	CraftMind mind = new CraftMind(ctx);
	
	List<Task> taskList = new ArrayList<Task>();
	
	@Override
	public void start()
	{
		log.info("FreeRunecrafter has started");
		
		String runes [] = {"Air", "Water", "Earth", "Fire", "Mind", "Body"};
		String rune_choice = (String) JOptionPane.showInputDialog(null, "Which runes to make?","Runes",JOptionPane.PLAIN_MESSAGE, null, runes,runes[0]);
		
		taskList.add(new Antiban(ctx));
		
		if (rune_choice == "Air")
		{
			taskList.add(new CraftAir(ctx));
		}
		if (rune_choice == "Water")
		{
			taskList.add(new CraftWater(ctx));
		}
		if (rune_choice == "Fire")
		{
			taskList.add(new CraftFire(ctx));
		}
		if (rune_choice == "Earth")
		{
			taskList.add(new CraftEarth(ctx));
		}
		if (rune_choice == "Body")
		{
			taskList.add(new CraftBody(ctx));
		}
		if (rune_choice == "Mind")
		{
			taskList.add(new CraftMind(ctx));
		}
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
        g.drawString("Free RuneCrafter", 50, 50);
        g.drawString("Runes Made = " + (air.get_runes() + water.get_runes() + fire.get_runes() + earth.get_runes() + body.get_runes() + mind.get_runes()), 50, 65);
    }



}