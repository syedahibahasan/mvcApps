package CALab;

import java.awt.*;
import javax.swing.*;
import mvc.*;
import Life.*;

/*
Edits:
   Hiba 3/15/24: created file
   
   Hiba 3/20/24: Integrated GridView into GridPanel for display.
*/


public class GridPanel extends AppPanel{
	
	private JButton run1;
	private JButton run50;
	private JButton populate;
	private JButton clear;
	
	public GridPanel(AppFactory factory) {
		super(factory);
	    View gridView = factory.makeView(model);
	    add(gridView); 
	 
		run1 = new JButton("Run 1");
		run1.addActionListener(this);
		run50 = new JButton("Run 50");
		run50.addActionListener(this);
		populate = new JButton("Populate");
		populate.addActionListener(this);
		clear = new JButton("Clear");
		clear.addActionListener(this);
		
		controlPanel.add(run1);
		controlPanel.add(run50);
		controlPanel.add(populate);
		controlPanel.add(clear);
		
		
	}
	
}
