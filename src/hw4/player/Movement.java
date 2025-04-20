package hw4.player;

/**
 * Represents the four possible movement directions for the player within the maze.
 * 
 * UP    	Moves the player one row up (decreases row index)
 * DOWN  	Moves the player one row down (increases row index)
 * LEFT  	Moves the player one column left (decreases column index)
 * RIGHT 	Moves the player one column right (increases column index)
 */
public enum Movement {
	UP,
	DOWN,
	LEFT,
	RIGHT
}
