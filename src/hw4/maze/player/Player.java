package hw4.maze.player;

public class Player {
	
	private int currentRow;
	private int currentCell;
	
	public Player(int currentRow, int currentCell) {
		this.currentRow = currentRow;
		this.currentCell = currentCell;
	}

	public int getCurrentRow() {
		return currentRow;
	}

	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}

	public int getCurrentCell() {
		return currentCell;
	}

	public void setCurrentCell(int currentCell) {
		this.currentCell = currentCell;
	}

	@Override
	public String toString() {
		return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
	}
	
	
	
	

}
