package mvc;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/*
Edits:
   Hiba 3/5/24: created file
   
   Hiba 3/5/24: : implemented AppPanel (MVC Pattern: finished)
*/

public class AppPanel extends JPanel implements ActionListener, PropertyChangeListener {

    private Model model;
    private View view;

    // Constructor
    public AppPanel(Model model, View view) {
        this.model = model;
        this.view = view;
        model.addPropertyChangeListener(this);

        initializeUI();
    }

    // Method to set up the UI components
    private void initializeUI() {
        // Set layout and add components
        setLayout(new BorderLayout());
        // ... add buttons, text fields, etc.
    }

 // Method from ActionListener interface
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle action events from the control panel or menus
    }


    // Method from PropertyChangeListener interface
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Handle property change events from the model
    }
}

