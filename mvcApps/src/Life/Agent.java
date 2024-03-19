package Life;
import CALab.Cell;
import java.lang.Math;
import java.util.*;
/*
 * Christopher Vu 3/17/24: Created Life package, added Agent.java
 * 
 * Christopher Vu 3/18/24: implemented update(), observe(), and interact()
 */

public class Agent extends Cell {
	// status == 0 is dead, == 1 is alive
	private int status = 0;
	// observe() updates ambience to this Agent's total number of neighbors that are alive
	private int ambience = 8;
	
	public void update() {
		if (Society.rebirth.contains(this.ambience)) {
			this.status = 1; 
		} else if (Society.death.contains(this.ambience)) {
			this.status = 0;
		}
	}
	
	public void observe() {
		int result = 0;
		Iterator<Cell> neighbor = this.neighbors.iterator();
		while(neighbor.hasNext()) {
			if (( (Agent) neighbor).getStatus() == 1) {
				result++;
			}
		}
		ambience = result;
	}
	
	protected int getStatus() {
		return status;
	}
	
	// "interaction phase is empty (i.e., a no-op)" - Dr. Pearce
	public void interact() {}
	
	public void reset(boolean randomly) {
		
	}
	
	public void nextState() {}

}
