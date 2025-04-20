package hw4.player;

import hw4.maze.Cell;
import hw4.maze.Row;

/**
 * Represents the player in the maze.
 * Tracks the player's current location by referencing both the current Row and the current Cell within that row.
 */

public class Player {
	
	private Row currentRow;
	private Cell currentCell;
	
	/**
	 * Constructs a Player with the specified current row and cell.
	 *
	 * @param currentRow  		the row in which the player is located
	 * @param currentCell 		the cell within the current row where the player is located
	 */
	public Player(Row currentRow, Cell currentCell) {
		this.currentRow = currentRow;
		this.currentCell = currentCell;
	}

	/**
	 * Returns the player's current row.
	 *
	 * @return the current Row object
	 */
	public Row getCurrentRow() {
		return currentRow;
	}

	/**
	 * Sets the player's current row.
	 *
	 * @param currentRow 		the new Row the player is in
	 */
	public void setCurrentRow(Row currentRow) {
		this.currentRow = currentRow;
	}

	/**
	 * Returns the player's current cell within the current row.
	 *
	 * @return the current Cell object
	 */
	public Cell getCurrentCell() {
		return currentCell;
	}

	/**
	 * Sets the player's current cell.
	 *
	 * @param currentCell 		the new Cell the player is in.
	 */
	public void setCurrentCell(Cell currentCell) {
		this.currentCell = currentCell;
	}

	@Override
	public String toString() {
		return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
	}
	
	
	
	

}
