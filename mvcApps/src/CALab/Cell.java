package CALab;

import java.util.*;
import java.awt.Color;
import java.io.*;
import mvc.*;
/*
Edits:
   Hiba 3/15/24: created file, added getStatus & getColor Methods 
*/

public abstract class Cell extends Publisher implements Serializable {

    protected int row = 0, col = 0;
    protected Set<Cell> neighbors = new HashSet<Cell>();
    protected Grid myGrid = null;
    protected Cell partner = null;


    // choose a random neighbor as a partner
    public void choosePartner() {
        if (partner == null && neighbors != null) {
			/*
			Set partner to null
			Convert neighbors set to a local array
			Starting at a random position in the array search for a neighbor without a partner
			Make the first such neighbor (if any) the partner and set its partner field to this
			*/
        	partner = null;
        	Cell[] neighborArray = (Cell[]) neighbors.toArray();
        	int start = (int)(Math.random() * neighborArray.length);
        	int index = start; // start at "start"
        	Cell curr;
        	while (index < neighborArray.length) {
        		curr = neighborArray[index];
        		if (curr.partner == null) {
        			curr.partner = this;
        			this.partner = curr;
        			return;
        		}
        		index++;
        	}
        	index = 0;
        	while (index < start) {
        		curr = neighborArray[index];
        		if (curr.partner == null) {
        			curr.partner = this;
        			this.partner = curr;
        			return;
        		}
        		index++;
        	}
		}

    }
    

    public void unpartner() {
        if (partner != null) {
            if (partner.partner != null) {
                partner.partner = null;
            }
            partner = null;
        }
    }

    // observer neighbors' states
    public abstract void observe();
    // interact with a random neighbor
    public abstract void interact();
    // update my state
    public abstract void update();
    // set status to a random or initial value
    public abstract void reset(boolean randomly);
    //get status
	protected abstract int getStatus();
    // set status to status + 1 mod whatever
    public abstract void nextState();
  

	
	protected Color getColor() {
		//Implement logic to return a color based on the cell's state
		return this.getStatus() == 1 ? Color.GREEN : Color.RED;
	}


}