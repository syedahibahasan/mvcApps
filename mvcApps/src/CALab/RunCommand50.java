package CALab;

import mvc.Command;
import mvc.Model;

public class RunCommand50  extends Command{
	
	
	public RunCommand50(Model model) {
		super(model);
	}
	
	public void execute() throws Exception {
		if (!(model instanceof Grid)) {
			throw new Exception("Model must instantiate Grid");
		}
		Grid grid = (Grid) model;
		grid.updateLoop(50);
	}
	
}
