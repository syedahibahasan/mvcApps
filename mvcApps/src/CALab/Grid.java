package CALab;

import java.awt.*;
import java.util.*;
import java.io.*;
import mvc.*;

/*
Edits:
   Hiba 3/15/24: created file
   
   Adarsh 3/18/24: implemented populate(), repopulate(), interact(), update()
*/

public abstract class Grid extends Model {
    public static int time = 0;
    public static int dim = 20;
    protected Cell[][] cells;

    public int getDim() { return dim; }
    public int getTime() { return time; }
    public Cell getCell(int row, int col) { return cells[row][col]; }
    public abstract Cell makeCell();


    public Grid(int dim) {
        this.dim = dim;
        cells = new Cell[dim][dim];
        populate();
    }
    public Grid() { this(20); }

    protected void populate() {
    	// 1. use makeCell to fill in cells
        // 2. use getNeighbors to set the neighbors field of each cell
    	for (int i = 0; i < cells.length; i++) {
    		for (int j = 0; j < cells[i].length; j++) {
    			cells[i][j] = makeCell();
    		}
    	}
    	for (int i = 0; i < cells.length; i++) {
    		for (int j = 0; j < cells[i].length; j++) {
    			cells[i][j].neighbors = getNeighbors(cells[i][j], 1);
    		}
    	}
    }

    // called when Populate and clear buttons are clicked
    public void repopulate(boolean randomly) {
    	// randomly set the status of each cell
    	for (int i = 0; i < cells.length; i++) {
        	for (int j = 0; j < cells[i].length; j++) {
        		cells[i][j].reset(randomly);
        	}
        }
        
        // notify subscribers
        notifySubs();
    }


    public Set<Cell> getNeighbors(Cell asker, int radius) {
        /*
        return the set of all cells that can be reached from the asker in radius steps.
        If radius = 1 this is just the 8 cells touching the asker.
        Tricky part: cells in row/col 0 or dim - 1.
        The asker is not a neighbor of itself.
        */
    	Set<Cell> neighbors = new HashSet<Cell>();
    	int centerRow = asker.row;
    	int centerCol = asker.col;
    	for (int dist = 1; dist <= radius; dist++) {
    		for (int row = centerRow - dist; row <= centerRow + dist; row++) {
    			for (int col = centerCol - dist; col <= centerCol + dist; col++) {
    				if (row == centerRow && col == centerCol) continue;
    				//INCOMPLETE
    			}
    		}
    	}
    	
    	return neighbors;
    	
    }


   // cell phases:

    public void observe() {
        // call each cell's observe method and notify subscribers
    	for (int i = 0; i < cells.length; i++) {
    		for (int j = 0; j < cells[i].length; j++) {
    			cells[i][j].observe();
    			update();
    		}
    	}
    }

    public void interact() {
        for (int i = 0; i < cells.length; i++) {
        	for (int j = 0; j < cells[i].length; j++) {
        		cells[i][j].interact();
        		update();
        	}
        }
    }

    public void update() {
        for (int i = 0; i < cells.length; i++) {
        	for (int j = 0; j < cells[i].length; j++) {
        		cells[i][j].update();
        	}
        }
    }

    public void updateLoop(int cycles) {
        observe();
        for (int cycle = 0; cycle < cycles; cycle++) {
            interact();
            update();
            observe();
            time++;
            System.out.println("time = " + time);
        }
    }
}
