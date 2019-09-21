package needscroll.ChickenGrabber.Tasks;

import org.powerbot.script.rt4.ClientContext;

public class Quester extends Action{
	
	public static boolean has_money = false;
	public static boolean has_pirate = false;
	public static boolean has_wine = false;
	public static boolean has_island = false;
	public static boolean has_banana = false;
	public static boolean has_crate = false;
	public static boolean has_apron = false;

	public Quester(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean activate() {
		return !has_apron;
	}

	@Override
	public void execute() {
		if (!has_money)
		{
			get_money();
			has_money = true;
		}
		if (has_money && !has_pirate)
		{
			get_pirate();
		}
		if (has_pirate && !has_island)
		{
			get_island();
		}
		if (has_island && !has_wine)
		{
			get_wine();
		}
		if (has_wine && has_banana)
		{
			get_banana();
		}
		if (has_banana && !has_crate)
		{
			get_crate();
		}
		if (has_crate && has_apron)
		{
			get_apron();
		}
		
		
	}


	private void get_money()
	{
		
	}
	
	private void get_pirate()
	{
		
	}
	
	private void get_island() 
	{
	
	}
	
	private void get_wine()
	{
		
	}
	
	private void get_banana()
	{
		
	}
	
	private void get_crate()
	{
		
	}
	
	private void get_apron() 
	{
		
	}
}
