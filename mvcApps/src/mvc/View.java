package mvc;

import javax.swing.JPanel;

/*
Edits:
    Adarsh 3/10/24: implemented View (MVC Pattern: finished)
    
    Christopher 3/13/24: added update() (required from implementing Subscriber)
    
    Adarsh 3/14/24: added setModel() method to resolve error in AppPanel class --> UNKNOWN if this is correct implementation
    
 */
public class View extends JPanel implements Subscriber {

    private Model model;
    public void update() {}
    
    public void setModel(Model newModel) {
    	this.model.unsubscribe(this);
    	model = newModel;
    	this.model.subscribe(this);
    }

}
