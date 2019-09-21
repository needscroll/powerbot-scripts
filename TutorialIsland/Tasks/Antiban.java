package needscroll.TutorialIsland.Tasks;

import org.powerbot.script.rt4.ClientContext;

public class Antiban extends Action{

	public Antiban(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean activate() {
		return component_valid(CONSTANTS.click_continue_widget, CONSTANTS.click_continue_component) ||
				component_valid(CONSTANTS.new_new_anti_continue_widget, CONSTANTS.new_new_anti_continue_component) ||
				(ctx.camera.pitch() < 45);// || 
				//(ctx.movement.energyLevel() > 60 && !ctx.movement.running()); ||
				//component_valid(CONSTANTS.click_continue_levelup_widget, CONSTANTS.click_continue_levelup_component);
	}

	@Override
	public void execute() {
		System.out.println("Antiban");
		
		if (component_valid(CONSTANTS.click_continue_widget, CONSTANTS.click_continue_component))
		{
			use_component(CONSTANTS.click_continue_widget, CONSTANTS.click_continue_component);
			System.out.println(1);
		}
		
		if (component_valid(CONSTANTS.new_new_anti_continue_widget, CONSTANTS.new_new_anti_continue_component))
		{
			use_component(CONSTANTS.new_new_anti_continue_widget, CONSTANTS.new_new_anti_continue_component);
		}
		
		/*
		if (component_valid(CONSTANTS.click_continue_levelup_widget, CONSTANTS.click_continue))
		{
			use_component(CONSTANTS.click_continue_levelup_widget, CONSTANTS.click_continue);
			System.out.println(2);
		}*/
		
		/*
		if (component_valid(CONSTANTS.click_continue_levelup_widget, CONSTANTS.click_continue_levelup_component))
		{
			use_component(CONSTANTS.click_continue_levelup_widget, CONSTANTS.click_continue_levelup_component);
			System.out.println(3);
		}*/
		
		if (ctx.movement.energyLevel() > 60 && !ctx.movement.running())
		{
			//ctx.movement.running(true);
		}
		
		if (ctx.camera.pitch() < 45)
		{
			ctx.camera.pitch(60);
		}
		
		use_component(CONSTANTS.pickaxe_continue_widget, CONSTANTS.pickaxe_continue_component);
	}

}
