package mvc;

/*
Edits:

    Adarsh 3/10/24: implemented AppFactory (MVC Framework: finished)
    
    Adarsh 3/14/24: adjusted getHelp() and getEditCommands() methods to have return type String[]
 */

public interface AppFactory {

    public Model makeModel();

    public View makeView();

    public String getTitle();

    public String[] getHelp();

    public String about();

    public String[] getEditCommands();

    public Command makeEditCommand(String name);
}
