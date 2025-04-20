package hw4.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Movement;
import hw4.player.Player;

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
		
		//ArrayList<Cell> cells = new ArrayList<Cell>();
		ArrayList<Row> rows = new ArrayList<Row>();
		
		
		// Initialize a Grid of all walled off cells
		for (int i = 0; i < size; i++) {
			ArrayList<Cell> cells = new ArrayList<Cell>();
			for(int j = 0; j < size; j++) {
				// All cells walled off by default
				cells.add(new Cell(CellComponents.WALL, CellComponents.WALL, CellComponents.WALL, CellComponents.WALL));
			}
			
			// Wrap cell list in Row class
			rows.add(new Row(cells));
		}
		
		grid = new Grid(rows);
		
		// Drunkard's walk path carving algorithm
		
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
			
			if(direction.equals("UP")) {
				getCellAt(row, col).setUp(CellComponents.APERTURE);
				getCellAt(row - 1, col).setDown(CellComponents.APERTURE);
				row--;
			} else if(direction.equals("LEFT")) {
				getCellAt(row, col).setLeft(CellComponents.APERTURE);
				getCellAt(row, col - 1).setRight(CellComponents.APERTURE);
				col--;
			} else if(direction.equals("DOWN")) {
				getCellAt(row, col).setDown(CellComponents.APERTURE);
				getCellAt(row + 1, col).setUp(CellComponents.APERTURE);
				row++;
			} else if(direction.equals("RIGHT")) {
				getCellAt(row, col).setRight(CellComponents.APERTURE);
				getCellAt(row, col + 1).setLeft(CellComponents.APERTURE);
				col++;
			}
		}
		
		// Set the exit
		getCellAt(0, 0).setLeft(CellComponents.EXIT);
		
		return grid;
	}
	
	public boolean play(Movement direction, Player player) {
		
		if(player != null) {
			
			int row = grid.getRows().indexOf(player.getCurrentRow());
			int col = player.getCurrentRow().getCells().indexOf(player.getCurrentCell());
			
			if(direction == Movement.UP) {
				if(player.getCurrentCell().getUp() == CellComponents.APERTURE) {
					// For grid view implementation add a member to change the previous current cell to 'S'
					// and update the new current cell to 'A'
					row--;
					player.setCurrentRow(grid.getRows().get(row));
					player.setCurrentCell(getCellAt(row, col));
					printGrid(player);
					return true;
				} 
				
				else {
					return false;
				}	
			} else if(direction == Movement.LEFT) {
				if(player.getCurrentCell().getLeft() == CellComponents.APERTURE) {
					// For grid view implementation add a member to change the previous current cell to 'S'
					// and update the new current cell to 'A'
					col--;
					//player.setCurrentRow(grid.getRows().get(row));
					player.setCurrentCell(getCellAt(row, col));
					printGrid(player);
					return true;
				} else if(player.getCurrentCell().getLeft() == CellComponents.EXIT) {
					// Player escaped
					System.out.println("Player has escaped Diddy's House... With only stains of baby oil present.");
					printGrid(player);
					return true;
				}
				else {
					return false;
				}
			} else if(direction == Movement.DOWN) {
				if(player.getCurrentCell().getDown() == CellComponents.APERTURE) {
					// For grid view implementation add a member to change the previous current cell to 'S'
					// and update the new current cell to 'A'
					row++;
					player.setCurrentRow(grid.getRows().get(row));
					player.setCurrentCell(getCellAt(row, col));
					printGrid(player);
					return true;
				} 
				
				else {
					return false;
				}
			} else if(direction == Movement.RIGHT) {
				if(player.getCurrentCell().getRight() == CellComponents.APERTURE) {
					// For grid view implementation add a member to change the previous current cell to 'S'
					// and update the new current cell to 'A'
					col++;
					player.setCurrentRow(grid.getRows().get(row));
					player.setCurrentCell(getCellAt(row, col));
					printGrid(player);
					return true;
				} 
				
				else {
					return false;
				}
			}
		}
		// player null
		return false;
	}
	private Cell getCellAt(int row, int col) {
		return grid.getRows().get(row).getCells().get(col);
	}
	
	public void printGrid(Player player) {
	    for (int i = 0; i < grid.getRows().size(); i++) {
	        Row row = grid.getRows().get(i);
	        for (int j = 0; j < row.getCells().size(); j++) {
	            Cell cell = row.getCells().get(j);
	            
	            if (player.getCurrentRow() == row && player.getCurrentCell() == cell) {
	                System.out.print("A ");
	            } else if (j == 0 && cell.getLeft() == CellComponents.EXIT) {
	                System.out.print("E ");
	            } else {
	                System.out.print("S ");
	            }
	        }
	        System.out.println();
	    }
	}

}
