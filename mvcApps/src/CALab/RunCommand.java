package CALab;
import mvc.Command;
import mvc.Model;

public class RunCommand extends Command{
	
	private int cycles; // determines if we use run1 or run50
	
	public RunCommand(Model model, int cycles) {
		super(model);
		this.cycles = cycles;
	}
	
	public void execute() throws Exception {
		if (!(model instanceof Grid)) {
			throw new Exception("Model must instantiate Grid");
		}
		Grid grid = (Grid) model;
		// call method here
	}
	
}
