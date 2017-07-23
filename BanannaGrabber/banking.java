package needscroll.BanannaGrabber;

import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.Item;
import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientAccessor;

public class banking extends ClientAccessor{
	
	private final int[] BASKETS = {5376, 5408, 5410, 5412, 5414, 5416};
	private final int[] GLORY = {1712, 1710, 1708, 1706, 1704};
	private final int[] WEALTH = {20659, 20657, 20655, 20653, 2572};
	private final int[] DUELING = {2552, 2554, 2556, 2558, 2560, 2562, 2564, 2566};
	
	public banking(ClientContext ctx)
	{
		super(ctx);
	}

	private void withdraw(int id, int amount)
	{
		ctx.bank.withdraw(id, amount);
		Condition.sleep(2000);
	}
	
	public void bank_items(GameObject bank, String bankchoice)
	{
		if (bankchoice == "Grand Exchange")
		{
			bank.interact("Open Bank");
		}
		if (bankchoice == "Castle Wars")
		{
			bank.interact("Use");
		}
		if (bankchoice == "Edgeville")
		{
			bank.interact("Bank");
		}
		// needs to be changed depending on what bank used (fixed)
		
		Condition.sleep(5000);
		while (ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
		
		ctx.bank.depositInventory();
		Condition.sleep(2000);
		
		withdraw(BASKETS[0], 23);
	}
	
	public void get_tele_equipment(boolean amulet_fail, boolean ring_fail, Item amulet_w, Item ring_w, String bankchoice)
	{
		if (bankchoice == "Grand Exchange" && (amulet_fail || ring_fail))
		{
			ctx.bank.depositEquipment();
			Condition.sleep(2000);
			
			if (amulet_fail)
			{
				withdraw(GLORY[0], 1);
			}
			else
			{
				withdraw(amulet_w.id(), 1);
			}
			
			if (ring_fail)
			{
				withdraw(WEALTH[0], 1);
			}
			else
			{
				withdraw(ring_w.id(), 1);
			}
		}
		
		if(bankchoice == "Castle Wars" && (amulet_fail || ring_fail))
		{
			ctx.bank.depositEquipment();
			Condition.sleep(2000);
			
			if (amulet_fail)
			{
				withdraw(GLORY[0], 1);
			}
			else
			{
				withdraw(amulet_w.id(), 1);
			}
			
			if (ring_fail)
			{
				withdraw(DUELING[0], 1);
			}
			else
			{
				withdraw(ring_w.id(), 1);
			}
		}
		
		if (bankchoice == "Edgeville" && amulet_fail)
		{
			ctx.bank.depositEquipment();
			Condition.sleep(2000);

			withdraw(GLORY[0], 1);
		}
	}
	
	public void wear_items(boolean ring_fail, boolean amulet_fail, String bankchoice)
	{
		Item[] inv = ctx.backpack.items();
		
		if (bankchoice == "Grand Exchange" || bankchoice == "Castle Wars" && (amulet_fail || ring_fail))
		{
			inv[23].interact("Wear");
			Condition.sleep(2000);
			inv[24].interact("Wear");
			Condition.sleep(2000);
		}
		
		if (bankchoice == "Edgeville")
		{
			inv[23].interact("Wear");
			Condition.sleep(2000);
		}
	}
	
	public void close()
	{
		ctx.bank.close();
		Condition.sleep(2000);
	}
	
	public void fix_bankwithdraw(String bankchoice)
	{
		if (bankchoice == "Grand Exchange")
		{
			withdraw(GLORY[0], 1);
			withdraw(WEALTH[0], 1);
		}
		if (bankchoice == "Castle Wars")
		{
			withdraw(GLORY[0], 1);
			withdraw(DUELING[0], 1);
		}
		if (bankchoice == "Castle Wars")
		{
			withdraw(GLORY[0], 1);
		}
	}
	

}
