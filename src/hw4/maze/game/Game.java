package hw4.maze.game;

import java.util.ArrayList;

public class Game {
	
	private Grid grid;

	public Game(Grid grid) {
		this.grid = grid;
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}
	
	
	public Grid createRandomGrid(int size) {
		// Invalid size of grid
		if(size < 3 || size > 7) {
			return null;
		}
		
		List<Cell> cells = new ArrayList<Cell>();
		List<Row> rows = new ArrayList<Row>();
		
		
		// Initialize a Grid of all walled off cells
		for (int i = 0; i < size; i++) {
			
			for(int j = 0; i < size; j++) {
				// All cells walled off by default
				cells.add(new Cell(WALL, WALL, WALL, WALL));
			}
			
			// Wrap cell list in Row class
			rows.add(new Row(cells));
		}
		
		// Create empty grid
		grid = new Grid(rows);
		
		
	}
	
	private cell getCellAt(int row, int col) {
		return grid.getRows().get(row).getCells().get(col);
	}

}
