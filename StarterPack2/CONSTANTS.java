package needscroll.StarterPack2;

import org.powerbot.script.Area;
import org.powerbot.script.Tile;

public class CONSTANTS {
	
	/*
	public static String selected_skill = "";
	public static int[] selected_object = {0};
	public static int[] selected_products = {0};
	public static int selected_product = 0;
	public static String selected_interact = "";
	public static String selected_name = "";
	public static Tile selected_skill_tile;
	public static Tile selected_bank_tile;
	//public static int[] selected_bank_object = {0};
	public static Area selected_skill_area;
	public static Area selected_bank_area;
	public static int[] selected_obstacles = {0};
	public static String selected_obstacle_interact = "";
	public static int selected_widget = -1;
	public static int selected_component1 = -1;
	public static int selected_component2 = -1;
	public static int idle_duration = 1;
	public static int idle_times = 1;
	
	public static int selected_item1 = 0;
	public static int selected_item2 = 0;
	public static int item1_amount = 0;
	public static int item2_amount = 0;
	*/
	
	public static int tree[] = {1276, 1278, 1282, 1289};
	public static int logs = 1511;
	public static int oak_tree[] = {1751};
	public static int oak_logs = 1521;
	public static int willow_tree[] = {1750, 1758, 1756};
	public static int willow_logs = 1519;
	public static int maple_tree[] = {1759};
	public static int maple_logs = 1517;
	public static int yew_logs = 1515;
	public static int magic_logs = 1;
	
	public static int tinderbox = 590;
	public static int fire = 26185;
	
	public static int[] tin_rock = {10080, 7486, 7485};
	public static int tin_ore = 438;
	public static int[] copper_rock = {10079, 7453, 7484};
	public static int copper_ore = 436;
	public static int[] iron_rock = {7488, 7455};
	public static int iron_ore = 440;
	public static int[] coal_rock = {7456, 7489};
	public static int coal_ore = 453;
	
	public static int[] fishing_spot_net = {1530, 1523, 1526, 1525};
	public static int[] net_fish = {317, 321};
	public static int[] fishing_spot_fly = {1526, 1513};
	public static int[] fly_fish = {335, 331};
	public static int[] fishing_spot_bait = {1523, 1526, 1525, 1530, 1513};
	public static int[] bait_fish = {327, 345, 349};
	public static int[] fishing_spot_cage = {1521, 1522};
	public static int[] cage_fish = {377};
	public static int[] fishing_spot_harpoon = {1519};
	public static int[] harpoon_fish = {359, 371};
	public static int[] fishing_spot_bignet = {1520};
	public static int[] bignet_fish = {353, 363, 1061, 1059, 341, 407, 401, 405};
	
	public static int range = 26181;
	public static int karaid_door_c = 1535;
	public static Tile karaid_door_tile = new Tile(3275, 3180, 0);
		
	public static int grapes = 1987;
	public static int jug_of_water = 1937;
	public static int unfermented_wine = 1995;
	public static int bad_wine = 1991;
	public static int wine = 1993;
	public static int[] wines = {1995, 1993, 1991};
	
	public static int hardleather = 1743;
	public static int needle = 1733;
	public static int[] hardleather_body = {1131};
	
	public static int knife = 946;
	public static int arrow_shaft = 52;
	public static int shortbow_u = 50; 
	public static int longbow_u = 48;
	public static int[] fletch_products = {52, 48, 56, 58, 62, 50, 54, 60, 64, 66, 68};
	
	public static int vial_of_water = 227;
	
	public static int guam_g = 199;
	public static int guam_c = 249;
	
	public static int guam_unf = 91;
	public static int eye_of_newt = 221;
	public static int attack_potion_3 = 121;
	
	public static int molten_glass = 1775;
	public static int glass_blow_pipe = 1785;
	public static int uncharged_orb = 567;
	public static int vial = 229;
	
	public static int anvil = 1;
	public static int bronze_bar = 1;
	public static int iron_bar = 1;
	public static int steel_bar = 1;
	public static int mithril_bar = 1;
	public static int adamant_bar = 1;
	public static int rune_bar = 1;
	
	public static int furnace = 24009;
	public static int karad_furnace_door_c = 1535;
	public static Tile karaid_furnace_door_tile = new Tile(3280, 3185, 0);
	
	public static int nature_rune = 561;
	public static int x1 = 746;
	public static int y1 = 383;
	public static int x2 = 754;
	public static int y2 = 393;
	
	public static int bones = 526;
	
	public static int cooking_widget = 270;
	public static int cooking_component1 = 14;
	public static int cooking_component2 = 29;
	
	public static int smelting_widget = 270;
	public static int smelting_bronze_component1 = 14;
	public static int smelting_iron_component1 = 15;
	public static int smelting_bluritecomponent1 = 16;
	public static int smelting_steel_component1 = 17;
	public static int smelting_gold_component1 = 18;
	public static int smelting_mithril_component1 = 19;
	public static int smelting_adamant_component1 = 20;
	public static int smelting_runite_component1 = 21;

	
	//components start at 14 and goes to 18 from left to right
	public static int fletching_widget = 270;
	public static int fletching_component1 = 14;
	public static int fletching_component2 = 15;
	public static int fletching_component3 = 16;
	public static int fletching_component4 = 17;
	public static int fletching_component5 = 18;
	
	//components start at 14 and goes to 21 from left to right
	public static int glass_blowing_widget = 270;
	public static int glass_blowing_orb_component1 = 14;
	public static int glass_blowing_orb_component2 = 15;
	public static int glass_blowing_orb_component3 = 16;
	public static int glass_blowing_orb_component4 = 17;
	public static int glass_blowing_orb_component5 = 18;
	public static int glass_blowing_orb_component6 = 19;
	public static int glass_blowing_orb_component7 = 20;
	public static int glass_blowing_orb_component8 = 21;
	
	public static Tile varrock_bank_w = new Tile(3183, 3437, 0);
	public static Tile varrock_bank_w1 = new Tile(3180, 3433, 0);
	public static Tile varrock_bank_w2 = new Tile(3186, 3447, 0);
	public static Area varrock_bank_w_area = new Area(varrock_bank_w1, varrock_bank_w2);
	
	public static Tile varrock_oaks_w = new Tile(3167, 3417, 0);
	public static Tile varrock_oaks_w1 = new Tile(3171, 3424, 0);
	public static Tile varrock_oaks_w2 = new Tile(3158, 3410, 0);
	public static Area varrock_oaks_w_area = new Area(varrock_oaks_w1, varrock_oaks_w2);
	
	public static Tile draynor_bank = new Tile(3092, 3244, 0);
	public static Tile draynor_bank1 = new Tile(3090, 3246, 0);
	public static Tile draynor_bank2 = new Tile(3095, 3241, 0);
	public static Area draynor_bank_area = new Area(draynor_bank1, draynor_bank2);

	public static Tile draynor_sea = new Tile(3085, 3233, 0);
	public static Tile draynor_sea1 = new Tile(3083, 3239, 0);
	public static Tile draynor_sea2 = new Tile(3090, 3225, 0);
	public static Area draynor_sea_area = new Area(draynor_sea1, draynor_sea2);
	
	public static Tile karaid_bank = new Tile(3270, 3167, 0);
	public static Tile karaid_bank1 = new Tile(3266, 3172, 0);
	public static Tile karaid_bank2 = new Tile(3272, 3163, 0);
	public static Area karaid_bank_area = new Area(karaid_bank1, karaid_bank2);
	
	public static Tile karaid_cooking = new Tile(3274, 3180, 0);
	public static Tile karaid_cooking1 = new Tile(3271, 3183, 0);
	public static Tile karaid_cooking2 = new Tile(3275, 3179, 0);
	public static Area karaid_cooking_area = new Area(karaid_cooking1, karaid_cooking2);
	
	public static Tile karaid_furnace = new Tile(3276, 3186, 0);
	public static Tile karaid_furnace1 = new Tile(3279, 3184, 0);
	public static Tile karaid_furnace2 = new Tile(3272, 3188, 0);
	public static Area karaid_furnace_area = new Area(karaid_furnace1, karaid_furnace2);
	
	public static Tile seer_village_bank = new Tile(2725, 3492, 0);
	public static Tile seer_village_bank1 = new Tile(2722, 3490, 0);
	public static Tile seer_village_bank2 = new Tile(2730, 3494, 0);
	public static Area seer_village_bank_area = new Area(seer_village_bank1, seer_village_bank2);
	
	public static Tile seer_village_maple_tree = new Tile(2725, 3501, 0);
	public static Tile seer_village_maple_tree1 = new Tile(2718, 3498, 0);
	public static Tile seer_village_maple_tree2 = new Tile(2734, 3503, 0);
	public static Area seer_village_maple_tree_area = new Area(seer_village_maple_tree1, seer_village_maple_tree2);
	
	public static Tile varrock_w_fm_start1 = new Tile(3182, 3432, 0);
	public static Tile varrock_w_fm_start2 = new Tile(3183,3427, 0);
	public static Area varrock_w_fm_start_area = new Area(varrock_w_fm_start1, varrock_w_fm_start2);
	
	public static Tile varrock_w_fm_training1 = new Tile(3185, 3432, 0);
	public static Tile varrock_w_fm_training2 = new Tile(3164, 3426, 0);
	public static Area varrock_w_fm_training_area = new Area(varrock_w_fm_training1, varrock_w_fm_training2);
	
	public static Tile draynor_jail_combat_tile = new Tile(3121, 3239, 0);
	public static Tile draynor_jail_combat_tile1 = new Tile(3119, 3240, 0);
	public static Tile draynor_jail_combat_tile2 = new Tile(3125, 3236, 0);
	public static Area draynor_jail_combat_area = new Area(draynor_jail_combat_tile1, draynor_jail_combat_tile2);
	
	public static Tile draynor_jail_reset_tile = new Tile(3141, 3203, 0);
	public static Tile draynor_jail_reset_tile1 = new Tile(3138, 3200, 0);
	public static Tile draynor_jail_reset_tile2 = new Tile(3144, 3207, 0);
	public static Area draynor_jail_reset_area = new Area(draynor_jail_reset_tile1, draynor_jail_reset_tile2);

	public static Tile catherby_fishing_tile = new Tile(2853, 3424, 0);
	public static Tile catherby_fishing_tile1 = new Tile(2835, 3434, 0);
	public static Tile catherby_fishing_tile2 = new Tile(2864, 3423, 0);
	public static Area catherby_fishing_area = new Area(catherby_fishing_tile1, catherby_fishing_tile2);
	
	public static Tile catherby_range_tile = new Tile(2816, 3442, 0);
	public static Tile catherby_range_tile1 = new Tile(2814, 3445, 0);
	public static Tile catherby_range_tile2 = new Tile(2819, 3439, 0);
	public static Area catherby_range_area = new Area(catherby_range_tile1, catherby_range_tile2);
	
	public static Tile catherby_bank_tile = new Tile(2809, 3440, 0);
	public static Tile catherby_bank_tile1 = new Tile(2813, 3442, 0);
	public static Tile catherby_bank_tile2 = new Tile(2806, 3437, 0);
	public static Area catherby_bank_area = new Area(catherby_bank_tile1, catherby_bank_tile2);
	
	
	
	
	public static String tree_interact = "Chop";
	public static String drop_interact = "Drop";
	public static String rock_interact = "Mine";
	public static String net_interact = "Net";
	public static String bait_interact = "Bait";
	public static String fly_interact = "Lure";
	public static String combat_interact = "Attack";
	public static String food_interact = "Eat";
	public static String use_interact = "Use";
	public static String door_interact = "Open";
	public static String cage_interact = "Cage";
	public static String furnace_interact = "Smelt";
	public static String range_interact = "Cook";
	public static String bone_interact = "Bury";
	public static String harpoon_interact = "Harpoon";
	public static String bignet_interact = "Big Net";
	
	public static int[] range_bounds = {-32, 32, -100, -48, 44, 108};
	public static int[] karaid_door_bounds = {132, 116, -236, 0, 124, 0};
	public static int[] karaid_furnace_door_bounds = {-4, 12, -236, 0, 124, 0};
	public static int[] default_bounds = {-32, 32, -64, 0, -32, 32};
	
	
	/*
	public static int failures = 0;
	
	public static void set_id(String skill, int[] object, String interact, int[] products)
	{
		CONSTANTS.selected_skill = skill;
		CONSTANTS.selected_object = object;
		CONSTANTS.selected_interact = interact;
		CONSTANTS.selected_products = products;
	}
	
	public static void set_id(String skill, String interact)
	{
		CONSTANTS.selected_skill = skill;
		CONSTANTS.selected_interact = interact;
	}
	
	public static void set_item(int item1)
	{
		CONSTANTS.selected_item1 = item1;
	}
	
	public static void set_item(int item1, int item2)
	{
		CONSTANTS.selected_item1 = item1;
		CONSTANTS.selected_item2 = item2;
	}
	
	public static void set_products(int[] products)
	{
		CONSTANTS.selected_products = products;
	}
	
	public static void set_products(int item)
	{
		CONSTANTS.selected_products[0] = item;
	}
	
	public static void set_amounts(int amount1, int amount2)
	{
		CONSTANTS.item1_amount = amount1;
		CONSTANTS.item2_amount = amount2;
	}
	
	public static void set_area(Tile skill, Tile bank, Area skilling, Area banking)
	{
		CONSTANTS.selected_skill_tile = skill;
		CONSTANTS.selected_bank_tile = bank;
		CONSTANTS.selected_skill_area = skilling;
		CONSTANTS.selected_bank_area = banking;
	}
	
	public static void set_obstacles(int[] obstacles, String obstacle_interact)
	{
		CONSTANTS.selected_obstacles = obstacles;
		CONSTANTS.selected_obstacle_interact = obstacle_interact;
	}
	
	public static void set_component(int widget, int component1)
	{
		CONSTANTS.selected_widget = widget;
		CONSTANTS.selected_component1 = component1;
	}
	
	public static void set_component(int widget, int component1, int component2)
	{
		CONSTANTS.selected_widget = widget;
		CONSTANTS.selected_component1 = component1;
		CONSTANTS.selected_component2 = component2;
	}
	
	public static void set_idle(int times, int duration)
	{
		CONSTANTS.idle_times = times;
		CONSTANTS.idle_duration = duration;
	}*/

}
