package CALab;

import javax.swing.*;
import mvc.*;
import java.awt.*;

/*
Edits:
   Hiba 3/15/24: created file
*/

public class GridView extends View {

    private CellView cellViews[][];
    protected Grid model;

    public GridView(Model model) {
    	super(model);
        /*
        Cell cell = new CellView(((Grid)model).getCell(row, col)
        cellViews[row][col] = cell
        set cell.row and cell.col here
        */
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