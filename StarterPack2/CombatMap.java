package needscroll.StarterPack2;

import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

public class CombatMap extends TrainingMap{
	
	public Tile restore_tile;
	public Area restore_area;

	public CombatMap(Tile skill_tile, Tile bank_tile, Tile restore_tile, Area skill_area, Area bank_area, Area restore_area) {
		super(skill_tile, bank_tile, skill_area, bank_area);
		this.restore_tile = restore_tile;
		this.restore_area = restore_area;
	}
	
	public boolean in_restore_area(ClientContext ctx)
	{
		return restore_area.contains(ctx.players.local());
	}

}
