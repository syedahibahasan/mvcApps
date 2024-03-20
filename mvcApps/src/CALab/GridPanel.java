package CALab;

import java.awt.*;
import javax.swing.*;

import mvc.*;
import Life.*;


public class GridPanel extends AppPanel{
	
	private JButton thing;
	
	public GridPanel(AppFactory factory) {
		super(factory);
	}
	
	public static void main(String[] args) {
		AppFactory factory = new LifeFactory();
		AppPanel panel = new GridPanel(factory);
		panel.display();
	}
}
