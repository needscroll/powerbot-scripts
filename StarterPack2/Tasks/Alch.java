package needscroll.StarterPack2.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;

import needscroll.StarterPack2.CONSTANTS;
import needscroll.StarterPack2.Task;

public class Alch extends Task{
	
	public static int x = 0;
	public static int y = 0;

	public Alch(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		Item[] items = ctx.inventory.items();
		Item nat = ctx.inventory.select().id(CONSTANTS.nature_rune).poll();
		return items[11].valid() && nat.valid();
	}

	@Override
	public void execute() {
		int rand_s = (int) (Math.random() * 300);
		int rand_s1 = (int) (Math.random() * 50);
		int rand_sleep_a = (int) (Math.random() * 2000) + 1000;
		int rand_sleep_b = (int) (Math.random() * 2000) + 1000;
		int rand_sleep = (rand_sleep_a + rand_sleep_b) / 2;
		int rand_sleep1 = (int) (Math.random() * 500) + 500;
		if (x == 0 || y == 0 || rand_s < 20)
		{
			x = (int) (Math.random() * (CONSTANTS.x2 - CONSTANTS.x1)) + CONSTANTS.x1;
			y = (int) (Math.random() * (CONSTANTS.y2 - CONSTANTS.y1)) + CONSTANTS.y1;
			System.out.println("switching");
		}
		
		if (!ctx.game.tab().equals(ctx.game.tab().MAGIC))
		{
			ctx.game.tab(ctx.game.tab().MAGIC);
			ctx.input.click(x, y, true);
			Condition.sleep(rand_sleep1);
			ctx.input.click(x, y, true);
			Condition.sleep(rand_sleep);
		}
		
		ctx.input.click(x, y, true);
		Condition.sleep(rand_sleep1);
		ctx.input.click(x, y, true);
		Condition.sleep(rand_sleep);
		
		//746, 383
		//754, 393
		
	}

}
