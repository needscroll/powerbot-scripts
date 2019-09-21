package needscroll.StarterPack2.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;

import needscroll.StarterPack2.CONSTANTS;
import needscroll.StarterPack2.Obstacle;
import needscroll.StarterPack2.Task;
import needscroll.StarterPack2.TrainingMap;

public class AreaItemUseTraining extends Task{
	
	int[] items;
	int[] item_amounts;
	
	int training_object;
	String training_object_string;
	
	Obstacle obstacle;
	TrainingMap map;
	Component training_component;
	
	int[] bounds;
	int[] default_bounds = {-32, 32, -64, 0, -32, 32};
	
	int failures;
	
	public AreaItemUseTraining(ClientContext ctx, int[] items, int[] item_amounts,
			int training_object, String training_object_string,
			Obstacle obstacle, TrainingMap map, Component training_component) {
		
		super(ctx);
		this.items = items;
		this.item_amounts = item_amounts;
		this.training_object = training_object;
		this.training_object_string = training_object_string;
		this.obstacle = obstacle;
		this.bounds = default_bounds;
		this.map = map;
		this.training_component = training_component;
		failures = 0;
	}

	public AreaItemUseTraining(ClientContext ctx, int[] items, int[] item_amounts,
			int training_object, String training_object_string, int[] bounds,
			Obstacle obstacle, TrainingMap map, Component training_component) {
		
		super(ctx);
		this.items = items;
		this.item_amounts = item_amounts;
		this.training_object = training_object;
		this.training_object_string = training_object_string;
		this.obstacle = obstacle;
		this.bounds = bounds;
		this.map = map;
		this.training_component = training_component;
		failures = 0;
	}

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return failures <= 2 && items.length == item_amounts.length;
	}

	@Override
	public void execute() {
		/*
		 * if inventory matches spec, go to training area
		 * if in training area, train until inventory no longer matches spec
		 * if inventory does not match spec, go to bank
		 * if in bank, get inventory up to spec
		 */
		
		if (idling(ctx))
		{			
			
			if (valid_inv(ctx, items))
			{
				skill();
			}
			else
			{
				deposit();
			}
		}
	}
	
	private void skill() 
	{
		if (!map.in_skill_area(ctx))
		{
			step_tile(ctx, map.skill_tile);
		}
		if (obstacle != null && obstacle_exists())
		{
			clear_obstacle();
		}
		if (object_valid(ctx, training_object))
		{
			if (!component_valid(training_component))
			{
				activate_training();
			}
			select_component();
		}
		
	}
	
	private void activate_training()
	{
		//use_item(ctx, items[0], training_object_string); MAYBE THIS IS NEEDED FOR SOME OTHER ACTIVITIES?
		use_object(ctx, training_object, training_object_string, bounds);
	}


	private void clear_obstacle() {
		obstacle.clear_obstacle(ctx);
	}

	private boolean obstacle_exists() {
		return obstacle.obstacle_valid(ctx);
	}

	private void deposit() 
	{
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
	
	private void select_component() {
		if (component_valid(training_component))
		{
			use_component(training_component);
		}		
	}



}
