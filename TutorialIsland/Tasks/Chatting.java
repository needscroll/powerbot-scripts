package needscroll.TutorialIsland.Tasks;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;

public class Chatting extends Action{

	public Chatting(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean activate() {
		return component_valid(CONSTANTS.new_continue_widget, CONSTANTS.new_continue_componnent) ||
				component_valid(CONSTANTS.new_chat_continue_widget, CONSTANTS.new_chat_continue_component) ||
				component_valid(CONSTANTS.new_chat_continue_widget_second, CONSTANTS.new_chat_continue_component_second) ||
				component_valid(CONSTANTS.new_chat_continue_widget_third, CONSTANTS.new_chat_continue_component_third) ||
				component_valid(CONSTANTS.new_chat_continue_widget_fourth, CONSTANTS.new_chat_continue_component_fourth);
		//return ctx.chat.chatting() && ctx.chat.canContinue(); new change from new component update
	}
	
	@Override
	public void execute() {
		System.out.println("Chatting");
		ctx.chat.clickContinue();

		if (component_valid(CONSTANTS.new_continue_widget, CONSTANTS.new_continue_componnent))
		{
			use_component(CONSTANTS.new_continue_widget, CONSTANTS.new_continue_componnent);
		}
		
		if (component_valid(CONSTANTS.new_chat_continue_widget, CONSTANTS.new_chat_continue_component))
		{
			use_component(CONSTANTS.new_chat_continue_widget, CONSTANTS.new_chat_continue_component, 0.0);
		}
		if (component_valid(CONSTANTS.new_chat_continue_widget_second, CONSTANTS.new_chat_continue_component_second))
		{
			use_component(CONSTANTS.new_chat_continue_widget_second, CONSTANTS.new_chat_continue_component_second, 0.0);
		}
		if (component_valid(CONSTANTS.new_chat_continue_widget_third, CONSTANTS.new_chat_continue_component_third))
		{
			use_component(CONSTANTS.new_chat_continue_widget_third, CONSTANTS.new_chat_continue_component_third, 0.0);
		}
		if (component_valid(CONSTANTS.new_chat_continue_widget_fourth, CONSTANTS.new_chat_continue_component_fourth))
		{
			use_component(CONSTANTS.new_chat_continue_widget_fourth, CONSTANTS.new_chat_continue_component_fourth, 0.0);
		}
/*
		Component chat_continue1 = ctx.widgets.widget(CONSTANTS.new_chat_continue_widget).component(CONSTANTS.new_chat_continue_component);
		Component chat_continue2 = ctx.widgets.widget(CONSTANTS.new_chat_continue_widget_second).component(CONSTANTS.new_chat_continue_component_second);
		System.out.println("1: " + chat_continue1.valid());
		System.out.println("2: " + chat_continue2.valid());
*/
		rand_sleep(1100);	
	}

}
