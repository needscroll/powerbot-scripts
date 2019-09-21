package needscroll.StarterPack2.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;

import needscroll.StarterPack2.CONSTANTS;
import needscroll.StarterPack2.CombatMap;
import needscroll.StarterPack2.Obstacle;
import needscroll.StarterPack2.Task;

public class BankingCombat extends Task{
	
	int[] food;
	int[] food_amounts;
	
	protected CombatMap map;
	Obstacle obstacle;
	
	boolean agro;
	boolean need_food;
	int failures;

	public BankingCombat(ClientContext ctx, int[] food, int[] food_amounts, CombatMap map) {
		super(ctx);
		
		this.food = food;
		this.food_amounts = food_amounts;
		this.map = map;
		
		agro = true;
		need_food = false;
		failures = 0;
	}
	
	public BankingCombat(ClientContext ctx, int[] food, int[] food_amounts, CombatMap map, Obstacle obstacle) {
		super(ctx);
		
		this.food = food;
		this.food_amounts = food_amounts;
		this.map = map;
		this.obstacle = obstacle;
		
		agro = true;
		need_food = false;
		failures = 0;
	}

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return failures <= 2;
	}

	@Override
	public void execute() {
		/*
		 * if not have food, go bank get food
		 * if have food and not agro, go reset agro
		 * on default, sleep on agro and have food
		 */
		
		if (amount_food() < 5)
		{
			need_food = true;
		}
		if (!need_food && agro && map.in_skill_area(ctx) && idling(ctx, 1000, 30))
		{
			agro = false;
		}

		if (ctx.players.local().healthPercent() < 50)
		{
			heal(ctx);
		}
		if (need_food)
		{
			get_food();
		}
		if (!need_food && !agro)
		{
			restore_agro();
		}

		if (!need_food && agro && !map.in_skill_area(ctx))
		{
			go_combat_area();
		}
		
	}
	
	private void go_combat_area() 
	{
		if (!map.in_skill_area(ctx))
		{
			step_tile(ctx, map.skill_tile);
		}
		if (obstacle != null && obstacle_exists())
		{
			clear_obstacle();
		}
	}

	private boolean obstacle_exists() {
		// TODO Auto-generated method stub
		return false;
	}

	private void clear_obstacle() {
		// TODO Auto-generated method stub
		
	}

	private void restore_agro() {
		if (!map.in_restore_area(ctx))
		{
			step_tile(ctx, map.restore_tile);
		}
		if (map.in_restore_area(ctx))
		{
			agro = true;
		}
	}
	
	private void get_food() 
	{
		if (!map.in_bank_area(ctx))
		{
			step_tile(ctx, map.bank_tile);
		}
		if (map.in_bank_area(ctx))
		{	
			withdraw(ctx, food, food_amounts);
			if (!valid_inv(ctx, food))
			{
				failures++;
			}
			else
			{
				failures = 0;
				need_food = false;
			}
		}
	}
	
	private int amount_food()
	{
		Item[] inv = ctx.inventory.items();
		int amount = 0;

		for (int i = 0; i < inv.length; i++)
		{
			for (int j = 0; j < inv[i].inventoryActions().length; j++)
			{
				if (inv[i].inventoryActions()[j] != null && inv[i].inventoryActions()[j].equals("Eat"))
				{
					amount++;
				}
			}
		}
		return amount;
	}
}
