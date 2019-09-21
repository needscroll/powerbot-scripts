package needscroll.SpadeGrabber.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Component;

import needscroll.SpadeGrabber.Task;

public class Banking extends Task{

	public Banking(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		return ctx.inventory.select().count() == 28 && CONSTANTS.bank_deposit_area.contains(ctx.players.local());
	}

	@Override
	public void execute() {
		GameObject bank = ctx.objects.select().id(CONSTANTS.bank_deposit).nearest().poll();
		Component deposit_all = ctx.widgets.widget(CONSTANTS.deposit_widget).component(CONSTANTS.deposit_component);
		Component exit = ctx.widgets.widget(CONSTANTS.deposit_widget).component(CONSTANTS.exit_component1).component(CONSTANTS.exit_component2);
		
		if (!deposit_all.visible() && bank.valid())
		{
			if (!bank.inViewport())
			{
				ctx.camera.turnTo(bank.tile());
			}
			bank.interact(CONSTANTS.bank_deposit_interact);
			Condition.sleep(1000);
			while (ctx.players.local().inMotion())
			{
				Condition.sleep(1000);
			}
		}
		if (deposit_all.valid() && deposit_all.visible())
		{
			deposit_all.click(true);
			Condition.sleep(500);
			exit.click(true);
			Condition.sleep(500);
		}
		
		
		
	}

}
