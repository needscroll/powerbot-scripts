package needscroll.RopeGrabber.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Tile;

public class CONSTANT {
	
	public static int COINS = 995;
	public static int DOOR_C = 1535;
	public static int DOOR_O = 1536;
	public static int NED_NPC = 4280;
	public static int BANK_BOOTH = 6943;
	public static int ROPE = 954;
	
	public static Tile NED_TILE = new Tile(3099, 3258, 0);
	public static Tile BANK_TILE = new Tile(3092, 3245, 0);
	
	private static Tile draynor1 = new Tile(3082, 3232, 0);
	private static Tile draynor2 = new Tile(3113, 3272, 0);
	public static Area DRAYNOR_AREA = new Area(draynor1, draynor2);
	
	private static Tile ned1 = new Tile(3096, 3261, 0);
	private static Tile ned2 = new Tile(3102, 3256, 0);
	public static Area NED_HOUSE = new Area(ned1, ned2);
	
	final public static int[] DOOR_BOUNDS = {132, 112, -240, 0, 8, 116};
}
