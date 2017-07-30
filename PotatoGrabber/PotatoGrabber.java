package needscroll.PotatoGrabber;

import org.powerbot.script.*;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Item;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


@Script.Manifest(description = "gets potatos", name = "potato grabber")
public class PotatoGrabber extends PollingScript<ClientContext> implements PaintListener{
	
	private final int POTATO = 1942;
	private final int POTATO_NOTE = 1943;
	private final int SEED = 5318;
	
	private String CURRENT_STATE = "";
	private int[] ITEMS_GRABBED = {0};
	
	@Override
	public void start()
	{
		log.info("potato grabber has started");
	
		poll();
	}
	
	@Override
	public void stop()
	{
		log.info("potato grabber has stopped");
		ctx.controller.stop();
	}
	
	@Override
	public void poll() {
		Condition.sleep(loop());
	}
	
	private int loop()
	{
		anti();
		Getstate current = new Getstate(ctx);
		
		if (current.fullinventory())
		{
			note();
		}
		else
		{
			collect();
		}
		
		return 200;
	}
	
	private void note()
	{
		CURRENT_STATE = "Noting"; 
		
		Noting note = new Noting(ctx);
		note.go_note();
	}
	
	private void collect()
	{
		CURRENT_STATE = "Collecting";
		
		Fill potato = new Fill(ctx);
		potato.pick(ITEMS_GRABBED);
	}
	
	private void anti()
	{
		Antiban fix = new Antiban(ctx);
		fix.run_anti();
	}

	@Override
	public void repaint(Graphics g1) {
		Graphics2D g = (Graphics2D)g1;
        g.setColor(Color.RED);
        g.drawString("Potato Grabber", 50, 50);
        g.drawString("Current State: " + CURRENT_STATE, 50, 65);
        g.drawString("Potatos Grabbed: " + ITEMS_GRABBED[0], 50, 80);
	}

}
