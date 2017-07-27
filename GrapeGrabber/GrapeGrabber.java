package needscroll.GrapeGrabber;

import org.powerbot.script.*;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Item;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


@Script.Manifest(description = "gets grapes", name = "grape grabber")
public class GrapeGrabber extends PollingScript<ClientContext> implements PaintListener{
	
	private int GRAPES = 1987;
	private int APPLES = 1955;
	private int[] STAIRS = {24073, 24074, 24075};
	private int DOOR_ID = 2712;
	
	private String ITEMS_GRABBING = "Grapes and Apples";
	private int[] ITEMS_GRABBED = {0, 0};
	private String CURRENT_STATE = "";
	
	@Override
	public void start()
	{
		log.info("grape grabber has started");
	
		poll();
	}
	
	@Override
	public void stop()
	{
		log.info("grape grabber has stopped");
		ctx.controller.stop();
	}
	
	@Override
	public void poll() {
		Condition.sleep(loop());
	}
	
	private int loop()
	{
		anti();
		Item[] inv = ctx.backpack.items();
		Getstate current = new Getstate(ctx);
		boolean fullinv = current.full_inv(inv);
		
		if (fullinv)
		{
			bank();
		}
		else
		{
			collect(current);
		}
		
		return 200;
	}
	
	private void bank()
	{
		CURRENT_STATE = "Banking";
		
		Travel go = new Travel(ctx);
		go.go_bank();
		
		banking newbank = new banking(ctx);
		newbank.use_bank();
		
		go.go_guild();
	}
	
	private void collect(Getstate current)
	{
		CURRENT_STATE = "Collecting";
		
		int floor = current.findfloor();
		Fill bag = new Fill(ctx);
		
		bag.run_fill(floor, current, ITEMS_GRABBED, ITEMS_GRABBING);
	}
	
	private void anti()
	{
		Antiban fix = new Antiban(ctx);
		fix.run_antiban();
	}

	@Override
	public void repaint(Graphics g1) {
		Graphics2D g = (Graphics2D)g1;
        g.setColor(Color.RED);
        g.drawString("Grape Grabber", 50, 50);
        g.drawString("Current State: " + CURRENT_STATE, 50, 65);
        g.drawString("Grapes Grabbed: " + ITEMS_GRABBED[0], 50, 80);
        g.drawString("Apples Grabbed: " + ITEMS_GRABBED[1], 50, 95);
	}

}
