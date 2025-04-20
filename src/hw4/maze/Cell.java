package hw4.maze;

public class Cell {
	
	private CellComponents left;
	private CellComponents right;
	private CellComponents up;
	private CellComponents down;

	public Cell(CellComponents left, CellComponents right, CellComponents up, CellComponents down) {
		
		this.setLeft(left);
		this.setRight(right);
		this.setUp(up);
		this.setDown(down);
	}
	

	public CellComponents getLeft() {
		return left;
	}

	public void setLeft(CellComponents left) {
		if (left != null) {
		    this.left = left;
		} else {
		    this.left = CellComponents.WALL;
		}
	}

	public CellComponents getRight() {
		return right;
	}

	public void setRight(CellComponents right) {
		if (right != null) {
		    this.right = right;
		} else {
		    this.right = CellComponents.WALL;
		}
	}

	public CellComponents getUp() {
		return up;
	}

	public void setUp(CellComponents up) {
		if (up != null) {
		    this.up = up;
		} else {
		    this.up = CellComponents.WALL;
		}
	}

	public CellComponents getDown() {
		return down;
	}

	public void setDown(CellComponents down) {
		if (down != null) {
		    this.down = down;
		} else {
		    this.down = CellComponents.WALL;
		}
	}
	
	@Override
	public String toString() {
	    return "Cell [left=" + left + ", right=" + right + ", up=" + up + ", down=" + down + "]";
	}
}
