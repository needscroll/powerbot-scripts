package needscroll.PotatoGrabber;

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

import needscroll.PotatoGrabber.Tasks.Antiban;
import needscroll.PotatoGrabber.Tasks.Bank;
import needscroll.PotatoGrabber.Tasks.CONSTANTS;
import needscroll.PotatoGrabber.Tasks.GoBank;
import needscroll.PotatoGrabber.Tasks.Pick;
import needscroll.PotatoGrabber.Tasks.GoField;

@Script.Manifest(description = "Picks potatoes and banks at draynor", name = "PotatoGrabber", properties = "author=needscroll; topic=1344305; client=4; hidden=false")

public class PotatoGrabber extends PollingScript<ClientContext> implements PaintListener{

	List<Task> taskList = new ArrayList<Task>();

	@Override
	public void start()
	{
		log.info("PotatoGrabber has started");
		
		taskList.add(new Antiban(ctx));
		taskList.add(new Pick(ctx));
		taskList.add(new Bank(ctx));
		taskList.add(new GoField(ctx));
		taskList.add(new GoBank(ctx));
	}
	
	@Override
	public void stop()
	{
		log.info("PotatoGrabber has stopped");
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
        g.drawString("Potato Grabber", 50, 50);
        g.drawString("Amount Picked: " + CONSTANTS.amount, 50, 65);
	}
}
