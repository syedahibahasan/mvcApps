package CALab;
import mvc.Command;
import mvc.Model;

/*
Edits: 

Adarsh 3/18/24: created file

Adarsh 3/19/24: fixed constructor

Adarsh 3/19/24: finished execute() method

 */

public class RunCommand extends Command{
	
	private int numRuns; // determines if we use run1 or run50
	
	public RunCommand(Model model, int numRuns) {
		super(model);
		this.numRuns = numRuns;
	}
	
	public void execute() throws Exception {
		if (!(model instanceof Grid)) {
			throw new Exception("Model must instantiate Grid");
		}
		Grid grid = (Grid) model;
		grid.updateLoop(numRuns);
	}
	
}
