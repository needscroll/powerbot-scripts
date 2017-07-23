package needscroll.BanannaGrabber;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PlayerInput extends JFrame implements ActionListener
{
	static String[] destinations = {"please select one", "Grand Exchange", "Castle Wars", "Edgeville"};
	static String[] choices = {"Gather"}; // add "Unbasket later"
	static JComboBox messageList = new JComboBox(destinations);
	static JComboBox messageList2 = new JComboBox(choices);
	JButton startbutton = new JButton("Start Botting");
	
	JLabel topText = new JLabel("Bank you are using");
	JLabel midText = new JLabel("Collecting? Or Unbasketing?");
	JPanel panel = new JPanel();
	Font font = new Font("SansSerif", Font.PLAIN, 12);
	
	static boolean gotinfo = false;
	
	
	boolean isClosing = false;
	
	//Calls Gui
	Gui closed = new Gui();
	
	
	static String bankLocation;
	static String gatherOrUnBasket;
	
	public PlayerInput(String title)
	{
		super(title);
		
		
		//sets up the GUI user options
		add(panel);
		messageList.setSelectedIndex(0);
		
		//Sets layout
		panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
		
		//Adds buttons and lists
		panel.add(topText);
		panel.add(Box.createRigidArea(new Dimension(0,10)));
		panel.add(messageList);
		panel.add(Box.createRigidArea(new Dimension(0,10)));
		panel.add(midText);
		panel.add(Box.createRigidArea(new Dimension(0,10)));
		panel.add(messageList2);
		panel.add(Box.createRigidArea(new Dimension(0,10)));
		panel.add(startbutton);
		startbutton.setFont(font);
		
		//adds listeners
		messageList.addActionListener(this);
		messageList2.addActionListener(this);
		startbutton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == messageList)
		{
			bankLocation = messageList.getSelectedItem().toString();
			System.out.println(bankLocation);
		}
		if (e.getSource() == messageList2)
		{
			gatherOrUnBasket = messageList2.getSelectedItem().toString();
			System.out.println(gatherOrUnBasket);
		}
		if (e.getSource() == startbutton)
		{
			isClosing = true;
			gotinfo = true;
			closed.closing(isClosing);
		}
		
	}

	
	
	
	
	
}