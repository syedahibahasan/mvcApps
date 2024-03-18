package CALab;

import mvc.Command;
import mvc.Model;

/*
Edits: 

3/18/24, Adarsh: created file

 */

public class ClearCommand extends Command {
	
	public ClearCommand(Model model) {
		super(model);
	}
	
	public void execute() throws Exception {
		if (!(model instanceof Grid)) {
			throw new Exception("Model must instantiate Grid");
		}
		Grid grid = (Grid) model;
		// call method here
	}
}
