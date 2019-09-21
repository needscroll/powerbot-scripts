package needscroll.StarterPack2.Tasks;

import org.powerbot.script.rt4.ClientContext;

import needscroll.StarterPack2.Task;

public class Combat extends Task{
	
	String monster_name;
	String monster_interact;

	public Combat(ClientContext ctx, String monster_name, String monster_interact) {
		super(ctx);
		this.monster_name = monster_name;
		this.monster_interact = monster_interact;
	}

	@Override
	public boolean activate() {
		return true;
	}

	@Override
	public void execute() {
		if (!ctx.players.local().inCombat() && idling(ctx, 500, 6))
		{
			combat();
		}
		if (ctx.players.local().healthPercent() < 50)
		{
			heal(ctx);
		}
	}
	
	private void combat()
	{
		use_npc(ctx, monster_name, monster_interact);
	}

}
