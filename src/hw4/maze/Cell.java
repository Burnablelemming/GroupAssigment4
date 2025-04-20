package hw4.maze;

/**
 * Represents a single cell in the grid. 
 * Each cell has four directional components: left, right, up, and down.
 * Each component is of type CellComponent and represent either a WALL, APERTURE, or EXIT.
 * Null inputs default to WALL.
 */
public class Cell {
	
	private CellComponents left;
	private CellComponents right;
	private CellComponents up;
	private CellComponents down;

	/**
	 * Constructs a new Cell with the given directional components.
	 * If any component is null, it defaults to WALL
	 *  
	 * @param left  	the left side component of the cell
	 * @param right 	the right side component of the cell
	 * @param up    	the upper side component of the cell
	 * @param down  	the bottom side component of the cell
	 */
	public Cell(CellComponents left, CellComponents right, CellComponents up, CellComponents down) {
		
		this.setLeft(left);
		this.setRight(right);
		this.setUp(up);
		this.setDown(down);
	}
	
	/**
	 * Returns the left component of the cell.
	 *
	 * @return the left component
	 */
	public CellComponents getLeft() {
		return left;
	}

	/**
	 * Sets the left component.
	 * If left is null, defaults to WALL.
	 *
	 * @param left 		the component to set for the left side
	 */
	public void setLeft(CellComponents left) {
		if (left != null) {
		    this.left = left;
		} else {
		    this.left = CellComponents.WALL;
		}
	}

	/**
	 * Returns the right component of the cell.
	 *
	 * @return the right component
	 */
	public CellComponents getRight() {
		return right;
	}

	/**
	 * Sets the right component.
	 * If right is null, defaults to WALL.
	 *
	 * @param right 	the component to set for the right side
	 */
	public void setRight(CellComponents right) {
		if (right != null) {
		    this.right = right;
		} else {
		    this.right = CellComponents.WALL;
		}
	}

	/**
	 * Returns the upper component of the cell.
	 *
	 * @return the up component
	 */
	public CellComponents getUp() {
		return up;
	}

	/**
	 * Sets the upper component.
	 * If up is null, defaults to WALL.
	 *
	 * @param up 		the component to set for the upper side
	 */
	public void setUp(CellComponents up) {
		if (up != null) {
		    this.up = up;
		} else {
		    this.up = CellComponents.WALL;
		}
	}

	/**
	 * Returns the bottom component of the cell.
	 *
	 * @return the down component
	 */
	public CellComponents getDown() {
		return down;
	}

	/**
	 * Sets the bottom component.
	 * If down is null, defaults to WALL.
	 *
	 * @param down 		the component to set for the bottom side
	 */
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
