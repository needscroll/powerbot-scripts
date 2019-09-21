package needscroll.StarterPack2;

import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

public class TrainingMap {
	
	public Tile skill_tile;
	public Tile bank_tile;
	public Area skill_area;
	public Area bank_area;
	
	public TrainingMap(Tile skill_tile, Tile bank_tile, Area skill_area, Area bank_area) 
	{
		this.skill_tile = skill_tile;
		this.bank_tile = bank_tile;
		this.skill_area = skill_area;
		this.bank_area = bank_area;
	}
	
	public boolean in_skill_area(ClientContext ctx)
	{
		return skill_area.contains(ctx.players.local());
	}
	
	public boolean in_bank_area(ClientContext ctx)
	{
		return bank_area.contains(ctx.players.local());
	}

}
