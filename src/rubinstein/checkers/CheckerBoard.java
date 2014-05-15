package rubinstein.checkers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This implementation of a game of Checkers should match
 * http://simple.wikipedia.org/wiki/Checkers
 * 
 * How to play Checkers: https://www.youtube.com/watch?v=SuQY1_fCVsA
 */
public class CheckerBoard {

	public static final int WIDTH = 8;
	public static final int HEIGHT = 8;
	private final Piece[][] board;

	public CheckerBoard() {
		this.board = new Piece[HEIGHT][WIDTH];
		// height = y, width = x
	}

	public Piece getPiece(final int x, final int y) {
		return board[y][x];
	}

	public void setPiece(final int x, final int y, final Piece piece) {
		board[y][x] = piece;
	}

	public void removePiece(final int x, final int y) {
		setPiece(x, y, null);
	}

	/**
	 * Returns true if the x,y coordinate is within the 8x8 board, otherwise
	 * false
	 */
	public boolean isOnBoard(final int x, final int y) {// done
		return (x < WIDTH && y < HEIGHT && x > 0 && y > 0);
	}

	/**
	 * Returns true if the square is null, otherwise false
	 */
	public boolean isEmptySquare(final int x, final int y) {// done
		return getPiece(x, y) == null;
	}

	/**
	 * Removes all pieces from the board
	 */
	public void clear() {
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				setPiece(x, y, null);
			}
		}
	}

	/**
	 * Sets the board to a starting configuration
	 */
	public void resetNewGame() {// done
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				if (y % 2 == 0) {
					if (y < 3 && x % 2 == 1) {
						setPiece(x, y, Piece.WHITE_MAN);
					} else if (y > 4 && x % 2 == 1) {
						setPiece(x, y, Piece.RED_MAN);
					} else {
						setPiece(x, y, null);
					}
				} else {
					if (y < 3 && x % 2 == 0) {
						setPiece(x, y, Piece.WHITE_MAN);
					} else if (y > 4 && x % 2 == 0) {
						setPiece(x, y, Piece.RED_MAN);
					} else {
						setPiece(x, y, null);
					}
				}
			}
		}
	}

	@Override
	/**
	 * Returns a String representation of the board. Each row of the board should be on it's own line.
	 * A dash "-" represents an empty square. Pieces should be displayed using the .toString() method
	 * of the piece class.
	 */
	public String toString() {
		StringBuilder board = new StringBuilder();
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				if (getPiece(x, y) != null) {
					board.append(getPiece(x, y).toString());
				} else {
					board.append('-');
				}
			}
			board.append("\n");
		}
		return board.toString();
	}

	/**
	 * Do the Move, removing the piece from x1, y1 and setting the piece in x2,
	 * y2. If the piece is now on their "King's Row", then promote the piece
	 * should be promoted to a King
	 */
	public void execute(final Move move) {// done
		Piece piece = getPiece(move.getX1(), move.getY1());

		if (piece.equals(Piece.WHITE_MAN) && ((Integer) move.getY2()).equals(7)) {
			piece = Piece.WHITE_KING;
		} else if (piece.equals(Piece.RED_MAN)
				&& ((Integer) move.getY2()).equals(0)) {
			piece = Piece.RED_KING;
		}
		setPiece(move.getX2(), move.getY2(), piece);
		setPiece(move.getX1(), move.getY1(), null);
	}

	/**
	 * Do the Jump, removing the piece from x1, y1 and setting the piece in x2,
	 * y2. Remove the piece from captureX, captureY as well. If the piece is now
	 * on their "King's Row", then promote the piece should be promoted to a
	 * King
	 */
	public void execute(final Jump jump) {
		Piece piece = getPiece(jump.getX1(), jump.getY1());

		if (piece.equals(Piece.WHITE_MAN) && ((Integer) jump.getY2()).equals(7)) {
			piece = Piece.WHITE_KING;
		} else if (piece.equals(Piece.RED_MAN)
				&& ((Integer) jump.getY2()).equals(0)) {
			piece = Piece.RED_KING;
		}
		setPiece(jump.getCaptureX(), jump.getCaptureY(), null);
		setPiece(jump.getX2(), jump.getY2(), piece);
		setPiece(jump.getX1(), jump.getY1(), null);
	}

	/**
	 * Returns a list of all possible moves from the piece at (x,y). If there is
	 * no piece on that square, or the piece cannot make a legal move then
	 * return an empty list
	 */
	public List<Move> getMoves(final int x, final int y) {
		List<Move> moves = new ArrayList<Move>();
		Piece piece = getPiece(x, y);
		if (piece != null) {
			if (piece.isColor(Color.WHITE)) {
				if (x != 7) {
					if (y != 7) {
						if (getPiece(x + 1, y + 1) == null) {
							moves.add(new Move(x, y, x + 1, y + 1));
						}
					}
					if (piece.isKing()) {
						if (y != 0) {
							if (getPiece(x + 1, y - 1) == null) {
								moves.add(new Move(x, y, x + 1, y - 1));
							}
						}
					}
				}
				if (x != 0) {
					if (y != 7) {
						if (getPiece(x - 1, y + 1) == null) {
							moves.add(new Move(x, y, x - 1, y + 1));
						}
					}
					if (piece.isKing()) {
						if (y != 0) {
							if (getPiece(x - 1, y - 1) == null) {
								moves.add(new Move(x, y, x - 1, y - 1));
							}
						}
					}
				}
			} else {
				if (x != 7) {
					if (y != 0) {
						if (getPiece(x + 1, y - 1) == null) {
							moves.add(new Move(x, y, x + 1, y - 1));
						}
					}
					if (piece.isKing()) {
						if (y != 7) {
							if (getPiece(x + 1, y + 1) == null) {
								moves.add(new Move(x, y, x + 1, y + 1));
							}
						}
					}
				}
				if (x != 0) {
					if (y != 0) {
						if (getPiece(x - 1, y - 1) == null) {
							moves.add(new Move(x, y, x - 1, y - 1));
						}
					}
					if (piece.isKing()) {
						if (y != 7) {
							if (getPiece(x - 1, y + 1) == null) {
								moves.add(new Move(x, y, x - 1, y + 1));
							}
						}
					}
				}
			}
		}

		return moves;

	}

	/**
	 * Returns a list of all possible jumps from the piece at (x,y). If there is
	 * no piece on that square, or the piece cannot make a legal jump then
	 * return an empty list
	 */
	public List<Jump> getJumps(final int x, final int y) {
		List<Jump> jumps = new ArrayList<Jump>();
		Piece piece = getPiece(x, y);
		if (piece != null) {
			if (piece.isColor(Color.WHITE)) {
				if (x < 6) {
					if (getPiece(x + 1, y + 1) != null
							&& getPiece(x + 2, y + 2) == null) {
						jumps.add(new Jump(x, y, x + 1, y + 1, x + 2, y + 2));
					}
					if (piece.isKing()) {
						if (getPiece(x + 1, y - 1) != null
								&& getPiece(x + 2, y - 2) == null) {
							jumps.add(new Jump(x, y, x + 1, y - 1, x + 2, y - 2));
						}
					}
				}
				if (x > 1) {
					if (getPiece(x - 1, y + 1) != null
							&& getPiece(x - 2, y + 2) == null) {
						jumps.add(new Jump(x, y, x - 1, y + 1, x - 2, y + 2));
					}
					if (piece.isKing()) {
						if (getPiece(x - 1, y - 1) != null
								&& getPiece(x - 2, y - 2) == null) {
							jumps.add(new Jump(x, y, x - 1, y - 1, x - 2, y - 2));
						}
					}
				}
			} else {
				if (x < 7) {
					if (getPiece(x + 1, y - 1) != null
							&& getPiece(x + 2, y - 2) == null) {
						jumps.add(new Jump(x, y, x + 1, y - 1, x + 2, y - 2));
					}
					if (piece.isKing()) {
						if (getPiece(x + 1, y + 1) != null
								&& getPiece(x + 2, y + 2) == null) {
							jumps.add(new Jump(x, y, x + 1, y + 1, x + 2, y + 2));
						}
					}
				}
				if (x > 0) {
					if (getPiece(x - 1, y - 1) != null
							&& getPiece(x - 2, y - 2) == null) {
						jumps.add(new Jump(x, y, x - 1, y - 1, x - 2, y - 2));
					}
					if (piece.isKing()) {
						if (getPiece(x - 1, y + 1) != null
								&& getPiece(x - 2, y + 2) == null) {
							jumps.add(new Jump(x, y, x - 1, y + 1, x - 2, y + 2));
						}
					}
				}
			}
		}

		return jumps;

	}

}
