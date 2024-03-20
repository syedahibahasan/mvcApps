package CALab;
import mvc.Command;
import mvc.Model;

/*
Edits: 

Adarsh 3/18/24: created file

Adarsh 3/19/24: fixed constructor

Adarsh 3/19/24: finished execute() method

 */

public class RunCommand1 extends Command{
	
	
	public RunCommand1(Model model) {
		super(model);
	}
	
	public void execute() throws Exception {
		if (!(model instanceof Grid)) {
			throw new Exception("Model must instantiate Grid");
		}
		Grid grid = (Grid) model;
		grid.updateLoop(1);
	}
	
}
