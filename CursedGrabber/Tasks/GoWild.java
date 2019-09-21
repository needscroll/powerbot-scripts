package needscroll.CursedGrabber.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;
import org.powerbot.script.rt6.GameObject;
import needscroll.CursedGrabber.Task;

public class GoWild extends Task{
	
	final static int[] WILD_WALL = {65081, 65083};
	final static int STONE_F = 69858;
	final static int STONE_F2 = 69859;
	final static int STONE_E = 69856;
	final static int STONE_E2 = 69857;
	final static int STONE_W = 84767;
	final static int STONE_W2 = 84768;
	final static int GATE_C = 28691;
	final static int GATE_O = 28693;
	public static boolean[] stone_f = {false};
	public static boolean[] stone_e = {false};
	public static boolean[] stone_w = {false};
	public static boolean first = false;
	public static boolean[] done = {false};

	public GoWild(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return !done[0];
	}

	@Override
	public void execute() {
		Tile burth1 = new Tile(2855, 3390, 0);
		Tile burth2 = new Tile(2942, 3555, 0);
		Tile gate_i = new Tile(2937, 3440, 0);
		Area burth = new Area(burth1, burth2);
		
		Tile fally_stone = new Tile(2967, 3405, 0);
		Tile fally1 = new Tile(2972, 3400, 0);
		Tile fally_b = new Tile(2943, 3450, 0);
		Area fally_o = new Area(fally_b, fally1);
		
		Tile edge_stone = new Tile(3066, 3506, 0);
		
		Tile wall = new Tile(3062, 3520, 0);
		Tile north1 = new Tile(3040, 3523, 0);
		Tile north2 = new Tile(3300, 3900, 0);;
		Area wild_north = new Area(north1, north2);
		
		Tile wild_stone = new Tile(3143, 3635, 0);
		
		boolean in_burth = burth.contains(ctx.players.local());
		boolean in_fally = fally_o.contains(ctx.players.local());
		boolean in_wild = wild_north.contains(ctx.players.local());
		
		Component warning = ctx.widgets.widget(382).component(10);
		
		if (!first)
		{
			go_burth();
			first = true;
		}
		
		if (in_burth && stone_f[0] == false)
		{
			burth_gate(gate_i);
		}
		
		if (in_fally && stone_f[0] == false)
		{
			go_stone(fally_stone, STONE_F, STONE_F2, stone_f);
		}
		
		if (stone_f[0] == true && stone_e[0] == false)
		{
			go_stone(edge_stone, STONE_E, STONE_E2, stone_e);
		}
		
		if (stone_f[0] && stone_e[0] && !in_wild)
		{
			enter_wild(wall);
		}
		
		if (warning.valid() && warning.visible())
		{
			clear_warning(warning);
		}
		
		if (in_wild)
		{
			go_stone(wild_stone, STONE_W, STONE_W2, stone_w);
		}
		
		if (stone_f[0] && stone_e[0] && stone_w[0])
		{
			done[0] = true;
		}
	
	}
	
	private void burth_gate(Tile gate_i)
	{
		ctx.movement.step(gate_i.tile());
		Condition.sleep(1000);
		while (ctx.players.local().inMotion())
		{
			Condition.sleep(600);
		}
		
		GameObject gate_c = ctx.objects.select().id(GATE_C).nearest().poll();
		GameObject gate_o = ctx.objects.select().id(GATE_O).nearest().poll();
		Tile fally_stone = new Tile(2967, 3405, 0);

		if (gate_c.valid())
		{
			ctx.camera.turnTo(gate_c.tile());
			gate_c.interact("Open");
			Condition.sleep(1000);
			ctx.movement.step(fally_stone.tile());
			Condition.sleep(1000);
			while (ctx.players.local().inMotion())
			{
				Condition.sleep(600);
			}
		}
		
		if (gate_o.valid())
		{
			ctx.movement.step(fally_stone.tile());
			Condition.sleep(1000);
			while (ctx.players.local().inMotion())
			{
				Condition.sleep(600);
			}
		}
	}

	private void enter_wild(Tile wall_t)
	{	
		ctx.movement.step(wall_t.tile());
		Condition.sleep(1000);
		while (ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
		
		GameObject wall = ctx.objects.select().id(WILD_WALL).nearest().poll();
		
		if (wall.valid())
		{
			ctx.camera.turnTo(wall.tile());
			Condition.sleep(1000);
			if (wall.interact("Cross")) //need get interaction option
			{
				Condition.sleep(5000);
				while (ctx.players.local().inMotion())
				{
					Condition.sleep(600);
				}
			}
		}
	}
	
	private void clear_warning(Component warning)
	{
		warning.click(true);
		Condition.sleep(4000);
	}
	
	private void go_stone (Tile stone, int id, int id2, boolean[] gate)//need change boolean gate to array?
	{
		ctx.movement.step(stone.tile());
		Condition.sleep(1000);
		while (ctx.players.local().inMotion())
		{
			Condition.sleep(600);
		}
		
		if (activate_stone(id, id2))
		{
			gate[0] = true;
		}
	}
	
	private boolean activate_stone(int id, int id2)
	{
		GameObject stone = ctx.objects.select().id(id).nearest().poll();
		GameObject stone2 = ctx.objects.select().id(id2).nearest().poll();
		if (stone.valid() || stone2.valid())
		{
			ctx.camera.turnTo(stone.tile());
			Condition.sleep(1000);
			if (stone.interact("Activate") || stone2.valid() || stone2.inViewport())
			{
				Condition.sleep(1000);
				while (ctx.players.local().inMotion())
				{
					Condition.sleep(600);
				}
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	private void go_burth()
	{
		ctx.input.send("t");
		Condition.sleep(2000);
		ctx.input.send("b");
		Condition.sleep(22000);
	}

}