package mvc;

import javax.swing.JPanel;

/*
Edits:
    Adarsh 3/10/24: implemented View (MVC Pattern: finished)
    
    Christopher 3/13/24: added update() (required from implementing Subscriber)
 */
public class View extends JPanel implements Subscriber {

    private Model model;
    public void update() {}

}
