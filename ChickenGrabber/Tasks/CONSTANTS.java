package needscroll.ChickenGrabber.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Tile;

public class CONSTANTS {
	
	public static int crate_to_grab = 1;
	
	public static int chicken_crate = 15032;
	public static int potato_crate = 1;
	public static int banana_crate = 2071;
	public static int cabbage_crate = 1;
	
	public static int chicken = 2138;
	public static int banana = 1963;
	public static int potato = 1;
	public static int cabbage = 1;
	
	public static int chicken_noted = 1;
	public static int potato_noted = 1;
	public static int banana_noted = 1;
	public static int cabbage_noted = 1;
	
	public static int[] trading_items = {2138, 1963, 1, 1};
	public static int[] noted_items = {2139, 1964, 1, 1};
	
	public static int back_door = 2069;
	public static int front_door = 1535;
	public static int bank_deposit = 26254;
	public static int bank_booth = 24101;
	
	public static int pirate = 1;
	public static int sailor = 1;
	public static int gangplank1 = 1;
	public static int gangplank2 = 1;
	public static int banana_man = 1;
	public static int bananna_crate = 1;
	public static int banana_tree = 1;
	public static int karamja_rum = 1;
	public static int wine_merchant = 1;
	
	public static Tile store_tile = new Tile (3015, 3205, 0);
	public static Tile back_store1 = new Tile(3012, 3203, 0);
	public static Tile back_store2 = new Tile(3009, 3210, 0);
	public static Area back_store_area = new Area(back_store1, back_store2);
	
	public static Tile bank_deposit_tile = new Tile(3045, 3235, 0);
	public static Tile bank_deposit1 = new Tile(3042, 3237, 0);
	public static Tile bank_deposit2 = new Tile(3048, 3233, 0);
	public static Area bank_deposit_area = new Area(bank_deposit1, bank_deposit2);
	
	public static Tile gen_store_tile = new Tile(3211, 3247, 0);
	public static Tile gen_store_tile1 = new Tile(3209, 33250, 0);
	public static Tile gen_store_tile2 = new Tile(3215, 3243, 0);
	public static Area gen_store_area = new Area(gen_store_tile1, gen_store_tile2);
	
	public static Tile fally_bank = new Tile(3013, 3357, 0);
	public static Tile fally_bank1 = new Tile(3019, 3354, 0);
	public static Tile fally_bank2 = new Tile(3010, 3358, 0);
	public static Area fally_bank_area = new Area(fally_bank1, fally_bank2);
	
	public static int yestake_widget = 219;
	public static int yestake_component1 = 0;
	public static int yestake_component2 = 1;
	
	public static int deposit_widget = 192;
	public static int deposit_component = 3;
	
	public static int exit_widget = 192;
	public static int exit_component1 = 1;
	public static int exit_component2 = 11;
	
	public static String crate_interact = "Search";
	public static String back_door_interact = "Open";
	public static String mule_interact = "Trade";
	public static String bank_deposit_interact = "Deposit";
	public static String bank_booth_interact = "Bank";
	public static String offer_all_interact = "Offer-All";
	public static String banana_interact = "Take";
	
	public static int trade_window_widget = 335;
	public static int trade_window_component = 31;
	public static int trade_window_widget2 = 334;
	public static int trade_window_component2 = 4;
	public static int trade_text_widget = 162;
	public static int trade_text_component = 44;
	public static int trade_text_component2 = 0;
	public static int accept1_widget = 335;
	public static int accept1_component = 12;
	public static int accept2_widget = 334;
	public static int accept2_component = 25;
	public static int accepted1_widget = 335;
	public static int accepted1_component = 30;
	public static int accepted2_widget = 334;
	public static int accepted2_component = 4;
	
	public static int[] bounds = {-16, 16, -100, -90, -16, 16};
	
	public static int total = 0;
	
	public static String mule_name = "molomolo1"; // need add later
	
	public static int get_total()
	{
		return total;
	}
}
