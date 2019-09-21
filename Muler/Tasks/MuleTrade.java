package needscroll.Muler.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ChatOption;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;

import needscroll.Muler.Task;

public class MuleTrade extends Task{

	public MuleTrade(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		return true;
	}

	@Override
	public void execute() {
		Component trade_window = ctx.widgets.widget(CONSTANTS.trade_window_widget).component(CONSTANTS.trade_window_component);
		Component trade_window2 = ctx.widgets.widget(CONSTANTS.trade_window_widget2).component(CONSTANTS.trade_window_component2);
		Component trade_text = ctx.widgets.widget(CONSTANTS.trade_text_widget).component(CONSTANTS.trade_text_component).component(CONSTANTS.trade_text_component2);
		Component accept1 = ctx.widgets.widget(CONSTANTS.accept1_widget).component(CONSTANTS.accept1_component);
		Component accept2 = ctx.widgets.widget(CONSTANTS.accept2_widget).component(CONSTANTS.accept2_component);
		Component accepted1 = ctx.widgets.widget(CONSTANTS.accepted1_widget).component(CONSTANTS.accepted1_component);
		Component accepted2 = ctx.widgets.widget(CONSTANTS.accepted2_widget).component(CONSTANTS.accepted2_component);
		
		Component click_here = ctx.widgets.widget(CONSTANTS.click_here_widget).component(CONSTANTS.click_here_component);
		Component trade_chat = ctx.widgets.widget(CONSTANTS.trade_chat_widget).component(CONSTANTS.trade_chat_component);
		
		if (click_here.valid() && click_here.visible())
		{
			click_here.click(true);
			trade_chat.click(true);
		}
		
		if (slave_traded() && !trade_window.valid() && !trade_window.visible())
		{
			trade_text.click(true); // trade back or accept trade
			Condition.sleep(5000);
		}
		if (accepted1.text().contains("player"))
		{
			accept1.click(true);
			Condition.sleep(5000);
		}
		if (accepted2.valid())
		{
			accept2.click(true);
			Condition.sleep(5000);
		}
		/*
		for (int counter = 0; counter < 60 && !slave_traded() && !trade_window.valid() && !trade_window2.valid(); counter++)
		{
			Condition.sleep(3000);
		}
		ctx.camera.pitch(70);
		ctx.camera.angle('n');*/
	}
	
	private boolean slave_traded()
	{
		Component trade_text = ctx.widgets.widget(CONSTANTS.trade_text_widget).component(CONSTANTS.trade_text_component).component(CONSTANTS.trade_text_component2);
		boolean traded = false;
		
		if (trade_text.text().contains("wishes"))
		{
			traded = true;
		}
		
		return traded;
	}
}
