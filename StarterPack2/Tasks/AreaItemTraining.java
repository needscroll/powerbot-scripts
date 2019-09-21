package needscroll.StarterPack2.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

public class AreaItemTraining extends Powering{
	
	Tile selected_skill_tile;
	Tile selected_bank_tile;
	Area selected_skill_area;
	Area selected_bank_area;

	public AreaItemTraining(ClientContext ctx, int[] object, int[] product, String interact, String disposal,
			Tile skill_tile, Tile bank_tile, Area skill_area, Area bank_area) {
		super(ctx, object, product, interact, disposal);
		this.selected_skill_tile = skill_tile;
		this.selected_bank_tile = bank_tile;
		this.selected_skill_area = skill_area;
		this.selected_bank_area = bank_area;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gather()
	{
		if (idling(ctx))
		{
			if (!selected_skill_area.contains(ctx.players.local()))
			{
				step_use_object(ctx, selected_skill_tile, selected_objects, selected_interact);
			}
			if (selected_skill_area.contains(ctx.players.local()))
			{
				use_npc(ctx, selected_objects, selected_interact);
				use_object(ctx, selected_objects, selected_interact);
			}
		}
	}
	
	@Override
	public void deposit()
	{
		if (!selected_bank_area.contains(ctx.players.local()))
		{
			ctx.movement.step(selected_bank_tile);
			wait_sleep(ctx);
		}
		else
		{
			bank_items(ctx, selected_products);
		}
	}

}
