package Life;
import CALab.*;
import mvc.*;

public class LifeFactory extends GridFactory {
	
	
	public Model makeModel() {
	
		return new Society();
		
	}
	
}
