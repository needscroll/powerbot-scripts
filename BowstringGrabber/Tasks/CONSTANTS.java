package needscroll.BowstringGrabber.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Tile;

public class CONSTANTS {
	
	public static int flax_id = 1779;
	public static int wheel_id = 14889;
	public static int bank_booth = 18491;
	public static int door_c_id = 1543;
	public static int bowstring = 1777;
	
	public static int stair2_id = 16673;
	public static int stair1_id = 16672;
	public static int stair0_id = 16671;
	
	public static String wheen_interact = "Spin";
	public static String make_interact = "Spin-All";
	public static String stair_interact_up = "Climb-up";
	public static String stair_interact_down = "Climb-down";
	public static String bank_interact = "Bank";
	public static String door_interact = "Open";
	
	public static Tile wheel = new Tile(3209, 3213, 1);
	public static Tile wheel1 = new Tile(3208, 3216, 1);
	public static Tile wheel2 = new Tile(3212, 3212, 1);
	public static Area wheel_area = new Area(wheel1, wheel2);
	
	public static Tile bank = new Tile(3209, 3220, 2);
	public static Tile bank1 = new Tile(3207, 3222, 2);
	public static Tile bank2 = new Tile(3210, 3216, 2);
	public static Area bank_area = new Area(bank1, bank2);
	
	public static int spinning_widget = 270;
	public static int spinning_component1 = 16;
	public static int spinning_component2 = 29;
	
	public static int bank_widget = 12;
	public static int bank_component1 = 12;
	public static int bank_component2 = 0;
	
	public static int spinning_animation = 894;
	
	public static int fails = 0;
	
	public static int[] bounds = {148, 116, -200, 0, 108, 8};
}
