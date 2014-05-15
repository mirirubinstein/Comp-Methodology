package rubinstein.tictactoe;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TicTacToeBoardTest {

	@Test
	public void test1() {
		TicTacToeBoard board = new TicTacToeBoard();
		Evaluator eval = new Evaluator(board);
		board.reset();
		board.setSquare(1, 1, 'x');
		board.setSquare(1, 2, 'x');
		board.setSquare(1, 3, 'x');

		eval.evaluate();

		Symbol expected = null;
		expected = expected.valueOf('X');
		Assert.assertEquals(eval.getWinner(), expected);

	}

	@Test
	public void test2() {
		TicTacToeBoard board = new TicTacToeBoard();
		Evaluator eval = new Evaluator(board);
		board.reset();
		board.setSquare(3, 3, 'x');
		board.setSquare(2, 2, 'o');
		board.setSquare(1, 1, 'o');
		board.setSquare(2, 1, 'x');
		board.setSquare(1, 2, 'o');
		board.setSquare(1, 3, 'o');

		eval.evaluate();
		Symbol expected = null;
		expected = expected.valueOf('O');
		Assert.assertEquals(eval.getWinner(), expected);
	}

	@Test
	public void test3() {
		TicTacToeBoard board = new TicTacToeBoard();
		Evaluator eval = new Evaluator(board);
		board.reset();
		board.setSquare(3, 3, 'x');
		board.setSquare(2, 2, 'o');
		board.setSquare(1, 1, 'o');
		board.setSquare(2, 1, 'x');
		board.setSquare(1, 2, 'o');
		board.setSquare(1, 3, 'o');

		eval.evaluate();
		List<Location> expected = new ArrayList<Location>();
		expected.add(new Location(0, 0));
		expected.add(new Location(0, 1));
		expected.add(new Location(0, 2));
		Assert.assertEquals(eval.getList(), expected);
		// System.out.println(expected);
		// System.out.println(eval.getList());
	}

}
