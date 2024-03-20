package CALab;

import javax.swing.*;
import mvc.*;
import java.awt.*;

/*
Edits:
   Hiba 3/15/24: created file
   
   Hiba:3/20/24: Implemented GridView to display a grid layout corresponding to the dimensions of the model's grid. 
   				 Initialized and populated CellView for each cell in the grid.
*/

public class GridView extends View {

    private CellView cellViews[][];
    protected Grid model;

    public GridView(Model model) {
        super(model);
        this.model = (Grid) model; 
        setLayout(new GridLayout(Grid.dim, Grid.dim)); 

        // Initialize cellViews with the dimensions of the grid
        cellViews = new CellView[Grid.dim][Grid.dim];
        
        // Populate cellViews with CellView objects
        for (int i = 0; i < Grid.dim; i++) {
            for (int j = 0; j < Grid.dim; j++) {
                Cell cell = this.model.getCell(i, j);
                cellViews[i][j] = new CellView(cell);
                add(cellViews[i][j]); // Add CellView to the GridView
            }
        } 
    }
    

    public void update() {
        // call update method of each CellView
    	for (int i = 0; i < cellViews.length; i++) {
            for (int j = 0; j < cellViews[i].length; j++) {
                cellViews[i][j].update();
            }
        }
    }
}