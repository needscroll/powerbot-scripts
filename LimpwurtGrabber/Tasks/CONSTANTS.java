package needscroll.LimpwurtGrabber.Tasks;

import org.powerbot.script.Area;
import org.powerbot.script.Tile;

public class CONSTANTS {
	
	final static int LADDER = 12389;
	final static int BANKER = 3293;
	final static int KEY = 983;
	final static int[] WEALTH = {20659, 20657, 20655, 20653, 2572};
	final static int GE_BANK = 87989;
	final static int ENTRANCE = 52853;
	final static int DOOR = 1804;
	final static int ROOT = 225;
	
	
	
	final static int dung_door = 52868;
	final static int hill_ladder = 29355;
	final static int well = 87989;
	final static int fortune = 39808;

	final static Tile dungeon_exit_tile = new Tile(1140, 4590, 0);
	final static Tile dungeon1 = new Tile(1140, 4590, 0);
	final static Tile dungeon2 = new Tile(1100, 4560, 0);
	final static Area dungeon_area = new Area(dungeon1, dungeon2);
	
	final static Tile hill_exit = new Tile(3118, 9852, 0);
	final static Tile hill1 = new Tile (3090, 9820, 0);
	final static Tile hill2 = new Tile (3125, 9860, 0);
	final static Area hill_area = new Area(hill1, hill2);
	
	final static Tile overworld1 = new Tile(3107, 3421, 0); // overworld area
	final static Tile overworld2 = new Tile(3200, 3489, 0);
	final static Area overworld = new Area(overworld1, overworld2);
	
	final static Tile entrance = new Tile(3104, 9826, 0); // entrance area
	final static Tile entrance1 = new Tile(3101, 9829, 0);
	final static Tile entrance2 = new Tile(3108, 9824, 0);
	final static Area entrance_area = new Area(entrance1, entrance2);
	
	final static Tile ladder1 = new Tile(3118, 3454, 0); // ladder area
	final static Tile ladder2 = new Tile(3112, 3450, 0);
	final static Area ladder = new Area(ladder1, ladder2);
	
	final static Tile limp = new Tile(1116, 4574, 0); // limpwurt root area
	final static Tile limp1 = new Tile(1102, 4560, 0);
	final static Tile limp2 = new Tile(1140, 4593, 0);
	final static Area limp_area = new Area(limp1, limp2);
	
	final static Tile bank = new Tile(3162, 3465, 0); // ge teleport area
	final static Tile bank_tile = new Tile(3162, 3456, 0);
	final static Tile bank1 = new Tile(3169, 3450, 0);
	final static Tile bank2 = new Tile(3154, 3460, 0);
	final static Area bank_area = new Area(bank1, bank2);
	
	final static Tile house_o = new Tile(3117, 3447, 0);
	final static Tile house_o1 = new Tile(3114, 3449, 0);
	final static Tile house_o2 = new Tile(3120, 3444, 0);
	final static Area house_area_o = new Area(house_o1, house_o2);
	
	final static String dung_exit_interact = "Exit";
	final static String ladder_interact = "Climb-up";
}
