package needscroll.PotatoGrabber.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Tile;

public class CONSTANTS {
	
	public static int potato_plant = 312;
	public static int potato = 1;
	public static int gate_c = 1560;
	
	public static Tile gate_o_tile = new Tile(3145, 3293, 0);
	public static Tile gate_i_tile = new Tile(3146, 3291, 0);
	
	public static Tile potato_tile = new Tile(3145, 3286, 0);
	public static Tile potato_tile1 = new Tile(3140, 3291, 0);
	public static Tile potato_tile2 = new Tile(3153, 3271, 0);
	public static Area potato_area = new Area(potato_tile1, potato_tile2);
	
	public static Tile draynor_bank = new Tile(3092, 3244, 0);
	public static Tile draynor_bank1 = new Tile(3090, 3246, 0);
	public static Tile draynor_bank2 = new Tile(3095, 3241, 0);
	public static Area draynor_bank_area = new Area(draynor_bank1, draynor_bank2);
	
	public static Tile gate_tile1 = new Tile(3143, 3296, 0);
	public static Tile gate_tile2 = new Tile(3148, 3291, 0);
	public static Area gate_area = new Area(gate_tile1, gate_tile2);
	
	public static String pick_interact = "Pick";
	public static String gate_interact = "Open";
	
	public static int amount = 0;
	
	public static int[] gate_bounds = {-72, 96, -96, 0, 152, 112};

}
