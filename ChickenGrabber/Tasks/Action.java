package needscroll.ChickenGrabber.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.GroundItem;
import org.powerbot.script.rt4.Interactive;
import org.powerbot.script.rt4.Item;
import org.powerbot.script.rt4.Npc;

import needscroll.ChickenGrabber.Task;

public class Action extends Task{

	public Action(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
	
	protected boolean object_valid(int id)
	{
		GameObject thing = ctx.objects.select().id(id).nearest().poll();
		if (thing.valid())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	protected void step_use_object(Tile tile, int thing_id, String use)
	{
		GameObject thing = ctx.objects.select().id(thing_id).nearest().poll();
		ctx.movement.step(tile);
		Condition.sleep(1000);
		while (ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
		
		if (thing.valid())
		{
			if (!thing.inViewport())
			{
				ctx.camera.turnTo(thing.tile());
			}
			if (thing.interact(use))
			{
				Condition.sleep(1000);
				while (ctx.players.local().inMotion())
				{
					Condition.sleep(1000);
				}
			}
		}
	}
	
	protected void use_object(int id, String use)
	{
		GameObject thing = ctx.objects.select().id(id).nearest().poll();

		if (thing.valid())
		{
			if (!thing.inViewport())
			{
				ctx.camera.turnTo(thing.tile());
			}
			if (thing.interact(use))
			{
				Condition.sleep(1000);
				while (ctx.players.local().inMotion())
				{
					Condition.sleep(1000);
				}
			}
		}
	}
	
	protected void step_use_npc(Tile tile, int thing_id, String use)
	{
		Npc npc = ctx.npcs.select().id(thing_id).nearest().poll();
		ctx.movement.step(tile);
		Condition.sleep(1000);
		while (ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
		
		if (npc.valid())
		{
			if (!npc.inViewport())
			{
				ctx.camera.turnTo(npc.tile());
			}
			if (npc.interact(use))
			{
				Condition.sleep(1000);
				while (ctx.players.local().inMotion())
				{
					Condition.sleep(1000);
				}
			}
		}
	}
	
	protected void use_npc(int id, String use)
	{
		Npc npc = ctx.npcs.select().id(id).nearest().poll();
		if (npc.valid())
		{
			if (!npc.inViewport())
			{
				ctx.camera.turnTo(npc.tile());
			}
			if (npc.interact(use))
			{
				Condition.sleep(1000);
				while (ctx.players.local().inMotion())
				{
					Condition.sleep(1000);
				}
			}
		}
	}
	
	protected boolean component_valid(int widget, int component)
	{
		Component thing = ctx.widgets.widget(widget).component(component);
		if (thing.valid() && thing.visible())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	protected boolean component_valid(int widget, int component, int component2)
	{
		Component thing = ctx.widgets.widget(widget).component(component).component(component2);
		if (thing.valid() && thing.visible())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	protected void use_component(int widget, int component)
	{
		Component thing = ctx.widgets.widget(widget).component(component);
		thing.click(true);
		Condition.sleep(1000);
	}
	
	protected void use_component(int widget, int component, int component2)
	{
		Component thing = ctx.widgets.widget(widget).component(component).component(component2);
		thing.click(true);
		Condition.sleep(1000);
	}
	
	protected boolean grounditem_valid(int id)
	{
		GroundItem thing = ctx.groundItems.select().id(id).nearest().poll();
		if (thing.valid())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	protected void step_use_grounditem(Tile tile, int thing_id, String use)
	{
		GroundItem thing = ctx.groundItems.select().id(thing_id).nearest().poll();
		ctx.movement.step(tile);
		Condition.sleep(1000);
		while (ctx.players.local().inMotion())
		{
			Condition.sleep(1000);
		}
		
		if (thing.valid())
		{
			if (!thing.inViewport())
			{
				ctx.camera.turnTo(thing.tile());
			}
			if (thing.interact(use))
			{
				Condition.sleep(1000);
				while (ctx.players.local().inMotion())
				{
					Condition.sleep(1000);
				}
			}
		}
	}
	
	protected void use_grounditem(int id, String use)
	{
		GroundItem thing = ctx.groundItems.select().id(id).nearest().poll();

		if (thing.valid())
		{
			if (!thing.inViewport())
			{
				ctx.camera.turnTo(thing.tile());
			}
			if (thing.interact(use))
			{
				Condition.sleep(1000);
				while (ctx.players.local().inMotion())
				{
					Condition.sleep(1000);
				}
			}
		}
	}
	
	protected void use_grounditem(int id, String use, int[] bounds)
	{
		GroundItem thing = ctx.groundItems.select().id(id).each(Interactive.doSetBounds(bounds)).nearest().poll();

		if (thing.valid())
		{
			if (!thing.inViewport())
			{
				ctx.camera.turnTo(thing.tile());
			}
			if (thing.interact(use))
			{
				Condition.sleep(1000);
				while (ctx.players.local().inMotion())
				{
					Condition.sleep(1000);
				}
			}
		}
	}
	
	protected boolean item_valid(int id)
	{
		Item thing = ctx.inventory.select().id(id).poll();
		if (thing.valid())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	protected void use_item(int id, String use)
	{
		Item thing = ctx.inventory.select().id(id).poll();

		if (thing.valid())
		{
			if (thing.interact(use))
			{
				Condition.sleep(1000);
			}
		}
	}

}
