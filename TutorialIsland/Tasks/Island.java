package needscroll.TutorialIsland.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.Game.Tab;
import org.powerbot.script.rt4.GameObject;

public class Island extends Action{
	
	public int state = 0;

	public Island(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean activate() {
		return on_island();
	}

	@Override
	public void execute() {
		state = det_progress();
		if (state == 0)
		{
			create_char();
		}
		
		if (state == 1)
		{
			talk_guide();
		}
		
		if (state == 2)
		{
			talk_survival();
		}
		
		if (state == 3)
		{
			talk_cook();
		}
		
		if (state == 4)
		{
			go_quest();
		}
		
		if (state == 5)
		{
			talk_quest();
		}
		
		if (state == 6)
		{
			talk_mining();
		}
	}

	private boolean on_island()
	{
		return true;
	}
	
	private void create_char()
	{
		if (component_valid(CONSTANTS.char_creat_widget, CONSTANTS.char_creat_component))
		{
			use_component(CONSTANTS.char_creat_widget, CONSTANTS.char_creat_accept_component);
		}
		state = 1;
	}
	
	private void talk_guide()
	{
		use_npc(CONSTANTS.runescape_guide, CONSTANTS.npc_interact);
		
		while (ctx.chat.chatting() || ctx.chat.canContinue())
		{
			if (component_valid(CONSTANTS.chat_continue_widget, CONSTANTS.chat_continue_component))
			{
				use_component(CONSTANTS.chat_continue_widget, CONSTANTS.chat_continue_component);
			}
			if (component_valid(CONSTANTS.click_continue_widget, CONSTANTS.click_continue_component))
			{
				use_component(CONSTANTS.click_continue_widget, CONSTANTS.click_continue_component);
			}
			if (component_valid(CONSTANTS.experienced_player_widget, CONSTANTS.experienced_player_component))
			{
				use_component(CONSTANTS.experienced_player_widget, CONSTANTS.experienced_player_component);
			}
			if (ctx.chat.canContinue())
			{
				ctx.chat.clickContinue();
			}
			System.out.println("in while");
		}
		System.out.println("out while");
		Condition.sleep(1500);
		if (component_valid(CONSTANTS.experienced_player_widget, CONSTANTS.experienced_player_component))
		{
			use_component(CONSTANTS.experienced_player_widget, CONSTANTS.experienced_player_component);
		}

		ctx.game.tab(Tab.OPTIONS);
		use_npc(CONSTANTS.runescape_guide, CONSTANTS.npc_interact);
		continue_chat();
		use_object(CONSTANTS.guide_door, CONSTANTS.door_interact);
		if (ctx.players.local().tile().x() == 3098)
		{
			state = 2;
		}
	}
	
	private void talk_survival()
	{
		
		step_use_npc(CONSTANTS.survival_tile, CONSTANTS.survival_guide, CONSTANTS.npc_interact);
		continue_chat();
		ctx.game.tab(Tab.INVENTORY);
		use_object(CONSTANTS.tree, CONSTANTS.tree_interact);
		
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
		ctx.game.tab(Tab.STATS);
		use_npc(CONSTANTS.survival_guide, CONSTANTS.npc_interact);
		continue_chat();
		ctx.game.tab(Tab.INVENTORY);
		
		if (!item_valid(CONSTANTS.cooked_shrimp))
		{
			use_npc(CONSTANTS.fishing_spot, CONSTANTS.fishing_interact);
			if (item_valid(CONSTANTS.raw_shrimp))
			{
				use_item(CONSTANTS.raw_shrimp, CONSTANTS.item_interact);
				use_object(CONSTANTS.fire, CONSTANTS.item_interact);
			}
		}
		
		if (item_valid(CONSTANTS.cooked_shrimp))
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
	
	private void talk_cook()
	{
		step_use_object(CONSTANTS.cook_tile, CONSTANTS.cook_door1, CONSTANTS.door_interact, CONSTANTS.cook_door_bounds1);
		use_npc(CONSTANTS.cook, CONSTANTS.npc_interact);
		continue_chat();
		
		if (item_valid(CONSTANTS.flour) && item_valid(CONSTANTS.water))
		{
			use_item(CONSTANTS.flour, CONSTANTS.item_interact);
			use_item(CONSTANTS.water, CONSTANTS.item_interact);
		}
		
		if (item_valid(CONSTANTS.dough))
		{
			use_item(CONSTANTS.dough, CONSTANTS.item_interact);
			use_object(CONSTANTS.range, CONSTANTS.item_interact);
			ctx.game.tab(Tab.MUSIC);
		}
		
		if (item_valid(CONSTANTS.bread))
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
			ctx.game.tab(Tab.EMOTES);
			use_component(CONSTANTS.emote_widget, CONSTANTS.emote_component1, CONSTANTS.emote_component2);
			ctx.game.tab(Tab.OPTIONS);
			Condition.sleep(1000);
			use_component(CONSTANTS.run_widget, CONSTANTS.run_component);
			
			if (!ctx.movement.running())
			{
				ctx.movement.running(true);
			}
		}
	}
	
	private void go_quest()
	{
		if (ctx.players.local().tile().x() != 3086)
		{
			step_use_object(CONSTANTS.quest_tile, CONSTANTS.quest_door, CONSTANTS.door_interact, CONSTANTS.quest_door_bounds);
		}
		if (ctx.players.local().tile().x() == 3086)
		{
			state = 5;
		}
	}
	
	private void talk_quest()
	{
		use_npc(CONSTANTS.quest_guide, CONSTANTS.npc_interact);
		continue_chat();
		ctx.game.tab(Tab.QUESTS);
		use_npc(CONSTANTS.quest_guide, CONSTANTS.npc_interact);
		continue_chat();
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
	
	private void talk_mining()
	{ 
		ctx.game.tab(Tab.INVENTORY);
		while (!ctx.chat.chatting())
		{
			step_use_npc(CONSTANTS.mining_guide_tile, CONSTANTS.mining_guide, CONSTANTS.npc_interact);
		}
		continue_chat();
		Condition.sleep(2000);
		step_use_object(CONSTANTS.mining_guide_tile, CONSTANTS.tin_rock, CONSTANTS.rock_prospect_interact);
		Condition.sleep(2000);
		step_use_object(CONSTANTS.mining_guide_tile, CONSTANTS.copper_rock, CONSTANTS.rock_prospect_interact);
		Condition.sleep(2000);
		
		step_use_npc(CONSTANTS.mining_guide_tile, CONSTANTS.mining_guide, CONSTANTS.npc_interact);
		continue_chat();
		Condition.sleep(1000);
		
		if (item_valid(CONSTANTS.bronze_pickaxe) && !(item_valid(CONSTANTS.tin_ore) && item_valid(CONSTANTS.copper_ore)))
		{
			step_use_object(CONSTANTS.mining_guide_tile, CONSTANTS.tin_rock, CONSTANTS.rock_mine_interact);
			Condition.sleep(2000);
			step_use_object(CONSTANTS.mining_guide_tile, CONSTANTS.copper_rock, CONSTANTS.rock_mine_interact);
			Condition.sleep(2000);
		}
		
		if (item_valid(CONSTANTS.tin_ore) && item_valid(CONSTANTS.copper_ore) && !item_valid(CONSTANTS.bronze_bar))
		{
			use_item(CONSTANTS.tin_ore, CONSTANTS.item_interact);
			use_object(CONSTANTS.furnace, CONSTANTS.item_interact);
		}
		
		if (!item_valid(CONSTANTS.hammer))
		{
			use_component(CONSTANTS.bronze_continue_widget, CONSTANTS.bronze_continue_component); 
			step_use_npc(CONSTANTS.mining_guide_tile, CONSTANTS.mining_guide, CONSTANTS.npc_interact);
			continue_chat();
		}
		
		if (item_valid(CONSTANTS.hammer) && item_valid(CONSTANTS.bronze_bar))
		{
			step_use_object(CONSTANTS.furnace_tile, CONSTANTS.anvil, CONSTANTS.anvil_interact);
			if (component_valid(CONSTANTS.smith_widget, CONSTANTS.smith_component1, CONSTANTS.smith_component2))
			{
				use_component(CONSTANTS.dagger_widget, CONSTANTS.dagger_component);
			}
		}
		
		if (item_valid(CONSTANTS.bronze_dagger) && ctx.players.local().tile().x() != 3095)
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
	
	private void continue_chat()
	{
		while (ctx.chat.chatting())
		{
			if (component_valid(CONSTANTS.chat_continue_widget, CONSTANTS.chat_continue_component))
			{
				use_component(CONSTANTS.chat_continue_widget, CONSTANTS.chat_continue_component);
			}
			if (component_valid(CONSTANTS.click_continue_widget, CONSTANTS.click_continue_component))
			{
				use_component(CONSTANTS.click_continue_widget, CONSTANTS.click_continue_component);
			}
			if (ctx.chat.canContinue())
			{
				ctx.chat.clickContinue();
			}
		}
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
		
		return progress;
	}
}
