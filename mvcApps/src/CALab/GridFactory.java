package CALab;
import mvc.*;

/*
 Edits:
 
 Adarsh 3/18/24: created class
 
 */
public abstract class GridFactory implements AppFactory {

	public abstract Model makeModel();

    public View makeView(Model m) {
    	return new GridView(m);
    }

    public String getTitle() {
    	return "Cellular Automata Lab";
    }

    public String[] getHelp() {
    	String[] help = {"Run1 runs the grid once", "Run50 runs the grid 50 times",
    			"Populate updates the state of the cells", "Clear resets the grid"};
    	return help;
    	
    }

    public String about() {
    	return "Cellular Automata model";
    }

    public String[] getEditCommands() {
    	
    	String[] result = {"Run1", "Run50", "Populate", "Clear"};
    	return result;
    }

    public Command makeEditCommand(Model m, String name, Object source) {
    	if (name.equals("Run1")) return new RunCommand(m, 1);
    	if (name.equals("Run50")) return new RunCommand(m, 50);
    	if (name.equals("Populate")) return new PopulateCommand(m);
    	if (name.equals("Clear")) return new ClearCommand(m);
    	return null;
    }
	
}
