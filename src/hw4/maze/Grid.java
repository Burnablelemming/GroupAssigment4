package hw4.maze;

import java.util.ArrayList;

/**
 * Represents maze structure, composed of multiple Row objects.
 * Each Row contains a list of Cells, forming an NxN maze.
 */
public class Grid {
	
	private ArrayList<Row> rows;

	/**
	 * Constructs a Grid with the specified list of rows.
	 *
	 * @param rows 			the list of Row objects representing the grid
	 */
	public Grid(ArrayList<Row> rows) {
	    this.rows = rows;
	}

	/**
	 * Returns the list of rows in the grid.
	 *
	 * @return the list of Row objects
	 */
	public ArrayList<Row> getRows() {
	    return rows;
	}

	/**
	 * Replaces the current list of rows with the specified list.
	 *
	 * @param rows 			the new list of Row objects
	 */
	public void setRows(ArrayList<Row> rows) {
	    this.rows = rows;
	}

	@Override
	public String toString() {
	    return "Grid [rows=" + rows + "]";
	}

}
