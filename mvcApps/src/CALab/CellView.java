package CALab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import mvc.*;
/*
Edits:
   Hiba 3/15/24: created file
*/


public class CellView extends JButton implements ActionListener, Subscriber {
    private Cell myCell;

    public CellView(Cell c) {
        myCell = c;
        if (c != null) { c.subscribe(this); }
        this.addActionListener(this);
    }

    public CellView() { this(null); }

    @Override
    public void actionPerformed(ActionEvent e) {
        myCell.nextState();
        // call update needed?
    }

    // called by notifySubscribers and GridView.update

    @Override
    public void update() {
        setBackground(myCell.getColor());
        setBorder(BorderFactory.createLineBorder(Color.black)); // needed?
        setText("" + myCell.getStatus());
    }
}