package mvc;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
Edits:
   Hiba 3/5/24: created file
   
   Hiba 3/5/24: : implemented AppPanel (MVC Pattern: finished)
   
   Christopher 3/13/24: Now implements Subscriber in addition to ActionListener. Neither
   	uses PropertyChangeListener nor JavaBean anymore (due to revised specifications). Added
   	update(), modified AppPanel constructor according to Pub-Sub, added to actionPerformed
   	and error handling
   	
*/

public class AppPanel extends JPanel implements Subscriber, ActionListener {

    private Model model;
    private View view;

    // Constructor
    public AppPanel(Model model, View view) {
        this.model = model;
        this.view = view;
        model.subscribe(this);

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
    public void actionPerformed(ActionEvent ae) {
    	try {
	     // handle control actions here
	   	} catch (Exception e) {
	   		handleException(e);
	   	}
    }
    
    protected void handleException(Exception e) {
    	Utilities.error(e);
	}
    
    public void update() {}
}

