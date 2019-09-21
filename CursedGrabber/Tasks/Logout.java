package needscroll.CursedGrabber.Tasks;

import java.util.List;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;
import org.powerbot.script.rt6.Player;
import org.powerbot.script.rt6.PlayerQuery;

import needscroll.CursedGrabber.Task;

public class Logout extends Task{

	public Logout(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() 
	{
		Component skip = ctx.widgets.widget(906).component(502);
		
		Tile volc_o = new Tile(0, 0, 0);
		Tile volc_o1 = new Tile(3190, 3628, 0);
		Tile volc_o2 = new Tile(3114, 3736, 0);
		Area volc_o_area = new Area(volc_o1, volc_o2);
		
		PlayerQuery<Player> people = ctx.players.select().within(30);
		return volc_o_area.contains(ctx.players.local()) && people.size() > 1 || (ctx.lobby.opened() || (skip.visible() && skip.valid()));
	}

	@Override
	public void execute() 
	{
		Component skip = ctx.widgets.widget(906).component(502);
		
		if (!ctx.lobby.opened())
		{
			go_lobby();
		}
		
		if (skip.visible() && skip.valid())
		{
			System.out.println("skipping");
			skip.click(true);
			Condition.sleep(2000);
		}
		
		if (ctx.lobby.opened())
		{
			hop();
		}
	}

	private void go_lobby()
	{
		
	}
	
	private void hop()
	{
		
	}
	
}
