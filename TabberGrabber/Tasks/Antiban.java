package needscroll.TabberGrabber.Tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import needscroll.TabberGrabber.Task;

public class Antiban extends Task{
	
	//C:/Users/justi/Desktop/antiban.txt
	
	boolean DONE = false;
	String FILENAME = "";
	String TEXT = "";
	public static String STATUS = "";

	public Antiban(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		int random_chance = (int) (Math.random() * 5000);
		
		if (DONE == false)
		{
			System.out.println("not done");
			init();
			read();
			DONE = true;
		}
		return random_chance < 50;
	}

	@Override
	public void execute() 
	{
		STATUS = "Antiban";
		int random_chance = (int) (Math.random() * 10);
		
		if (random_chance < 7)
		{
			sleep();
		}
		
		if (random_chance >= 7)
		{
			spit();
			Condition.sleep(2000);
		}
		STATUS = "";
	}
	
	private void sleep()
	{
		int random_sleep = (int) (Math.random() * 30000);
		Condition.sleep(random_sleep);
	}

	private void spit()
	{
		String thing = cut(TEXT);
		
		System.out.println(thing);
		ctx.input.sendln("");
		Condition.sleep(3000);
		ctx.input.send(thing);
		Condition.sleep(3000);
		ctx.input.sendln("");
		Condition.sleep(2500);
	}
	
	private String cut(String text)
	{
		int start = (int) (Math.random() * TEXT.length());
		int limit = TEXT.length();
		int end = 0;
		
		while (start + 50 > limit - 30)
		{
			start = (int) (Math.random() * TEXT.length());
		}

		end = start + (int) (Math.random() * 50);
		
		return TEXT.substring(start, end);
	}
	
	private void init()
	{
		FILENAME = JOptionPane.showInputDialog(null, "Enter the path to antiban txt file");
	}
	
		private void read()
	{
		File anti = new File(FILENAME);

		try 
		{
			Scanner scan_i = new Scanner(anti);
			
			while (scan_i.hasNextLine())
			{
				TEXT += scan_i.nextLine();
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("can't find file");
		}
	}
		
	public String get_status()
	{
		return STATUS;
	}
}
