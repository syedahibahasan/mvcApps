package mvc;

import CALab.Cell; 
import javax.swing.*;
import java.awt.*;
/*
Edits:
* 	Hiba 3/5/24: created file
* 
    Adarsh 3/10/24: implemented View (MVC Pattern: finished)
    
    Christopher 3/13/24: added update() (required from implementing Subscriber)
    
    Adarsh 3/14/24: added setModel() method to resolve error in AppPanel class --> UNKNOWN if this is correct implementation
    
    Hiba 3/14/24: Integrated the View with the Model's publisher-subscriber mechanism. Adapted cell initialization to utilize 
    model.makeCell(i, j) for creating Cell instances. Implemented cellClicked method to invoke Cell's state change and notification 
    logic. Updated the update method to refresh the View based on Cell state changes notified by the Model. Ensured View subscribes 
    to both Model and individual Cells for state changes. Added logic to setModel for subscribing to a new Model.

    
 */
public class View extends JPanel implements Subscriber {

    private Model model;
    private Cell[][] cells; 

    public View(Model model, int rows, int cols) {
        this.model = model;
        model.subscribe(this); 
        initializeComponents(rows, cols);
    }

    private void initializeComponents(int rows, int cols) {
        setLayout(new GridLayout(rows, cols)); // GridLayout for the cells
        cells = new Cell[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Assumes makeCell() is a method that correctly instantiates Cell objects
                cells[i][j] = model.makeCell(i, j); // You need to cast if makeCell() returns a type other than Cell
                Cell cell = cells[i][j];
                cell.subscribe(this); // Subscribe to individual cell changes
                JButton button = new JButton();
                button.addActionListener(e -> cellClicked(cell));
                add(button);
                // Keep a reference to the button in Cell if necessary or maintain a mapping if needed.
            }
        }
    }

    // Method to handle cell clicks
    private void cellClicked(Cell cell) {
        cell.nextState(); 
        cell.notifySubs(); 

    }

    // Subscriber update method
    @Override
    public void update() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j].update(); 
            }
        }
    }

    public void setModel(Model newModel) {
        if (this.model != null) {
            this.model.unsubscribe(this);
        }
        this.model = newModel;
        if (this.model != null) {
            this.model.subscribe(this);
            update(); 
        }
    }
}