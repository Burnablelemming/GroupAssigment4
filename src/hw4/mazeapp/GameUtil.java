package hw4.mazeapp;

import java.util.Scanner;

import hw4.player.Movement;

/**
 * Utility Class for handling user input in the Maze Game.
 * 
 * Provides helper methods for reading and validating the maze size 
 * and movement directions from the user.
 */
public class GameUtil {
	
	/**
	 * Prompts the user to enter a valid maze size between 3 and 7.
	 * Will continue prompting until a valid integer within range is recieved.
	 * 
	 * @param scanner the Scanner object used to read user input
	 * @return a valid integer size (3-7 inclusive)
	 */
    public static int getGridSize(Scanner scanner) {
        int size = 0;
        while (size < 3 || size > 7) {
            System.out.print("Enter maze size (3–7): ");
            if (scanner.hasNextInt()) {
                size = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (size < 3 || size > 7) {
                    System.out.println("Size must be between 3 and 7.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // clear invalid input
            }
        }
        return size;
    }
    
    /**
     * Prompts the user to enter a movement direction.
     * Accepts only "UP", "DOWN", "LEFT", or "RIGHT" (case-insensitive).
     * Will continue prompting until a valid Movement enum is provided.
     * 
     * @param scanner the Scanner object used to read user input
     * @return a valid Movement enum
     */
    public static Movement getMove(Scanner scanner) {
    	while(true) {
    		System.out.println("Enter direction (UP, DOWN, LEFT, RIGHT): ");
    		String move = scanner.nextLine().trim().toUpperCase();
    		
    		try {
    			return Movement.valueOf(move);
    		} 
    		catch(IllegalArgumentException e) {
    			System.out.println("Invalid direction. Try again.");
    		}
    	}
    }
}
