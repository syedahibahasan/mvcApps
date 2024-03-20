package CALab;

import java.awt.*;
import javax.swing.*;

import mvc.*;
import Life.*;


public class GridPanel extends AppPanel{
	
	private JButton run1;
	private JButton run50;
	private JButton populate;
	private JButton clear;
	
	public GridPanel(AppFactory factory) {
		super(factory);
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
	
	public static void main(String[] args) {
		AppFactory factory = new LifeFactory();
		AppPanel panel = new GridPanel(factory);
		panel.display();
	}
}
