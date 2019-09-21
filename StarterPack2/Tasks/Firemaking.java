package needscroll.StarterPack2.Tasks;

import java.util.ArrayList;
import java.util.List;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.BasicQuery;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Item;

import needscroll.StarterPack2.CONSTANTS;
import needscroll.StarterPack2.Task;
import needscroll.StarterPack2.TrainingMap;

public class Firemaking extends Task{
	
	int failures;
	
	int[] items;
	int[] item_amounts;
	String interact_string;
	
	Area start_area;
	TrainingMap map;

	public Firemaking(ClientContext ctx, int[] items, int[] item_amounts, String interact_string,
			TrainingMap map, Area start_area) {
		super(ctx);
		this.items = items;
		this.item_amounts = item_amounts;
		this.interact_string = interact_string;
		this.start_area = start_area;
		this.map = map;
		failures = 0;
	}

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return failures <=2;
	}

	@Override
	public void execute() {
		if (ctx.players.local().animation() == -1)
		{
			if (valid_inv(ctx, items) && map.in_skill_area(ctx))
			{
				make_fire();
			}
			if (valid_inv(ctx, items) && !map.in_skill_area(ctx))
			{
				go_start();
			}
			if (!valid_inv(ctx, items))
			{
				get_logs();
			}
		}
		
	}

	private void make_fire()
	{
		GameObject fire = ctx.objects.select().id(CONSTANTS.fire).nearest().poll();
		if (fire.tile().equals(ctx.players.local().tile()))
		{
			go_start();
		}
		else
		{
			use_item(ctx, items[0], interact_string, 200);
			use_item(ctx, items[1], interact_string, 600);
			
			Item item = ctx.inventory.select().id(items[0]).poll();
			ctx.input.move(item.centerPoint());
			rand_sleep(500, 700);
		}
	}
	
	private void go_start() {
		for (int i = 0; i < start_area.tiles().length; i++)
		{
			step_tile(ctx, start_area.tiles()[i]);

			GameObject fire = ctx.objects.select().name("Fire").nearest().poll();
			if (!fire.tile().equals(ctx.players.local().tile()))
			{
				step_tile(ctx, start_area.tiles()[i]);
				break;
			}
		}
	}
	
	private void get_logs() {
		if (!map.in_bank_area(ctx))
		{
			step_tile(ctx, map.bank_tile);
		}
		if (map.in_bank_area(ctx))
		{		
			withdraw_preset(ctx, items, item_amounts);		
		}
		
		if (!valid_inv(ctx, items))
		{
			failures++;
		}
		else
		{
			failures = 0;
		}
		
	}

}
