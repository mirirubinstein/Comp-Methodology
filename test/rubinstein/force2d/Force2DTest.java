package rubinstein.force2d;

import org.junit.Assert;
import org.junit.Test;

public class Force2DTest {

	@Test
	public void test1() {
		Force2D force = new Force2D(10, 12);
		double code = force.getMagnitude();
		double expected = 15.62049935;
		Assert.assertEquals(code, expected, 0.001);
	}

	@Test
	public void test2() {
		Force2D force = new Force2D(10.0, 12.0);
		Force2D force2 = new Force2D(5.0, 20.0);
		Force2D result = force.add(force2);
		double codeX = result.getX();
		double codeY = result.getY();

		double expectedX = 15;
		double expectedY = 32;

		Assert.assertEquals(codeX, expectedX, 0.01);
		Assert.assertEquals(codeY, expectedY, 0.01);
	}

	@Test
	public void test3() {
		Force2D force = new Force2D(5, 20);
		double code = force.getAngle();
		double expected = 75.964;
		Assert.assertEquals(code, expected, 0.001);
	}

	@Test
	public void test4() {
		Force2D force = new Force2D(-10, 12);
		double code = force.getMagnitude();
		double expected = 15.62049935;
		Assert.assertEquals(code, expected, 0.001);
	}
}
