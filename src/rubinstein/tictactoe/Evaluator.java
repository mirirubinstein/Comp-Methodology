package rubinstein.tictactoe;


import java.util.ArrayList;
import java.util.List;

public class Evaluator {
	TicTacToeBoard tttBoard;
	Symbol[][] board;
	Symbol winner;
	ArrayList<Location> location = new ArrayList<Location>();

	public Evaluator(TicTacToeBoard tttBoard) {
		this.tttBoard = tttBoard;
		this.board = tttBoard.getBoard();
	}

	// constructor that passes in a board

	public void evaluate() {
		// check 3 in a column
		Location loc1, loc2, loc3;
		for (int row = 0; row < 3; row++) {
			int column = 0;
			if ((board[row][column] != null)
					&& (board[row][column + 1] != null)
					&& (board[row][column + 2] != null)
					&& (board[row][column] == board[row][column + 1])
					&& (board[row][column + 1] == board[row][column + 2])) {
				winner = board[row][column];
				loc1 = new Location(column, row);
				loc2 = new Location(column +1, row);
				loc3 = new Location (column +2, row);
				location.add(loc1);
				location.add(loc2);
				location.add(loc3);
			}
		}

		for (int column = 0; column < 3; column++) {// check 3 in a row
			int row = 0;
			if ((board[row][column] != null)
					&& (board[row + 1][column] != null)
					&& (board[row + 2][column] != null)
					&& (board[row][column] == board[row + 1][column])
					&& (board[row + 1][column] == board[row + 2][column])) {
				winner = board[row][column];
				loc1 = new Location(column, row);
				loc2 = new Location(column, row + 1);
				loc3 = new Location (column, row + 2);
				location.add(loc1);
				location.add(loc2);
				location.add(loc3);
			}
		}

		// check diagonal up from left to right
		int both = 0;
		if ((board[both][both] != null) && (board[both + 1][both + 1] != null)
				&& (board[both + 2][both + 2] != null)
				&& (board[both][both] == board[both + 1][both + 1])
				&& (board[both + 1][both + 1] == board[both + 2][both + 2])) {
			winner = board[both][both];
			loc1 = new Location(both, both);
			loc2 = new Location(both + 1, both + 1);
			loc3 = new Location (both + 2, both + 2);
			location.add(loc1);
			location.add(loc2);
			location.add(loc3);
		}
		int a = 2;
		int b = 0;
		if ((board[a][b] != null) && (board[a - 1][b + 1] != null)
				&& (board[a - 2][b + 2] != null)
				&& (board[a][b] == board[a - 1][b + 1])
				&& (board[a - 1][b + 1] == board[a - 2][b + 2])) {
			winner = board[a][b];
			loc1 = new Location(b, a);
			loc2 = new Location(b + 1, a-1);
			loc3 = new Location (b +2, a-2);
			location.add(loc1);
			location.add(loc2);
			location.add(loc3);
		}
		
		
	}

	// scans the board for a winner and the winning squares

	public Symbol getWinner() {
		return winner;
	}

	// returns the winner or null if no winner exists

	
	 public List<Location> getList(){ 
		return location;
		 
		 }
	
	// returns the winning squares or null if there are no winning squares
}
