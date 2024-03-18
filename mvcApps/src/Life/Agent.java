package Life;
import CALab.Cell;

/*
 * Christopher Vu 3/17/24: Created Life package, added Agent.java
 */

public class Agent extends Cell {
	int status = 0;
	int ambience = 8;
	
	public void update() {
		
	}
	
	public void observe() {
		
	}
	
	protected int getStatus() {
		return status;
	}
	
	public void interact() {}
	
	public void reset(boolean randomly) {}
	
	public void nextState() {}

}
