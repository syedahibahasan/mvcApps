package Life;
import mvc.*;
import CALab.*;

public class LifePanel extends GridPanel {
	

	public LifePanel(AppFactory factory) {
		super(factory);
	}
	

	public static void main(String[] args) {
		AppFactory factory = new LifeFactory();
		AppPanel panel = new GridPanel(factory);
		panel.display();
	}
}
