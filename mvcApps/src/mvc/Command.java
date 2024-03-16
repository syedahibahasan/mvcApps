package mvc;

/*
Edits:

    Adarsh 3/10/24: implemented Command (MVC Pattern: finished)
    
    Hiba 3/10/24: changed the execute method to an abstract type to enforce subclass-specific implementations
    
    Christopher 3/16/24: added Command constructor
 */

public abstract class Command {
    protected Model model;
    
    public Command(Model model) {
    	this.model = model;
    }

    public abstract void execute() throws Exception; // Declare the method as abstract
}
