package needscroll.SpadeGrabber.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Tile;

public class CONSTANTS {
	
	public static int spade_object = 31585;
	public static int gangplank = 31756;
	public static int bank_deposit = 26254;
	public static int bank_booth = 24101;
	
	public static int captain_tock = 1;
	public static int captain_tock_ship = 7958;
	
	public static Tile spade_tile = new Tile(2552, 2846, 0);
	public static Tile spade1 = new Tile(2549, 2848, 0);
	public static Tile spade2 = new Tile(2554, 2843, 0);
	public static Area spade_area = new Area(spade1, spade2);
	
	public static int[] trading_items = {952};
	public static int[] noted_items = {953};
	
	public static Tile bank_deposit_tile = new Tile(3045, 3235, 0);
	public static Tile bank_deposit1 = new Tile(3042, 3237, 0);
	public static Tile bank_deposit2 = new Tile(3048, 3233, 0);
	public static Area bank_deposit_area = new Area(bank_deposit1, bank_deposit2);
	
	public static Tile sarim_gangplank_tile = new Tile(3055, 3245, 0);
	public static Tile sarim_gangplank1 = new Tile(3060, 3240, 0);
	public static Tile sarim_gangplank2 = new Tile(3051, 3248, 0);
	public static Area sarim_gangplank_area = new Area(sarim_gangplank1, sarim_gangplank2);
	
	public static Tile island_gangplank_tile = new Tile(2578, 2840, 0);
	public static Tile island_gangplank1 = new Tile(0, 0, 0);
	public static Tile island_gangplank2 = new Tile(0, 0, 0);
	public static Area island_gangplank_area = new Area(island_gangplank1, island_gangplank2);
	
	public static Tile sarim_ship1 = new Tile(2050, 3243, 1);
	public static Tile sarim_ship2 = new Tile(3060, 3240, 1);
	public static Area sarim_ship_area = new Area(sarim_ship1, sarim_ship2);
	
	public static Tile island_ship1 = new Tile(2573, 2839, 1);
	public static Tile island_ship2 = new Tile(2583, 2834, 1);
	public static Area island_ship_area = new Area(island_ship1, island_ship2);
	
	public static Tile island1 = new Tile(2590, 2830, 0);
	public static Tile island2 = new Tile(2543, 2857, 0);
	public static Area island_area = new Area(island1, island2);
	
	public static Tile sarim1 = new Tile(3259, 3554, 0);
	public static Tile sarim2 = new Tile(3000, 3120, 0);
	public static Area sarim_area = new Area(sarim1, sarim2); // extended north and east by 100 - 200 blocks
	
	public static Tile fally_bank = new Tile(3013, 3357, 0);
	public static Tile fally_bank1 = new Tile(3019, 3354, 0);
	public static Tile fally_bank2 = new Tile(3010, 3358, 0);
	public static Area fally_bank_area = new Area(fally_bank1, fally_bank2);
	
	
	public static int deposit_widget = 192;
	public static int deposit_component = 3;
	
	public static int exit_widget = 192;
	public static int exit_component1 = 1;
	public static int exit_component2 = 11;
	
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
	
	
	
	
	public static String spade_interact = "Take";
	public static String gangplank_interact = "Cross";
	public static String bank_deposit_interact = "Deposit";
	public static String captain_tock_interact1 = "Talk-to";
	public static String captain_tock_interact2 = "Travel";
	public static String bank_booth_interact = "Bank";
	public static String mule_interact = "Trade";
	public static String offer_all_interact = "Offer-All";
	
	public static int[] bounds = {-64, -48, -116, 0, -56, -32};
	
	public static String mule_name = "molomolo1"; // need add later
}
