package needscroll.StarterPack2.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

import needscroll.StarterPack2.TrainingMap;

public class AreaItemGatheringTraining extends Powering{
	
	TrainingMap map;

	public AreaItemGatheringTraining(ClientContext ctx, int[] object, int[] product, String interact, TrainingMap map) {
		super(ctx, object, product, interact);
		this.map = map;
		// TODO Auto-generated constructor stub
	}

	public void gather()
	{
		if (idling(ctx))
		{
			if (!map.in_skill_area(ctx))
			{
				step_use_object(ctx, map.skill_tile, selected_objects, selected_interact);
			}
			if (map.in_skill_area(ctx))
			{
				use_npc(ctx, selected_objects, selected_interact);
				use_object(ctx, selected_objects, selected_interact);
			}
		}
	}
	
	public void deposit()
	{
		if (!map.in_bank_area(ctx))
		{
			step_tile(ctx, map.bank_tile);
		}
		else
		{
			bank_items(ctx, selected_products);
		}
	}

}
