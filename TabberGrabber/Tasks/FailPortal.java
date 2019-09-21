package needscroll.TabberGrabber.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.ClientContext;

import needscroll.TabberGrabber.Task;

public class FailPortal extends Task{
	
	final static int PORTAL = 1;

	public FailPortal(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		Tile out1 = new Tile(0, 0, 0);
		Tile out2 = new Tile(0, 0, 0);
		Area out = new Area(out1, out2);
		
		return out.contains(ctx.players.local());
	}

	@Override
	public void execute() {
		GameObject portal = ctx.objects.select().id(PORTAL).nearest().poll();
		
		portal.interact("Enter house");
		Condition.sleep(5000);
		
		// call butler
		//walk lectern room
		//have all doors opened
		//check butler distance if all doors are opened
		
	}

}
