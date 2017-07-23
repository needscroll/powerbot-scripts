package needscroll.BanannaGrabber;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Gui
{
	private PlayerInput Playerinput; 
	private static JFrame frame = new PlayerInput("Banana Bot");
	
	public Gui() 
	{
	}
	
	public static void isON()
	{	
		frame.setSize(300, 300);
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void closing(boolean closing)
	{
		if (closing)
		{
		frame.dispose();
		}
	}
		
}