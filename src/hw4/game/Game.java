package hw4.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;

public class Game {
	
	private Grid grid;

	public Game(Grid grid) {
		this.grid = grid;
	}
	
	public Game(int size) {
		this.grid = createRandomGrid(size);
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
		
		ArrayList<Cell> cells = new ArrayList<Cell>();
		ArrayList<Row> rows = new ArrayList<Row>();
		
		
		// Initialize a Grid of all walled off cells
		for (int i = 0; i < size; i++) {
			
			for(int j = 0; j < size; j++) {
				// All cells walled off by default
				cells.add(new Cell(CellComponents.WALL, CellComponents.WALL, CellComponents.WALL, CellComponents.WALL));
			}
			
			// Wrap cell list in Row class
			rows.add(new Row(cells));
		}
		
		grid = new Grid(rows);
		
		// Drunkard walk path carving algorithm
		
		// Start at the bottom right of the grid
		int row = size - 1;
		int col = size - 1;
		
		Random rand = new Random();
		
		while(row > 0 || col > 0) {
			List<String> directions = new ArrayList<>();
			
			if(row > 0) {
				directions.add("UP");
			}
			
			if(col > 0) {
				directions.add("LEFT");
			}
			
			// Additional carving options maze options
			if(row < size - 1) {
				directions.add("DOWN");
			}
			
			if(col < size - 1) {
				directions.add("RIGHT");
			}
			
			String direction = directions.get(rand.nextInt(directions.size()));
			
			if(directions.equals("UP")) {
				getCellAt(row, col).setUp(CellComponents.APERTURE);
				getCellAt(row - 1, col).setDown(CellComponents.APERTURE);
				row--;
			} else if(direction.equals("LEFT")) {
				getCellAt(row, col).setLeft(CellComponents.APERTURE);
				getCellAt(row, col - 1).setRight(CellComponents.APERTURE);
				col--;
			} else if(directions.equals("DOWN")) {
				getCellAt(row, col).setDown(CellComponents.APERTURE);
				getCellAt(row + 1, col).setUp(CellComponents.APERTURE);
				row++;
			} else if(directions.equals("RIGHT")) {
				getCellAt(row, col).setRight(CellComponents.APERTURE);
				getCellAt(row, col + 1).setLeft(CellComponents.APERTURE);
				col++;
			}
		}
		
		// Set the exit
		getCellAt(0, 0).setLeft(CellComponents.EXIT);
		
		return grid;
		
	}
	
	private Cell getCellAt(int row, int col) {
		return grid.getRows().get(row).getCells().get(col);
	}

}
