package hw4.mazeapp;

import java.util.Scanner;

import hw4.game.Game;
import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Movement;
import hw4.player.Player;

/**
 * The MazeGame class launches the interactive console-based 
 * adventure through "diddy's House" - a randomly generated maze.
 * 
 * This cursed maze game challenges the player to navigate from the
 * bottom-right corner of the grid to the only exit at the top-left,
 * indicated by a left-facing exit wall.
 * 
 * Gameplay consists of directional commands (UP, DOWN, LEFT, RIGHT)
 * that move the player ('A') one cell at a time through apertures,
 * until they eventually escape ('E').
 * 
 * DISCLAIMER: This project contains reference to 
 * "Diddy's House" purely for humor and meme-related purposes. The developers
 * do not endorse or support any real-life actions or allegations associated
 * with Sean "Diddy" Combs.
 */
public class MazeGame {

	/**
     * Launches the Maze Game. Initializes the maze, places the player
     * in the bottom-right corner, and begins the input loop to process
     * player movement until the EXIT is reached.
     *
     * @param args command-line arguments (not used)
     */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		boolean hasEsacped;
		int gridSize;
		Game game = null;
		Grid grid = null;
		Player player = null;
		Row startingRow;
		Cell startingCell;
		
		System.out.println("You awaken in a dimly lit, oil-slicked corridor. The walls hum with anticipation. "
				+ "\nWelcome to the Maze of Diddy's House. One way in. One way out. \nFind the exit... or become part of the floor shine.\n");
		
		// Initialize game
		boolean hasEscaped = false;
		gridSize = GameUtil.getGridSize(scanner);
		game = new Game(gridSize);
		grid = game.getGrid();
		
		// Put player in the bottom right of the maze
		startingRow = grid.getRows().get(gridSize - 1);
		startingCell = startingRow.getCells().get(gridSize - 1);
		player = new Player(startingRow, startingCell);
		
		System.out.println("\nGOOD LUCK! (You are 'A' and 'E' is the exit)\n");
		game.printGrid(player);
		
		while(!hasEscaped) {
			Movement move = GameUtil.getMove(scanner);
			
			if(move == Movement.UP) {
				if (game.play(move, player)) {
			        System.out.println("\nMove Successful\n");
			    } else {
			        System.out.println("\nMove Unsuccessful\n");
			        game.printGrid(player); 
			    }
			}
			else if(move == Movement.DOWN) {
				if (game.play(move, player)) {
			        System.out.println("\nMove Successful\n");
			    } else {
			        System.out.println("\nMove Unsuccessful\n");
			        game.printGrid(player); 
			    }
			}
			else if(move == Movement.LEFT) {
				
				if(player.getCurrentCell().getLeft() != CellComponents.EXIT) {
					// Play like normal
					if (game.play(move, player)) {
				        System.out.println("\nMove Successful\n");
				    } else {
				        System.out.println("\nMove Unsuccessful\n");
				        game.printGrid(player); 
				    }
				}
				else {
					game.play(move, player);
					hasEscaped = true;
				}
			}
			else if(move == Movement.RIGHT) {
				if (game.play(move, player)) {
			        System.out.println("\nMove Successful\n");
			    } else {
			        System.out.println("\nMove Unsuccessful\n");
			        game.printGrid(player); 
			    }
		}
	}
}
}
