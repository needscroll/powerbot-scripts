package needscroll.StarterPack2.Tasks;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;

import needscroll.StarterPack2.Task;

public class ItemCombineTraining extends Task{
	
	int[] items;
	int[] item_amounts;
	
	int[] products;
	
	String interact_string;
	
	Component training_component;
	
	int failures;

	public ItemCombineTraining(ClientContext ctx, int[] items, int[] item_amounts, int[] products,
			String interact_string, Component training_component) {
		super(ctx);
		this.items = items;
		this.item_amounts = item_amounts;
		this.products = products;
		this.interact_string = interact_string;
		this.training_component = training_component;

		failures = 0;
	}

	@Override
	public boolean activate() {
		return failures <= 2 && items.length == item_amounts.length;
	}

	@Override
	public void execute() {		
		if (idling(ctx, 500, 5))
		{
			if (valid_inv(ctx, items))
			{
				if (ctx.bank.opened())
				{
					ctx.bank.close();
				}
				if (!ctx.game.tab().equals(ctx.game.tab().INVENTORY))
				{
					ctx.game.tab(ctx.game.tab().INVENTORY);
				}
				if (!component_valid(training_component))
				{
					use_item(ctx, items[0], interact_string);
					if (items.length > 1)
					{
						use_item(ctx, items[1], interact_string);
						select_component();
					}
				}
				else
				{
					select_component();
				}
			}
			else
			{
				banking();
			}
		}
		
	}

	private void select_component() {
		use_component(training_component);
	}
	
	private void banking() {
		open_bank(ctx);
		deposit_all(ctx, products);
		
		for(int i = 0; i < items.length; i++)
		{
			if (item_amount(ctx, items[i]) < item_amounts[i])
			{
				ctx.bank.withdraw(items[i], item_amounts[i] - item_amount(ctx, items[i]));
			}
		}
		
		ctx.bank.close();
		boolean valid = true;
		for (int i: items)
		{
			if (!item_valid(ctx, i))
			{
				failures++;
				valid = false;
			}
		}
		if (valid)
		{
			failures = 0;
		}		
	}



}
