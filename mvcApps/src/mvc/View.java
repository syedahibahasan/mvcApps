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
    
    Christopher 3/16/24: added another constructor as View(Model), (temporarily?) commented out some conflicting
    	procedures related to cells field
    	
    Adarsh 3/17/24: Removed CellView-specific components in this class, making it a general frame work that will be extended by 
    	GridView and CellView
    	
 */

public class View extends JPanel implements Subscriber {

    protected Model model;

    
    public View(Model model) {
    	this.model = model;
    	model.subscribe(this);
    }

    // Subscriber update method
    
    public void update() {}
    
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