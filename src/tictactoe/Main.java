package tictactoe;

import java.util.Scanner;

// TIC TAC TOE game java practice from scratch by Alex Huang
public class Main {
	static final int ROWS = 3;
	static final int COLUMNS = 3;
	
	public static boolean winCheck(String[][] grid) {

		for (int i = 0; i < ROWS; i++) { // check rows
			if (grid[i][0] == grid[i][1] && grid[i][2] == grid[i][1] && grid[i][0] != null) {
				return true;
			}
		}

		for (int j = 0; j < COLUMNS; j++) { // check columns
			if (grid[0][j] == grid[1][j] && grid[1][j] == grid[2][j] && grid[0][j] != null) {
				return true;
			}
		}

		if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != null) {
			return true;
		}

		if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] != null) {
			return true;
		}
		return false;
	}
	
	public static void drawBoard(String[][] grid) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid[i][j] != null) {
					System.out.print(grid[i][j]);
				} else {
					System.out.print(" - ");
				}
				if (j == 2) {
					System.out.print("\n");
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO: refactoring, extensibility, clarity
		Scanner keyboard = new Scanner(System.in);
		System.out.println("TIC TAC TOE");
		System.out.println("P1 Name: ");
		Grid tacGrid = new Grid();
		String p1Name = keyboard.nextLine();
		Player p1 = new Player(0, p1Name, 0);
		System.out.println("P2 Name: ");
		String p2Name = keyboard.nextLine();
		Player p2 = new Player(0, p2Name, 1);
		String[][] grid;
		Player p = p1;
		while (true) {
			System.out.println(p.getName() + "- wins:" + p.getWins());
			System.out.println("");
			String inputCommand = keyboard.nextLine();
			String[] commandsXY = inputCommand.split(",");
			int x = Integer.parseInt(commandsXY[0]);
			int y = Integer.parseInt(commandsXY[1]);
			tacGrid.markGrid(x, y, p.getPlayerNumber());
			drawBoard(tacGrid.getGrid());
			

			if (winCheck(tacGrid.getGrid()) == true) {
				p.setWins();
				tacGrid = new Grid();
				System.out.print("Player: " + p.getName() + " has won this round, board restarted");
			}

			if (p == p1) { //player turn switch
				p = p2;
			} else if (p == p2) {
				p = p1;
			}
		}
	}

}
