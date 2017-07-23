package needscroll.BanannaGrabber;

import org.powerbot.script.*;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.Backpack;
import org.powerbot.script.rt6.Item;
import org.powerbot.script.rt6.MobileIdNameQuery;
import org.powerbot.script.rt6.Objects;
import org.powerbot.script.rt6.GameObject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import org.powerbot.bot.rt6.client.Player;
import org.powerbot.script.rt6.Camera;
import org.powerbot.script.rt6.Widget;
import org.powerbot.script.rt6.Widgets;
import org.powerbot.script.rt6.Component;
import org.powerbot.script.rt6.Equipment;
import org.powerbot.script.rt6.Bank;
import org.powerbot.script.rt6.Equipment.Slot;
import org.powerbot.script.rt6.Game;


@Script.Manifest(description = "gets banannas", name = "bananna grabber")

public class BanannaGrabber extends PollingScript<ClientContext> implements PaintListener{

	//private final int[] BANANNA_TREES = {2073, 2074, 2075, 2076, 2077, 2078}; // trees with empty tree
	private final int[] BANANNA_TREES = {2073, 2074, 2075, 2076, 2077};
	private final int[] BASKETS = {5376, 5408, 5410, 5412, 5414, 5416};
	private final int BANANNA = 1963;
	private final int[] WEALTH = {20659, 20657, 20655, 20653, 2572};
	private final int[] GLORY = {1712, 1710, 1708, 1706, 1704};
	private final int[] DUELING = {2552, 2554, 2556, 2558, 2560, 2562, 2564, 2566};
	private final int GE_BANK = 87989;
	private final int CASTLE_BANK = 83634;
	private final int EDGE_BANK = 42378;
	
	private String BANK_CHOICE = "Grand Exchange";
	private String BOT_CHOICE = "Gather";
	private int[] CHOICE_TELE = {20659, 20657, 20655, 20653, 2572};
	private int CHOICE_BANK = 87989;
	
	private String CURRENT_STATE = "";
	private int[] BANANNAS_GRABBED = {0};
	private int[] FAILSAFE_COUNTER = {1};
	private Item[][] INVSTATES = new Item[3][28];
	
	//Calls Gui 
	public Gui banana; 
	
	@Override
	public void start()
	{
		log.info("bananna grabber has started");
		
		banana.isON();
		
		while (PlayerInput.gotinfo == false)
		{
			BANK_CHOICE = PlayerInput.bankLocation;
			BOT_CHOICE = PlayerInput.gatherOrUnBasket;
			log.info(BANK_CHOICE);
			log.info(BOT_CHOICE);
		}
		setconfig();
		
		log.info("got player input");
		poll();
	}
	
	@Override
	public void stop()
	{
		log.info("bananna grabber has stopped");
		ctx.controller.stop();
	}
	
	@Override
	public void poll() {
		Condition.sleep(loop());
	}
	
	private int loop()
	{
		anti();
		Item[] inv = ctx.backpack.items();
		getstate current = new getstate();
		boolean fullinv = current.full_inv(inv);
		int spaces = current.empty_spaces(inv);
		
		if (fullinv)
		{
			fill_baskets(inv);
		}
		else
		{
			collect(spaces);
		}
		
		return 200;
	}
	
	private boolean fill_baskets(Item[] inv)
	{
		CURRENT_STATE = "Filling Baskets";
		
		fill bag = new fill(ctx);
		boolean done = bag.fill_basket(inv);
		
		if (done == false)
		{
			bank(BANK_CHOICE);
		}
		
		return done;
	}
	
	private void collect(int empty)
	{
		CURRENT_STATE = "Collecting Banannas";
		
		fill bag = new fill(ctx);
		bag.collect(BANANNA_TREES, empty, BANANNAS_GRABBED);
	}
	
	private void bank(String bankchoice)
	{
		CURRENT_STATE = "Banking";
		
		teleport travel = new teleport(ctx);
		getstate tele_state = new getstate();
		banking newbank = new banking(ctx);
		
		Component ring = ctx.widgets.widget(1464).component(14).component(12);
		Component amulet = ctx.widgets.widget(1464).component(14).component(2);
		
		travel.go_bank(bankchoice, ring, amulet);
		
		Item amulet_w = ctx.equipment.itemAt(Equipment.Slot.NECK);
		Item ring_w = ctx.equipment.itemAt(Equipment.Slot.RING);
		GameObject bank = ctx.objects.select().id(CHOICE_BANK).nearest().poll();
		
		boolean ring_fail = tele_state.get_ringmatch(ring_w, CHOICE_TELE, BANK_CHOICE);
		boolean amulet_fail = tele_state.get_amuletmatch(amulet_w, GLORY[4]);
		
		newbank.bank_items(bank, BANK_CHOICE);
		newbank.get_tele_equipment(amulet_fail, ring_fail, amulet_w, ring_w, BANK_CHOICE);
		newbank.wear_items(amulet_fail, ring_fail, BANK_CHOICE);
		newbank.close();
		
		travel.go_island(amulet);
	}
	
	private void setconfig()
	{
		if (BANK_CHOICE == "Castle Wars")
		{
			CHOICE_TELE = DUELING.clone();
			CHOICE_BANK = CASTLE_BANK;
		}
		
		if (BANK_CHOICE == "Grand Exchange")
		{
			CHOICE_TELE = WEALTH.clone();
			CHOICE_BANK = GE_BANK;
		}
		
		if (BANK_CHOICE == "Edgeville")
		{
			CHOICE_TELE = GLORY.clone();
			CHOICE_BANK = EDGE_BANK;
		}
	}
	
	private void anti()
	{
		antiban checker = new antiban(ctx);
		checker.run_antiban();
		checker.run_failsafe(INVSTATES, FAILSAFE_COUNTER, BANK_CHOICE);
	}
	
	@Override
    public void repaint(Graphics g1)
    {
        Graphics2D g = (Graphics2D)g1;
        g.setColor(Color.RED);
        g.drawString("Bananna Grabber", 50, 50);
        g.drawString("Current State: " + CURRENT_STATE, 50, 65);
        g.drawString("Banannas Grabbed: " + BANANNAS_GRABBED[0], 50, 80);
    }



}