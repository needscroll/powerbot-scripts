package needscroll.StarterPack2;

import javax.swing.JOptionPane;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;

import needscroll.StarterPack2.Tasks.Alch;
import needscroll.StarterPack2.Tasks.AreaItemGatheringTraining;
import needscroll.StarterPack2.Tasks.AreaItemUseTraining;
import needscroll.StarterPack2.Tasks.BankingCombat;
import needscroll.StarterPack2.Tasks.Combat;
import needscroll.StarterPack2.Tasks.Firemaking;
import needscroll.StarterPack2.Tasks.ItemCombineTraining;
import needscroll.StarterPack2.Tasks.Powering;
import needscroll.StarterPack2.Tasks.test;

public class SkillSelector {
	
	public enum skill
	{
		MINING, WOODCUTTING, FISHING, COOKING, CRAFTING, FLETCHING, COMBAT, ALCHING, HERBLORE, THIEVING, SMITHING, AGILITY, FIREMAKING, HUNTER, RUNECRAFTING, PRAYER, CONSTRUCTION, TEST; 
	}
	
	public enum WOODCUTTING
	{
		REGULAR_POWER, OAK_POWER, OAK_VARROCK, WILLOW_POWER, MAPLE_POWER, WILLOW_DRAYNOR, MAPLE_SEER
	}
	
	public enum MINING
	{
		COPPER_POWER, TIN_POWER, IRON_POWER, COAL_POWER, GRANITE_POWER, SANDSTONE_POWER, ESSENCE_POWER;
	}
	
	public enum FISHING
	{
		NET_POWER, BAIT_POWER, LURE_POWER, CAGE_POWER, HARPOON_POWER, NET_DRAYNOR, BAIT_DRAYNOR, HARPOON_CATHERBY, BIGNET_CATHERBY;
	}
	
	public enum COOKING
	{
		AL_KARAID, CATHERBY, WINE;
	}
	
	public enum CRAFTING
	{
		HARDLEATHER_BODY, GLASS_VIALS, GLASS_ORBS;
	}
	
	public enum FLETCHING
	{
		ARROWSHAFT_REGULAR, ARROWSHAFT_OAK, ARROWSHAFT_WILLOW, ARROWSHAFT_MAPLE, ARROWSHAFT_YEW, ARROWSHAFT_MAGIC,
		SHORTBOW_U_REGULAR, SHORTBOW_U_OAK, SHORTBOW_U_WILLOW, SHORTBOW_U_MAPLE, SHORTBOW_U_YEW, SHORTBOW_U_MAGIC,
		LONGBOW_U_REGULAR, LONGBOW_U_OAK, LONGBOW_U_WILLOW, LONGBOW_U_MAPLE, LONGBOW_U_YEW, LONGBOW_U_MAGIC,
		CBOW_U_REGULAR, CBOW_U_OAK, CBOW_U_WILLOW, CBOW_U_MAPLE, CBOW_U_YEW, CBOW_U_MAGIC,
		SHIELD_OAK, SHIELD_WILLOW, SHIELD_MAPLE, SHIELD_YEW, SHIELD_MAGIC,
		JAVLIN_SHAFT
		;
	}
	
	public enum HERBLORE
	{
		GUAM_UNF, MARRENTILL_UNF, TARROMIN_UNF, HARRALANDER_UNF, RANARR_UNF, TOADFLAX_UNF, IRIT_UNF, AVANTOE_UNF,
		KWUARM_UNF, SNAPDRAGON_UNF, CADANTINE_UNF, LANTADYME_UNF, DWARFWEED_UNF,
		
		
		ATTACK_POTION, ANTIPOISON_POTION, STRENGTH_POTION, STAT_RESTORE_POTION, ENERGY_POTOIN, DEFENCE_POTION,
		AGILITY_POTION, COMBAT_POTION, PRAYER_POTOIN, SUPER_ATTACK, SUPER_ANTIPOISON, FISHING_POTION, SUPER_ENERGY,
		HUNTING, SUPER_STRENGTH, WEAPON_POISON, SUPER_RESTORE, SUPER_DEFENCE, ANTIFIRE, RANGING, WEAPON_POISON_PLUS,
		MAGIC_POTION, STAMINA_POTION, ZAMORACK_BREW, BASTION_POTION, BATTLEMAGE_POTION, SARADOMIN_BREW, WEAPON_POISON_PLUS2,
		EXTENDED_ANTIFIRE, ANTI_VENOM, SUPER_COMBAT, SUPER_ANTIFIRE, SUPER_ANTIVENOM, EXTENDED_SUPER_ANTIFIRE,
		GUAM_TAR, MARRENTILL_TAR, TARROMIN_TAR, HARRALANDER_TAR;
	}
	
	public enum COMBAT
	{
		ACTIVE, AREA_PASSIVE, RANGED_MAGED, JAIL_PASSIVE;
	}
	
	public enum SMITHING
	{
		SMITH, SMELT;
	}
	
	public enum FURNACES
	{
		AL_KARAID, FALADORE;
	}
	
	public enum METAL
	{
		BRONZE, IRON, STEEL, MITHRIL, ADAMANT, RUNITE;
	}
	
	public enum BONE
	{
		REGULAR, BIG, DRAGON;
	}
	
	public enum FIREMAKING
	{
		REGULAR, OAK, WILLOW, MAPLE, YEW, MAGIC;
	}
	
	public static Task get_action(ClientContext ctx)
	{
		switch(get_skill())
		{
			case MINING:
				return get_mining(ctx);
			case WOODCUTTING:
				return get_woodcutting(ctx);
			case FISHING:
				return get_fishing(ctx);
			case COOKING:
				return get_cooking(ctx);
			case CRAFTING:
				return get_crafting(ctx);
			case FLETCHING:
				return get_fletching(ctx);
			case COMBAT:
				return get_combat(ctx);
			case ALCHING:
				return new Alch(ctx);
			case THIEVING:
				return null;
			case HERBLORE:
				return get_herblore(ctx);
			case SMITHING:
				return get_smelting(ctx);
			case AGILITY:
				return null;
			case FIREMAKING:
				return get_firemaking(ctx);
			case HUNTER:
				return null;
			case RUNECRAFTING:
				return null;
			case PRAYER:
				return get_prayer(ctx);
			case TEST:
				return new test(ctx);
			default:
				System.out.println("I don't know how you ended up here. Something has gone horribly wrong");
				return null;
		}		
	}

	private static skill get_skill()
	{
		skill act_choice = (skill) JOptionPane.showInputDialog(null, "What do you wish to do?","skill",JOptionPane.PLAIN_MESSAGE, null, skill.values(),skill.values()[0]);
		System.out.println(act_choice);
		return act_choice;
	}
	
	private static Task get_woodcutting(ClientContext ctx) {
		WOODCUTTING tree_choice = (WOODCUTTING) JOptionPane.showInputDialog(null, "What tree do you wish to cut?","regular",JOptionPane.PLAIN_MESSAGE, null, WOODCUTTING.values(),WOODCUTTING.values()[0]);
		int[] logs = {CONSTANTS.logs};
		int[] oak_logs = {CONSTANTS.oak_logs};
		int[] willow_logs = {CONSTANTS.willow_logs};
		int[] maple_logs = {CONSTANTS.maple_logs};
		int[] yew_logs = {CONSTANTS.yew_logs};

		switch(tree_choice)
		{
			case REGULAR_POWER:
				return new Powering(ctx, CONSTANTS.tree, logs, CONSTANTS.tree_interact);
			case OAK_POWER:
				return new Powering(ctx, CONSTANTS.oak_tree, oak_logs, CONSTANTS.tree_interact);
			case OAK_VARROCK:
				TrainingMap varrock_oak_map = new TrainingMap(CONSTANTS.varrock_oaks_w, CONSTANTS.varrock_bank_w, CONSTANTS.varrock_oaks_w_area, CONSTANTS.varrock_bank_w_area);
				return new AreaItemGatheringTraining(ctx, CONSTANTS.oak_tree, oak_logs, CONSTANTS.tree_interact, varrock_oak_map);
			case WILLOW_POWER:
				return new Powering(ctx, CONSTANTS.willow_tree, willow_logs, CONSTANTS.tree_interact);
			case MAPLE_POWER:
				return new Powering(ctx, CONSTANTS.maple_tree, maple_logs, CONSTANTS.tree_interact);
			case WILLOW_DRAYNOR:
				TrainingMap willow_map = new TrainingMap(CONSTANTS.draynor_sea, CONSTANTS.draynor_bank, CONSTANTS.draynor_sea_area, CONSTANTS.draynor_bank_area);
				return new AreaItemGatheringTraining(ctx, CONSTANTS.willow_tree, willow_logs, CONSTANTS.tree_interact, willow_map);
			case MAPLE_SEER:
				TrainingMap maple_map = new TrainingMap(CONSTANTS.seer_village_maple_tree, CONSTANTS.seer_village_bank, CONSTANTS.seer_village_maple_tree_area, CONSTANTS.seer_village_bank_area);
				return new AreaItemGatheringTraining(ctx, CONSTANTS.maple_tree, maple_logs, CONSTANTS.tree_interact, maple_map);
			default:
				System.out.println("I don't know how you ended up here. Something has gone horribly wrong");
				return null;
		}
	}
	
	private static Task get_mining(ClientContext ctx) {
		MINING mining_choice = (MINING) JOptionPane.showInputDialog(null, "What would you like to mine?","regular",JOptionPane.PLAIN_MESSAGE, null, MINING.values(),MINING.values()[0]);
		switch(mining_choice)
		{
			case COPPER_POWER:
				return new Powering(ctx, CONSTANTS.copper_rock, new int[] {CONSTANTS.copper_ore}, CONSTANTS.rock_interact);
			case TIN_POWER:
				return new Powering(ctx, CONSTANTS.tin_rock, new int[] {CONSTANTS.tin_ore}, CONSTANTS.rock_interact);
			case IRON_POWER:
				return new Powering(ctx, CONSTANTS.iron_rock, new int[] {CONSTANTS.iron_ore}, CONSTANTS.rock_interact);
			case COAL_POWER:
				return new Powering(ctx, CONSTANTS.coal_rock, new int[] {CONSTANTS.coal_ore}, CONSTANTS.rock_interact);
			case GRANITE_POWER:
				return null;
			case SANDSTONE_POWER:
				return null;
			case ESSENCE_POWER:
				return null;
			default:
				System.out.println("I don't know how you ended up here. Something has gone horribly wrong");
				return null;
		}
	}
	
	
	private static Task get_fishing(ClientContext ctx) {
		FISHING fishing_choice = (FISHING) JOptionPane.showInputDialog(null, "What would you like to fish?","regular",JOptionPane.PLAIN_MESSAGE, null, FISHING.values(),FISHING.values()[0]);
		TrainingMap map;
		switch(fishing_choice)
		{
			case NET_POWER:
				return new Powering(ctx, CONSTANTS.fishing_spot_net, CONSTANTS.net_fish, CONSTANTS.net_interact);
			case BAIT_POWER:
				return new Powering(ctx, CONSTANTS.fishing_spot_bait, CONSTANTS.bait_fish, CONSTANTS.bait_interact);
			case LURE_POWER:
				return new Powering(ctx, CONSTANTS.fishing_spot_fly, CONSTANTS.fly_fish, CONSTANTS.fly_interact);
			case CAGE_POWER:
				return new Powering(ctx, CONSTANTS.fishing_spot_cage, CONSTANTS.cage_fish, CONSTANTS.cage_interact);
			case HARPOON_POWER:
				return null;
			case NET_DRAYNOR:
				map = new TrainingMap(CONSTANTS.draynor_sea, CONSTANTS.draynor_bank, CONSTANTS.draynor_sea_area, CONSTANTS.draynor_bank_area);
				return new AreaItemGatheringTraining(ctx, CONSTANTS.fishing_spot_net, CONSTANTS.net_fish, CONSTANTS.net_interact, map);
			case BAIT_DRAYNOR:
				map = new TrainingMap(CONSTANTS.draynor_sea, CONSTANTS.draynor_bank, CONSTANTS.draynor_sea_area, CONSTANTS.draynor_bank_area);
				return new AreaItemGatheringTraining(ctx, CONSTANTS.fishing_spot_bait, CONSTANTS.bait_fish, CONSTANTS.bait_interact, map);
			case HARPOON_CATHERBY:
				map = new TrainingMap(CONSTANTS.catherby_fishing_tile, CONSTANTS.catherby_bank_tile, CONSTANTS.catherby_fishing_area, CONSTANTS.catherby_bank_area);
				return new AreaItemGatheringTraining(ctx, CONSTANTS.fishing_spot_harpoon, CONSTANTS.harpoon_fish, CONSTANTS.harpoon_interact, map);
			case BIGNET_CATHERBY:
				map = new TrainingMap(CONSTANTS.catherby_fishing_tile, CONSTANTS.catherby_bank_tile, CONSTANTS.catherby_fishing_area, CONSTANTS.catherby_bank_area);
				return new AreaItemGatheringTraining(ctx, CONSTANTS.fishing_spot_bignet, CONSTANTS.bignet_fish, CONSTANTS.bignet_interact, map);
			default:
				System.out.println("I don't know how you ended up here. Something has gone horribly wrong");
				return null;
		}
	}

	private static Task get_fletching(ClientContext ctx) {
		FLETCHING fletch_choice = (FLETCHING) JOptionPane.showInputDialog(null, "What would you like to fish?","regular",JOptionPane.PLAIN_MESSAGE, null, FLETCHING.values(),FLETCHING.values()[0]);
		int[] items = {CONSTANTS.knife, -1};
		int[] amounts = {1, 27};
		int[] products = CONSTANTS.fletch_products;
		Component component;
		switch(fletch_choice)
		{
		case ARROWSHAFT_REGULAR:
			items[1] = CONSTANTS.logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component1);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
		case ARROWSHAFT_OAK:
			items[1] = CONSTANTS.oak_logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component1);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
		case ARROWSHAFT_WILLOW:
			items[1] = CONSTANTS.willow_logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component1);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
		case ARROWSHAFT_MAPLE:
			items[1] = CONSTANTS.maple_logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component1);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
		case ARROWSHAFT_YEW:
			items[1] = CONSTANTS.yew_logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component1);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
		case ARROWSHAFT_MAGIC:
			items[1] = CONSTANTS.magic_logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component1);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
			
		case SHORTBOW_U_REGULAR:
			items[1] = CONSTANTS.logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component3);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
		case SHORTBOW_U_OAK:
			items[1] = CONSTANTS.oak_logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component2);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
		case SHORTBOW_U_WILLOW:
			items[1] = CONSTANTS.willow_logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component2);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
		case SHORTBOW_U_MAPLE:
			items[1] = CONSTANTS.maple_logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component2);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
		case SHORTBOW_U_YEW:
			items[1] = CONSTANTS.yew_logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component2);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
		case SHORTBOW_U_MAGIC:
			items[1] = CONSTANTS.magic_logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component2);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
			
		case LONGBOW_U_REGULAR:
			items[1] = CONSTANTS.logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component4);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
		case LONGBOW_U_OAK:
			items[1] = CONSTANTS.oak_logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component3);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
		case LONGBOW_U_WILLOW:
			items[1] = CONSTANTS.willow_logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component3);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
		case LONGBOW_U_MAPLE:
			items[1] = CONSTANTS.maple_logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component3);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
		case LONGBOW_U_YEW:
			items[1] = CONSTANTS.yew_logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component3);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
		case LONGBOW_U_MAGIC:
			items[1] = CONSTANTS.magic_logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component3);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
			
		case CBOW_U_REGULAR:
			items[1] = CONSTANTS.logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component5);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
		case CBOW_U_OAK:
			items[1] = CONSTANTS.oak_logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component4);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
		case CBOW_U_WILLOW:
			items[1] = CONSTANTS.willow_logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component4);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
		case CBOW_U_MAPLE:
			items[1] = CONSTANTS.maple_logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component4);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
		case CBOW_U_YEW:
			items[1] = CONSTANTS.yew_logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component4);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
		case CBOW_U_MAGIC:
			items[1] = CONSTANTS.magic_logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component4);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
			
		case SHIELD_OAK:
			items[1] = CONSTANTS.oak_logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component5);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
		case SHIELD_WILLOW:
			items[1] = CONSTANTS.willow_logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component5);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
		case SHIELD_MAPLE:
			items[1] = CONSTANTS.maple_logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component5);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
		case SHIELD_YEW:
			items[1] = CONSTANTS.yew_logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component5);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
		case SHIELD_MAGIC:
			items[1] = CONSTANTS.magic_logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component5);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
			
			
			
		case JAVLIN_SHAFT:
			items[1] = CONSTANTS.logs;
			component = ctx.widgets.widget(CONSTANTS.fletching_widget).component(CONSTANTS.fletching_component2);
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);

		default:
			System.out.println("I don't know how you ended up here. Something has gone horribly wrong");
			return null;
		}
	}

	private static Task get_crafting(ClientContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private static Task get_herblore(ClientContext ctx) {
		HERBLORE herblore_choice = (HERBLORE) JOptionPane.showInputDialog(null, "What tree do you wish to do?","regular",JOptionPane.PLAIN_MESSAGE, null, HERBLORE.values(),HERBLORE.values()[0]);
		int[] items = {-1, -1};
		int[] amounts = {14, 14};
		int[] products = {-1};
		Component component = ctx.widgets.widget(CONSTANTS.cooking_widget).component(CONSTANTS.cooking_component1);
		switch(herblore_choice)
		{
		case GUAM_UNF:
			items[0] = CONSTANTS.vial_of_water;
			items[1] = CONSTANTS.guam_c;
			products[0] = CONSTANTS.guam_unf;
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
		
		case ATTACK_POTION:
			items[0] = CONSTANTS.guam_unf;
			items[1] = CONSTANTS.eye_of_newt;
			products[0] = CONSTANTS.attack_potion_3;
			return new ItemCombineTraining(ctx, items, amounts, products, CONSTANTS.use_interact, component);
		default:
			System.out.println("I don't know how you ended up here. Something has gone horribly wrong");
			return null;
		}
	}

	private static Task get_cooking(ClientContext ctx) {
		COOKING cooking_choice = (COOKING) JOptionPane.showInputDialog(null, "What tree do you wish to do?","regular",JOptionPane.PLAIN_MESSAGE, null, COOKING.values(),COOKING.values()[0]);
		String foodn;
		int[] food;
		int[] amount;
		TrainingMap map;
		Component cooking_component = ctx.widgets.widget(CONSTANTS.cooking_widget).component(CONSTANTS.cooking_component1);
		switch(cooking_choice)
		{
		case AL_KARAID:
			foodn = JOptionPane.showInputDialog("Please enter the id of the item you wish to cook");
			food = new int[]{Integer.parseInt(foodn)};
			amount = new int[]{28};
			map = new TrainingMap(CONSTANTS.karaid_cooking, CONSTANTS.karaid_bank, CONSTANTS.karaid_cooking_area, CONSTANTS.karaid_bank_area);
			Obstacle obstacle = new Obstacle(CONSTANTS.karaid_door_c, CONSTANTS.karaid_door_tile, CONSTANTS.door_interact, CONSTANTS.karaid_door_bounds);
			return new AreaItemUseTraining(ctx, food, amount, CONSTANTS.range, CONSTANTS.range_interact, CONSTANTS.range_bounds, obstacle, map, cooking_component);
		case CATHERBY:
			foodn = JOptionPane.showInputDialog("Please enter the id of the item you wish to cook");
			food = new int[]{Integer.parseInt(foodn)};
			amount = new int[] {28};
			map = new TrainingMap(CONSTANTS.catherby_range_tile, CONSTANTS.catherby_bank_tile, CONSTANTS.catherby_range_area, CONSTANTS.catherby_bank_area);
			return new AreaItemUseTraining(ctx, food, amount, CONSTANTS.range, CONSTANTS.range_interact, CONSTANTS.default_bounds, null, map, cooking_component);
		case WINE:
			int[] wine_materials = {CONSTANTS.grapes, CONSTANTS.jug_of_water};
			int[] wine_amounts = {14, 14};
			int[] wine_products = CONSTANTS.wines;
			return new ItemCombineTraining(ctx, wine_materials, wine_amounts, wine_products, CONSTANTS.use_interact, cooking_component);
		default:
			System.out.println("I don't know how you ended up here. Something has gone horribly wrong");
			return null;
		}
	}

	private static Task get_firemaking(ClientContext ctx) {
		FIREMAKING firemaking_choice = (FIREMAKING) JOptionPane.showInputDialog(null, "What do you wish to do?","skill",JOptionPane.PLAIN_MESSAGE, null, FIREMAKING.values(),FIREMAKING.values()[0]);
		int[] amounts = {1, 27};
		TrainingMap map = new TrainingMap(CONSTANTS.varrock_w_fm_start1, CONSTANTS.varrock_bank_w, CONSTANTS.varrock_w_fm_training_area, CONSTANTS.varrock_bank_w_area);
		switch(firemaking_choice)
		{
		case REGULAR:
			int[] regular_supplies = {CONSTANTS.tinderbox, CONSTANTS.logs};
			return new Firemaking(ctx, regular_supplies, amounts, CONSTANTS.use_interact, map, CONSTANTS.varrock_w_fm_start_area);
		case OAK:
			int[] oak_supplies = {CONSTANTS.tinderbox, CONSTANTS.oak_logs};
			return new Firemaking(ctx, oak_supplies, amounts, CONSTANTS.use_interact, map, CONSTANTS.varrock_w_fm_start_area);
		case WILLOW:
			int[] willow_supplies = {CONSTANTS.tinderbox, CONSTANTS.willow_logs};
			return new Firemaking(ctx, willow_supplies, amounts, CONSTANTS.use_interact, map, CONSTANTS.varrock_w_fm_start_area);
		case MAPLE:
			int[] maple_supplies = {CONSTANTS.tinderbox, CONSTANTS.maple_logs};
			return new Firemaking(ctx, maple_supplies, amounts, CONSTANTS.use_interact, map, CONSTANTS.varrock_w_fm_start_area);
		case YEW:
			int[] yew_supplies = {CONSTANTS.tinderbox, CONSTANTS.yew_logs};
			return new Firemaking(ctx, yew_supplies, amounts, CONSTANTS.use_interact, map, CONSTANTS.varrock_w_fm_start_area);
		case MAGIC:
			int[] magic_supplies = {CONSTANTS.tinderbox, CONSTANTS.magic_logs};
			return new Firemaking(ctx, magic_supplies, amounts, CONSTANTS.use_interact, map, CONSTANTS.varrock_w_fm_start_area);
		}
		return null;
	}

	private static Task get_combat(ClientContext ctx) {
		COMBAT combat_choice = (COMBAT) JOptionPane.showInputDialog(null, "What tree do you wish to do?","regular",JOptionPane.PLAIN_MESSAGE, null, COMBAT.values(),COMBAT.values()[0]);
		
		switch(combat_choice)
		{
		case ACTIVE:
			String name = JOptionPane.showInputDialog("Please enter the name of the mob to kill");
			return new Combat(ctx, name, CONSTANTS.combat_interact);
		case JAIL_PASSIVE:
			String foodn = JOptionPane.showInputDialog("Please enter the id of the food item");
			int[] food = {Integer.parseInt(foodn)};
			int[] amount = {28};
			CombatMap map = new CombatMap(CONSTANTS.draynor_jail_combat_tile, CONSTANTS.draynor_bank, CONSTANTS.draynor_jail_reset_tile,
					CONSTANTS.draynor_jail_combat_area, CONSTANTS.draynor_bank_area, CONSTANTS.draynor_jail_reset_area);
			return new BankingCombat(ctx, food, amount, map);
		default:
			System.out.println("I don't know how you ended up here. Something has gone horribly wrong");
			return null;
		}

	}
	
	private static Task get_smithing(ClientContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Task get_smelting(ClientContext ctx) {
		METAL metal_choice = (METAL) JOptionPane.showInputDialog(null, "What metal?","regular",JOptionPane.PLAIN_MESSAGE, null, METAL.values(),METAL.values()[0]);
		Component component;
		TrainingMap map;
		Obstacle obstacle;
		switch (metal_choice)
		{
			case BRONZE:
				int[] bronze_ores = {CONSTANTS.copper_ore, CONSTANTS.tin_ore};
				int[] bronze_amounts = {14, 14};
				component = ctx.widgets.widget(CONSTANTS.smelting_widget).component(CONSTANTS.smelting_bronze_component1);
				map = new TrainingMap(CONSTANTS.karaid_furnace, CONSTANTS.karaid_bank, CONSTANTS.karaid_furnace_area, CONSTANTS.karaid_bank_area);
				obstacle = new Obstacle(CONSTANTS.karad_furnace_door_c, CONSTANTS.karaid_furnace_door_tile, CONSTANTS.door_interact, CONSTANTS.karaid_furnace_door_bounds);
				return new AreaItemUseTraining(ctx, bronze_ores, bronze_amounts, CONSTANTS.furnace, CONSTANTS.furnace_interact, obstacle, map, component);
			case IRON:
				int[] iron_ores = {CONSTANTS.iron_ore};
				int[] iron_amounts = {28};
				component = ctx.widgets.widget(CONSTANTS.smelting_widget).component(CONSTANTS.smelting_iron_component1);
				map = new TrainingMap(CONSTANTS.karaid_furnace, CONSTANTS.karaid_bank, CONSTANTS.karaid_furnace_area, CONSTANTS.karaid_bank_area);
				obstacle = new Obstacle(CONSTANTS.karad_furnace_door_c, CONSTANTS.karaid_furnace_door_tile, CONSTANTS.door_interact, CONSTANTS.karaid_furnace_door_bounds);
				return new AreaItemUseTraining(ctx, iron_ores, iron_amounts, CONSTANTS.furnace, CONSTANTS.furnace_interact, obstacle, map, component);
			case STEEL:
				int[] steel_ores = {CONSTANTS.iron_ore, CONSTANTS.coal_ore};
				int[] steel_amounts = {9, 18};
				component = ctx.widgets.widget(CONSTANTS.smelting_widget).component(CONSTANTS.smelting_steel_component1);
				map = new TrainingMap(CONSTANTS.karaid_furnace, CONSTANTS.karaid_bank, CONSTANTS.karaid_furnace_area, CONSTANTS.karaid_bank_area);
				obstacle = new Obstacle(CONSTANTS.karad_furnace_door_c, CONSTANTS.karaid_furnace_door_tile, CONSTANTS.door_interact, CONSTANTS.karaid_furnace_door_bounds);
				return new AreaItemUseTraining(ctx, steel_ores, steel_amounts, CONSTANTS.furnace, CONSTANTS.furnace_interact, obstacle, map, component);
			case MITHRIL:
				return null;
			case ADAMANT:
				return null;
			case RUNITE:
				return null;
			default:
				System.out.println("I don't know how you ended up here. Something has gone horribly wrong");
				return null;
		}
	}
	

	private static Task get_prayer(ClientContext ctx) {
		BONE bone_choice = (BONE) JOptionPane.showInputDialog(null, "What bone?","regular",JOptionPane.PLAIN_MESSAGE, null, BONE.values(),BONE.values()[0]);
		switch(bone_choice)
		{
		case REGULAR:
			int[] regular_bones = {CONSTANTS.bones};
			int[] regular_bones_amount = {28};
			int[] bone_products = {0};
			Component fails_intentionally = ctx.widgets.widget(0).component(0);
			return new ItemCombineTraining(ctx, regular_bones, regular_bones_amount, bone_products, CONSTANTS.bone_interact, fails_intentionally);
		case BIG:
			return null;
		case DRAGON:
			return null;
		}
		return null;
	}

}
