package needscroll.StarterPack2.Tasks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.util.List;

import org.powerbot.script.Condition;
import org.powerbot.script.PaintListener;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Interactive;
import org.powerbot.script.rt4.Player;
import org.powerbot.script.rt4.TileMatrix;

import needscroll.StarterPack2.CONSTANTS;
import needscroll.StarterPack2.Task;


public class test extends Task{
	
	public static int x = 0;
	public static int y = 0;
	
	final int x_pos = 730;
	final int y_pos = 366;

	public test(ClientContext ctx) {
		super(ctx);
		x = 730;
		y = 366;
	}

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void execute() {
		int rand_s = (int) (Math.random() * 300);
		int rand_s1 = (int) (Math.random() * 50);
		int rand_sleep_a = (int) (Math.random() * 1000) + 1000;
		int rand_sleep_b = (int) (Math.random() * 1000) + 1000;
		int rand_sleep = (rand_sleep_a + rand_sleep_b) / 2;
		int rand_sleep1 = (int) (Math.random() * 500) + 500;
		
		
		if (x == 0 || y == 0 || rand_s < 20)
		{
			x = (int) ((Math.random() * 14 - 7) + x_pos);
			y = (int) ((Math.random() * 14 - 7) + y_pos);
			System.out.println("switching");
		}
		
		if (!ctx.game.tab().equals(ctx.game.tab().MAGIC))
		{
			ctx.game.tab(ctx.game.tab().MAGIC);
		}
		
		ctx.input.move(x, y);
		ctx.input.click(true);
		Condition.sleep(rand_sleep);

	}
}
