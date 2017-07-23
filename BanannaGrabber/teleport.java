package needscroll.BanannaGrabber;

import org.powerbot.script.Tile;
import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;
import org.powerbot.script.rt6.Equipment;
import org.powerbot.script.rt6.Item;

public class teleport extends ClientAccessor{
	
	private final int[] GLORY = {1712, 1710, 1708, 1706, 1704};
	//3081, 3500, 0
	//3092, 3497, 0
	
	public teleport(ClientContext ctx)
	{
		super(ctx);
	}
	
	public void go_bank(String bankchoice, Component ring, Component amulet)
	{
		if (bankchoice == "Grand Exchange")
		{
			go_ge(ring);
		}
		if (bankchoice == "Castle Wars")
		{
			go_castle(ring);
		}
		if (bankchoice == "Edgeville")
		{
			go_edge(amulet);
		}
	}
	
	private void go_ge(Component ring)
	{
		ring.interact("Grand Exchange");
		Condition.sleep(6000);
	}
	
	private void go_castle(Component ring)
	{
		ring.interact("Castle Wars");
		Condition.sleep(6000);
	}
	
	private void go_edge(Component amulet)
	{
		Item amulet_w = ctx.equipment.itemAt(Equipment.Slot.NECK);
		
		if (amulet_w.id() == GLORY[4])
		{
			go_edgeload();
		}
		else
		{
			amulet.interact("Edgeville");
			Condition.sleep(6000);
		}
	}
	
	private void go_edgeload()
	{
		 ctx.input.send("t");
		 Condition.sleep(2000);
		 ctx.input.send("e");
		 Condition.sleep(25000);
		 walk_tobank();
	}

	public void go_island(Component amulet)
	{
		amulet.interact("Karamja");
		Condition.sleep(6000);
	}
	
	private void walk_tobank()
	{
		Tile[] pathToBank = new Tile[] {new Tile(3081, 3500, 0), new Tile(3092, 3497, 0)};
		
		for (int counter = 0; counter < pathToBank.length; counter++)
		{
			ctx.movement.step(pathToBank[counter]);
			Condition.sleep(1000);
			
			while(ctx.players.local().inMotion())
			{
				Condition.sleep(1000);
			}
		}
	}
	
	public void fix_tele()
	{
		go_edgeload();
		walk_tobank();
	}
}
