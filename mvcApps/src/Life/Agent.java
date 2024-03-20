package Life;
import CALab.Cell;

import java.awt.Color;
import java.lang.Math;
import java.util.*;
/*
 * Christopher Vu 3/17/24: Created Life package, added Agent.java
 * 
 * Christopher Vu 3/18/24: implemented update(), observe(), and interact()
 * 
 * Christopher Vu 3/20/24: implemented nextState() and reset, also added constructors
 * 
 * Christopher Vu 3/20/24: getColor() is customized to Agent
 */

public class Agent extends Cell {
	// status == 0 is dead, == 1 is alive
	private int status = 0;
	// observe() updates ambience to this Agent's total number of neighbors that are alive
	private int ambience = 8;
	
	public Agent() {
		
	}
	public Agent(int status, int ambience) {
		this.status = status;
		this.ambience = ambience;
	}
	
	public void update() {
		if (Society.rebirth.contains(ambience)) {
			status = 1; 
		} else if (Society.death.contains(ambience)) {
			status = 0;
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
		if (randomly) {
			double rand = Math.random();
			if (rand > 0.499) {
				status = 1;
			} else {
				status = 0;
			}
		} else {
			status = 0;
		}
	}
	
	public void nextState() {
		if (this.status == 0) {
			this.status = 1;
		} else {
			this.status = 0;
		}
	}
	
	public Color getColor() {
		//Implement logic to return a color based on the cell's state
		return this.getStatus() == 1 ? Color.GREEN : Color.RED;
	}
}
