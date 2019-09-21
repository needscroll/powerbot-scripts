package needscroll.CursedGrabber.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Equipment;
import org.powerbot.script.rt6.Item;

import needscroll.CursedGrabber.Task;

public class Teleport extends Task{
	
	final static int[] WEALTH = {20659, 20657, 20655, 20653, 2572};
	final static int[] GLORY = {1712, 1710, 1708, 1706, 1704};
	final static int CURSED_E = 37941;
	public static int COLLECTED = 0;

	public Teleport(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() 
	{
		Tile volc_t = new Tile(3143, 3711, 0);
		Tile volc_t1 = new Tile(3121, 3729, 0);
		Tile volc_t2 = new Tile(3160, 3692, 0);
		Area volc_t_area = new Area(volc_t1, volc_t2);
		
		Tile edge1 = new Tile(3079, 3505, 0);
		Tile edge2 = new Tile(3114, 3474, 0);
		Area edge_area = new Area(edge1, edge2);
		
		Tile ge_bank1 = new Tile(3169, 3457, 0);
		Tile ge_bank2 = new Tile(3144, 3484, 0);
		Area ge_bank_area = new Area(ge_bank1, ge_bank2);
		
		boolean edge_bank = edge_area.contains(ctx.players.local());
		boolean ge_bank = ge_bank_area.contains(ctx.players.local());
		
		Item energy = ctx.backpack.select().id(CURSED_E).poll();
		
		return ((ctx.players.local().inCombat() || energy.stackSize() > 500) && (!edge_bank && !ge_bank) && volc_t_area.contains(ctx.players.local()));
	}

	@Override
	public void execute() 
	{
		System.out.println("execute");
		Item amulet_w = ctx.equipment.itemAt(Equipment.Slot.NECK);
		Item ring_w = ctx.equipment.itemAt(Equipment.Slot.RING);
		Item energy = ctx.backpack.select().id(CURSED_E).poll();
		boolean ring_fail = fail(ring_w);
		boolean amulet_fail = fail(amulet_w);
		
		if (!ring_fail)
		{
			if (ring_w.interact("Grand Exchange"))
			{
				Condition.sleep(6000);
			}
			else
			{
				ring_w.interact("Grand Exchange");
				Condition.sleep(6000);
			}
		}
		else
		{
			if (amulet_w.interact("Edgeville"))
			{
				Condition.sleep(6000);
			}
			else
			{
				amulet_w.interact("Edgeville");
				Condition.sleep(6000);
			}
		}
		COLLECTED += energy.stackSize();
	}
	
	private boolean fail(Item thing)
	{
		boolean fail = true;
		
		for (int counter = 0; counter < WEALTH.length - 1; counter++)
		{
			if (thing.id() == WEALTH[counter] || thing.id() == GLORY[counter])
			{
				fail = false;
			}
		}
		
		return fail;
	}
	
	public static int get_energy()
	{
		return COLLECTED;
	}
}
