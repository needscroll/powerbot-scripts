package needscroll.BeerGrabber.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Tile;

public class CONSTANTS {
	
	public static int beer = 1917;
	public static int bones = 526;
	public static int coins = 995;
	public static int cooked_meat = 2142;
	public static int tin_ore = 438;
	public static int bear_fur = 948;
	public static int iron_axe = 3149;
	
	public static int bronze_arrows = 882;
	public static int iron_arrows = 884;
	public static int steel_arrows = 886;
	public static int mithril_arrows = 888;
	public static int adamant_arrows = 890;
	
	public static int[] items = {890, 888, 886, 1917, 526, 995, 2142, 438, 948, 3149, 882, 884};
	public static int[] noted_items = {995, 890, 888, 886, 882, 884, 1918, 527, 2143, 1350, 949};
	
	public static int beer_noted = 1918;
	public static int bones_noted = 527;
	public static int cooked_meat_noted = 2143;
	public static int iron_axe_noted = 1350;
	
	public static Tile hall = new Tile(3079, 3437, 0);
	public static Tile hall1 = new Tile(3074, 3435, 0);
	public static Tile hall2 = new Tile(3083, 3446, 0);
	public static Area hall_area = new Area(hall1, hall2);
	
	public static Tile village1 = new Tile(0, 0, 0);
	public static Tile village2 = new Tile(0, 0, 0);
	public static Area village_area = new Area(village1, village2);
	
	public static Tile outside1 = new Tile(0, 0, 0);
	public static Tile outside2 = new Tile(0, 0, 0);
	public static Area outside_area = new Area(outside1, outside2);
	
	public static Tile bank = new Tile(3093, 3493, 0);
	public static Tile bank1 = new Tile(3091, 3487, 0);
	public static Tile bank2 = new Tile(3099, 3496, 0);
	public static Area bank_area = new Area(bank1, bank2);

	public static int door_c = 11620;
	public static int bank_booth = 6943;
	
	public static String door_c_interact = "Open";
	public static String take_interact = "Take";
	public static String banker_interact = "Bank";
	public static String mule_interact = "Trade with";
	public static String item_interact = "Offer-All"; // might need change
	
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
	
	public static String accepted_text = "Other player has accepted";
	
	public static String mule_name = "fm";
	
	public static int[] bounds = {-16, 16, -100, -130, -16, 16};
	public static int amount_grabbed = 0;
}
