package CALab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import mvc.*;
/*
Edits:
   Hiba 3/15/24: created file
   
   Adarsh 3/18/24: adjusted actionPerformed() implementation to reflect lecture sample
   
   Hiba 3/15/24: Implemented updateVisuals method to refresh the button's appearance according to the cell's status, color, and border.
                 Enhanced actionPerformed to change cell state upon action and immediately update the button's visuals.
*/
public class CellView extends JButton implements ActionListener, Subscriber {
    private Cell myCell;

    public CellView(Cell c) {
    	super();
        myCell = c;
        if (c != null) { 
        	c.subscribe(this); 
        	updateVisuals();
        	}
        this.addActionListener(this);
    }

    private void updateVisuals() {
    	if (myCell != null) {
            setBackground(myCell.getColor()); 
            setBorder(BorderFactory.createLineBorder(Color.black)); // Set or reaffirm the border color.
            setText("" + myCell.getStatus()); 
        }	
	}

	public CellView() { 
    	this(null); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	 if (myCell != null) {
             myCell.nextState();
             updateVisuals(); 
         }
     }

    // called by notifySubscribers and GridView.update
    @Override
    public void update() {
       updateVisuals();
    }
}