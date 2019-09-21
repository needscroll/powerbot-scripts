package needscroll.StarterPack2.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;

import needscroll.StarterPack2.CombatMap;

public class PassiveCombatReset extends BankingCombat{

	public PassiveCombatReset(ClientContext ctx, int[] food, int[] food_amounts, CombatMap map) {
		super(ctx, food, food_amounts, map);
		// TODO Auto-generated constructor stub
	}
	
	private void get_food()
	{
		if (!map.in_bank_area(ctx))
		{
			step_tile(ctx, map.bank_tile);
		}
		if (map.in_bank_area(ctx))
		{	
			Condition.sleep();
		}
	}

}
