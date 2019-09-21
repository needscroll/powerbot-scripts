package needscroll.CursedGrabber.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;
import org.powerbot.script.rt6.Equipment;
import org.powerbot.script.rt6.Item;
import org.powerbot.script.rt6.Npc;

import needscroll.CursedGrabber.Task;

public class GeBank extends Task{
	
	final static int BANKER = 3293;
	final static int[] WEALTH = {20659, 20657, 20655, 20653, 2572};
	final static int[] GLORY = {1712, 1710, 1708, 1706, 1704};
	final static int BOW = 841;

	public GeBank(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		Tile ge_bank1 = new Tile(3169, 3457, 0);
		Tile ge_bank2 = new Tile(3144, 3484, 0);
		Area ge_bank_area = new Area(ge_bank1, ge_bank2);
		
		return ge_bank_area.contains(ctx.players.local());
	}

	@Override
	public void execute() 
	{	
		Component lode = ctx.widgets.widget(1092).component(49).component(14); // lodestone network component
		Item amulet_w = ctx.equipment.itemAt(Equipment.Slot.NECK);
		Item ring_w = ctx.equipment.itemAt(Equipment.Slot.RING);
		boolean ring_fail = fail(ring_w);
		boolean amulet_fail = fail(amulet_w);
		
		go_load();
		/*
		if (!ctx.bank.open())
		{
			open_bank();	
		}
		if (ctx.bank.open())
		{
			get_items();
			go_load();
		}	
		if (lode.valid() && lode.visible() && !ring_fail && !amulet_fail)
		{
			go_load();
		}*/
	}

	private void open_bank()
	{
		if (ctx.bank.open())
		{
			return;
		}
		
		Tile bank_tile = new Tile(3149, 3474, 0);
		Npc banker = ctx.npcs.select().id(BANKER).nearest().poll();
		ctx.camera.turnTo(banker.tile());
		
		if (banker.interact("Bank"))
		{
			Condition.sleep(1000);
			while(ctx.players.local().inMotion())
			{
				Condition.sleep(1000);
			}
		}
		else
		{
			ctx.movement.step(bank_tile);
			Condition.sleep(1000);
			while(ctx.players.local().inMotion())
			{
				Condition.sleep(1000);
			}
			banker.interact("Bank");
			Condition.sleep(1000);
			while(ctx.players.local().inMotion())
			{
				Condition.sleep(1000);
			}
		}
	}
	
	private void get_items()
	{
		Item amulet_w = ctx.equipment.itemAt(Equipment.Slot.NECK);
		Item ring_w = ctx.equipment.itemAt(Equipment.Slot.RING);
		boolean ring_fail = fail(ring_w);
		boolean amulet_fail = fail(amulet_w);
		
		ctx.bank.depositInventory();
		Condition.sleep(2000);
		
		if (amulet_fail || ring_fail)
		{
			ctx.bank.depositEquipment();
			Condition.sleep(2000);
			
			ctx.bank.withdraw(BOW, 1);
			Condition.sleep(2000);
			Item thing = ctx.backpack.select().id(BOW).poll();
			thing.interact("Wield");
			
			if (amulet_fail)
			{
				take_wear(GLORY[0]);
			}
			else
			{
				take_wear(amulet_w.id());
			}
			if (ring_fail)
			{
				take_wear(WEALTH[0]);
			}
			else
			{
				take_wear(ring_w.id());
			}
		}
		
		ctx.bank.close();
		Condition.sleep(2000);
	}
	
	private void take_wear(int id)
	{
		ctx.bank.withdraw(id, 1);
		Item thing = ctx.backpack.select().id(id).poll();
		thing.interact("Wear");
		Condition.sleep(1800);
	}
	
	private void go_load()
	{
		Component cont = ctx.widgets.widget(1186).component(4);
		Component yes = ctx.widgets.widget(1188).component(0);
		
		ctx.input.send("t");
		Condition.sleep(4000);
		ctx.input.send("w");
		Condition.sleep(2000);
		cont.click(true);
		Condition.sleep(2000);
		yes.click(true);
		Condition.sleep(20000);
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
}
