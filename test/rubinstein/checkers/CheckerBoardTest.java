package rubinstein.checkers;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CheckerBoardTest {

	@Test
	/**
	 * Your code must pass this test. Do not edit this test.
	 */
	public void testToStringOnEmptyBoard() {
		final CheckerBoard board = new CheckerBoard();
		final String expected = "--------\n" + "--------\n" + "--------\n"
				+ "--------\n" + "--------\n" + "--------\n" + "--------\n"
				+ "--------\n";
		Assert.assertEquals(expected.trim(), board.toString().trim());
	}

	@Test
	/**
	 * Your code must pass this test. Do not edit this test.
	 */
	public void testToStringAfterNewGame() {
		final CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		final String expected = "-w-w-w-w\n" + "w-w-w-w-\n" + "-w-w-w-w\n"
				+ "--------\n" + "--------\n" + "r-r-r-r-\n" + "-r-r-r-r\n"
				+ "r-r-r-r-\n";
		Assert.assertEquals(expected.trim(), board.toString().trim());
	}

	@Test
	/**
	 * Test that isOnBoard() returns the correct result for different xs and ys
	 */
	public void testIsOnBoard() {// done, passed
		CheckerBoard board = new CheckerBoard();
		boolean code = board.isOnBoard(-1, 0);
		boolean code2 = board.isOnBoard(9, 10);
		boolean expected = false;
		Assert.assertEquals(code, expected);
		Assert.assertEquals(code2, expected);
	}

	@Test
	/**
	 * Test that isEmptySquare() returns the correct result before and after setPiece() is called
	 */
	public void testIsEmptySquare() {// done, passed test
		CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		boolean code = board.isEmptySquare(0, 1);
		boolean expected = false;
		Assert.assertEquals(code, expected);
	}

	@Test
	/**
	 * Given an board with pieces, test that calling clear() clears the board
	 */
	public void testClear() {// passed
		CheckerBoard board = new CheckerBoard();
		board.clear();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Piece expected = null;
				Piece code = board.getPiece(i, j);
				Assert.assertEquals(code, expected);
			}
		}
	}

	@Test
	/**
	 * Test that the board is in the correct configuration after
	 * resetNewGame() is called
	 */
	public void testResetNewGame() { // done works
		CheckerBoard board1 = new CheckerBoard();
		board1.setPiece(1, 0, Piece.WHITE_MAN);
		board1.setPiece(3, 0, Piece.WHITE_MAN);
		board1.setPiece(5, 0, Piece.WHITE_MAN);
		board1.setPiece(7, 0, Piece.WHITE_MAN);
		board1.setPiece(0, 1, Piece.WHITE_MAN);
		board1.setPiece(2, 1, Piece.WHITE_MAN);
		board1.setPiece(4, 1, Piece.WHITE_MAN);
		board1.setPiece(6, 1, Piece.WHITE_MAN);
		board1.setPiece(1, 2, Piece.WHITE_MAN);
		board1.setPiece(3, 2, Piece.WHITE_MAN);
		board1.setPiece(5, 2, Piece.WHITE_MAN);
		board1.setPiece(7, 2, Piece.WHITE_MAN);

		board1.setPiece(0, 5, Piece.RED_MAN);
		board1.setPiece(2, 5, Piece.RED_MAN);
		board1.setPiece(4, 5, Piece.RED_MAN);
		board1.setPiece(6, 5, Piece.RED_MAN);
		board1.setPiece(1, 6, Piece.RED_MAN);
		board1.setPiece(3, 6, Piece.RED_MAN);
		board1.setPiece(5, 6, Piece.RED_MAN);
		board1.setPiece(7, 6, Piece.RED_MAN);
		board1.setPiece(0, 7, Piece.RED_MAN);
		board1.setPiece(2, 7, Piece.RED_MAN);
		board1.setPiece(4, 7, Piece.RED_MAN);
		board1.setPiece(6, 7, Piece.RED_MAN);

		CheckerBoard board2 = new CheckerBoard();
		board2.resetNewGame();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Piece expected = board1.getPiece(i, j);
				Piece code = board2.getPiece(i, j);
				Assert.assertEquals(code, expected);
			}
		}
	}

	@Test
	/**
	 * Test execute(Move) moves a piece from one square to the other
	 */
	public void testMove() {// passes
		CheckerBoard board = new CheckerBoard();
		board.setPiece(1, 0, Piece.RED_MAN);
		Move move = new Move(1, 0, 2, 1);
		board.execute(move);
		Piece code1 = board.getPiece(1, 0);
		Piece expected1 = null;
		Piece code2 = board.getPiece(2, 1);
		Piece expected2 = Piece.RED_MAN;
		Assert.assertEquals(code1, expected1);
		Assert.assertEquals(code2, expected2);
	}

	@Test
	/**
	 * Test execute(Move) promotes a WHITE_MAN to a WHITE_KING when moving to the 8th row
	 */
	public void testMovePromoteToWhiteKing() {// PASSES
		CheckerBoard board = new CheckerBoard();
		board.setPiece(5, 6, Piece.WHITE_MAN);
		Move move = new Move(5, 6, 6, 7);
		board.execute(move);

		Piece code1 = board.getPiece(5, 6);
		Piece expected1 = null;
		Piece code2 = board.getPiece(6, 7);
		Piece expected2 = Piece.WHITE_KING;
		Assert.assertEquals(code1, expected1);
		Assert.assertEquals(code2, expected2);
	}

	@Test
	/**
	 * Test execute(Move) promotes a RED_MAN to a RED_KING when moving to the 1st row
	 */
	public void testMovePromoteToRedKing() { // PASSES
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 1, Piece.RED_MAN);
		Move move = new Move(2, 1, 1, 0);
		board.execute(move);

		Piece code1 = board.getPiece(2, 1);
		Piece expected1 = null;
		Piece code2 = board.getPiece(1, 0);
		Piece expected2 = Piece.RED_KING;
		Assert.assertEquals(code1, expected1);
		Assert.assertEquals(code2, expected2);
	}

	@Test
	/**
	 * Test execute(Jump) moves a piece from one square to another AND removes the piece that was jumped
	 */
	public void testJump() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(1, 0, Piece.RED_MAN);
		Jump jump = new Jump(1, 0, 2, 1, 3, 2);
		board.execute(jump);
		Piece code1 = board.getPiece(1, 0);
		Piece expected1 = null;
		Piece code2 = board.getPiece(2, 1);
		Piece expected2 = null;
		Piece code3 = board.getPiece(3, 2);
		Piece expected3 = Piece.RED_MAN;
		Assert.assertEquals(code1, expected1);
		Assert.assertEquals(code2, expected2);
		Assert.assertEquals(code3, expected3);
	}

	@Test
	/**
	 * Test execute(Jump) promotes a RED_MAN to a RED_KING when moving to the 1st row
	 */
	public void testJumpPromoteToRedKing() {// /???
		CheckerBoard board = new CheckerBoard();
		board.setPiece(3, 2, Piece.RED_MAN);
		Jump jump = new Jump(3, 2, 2, 1, 1, 0);
		board.execute(jump);
		Piece code1 = board.getPiece(3, 2);
		Piece expected1 = null;
		Piece code2 = board.getPiece(2, 1);
		Piece expected2 = null;
		Piece code3 = board.getPiece(1, 0);
		Piece expected3 = Piece.RED_KING;
		Assert.assertEquals(code1, expected1);
		Assert.assertEquals(code2, expected2);
		Assert.assertEquals(code3, expected3);
	}

	@Test
	/**
	 * Test execute(Jump) promotes a WHITE_MAN to a WHITE_KING when moving to the 1st row
	 */
	public void testJumpPromoteToWhiteKing() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(4, 5, Piece.WHITE_MAN);
		Jump jump = new Jump(4, 5, 5, 6, 6, 7);
		board.execute(jump);
		Piece code1 = board.getPiece(4, 5);
		Piece expected1 = null;
		Piece code2 = board.getPiece(5, 6);
		Piece expected2 = null;
		Piece code3 = board.getPiece(6, 7);
		Piece expected3 = Piece.WHITE_KING;
		Assert.assertEquals(code1, expected1);
		Assert.assertEquals(code2, expected2);
		Assert.assertEquals(code3, expected3);
	}

	@Test
	/**
	 * Test that getMoves() returns the correct number of Move objects when called on an empty square
	 */
	public void testGetMovesForEmptySquare() {
		CheckerBoard board = new CheckerBoard();
		List<Jump> expected = new ArrayList<Jump>();
		List<Move> actual = board.getMoves(5, 3);
		Assert.assertEquals(expected, actual);
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_MAN is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForRedManInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 5, Piece.RED_MAN);
		List<Move> actual = board.getMoves(2, 5);
		List<Move> expected = new ArrayList<Move>();
		expected.add(new Move(2, 5, 3, 4));
		expected.add(new Move(2, 5, 1, 4));
		Assert.assertEquals(expected, actual);
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForRedKingInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 5, Piece.RED_KING);
		List<Move> actual = board.getMoves(2, 5);
		List<Move> expected = new ArrayList<Move>();
		expected.add(new Move(2, 5, 3, 4));
		expected.add(new Move(2, 5, 3, 6));
		expected.add(new Move(2, 5, 1, 4));
		expected.add(new Move(2, 5, 1, 6));
		Assert.assertEquals(expected, actual);
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_MAN is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForWhiteManInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 5, Piece.WHITE_MAN);
		List<Move> actual = board.getMoves(2, 5);
		List<Move> expected = new ArrayList<Move>();
		expected.add(new Move(2, 5, 3, 6));
		expected.add(new Move(2, 5, 1, 6));
		Assert.assertEquals(expected, actual);
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForWhiteKingInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 5, Piece.WHITE_KING);
		List<Move> actual = board.getMoves(2, 5);
		List<Move> expected = new ArrayList<Move>();
		expected.add(new Move(2, 5, 3, 6));
		expected.add(new Move(2, 5, 3, 4));
		expected.add(new Move(2, 5, 1, 6));
		expected.add(new Move(2, 5, 1, 4));
		Assert.assertEquals(expected, actual);
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is surrounded in 4 directions and
	 * cannot move.
	 * This should be an empty List
	 */
	public void testGetMovesForRedKingWhenSurrounded() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 5, Piece.RED_KING);
		board.setPiece(3, 4, Piece.WHITE_MAN);
		board.setPiece(3, 6, Piece.WHITE_MAN);
		board.setPiece(1, 4, Piece.WHITE_MAN);
		board.setPiece(1, 6, Piece.WHITE_MAN);
		List<Jump> expected = new ArrayList<Jump>();
		List<Move> actual = board.getMoves(2, 5);
		Assert.assertEquals(expected, actual);
	}

	@Test
	/**
	 * Test that when getMoves() is called for a piece at the EDGE of the board (0,7) then the correct
	 * move is returned.
	 */
	public void testGetMovesForRedKingAt07() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(0, 7, Piece.RED_KING);
		List<Move> actual = board.getMoves(0, 7);
		List<Move> expected = new ArrayList<Move>();
		expected.add(new Move(0, 7, 1, 6));
		Assert.assertEquals(expected, actual);
	}

	@Test
	/**
	 * Test that when getMoves() is called for a piece at the EDGE of the board (7,0) then the correct
	 * move is returned.
	 */
	public void testGetMovesForRedKingAt70() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(7, 0, Piece.RED_KING);
		List<Move> actual = board.getMoves(7, 0);
		List<Move> expected = new ArrayList<Move>();
		expected.add(new Move(7, 0, 6, 1));
		Assert.assertEquals(expected, actual);
	}

	@Test
	/**
	 * Test that getJumps() returns the correct number of Jump objects when called on an empty square
	 */
	public void testGetJumpsForEmptySquare() {
		CheckerBoard board = new CheckerBoard();
		List<Jump> expected = new ArrayList<Jump>();
		List<Jump> actual = board.getJumps(5, 3);
		Assert.assertEquals(expected, actual);
	}

	@Test
	/**
	 * Test that getJumps() returns the correct number of Jump objects when called on square that does not have
	 * any possible jumps
	 */
	public void testGetJumpsForRedKingInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 5, Piece.RED_KING);
		List<Jump> expected = new ArrayList<Jump>();
		List<Jump> actual = board.getJumps(2, 5);
		Assert.assertEquals(expected, actual);
	}

	@Test
	/**
	 * Test that getJumps() returns the correct Jump objects when a King can jump in 4 directions
	 */
	public void testGetJumpsForRedKingWhenSurrounded() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 5, Piece.RED_KING);
		board.setPiece(3, 6, Piece.WHITE_MAN);
		board.setPiece(3, 4, Piece.WHITE_MAN);
		board.setPiece(1, 6, Piece.WHITE_MAN);
		board.setPiece(1, 4, Piece.WHITE_MAN);
		List<Jump> actual = board.getJumps(2, 5);
		List<Jump> expected = new ArrayList<Jump>();
		expected.add(new Jump(2, 5, 3, 4, 4, 3));
		expected.add(new Jump(2, 5, 3, 6, 4, 7));
		expected.add(new Jump(2, 5, 1, 4, 0, 3));
		expected.add(new Jump(2, 5, 1, 6, 0, 7));
		Assert.assertEquals(expected, actual);
	}

	@Test
	/**
	 * Test that getJumps() returns the returns the correct Jump objects when a Piece can jump in 2 directions
	 */
	public void testGetJumpsForRedManWhenSurrounded() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 5, Piece.RED_MAN);
		board.setPiece(3, 6, Piece.WHITE_MAN);
		board.setPiece(3, 4, Piece.WHITE_MAN);
		board.setPiece(1, 6, Piece.WHITE_MAN);
		board.setPiece(1, 4, Piece.WHITE_MAN);
		List<Jump> actual = board.getJumps(2, 5);
		List<Jump> expected = new ArrayList<Jump>();
		expected.add(new Jump(2, 5, 3, 4, 4, 3));
		expected.add(new Jump(2, 5, 1, 4, 0, 3));
		Assert.assertEquals(expected, actual);
	}

}
