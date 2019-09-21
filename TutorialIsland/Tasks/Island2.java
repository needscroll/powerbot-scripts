package needscroll.TutorialIsland.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Game.Tab;

public class Island2 extends Action{
	
	public int state = 0;

	public Island2(ClientContext ctx) {
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
			//talk_cook();
		}
		
		if (state == 4)
		{
			//go_quest();
		}
		
		if (state == 5)
		{
			//talk_quest();
		}
		
		if (state == 6)
		{
			//talk_mining();
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
		if (what_do().contains("Moving around"))
		{
			step_use_npc(CONSTANTS.survival_tile, CONSTANTS.survival_guide, CONSTANTS.npc_interact);
			continue_chat();
		}
		if (what_do().contains("Viewing the items that"))
		{
			ctx.game.tab(Tab.INVENTORY);
		}
		if (what_do().contains("Cut down a tree"))
		{
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
			ctx.game.tab(Tab.INVENTORY);
		}
		if (what_do().contains("Your skill stats"))
		{
			use_npc(CONSTANTS.survival_guide, CONSTANTS.npc_interact);
			continue_chat();
		}
		if (what_do().contains("Catch some"))
		{
			use_npc(CONSTANTS.fishing_spot, CONSTANTS.fishing_interact);
		}
	}
	
	private String what_do()
	{
		String message = "";
		//Component does = ctx.widgets.widget(CONSTANTS.guide_text_widget).component(CONSTANTS.guide_text_component);
		//message = does.text();
		return message;
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
