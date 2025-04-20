package hw4.maze;

import java.util.ArrayList;

/**
 * Represents a single row in the maze.
 * A row is composed of a list of Cell objects arranged horizontally within the grid.
 */
public class Row {
	
	private ArrayList<Cell> cells;

	/**
	 * Constructs a Row with the specified list of cells.
	 *
	 * @param cells 		the list of Cell objects in the row
	 */
	public Row(ArrayList<Cell> cells) {
	    this.cells = cells;
	}

	/**
	 * Returns the list of cells in the row.
	 *
	 * @return the list of Cell objects
	 */
	public ArrayList<Cell> getCells() {
		return cells;
	}

	/**
	 * Replaces the current list of cells with the specified list.
	 *
	 * @param cells 		the new list of Cell objects
	 */
	public void setCells(ArrayList<Cell> cells) {
		this.cells = cells;
	}
	
	@Override
	public String toString() {
	    return "Row [cells=" + cells + "]";
	}


}
