package tictactoe;

public class Grid {
	int ROWS = Main.ROWS;
	int COLUMNS = Main.COLUMNS;
	String[][] tacGrid = new String[ROWS][COLUMNS];

	public Grid() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				this.tacGrid[i][j] = null;
			}
		}
	}

	public String[][] getGrid() {
		return this.tacGrid;
	}

	public void markGrid(int x, int y, int playerNumber) {
		if (playerNumber == 0) {
			this.tacGrid[x][y] = " X ";
		} else if (playerNumber == 1) {
			this.tacGrid[x][y] = " Y ";
		}
	}
}
