package hw4.maze;

/**
 * Represents the possible components on each side of a cell
 * 
 * WALL 		a solid boundary that cannot be passed through
 * APERTURE 	an open space that allows movement
 * EXIT 		the designated exit used to win or escape the grid
 */
public enum CellComponents {
	WALL,
	APERTURE,
	EXIT
}
