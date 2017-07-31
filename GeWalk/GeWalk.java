package needscroll.GeWalk;

import org.powerbot.script.*;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Item;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


@Script.Manifest(description = "Enables GE", name = "GE Walker")
public class GeWalk extends PollingScript<ClientContext> implements PaintListener{

	boolean done = false;
	
	@Override
	public void start()
	{
		log.info("GE Walker has started");
	
		poll();
	}
	
	@Override
	public void stop()
	{
		log.info("GE Walker has stopped");
		ctx.controller.stop();
	}
	
	@Override
	public void poll() {
		
		if (!done)
		{
			//walk();
			talk();
			done = true;
		}
		
		if (done)
		{
			stop();
		}
	}
	
	private void walk()
	{
		ctx.camera.angle('n');
		ctx.camera.pitch(85);
		
		Travel go = new Travel(ctx);
		go.run_walk();
	}
	
	private void talk()
	{
		Talking guy = new Talking(ctx);
		guy.run_talk();
	}
	

	@Override
	public void repaint(Graphics g1) {
		Graphics2D g = (Graphics2D)g1;
        g.setColor(Color.RED);
        g.drawString("GE Walker", 50, 50);
        g.drawString("Status: Walking", 50, 65);
	}
}

