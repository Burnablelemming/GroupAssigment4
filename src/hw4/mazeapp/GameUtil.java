package hw4.mazeapp;

import java.util.Scanner;

import hw4.player.Movement;

public class GameUtil {
	
    public static int getGridSize(Scanner scanner) {
        int size = 0;
        while (size < 3 || size > 7) {
            System.out.print("Enter grid size (3–7): ");
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
