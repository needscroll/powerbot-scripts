package needscroll.StarterPack2.Tasks;

import org.powerbot.script.rt4.ClientContext;

import needscroll.StarterPack2.Task;

public class Powering extends Task{
	
	protected int[] selected_objects;
	public int[] selected_products;
	
	protected String selected_interact;

	public Powering(ClientContext ctx, int[] object, int[] product, String interact) {
		super(ctx);
		this.selected_objects = object;
		this.selected_products = product;
		this.selected_interact = interact;
	}

	@Override
	public boolean activate() {
		return true;
	}

	@Override
	public void execute() {
		if (!full_inv(ctx))
		{
			gather();
		}
		if (full_inv(ctx))
		{
			deposit();
		}
	}

	protected void gather()
	{
		use_object(ctx, selected_objects, selected_interact);
		use_npc(ctx, selected_objects, selected_interact);
	}

	protected void deposit()
	{
		drop_items(ctx, selected_products);
	}

}
