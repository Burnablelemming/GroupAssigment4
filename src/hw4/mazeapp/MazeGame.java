package hw4.mazeapp;

import java.util.Scanner;

import hw4.game.Game;
import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Movement;
import hw4.player.Player;

public class MazeGame {

	/*
	 * DISCLAIMER:
	 * This project contains reference to "Diddy's House" purely for humor and meme-related purposes.
	 * The developers do not endorse or support any real-life actions or allegations associated with Sean "Diddy" Combs.
	 * All uses are fictional, satirical, and meant to enhance the cursed maze energy of the game.
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
		
		System.out.println("You awaken in a dimly lit, oil-slicked corridor - the walls hum with anticipation. "
				+ "Welcome to the Maze of Diddy's House. One way in. Oneway out. Find the exit... or become part of the floor shine.");
		
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
			        game.printGrid(player); // this prints directly to console
			    }
			}
			else if(move == Movement.DOWN) {
				if (game.play(move, player)) {
			        System.out.println("\nMove Successful\n");
			    } else {
			        System.out.println("\nMove Unsuccessful\n");
			        game.printGrid(player); // this prints directly to console
			    }
			}
			else if(move == Movement.LEFT) {
				
				if(player.getCurrentCell().getLeft() != CellComponents.EXIT) {
					// Play like normal
					if (game.play(move, player)) {
				        System.out.println("\nMove Successful\n");
				    } else {
				        System.out.println("\nMove Unsuccessful\n");
				        game.printGrid(player); // this prints directly to console
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
			        game.printGrid(player); // this prints directly to console
			    }
		}
	}
}
}
