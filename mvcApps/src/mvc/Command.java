package mvc;

/*
Edits:

    Adarsh 3/10/24: implemented Command (MVC Pattern: finished)
    
    Hiba 3/10/24: changed the execute method to an abstract type to enforce subclass-specific implementations

 */

public abstract class Command {
    protected Model model;

    public abstract void execute() throws Exception; // Declare the method as abstract
}
