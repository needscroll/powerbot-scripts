package needscroll.TutorialIsland.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Game.Tab;

public class Island3 extends Action{
	
	public static int state = 0;
	
	public Island3(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		return on_island();
	}
	
	@Override
	public void execute() {
		//state = det_progress();
		state = 0;
		System.out.println(what_do());
		System.out.println("state: " + state);

			create_char();

			talk_guide();

			talk_survival();

			talk_cook();

			go_quest();

			talk_quest();

			talk_mining();

			talk_combat();

			talk_bank();

			talk_monk();

			talk_mage();
	}
	
	private void talk_mage() {
		if (what_do().contains(CONSTANTS.guide_text54))
		{
			step_use_npc(CONSTANTS.mage_tile, CONSTANTS.mage_instructor, CONSTANTS.npc_interact);
		}
		if (what_do().contains(CONSTANTS.guide_text55))
		{
			ctx.game.tab(ctx.game.tab().MAGIC);
		}
		if (what_do().contains(CONSTANTS.guide_text56))
		{
			step_use_npc(CONSTANTS.mage_tile, CONSTANTS.mage_instructor, CONSTANTS.npc_interact);
		}
		if (what_do().contains(CONSTANTS.guide_text57))
		{
			ctx.game.tab(ctx.game.tab().MAGIC);
			ctx.movement.step(CONSTANTS.chicken_tile);
			wait_sleep();
			use_component(CONSTANTS.wind_strike_widget, CONSTANTS.wind_strike_component);
			use_npc(CONSTANTS.chicken, CONSTANTS.spell_interact);
		}
		if (what_do().contains(CONSTANTS.guide_text58))
		{

			step_use_npc(CONSTANTS.mage_tile, CONSTANTS.mage_instructor, CONSTANTS.npc_interact);
			if (ctx.chat.chatting())
			{
				ctx.input.send(" ");
				Condition.sleep(1500);
				ctx.input.send("1");
				Condition.sleep(1500);
				ctx.input.send(" ");
				Condition.sleep(1500);
				ctx.input.send("3");
				Condition.sleep(1500);
			}
		}

	}

	private void talk_monk() 
	{
		if (what_do().contains(CONSTANTS.guide_text49))
		{
			step_use_npc(CONSTANTS.monk_tile, CONSTANTS.monk, CONSTANTS.npc_interact);
			if (object_valid(CONSTANTS.monk_door))
			{
				use_object(CONSTANTS.monk_door, CONSTANTS.door_interact);
			}
		}
		if (what_do().contains(CONSTANTS.guide_text50))
		{
			ctx.game.tab(ctx.game.tab().PRAYER);
			use_npc(CONSTANTS.monk, CONSTANTS.npc_interact);
		}
		if (what_do().contains(CONSTANTS.guide_text51))
		{
			ctx.game.tab(ctx.game.tab().FRIENDS_LIST);
		}
		if (what_do().contains(CONSTANTS.guide_text52))
		{
			ctx.game.tab(ctx.game.tab().IGNORED_LIST);
		}
		if (what_do().contains(CONSTANTS.guide_text53))
		{
			ctx.game.tab(ctx.game.tab().IGNORED_LIST);
			use_npc(CONSTANTS.monk, CONSTANTS.npc_interact);
		}
		if (what_do().contains(CONSTANTS.guide_text54))
		{
			step_use_object(CONSTANTS.monk_door_tile, CONSTANTS.monk_exit_door, CONSTANTS.door_interact, CONSTANTS.church_exit_door_bounds);
			if (ctx.players.local().tile().y() < 3103)
			{
				state = 10;
				talk_mage();
			}
		}
	}

	private void talk_bank() 
	{
		if (what_do().contains(CONSTANTS.guide_text45))
		{
			if (ctx.chat.continueChat("Yes"))
			{
			}
			else
			{
				step_use_object(CONSTANTS.bank_tile, CONSTANTS.bank_booth, CONSTANTS.item_interact);
			}
			Condition.sleep(2000);
			if (ctx.bank.opened())
			{
				ctx.bank.close();
				step_use_object(CONSTANTS.bank_tile, CONSTANTS.poll_booth, CONSTANTS.item_interact);
			}
		}
		if (what_do().contains(CONSTANTS.guide_text46))
		{
			if (ctx.bank.opened())
			{
				ctx.bank.close();
			}
			step_use_object(CONSTANTS.bank_tile, CONSTANTS.poll_booth, CONSTANTS.item_interact);
			
		}
		if (what_do().contains(CONSTANTS.guide_text47))
		{
			step_use_object(CONSTANTS.bank_door_tile, CONSTANTS.bank_door, CONSTANTS.door_interact, CONSTANTS.bank_door_bounds);
		}
		if (what_do().contains(CONSTANTS.guide_text48))
		{
			use_npc(CONSTANTS.financial_advisor, CONSTANTS.npc_interact);
		}
		if (what_do().contains(CONSTANTS.guide_text48_1))
		{
			use_component(CONSTANTS.acc_management_tab_widget, CONSTANTS.acc_management_tab_component);
		}
		if (what_do().contains(CONSTANTS.guide_text48_2))
		{
			use_npc(CONSTANTS.financial_advisor, CONSTANTS.npc_interact);
		}
		if (what_do().contains("Continue through the next"))
		{
			use_object(CONSTANTS.financial_advisor_door, CONSTANTS.door_interact, CONSTANTS.bank_door_bounds);
		}
	}

	private void talk_combat() 
	{
		if (what_do().contains(CONSTANTS.guide_text33))
		{
			step_use_npc(CONSTANTS.combat_instructor_tile, CONSTANTS.combat_instructor, CONSTANTS.npc_interact);
		}
		if (what_do().contains(CONSTANTS.guide_text34))
		{
			ctx.game.tab(Tab.EQUIPMENT);
		}
		if (what_do().contains(CONSTANTS.guide_text35))
		{
			if (ctx.game.tab() != ctx.game.tab().EQUIPMENT)
			{
				ctx.game.tab(Tab.EQUIPMENT);
			}
			use_component(CONSTANTS.worn_equipment_widget, CONSTANTS.worn_equipment_component);
		}
		if (what_do().contains(CONSTANTS.guide_text36))
		{
			if (component_valid(CONSTANTS.worn_exit_widget, CONSTANTS.worn_exit_component))
			{
				use_component(CONSTANTS.worn_exit_widget, CONSTANTS.worn_exit_component);
			}
			else
			{
				ctx.game.tab(ctx.game.tab().INVENTORY);
				use_item(CONSTANTS.bronze_dagger, CONSTANTS.weapon_interact);
			}
		}
		if (what_do().contains(CONSTANTS.guide_text37))
		{
			use_npc(CONSTANTS.combat_instructor, CONSTANTS.npc_interact);
		}
		if (what_do().contains(CONSTANTS.guide_text38))
		{
			use_item(CONSTANTS.bronze_sword, CONSTANTS.weapon_interact);
			use_item(CONSTANTS.wooden_shield, CONSTANTS.weapon_interact);
		}
		if (what_do().contains(CONSTANTS.guide_text39) && !what_do().contains("This is your"))
		{
			ctx.game.tab(ctx.game.tab().ATTACK);
		}
		if (what_do().contains(CONSTANTS.guide_text40))
		{
			step_use_object(CONSTANTS.rat_gate_o, CONSTANTS.rat_gate, CONSTANTS.door_interact);
		}
		if (what_do().contains(CONSTANTS.guide_text41))
		{
			use_npc(CONSTANTS.giant_rat, CONSTANTS.combat_interact);
		}
		if (what_do().contains(CONSTANTS.guide_text41_1) && idling())
		{
			use_npc(CONSTANTS.giant_rat, CONSTANTS.combat_interact);
		}
		if (what_do().contains(CONSTANTS.guide_text42))
		{
			if (item_valid(CONSTANTS.bow))
			{
				ctx.game.tab(ctx.game.tab().INVENTORY);
				use_item(CONSTANTS.bow, CONSTANTS.weapon_interact);
				use_item(CONSTANTS.bronze_arrows, CONSTANTS.weapon_interact);
				use_npc(CONSTANTS.giant_rat, CONSTANTS.combat_interact);
			}
			else
			{
				step_use_object(CONSTANTS.rat_gate_o, CONSTANTS.rat_gate, CONSTANTS.door_interact);
				step_use_npc(CONSTANTS.combat_instructor_tile, CONSTANTS.combat_instructor, CONSTANTS.npc_interact);
			}
		}
		if (what_do().contains(CONSTANTS.guide_text43))
		{
			ctx.game.tab(ctx.game.tab().INVENTORY);
			use_item(CONSTANTS.bow, CONSTANTS.weapon_interact);
			use_item(CONSTANTS.bronze_arrows, CONSTANTS.weapon_interact);
			use_npc(CONSTANTS.giant_rat, CONSTANTS.combat_interact);
		}
		if (what_do().contains(CONSTANTS.guide_text44))
		{
			step_use_object(CONSTANTS.rat_ladder_tile, CONSTANTS.rat_ladder, CONSTANTS.ladder_interact_up);
		}
	}

	private void talk_mining() 
	{
		if (what_do().contains(CONSTANTS.guide_text24))
		{
			ctx.game.tab(Tab.INVENTORY);
			step_use_npc(CONSTANTS.mining_guide_tile, CONSTANTS.mining_guide, CONSTANTS.npc_interact);
		}
		if (what_do().contains(CONSTANTS.guide_text25))
		{
			step_use_object(CONSTANTS.mining_guide_tile, CONSTANTS.tin_rock, CONSTANTS.rock_prospect_interact);
		}
		if (what_do().contains(CONSTANTS.guide_text26))
		{
			step_use_object(CONSTANTS.mining_guide_tile, CONSTANTS.copper_rock, CONSTANTS.rock_prospect_interact);
		}
		if (what_do().contains(CONSTANTS.guide_text27))// && !item_valid(CONSTANTS.bronze_pickaxe))
		{
			step_use_npc(CONSTANTS.mining_guide_tile, CONSTANTS.mining_guide, CONSTANTS.npc_interact);
		}
		if (what_do().contains(CONSTANTS.guide_text28) && item_valid(CONSTANTS.bronze_pickaxe) && !item_valid(CONSTANTS.tin_ore) && !item_valid(CONSTANTS.bronze_bar))
		{
			step_use_object(CONSTANTS.mining_guide_tile, CONSTANTS.tin_rock, CONSTANTS.rock_mine_interact);
		}
		if (what_do().contains(CONSTANTS.guide_text28) && item_valid(CONSTANTS.bronze_pickaxe) && !item_valid(CONSTANTS.copper_ore) && !item_valid(CONSTANTS.bronze_bar))
		{
			step_use_object(CONSTANTS.mining_guide_tile, CONSTANTS.copper_rock, CONSTANTS.rock_mine_interact);
		}
		if (what_do().contains(CONSTANTS.guide_text29) && item_valid(CONSTANTS.bronze_pickaxe) && item_valid(CONSTANTS.copper_ore) && item_valid(CONSTANTS.tin_ore) && !item_valid(CONSTANTS.bronze_bar))
		{
			ctx.movement.step(CONSTANTS.furnace_tile);
			use_item(CONSTANTS.tin_ore, CONSTANTS.item_interact);
			use_object(CONSTANTS.furnace, CONSTANTS.item_interact);
			Condition.sleep(2000);
		}
		if (what_do().contains(CONSTANTS.guide_text30) && item_valid(CONSTANTS.bronze_bar))
		{
			step_use_npc(CONSTANTS.mining_guide_tile, CONSTANTS.mining_guide, CONSTANTS.npc_interact);
		}
		if (what_do().contains(CONSTANTS.guide_text31))
		{
			step_use_object(CONSTANTS.furnace_tile, CONSTANTS.anvil, CONSTANTS.anvil_interact);
			Condition.sleep(2000);
			if (component_valid(CONSTANTS.smith_widget, CONSTANTS.smith_component1, CONSTANTS.smith_component2))
			{
				use_component(CONSTANTS.dagger_widget, CONSTANTS.dagger_component);
			}
		}
		if (what_do().contains(CONSTANTS.guide_text32))
		{
			step_use_object(CONSTANTS.mining_gate_tile, CONSTANTS.mining_gate, CONSTANTS.door_interact, CONSTANTS.mining_gate_bounds);
			for (int counter = 0; counter < 3; counter++)
			{
				if (ctx.players.local().tile().x() == 3095)
				{
					state = 7;
				}
				else
				{
					step_use_object(CONSTANTS.mining_gate_tile, CONSTANTS.mining_gate, CONSTANTS.door_interact, CONSTANTS.mining_gate_bounds);
				}
			}
		}

	}

	private void talk_quest() 
	{
		if (what_do().contains(CONSTANTS.guide_text20))
		{
			use_npc(CONSTANTS.quest_guide, CONSTANTS.npc_interact);
		}
		if (what_do().contains(CONSTANTS.guide_text21))
		{
			ctx.game.tab(Tab.QUESTS);
		}
		if (what_do().contains(CONSTANTS.guide_text22))
		{
			use_npc(CONSTANTS.quest_guide, CONSTANTS.npc_interact);
		}
		if (what_do().contains(CONSTANTS.guide_text23))
		{
			use_object(CONSTANTS.quest_ladder, CONSTANTS.ladder_interact_down);
			
			if (ctx.players.local().tile().x() == 3088)
			{
				state = 6;
			}
			else
			{
				use_object(CONSTANTS.quest_ladder, CONSTANTS.ladder_interact_down);
			}		
		}
	}

	private void go_quest() 
	{
		if (what_do().contains(CONSTANTS.guide_text17))
		{
			if (!ctx.game.tab().equals(ctx.game.tab().EMOTES))
			{
				ctx.game.tab(ctx.game.tab().EMOTES);
				Condition.sleep(1000);
			}
			else
			{
				use_component(CONSTANTS.emote_widget, CONSTANTS.emote_component1, CONSTANTS.emote_component2);
			}
		}
		if (what_do().contains(CONSTANTS.guide_text18))
		{
			if (!ctx.game.tab().equals(ctx.game.tab().OPTIONS))
			{
				ctx.game.tab(ctx.game.tab().OPTIONS);
				Condition.sleep(1000);
			}
			else
			{
				//use_component(CONSTANTS.run_widget, CONSTANTS.run_component);
				ctx.movement.running(true);
			}
		}
		if (what_do().contains(CONSTANTS.guide_text19)) // NEED FIX
		{
			step_use_object(CONSTANTS.quest_tile, CONSTANTS.quest_door, CONSTANTS.door_interact, CONSTANTS.quest_door_bounds);
		}
		if (ctx.players.local().tile().x() == 3086)
		{
			state = 5;
		}
	}

	private void talk_cook() 
	{
		if (what_do().contains(CONSTANTS.guide_text13))
		{
			step_use_object(CONSTANTS.cook_tile, CONSTANTS.cook_door1, CONSTANTS.door_interact, CONSTANTS.cook_door_bounds1);
			use_npc(CONSTANTS.cook, CONSTANTS.npc_interact);
		}
		if (what_do().contains(CONSTANTS.guide_text14))
		{
			use_item(CONSTANTS.flour, CONSTANTS.item_interact);
			use_item(CONSTANTS.water, CONSTANTS.item_interact);
		}
		if (what_do().contains(CONSTANTS.guide_text15))
		{
			use_item(CONSTANTS.dough, CONSTANTS.item_interact);
			use_object(CONSTANTS.range, CONSTANTS.item_interact);
			ctx.game.tab(Tab.MUSIC);
		}
		if (what_do().contains(CONSTANTS.guide_text16))
		{
			step_use_object(CONSTANTS.cook_tile2, CONSTANTS.cook_door2, CONSTANTS.door_interact, CONSTANTS.cook_door_bounds2);
			for (int counter = 0; counter < 3; counter++)
			{
				if (ctx.players.local().tile().x() == 3072)
				{
					state = 4;
				}
				else
				{
					step_use_object(CONSTANTS.cook_tile2, CONSTANTS.cook_door2, CONSTANTS.door_interact, CONSTANTS.cook_door_bounds2);
				}
			}
		}
	}

	private void talk_survival() 
	{
		if (what_do().contains(CONSTANTS.guide_text3))
		{
			step_use_npc(CONSTANTS.survival_tile, CONSTANTS.survival_guide, CONSTANTS.npc_interact);
		}
		if (what_do().contains(CONSTANTS.guide_text4))
		{
			ctx.game.tab(ctx.game.tab().INVENTORY);
			Condition.sleep(1000);
		}
		if (what_do().contains(CONSTANTS.guide_text5))
		{
			use_object(CONSTANTS.tree, CONSTANTS.tree_interact);
		}
		if (what_do().contains(CONSTANTS.guide_text6))
		{
			GameObject fire = ctx.objects.select().id(CONSTANTS.fire).nearest().poll();
			if (fire != null && fire.tile().equals(ctx.players.local().tile()))
			{
				Tile random_tile = new Tile(ctx.players.local().tile().x(), ctx.players.local().tile().y() + 2, 0);
				ctx.movement.step(random_tile);
				use_item(CONSTANTS.logs, CONSTANTS.item_interact);
				use_item(CONSTANTS.tinderbox, CONSTANTS.item_interact);
			}
			else
			{
				use_item(CONSTANTS.logs, CONSTANTS.item_interact);
				use_item(CONSTANTS.tinderbox, CONSTANTS.item_interact);
			}
		}
		if (what_do().contains(CONSTANTS.guide_text7))
		{
			ctx.game.tab(ctx.game.tab().STATS);
			use_component(CONSTANTS.skills_tab_widget, CONSTANTS.skills_tab_component);
			Condition.sleep(1000);
		}
		if (what_do().contains(CONSTANTS.guide_text8))
		{
			step_use_npc(CONSTANTS.survival_tile, CONSTANTS.survival_guide, CONSTANTS.npc_interact);
		}
		if (what_do().contains(CONSTANTS.guide_text9))
		{
			step_use_npc(CONSTANTS.fishing_tile, CONSTANTS.fishing_spot, CONSTANTS.fishing_interact);
		}
		if (what_do().contains(CONSTANTS.guide_text10))
		{
			ctx.game.tab(ctx.game.tab().INVENTORY);
			Condition.sleep(1000);
			use_item(CONSTANTS.raw_shrimp, CONSTANTS.item_interact);
			use_object(CONSTANTS.fire, CONSTANTS.item_interact);
			ctx.camera.angle(((int)Math.random() * 360));

		}
		if (what_do().contains(CONSTANTS.guide_text11))
		{
			step_use_npc(CONSTANTS.fishing_tile, CONSTANTS.fishing_spot, CONSTANTS.fishing_interact);
			if (item_valid(CONSTANTS.raw_shrimp))
			{
				use_item(CONSTANTS.raw_shrimp, CONSTANTS.item_interact);
				use_object(CONSTANTS.fire, CONSTANTS.item_interact);
				ctx.camera.angle(((int)Math.random() * 360));
			}
		}
		if (what_do().contains(CONSTANTS.guide_text12))
		{
			step_use_object(CONSTANTS.gate_tile, CONSTANTS.gate, CONSTANTS.gate_interact, CONSTANTS.gate_bounds);
			
			for (int counter = 0; counter < 3; counter++)
			{
				if (ctx.players.local().tile().x() == 3089)
				{
					state = 3;
				}
				else
				{
					step_use_object(CONSTANTS.gate_tile, CONSTANTS.gate, CONSTANTS.gate_interact, CONSTANTS.gate_bounds);			
				}
			}
		}
	}

	private void talk_guide()
	{
		if (what_do().contains(CONSTANTS.guide_text1))
		{
			if (component_valid(CONSTANTS.experienced_player_widget, CONSTANTS.experienced_player_component))
			{
				use_component(CONSTANTS.experienced_player_widget, CONSTANTS.experienced_player_component);
			}
			if (!ctx.chat.chatting())
			{
				use_npc(CONSTANTS.runescape_guide, CONSTANTS.npc_interact);
			}
		}
		if (what_do().contains("Options menu"))
		{
			ctx.game.tab(ctx.game.tab().OPTIONS);
			rand_sleep(700);
			use_npc(CONSTANTS.runescape_guide, CONSTANTS.npc_interact);
		}
		if (what_do().contains(CONSTANTS.guide_text2))
		{
			use_object(CONSTANTS.guide_door, CONSTANTS.door_interact);
		}
		if (ctx.players.local().tile().x() == 3098)
		{
			state = 2;
		}
	}
	
	private void create_char()
	{
		if (component_valid(CONSTANTS.char_creat_widget, CONSTANTS.char_creat_component))
		{
			use_component(CONSTANTS.char_creat_widget, CONSTANTS.char_creat_accept_component);
		}
		state = 1;
	}
	
	private int det_progress()
	{
		int progress = 0;
		Component bars[] = new Component[20];
		
		for (int counter = 1; counter < 21; counter++)
		{
			bars[counter - 1] = ctx.widgets.widget(CONSTANTS.progress_bar_widget).component(counter);
		}
		
		if (bars[1].textColor() == CONSTANTS.progress_color_done)
		{
			progress = 2;
		}
		if (bars[3].textColor() == CONSTANTS.progress_color_done)
		{
			progress = 3;
		}
		
		if (bars[5].textColor() == CONSTANTS.progress_color_done)
		{
			progress = 4;
		}
		
		if (bars[6].textColor() == CONSTANTS.progress_color_done)
		{
			progress = 5;
		}
		
		if (bars[7].textColor() == CONSTANTS.progress_color_done)
		{
			progress = 6;
		}
		
		if (bars[9].textColor() == CONSTANTS.progress_color_done)
		{
			progress = 7;
		}
		
		if (bars[13].textColor() == CONSTANTS.progress_color_done)
		{
			progress = 8;
		}
		
		if (bars[15].textColor() == CONSTANTS.progress_color_done)
		{
			progress = 9;
		}
		
		if (bars[17].textColor() == CONSTANTS.progress_color_done)
		{
			progress = 10;
		}
		
		return progress;
	}
	
	private String what_do()
	{
		String message = "";
		Component does = ctx.widgets.widget(CONSTANTS.first_guide_text_widget).component(CONSTANTS.first_guide_text_component);
		Component does2 = ctx.widgets.widget(CONSTANTS.second_guide_text_widget).component(CONSTANTS.second_guide_text_component);
		Component does3 = ctx.widgets.widget(CONSTANTS.first_guide_text_widget).component(CONSTANTS.third_guide_text_component);
		message = does.text();
/*		
		System.out.println("1" + does.text());
		System.out.println("2" + does2.text());
		System.out.println("3" + does3.text());
*/
		
		if (message.length() < 1)
		{
			message = does2.text();
		}
		if (message.length() < 1)
		{
			message = does3.text();
		}
		//return message;
		return ctx.widgets.widget(CONSTANTS.new_guide_text_widget).component(CONSTANTS.new_guide_text_component1).component(CONSTANTS.new_guide_text_component2).text();
	}
	
	private boolean on_island()
	{
		return true;
	}

}
