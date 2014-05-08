package rubinstein.tictactoe;


public class TicTacToeBoard {
	private final Symbol[][] board;
	private final Location[][] loc;

	public TicTacToeBoard() {
		this.board = new Symbol[3][3];
		this.loc = new Location[3][3];

	}

	public void reset() {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				board[i][j] = null;
			}
		}
	}

	public boolean isFull() {
		boolean isFull = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == null) {
					isFull = false;
				}
			}
		}
		return isFull;
	}

	public void setSquare(Location loc, Symbol sym) {
		board[loc.getY()][loc.getX()] = sym;
	}

	public Symbol setSquare(int x, int y, char sym) {
		Symbol s = Symbol.valueOf(sym);
		return board[y - 1][x - 1] = s;
	}

	public Symbol getSquare(Location loc) {
		int x = loc.getX();
		int y = loc.getY();
		return board[y][x];
	}

	public Symbol getSquare(int x, int y) {
		int locX = x - 1;
		int locY = y - 1;
		return board[locX][locY];
	}

	@Override
	public String toString() {
		StringBuilder theBoard = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == null) {
					theBoard.append(" \t");
				} else {
					theBoard.append(board[i][j] + "\t");
				}
			}
			theBoard.append("\n" + "\n");
		}
		return theBoard.toString();
	}

	public Symbol[][] getBoard() {
		return board;
	}
}
