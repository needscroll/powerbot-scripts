package needscroll.BanannaGrabber;

import org.powerbot.script.rt6.Item;

public class getstate {
	
	private final int[] BASKETS = {5376, 5408, 5410, 5412, 5414, 5416};
	private final int BANANNA = 1963;
	
	public getstate()
	{
	}
	
	public boolean full_inv(Item[] inv)
	{
		boolean full = true;
		
		for (int counter = 0;counter < inv.length; counter++)
		{
			if (bad_item(inv[counter].id(), BANANNA, BASKETS))
			{
				full = false;
			}
		}
		
		return full;
	}
	
	private boolean bad_item(int id, int BANANNA ,int[] BASKETS)
	{
		boolean pass = true;
		
		if (id == BANANNA)
		{
			pass = false;
		}
		for (int counter = 0; counter < BASKETS.length; counter++)
		{
			if (id == BASKETS[counter])
			{
				pass = false;
			}
		}
		
		return pass;
	}
	
	public int empty_spaces(Item[] inv)
	{
		int empty = 0;
		
		for (int counter = 0;counter < inv.length; counter++)
		{
			if (bad_item(inv[counter].id(), BANANNA, BASKETS))
			{
				empty++;
			}
		}
		
		return empty;
	}
	
	public boolean get_ringmatch(Item thing, int[] choice_tele, String bankchoice)
	{
		boolean fail = false;
		
		if (bankchoice == "Grand Exchange")
		{
			if (thing.id() == choice_tele[4])
			{
				fail = true;
			}
		}
		
		if (bankchoice == "Castle Wars")
		{
			fail = true;
			
			for (int counter = 0; counter < choice_tele.length; counter++)
			{
				if (thing.id() == choice_tele[counter])
				{
					fail = false;
				}
			}
		}
		
		if (bankchoice == "Edgeville")
		{
			fail = false;
		}
		
		return fail;
	}
	
	public boolean get_amuletmatch(Item thing, int id)
	{
		boolean fail = false;
		
		if (thing.id() == id)
		{
			fail = true;
		}
		
		return fail;
	}
}
