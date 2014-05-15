package rubinstein.homework;

import org.junit.Assert;
import org.junit.Test;

public class Circle2DTest {
	private final Circle2D circle1 = new Circle2D(10, 10, 10);
	private final Circle2D circle2 = new Circle2D(10, 10, 5);
	private final Circle2D circle3 = new Circle2D(3, 4, 7);

	@Test
	public void testGetPerimeter() {
		double code = circle1.getPerimeter();
		double expected = 2 * Math.PI * circle1.getRadius();// write in the
															// actual numbers
															// your expecting
		Assert.assertEquals(code, expected, 0.0001);
	}

	@Test
	public void testGetArea() {
		double code = circle1.getArea();
		double expected = Math.PI * circle1.getRadius() * circle1.getRadius();
		Assert.assertEquals(code, expected, 0.0001);
	}

	public Circle2D getCircle1() {
		return circle1;
	}

	public Circle2D getCircle2() {
		return circle2;
	}

	public Circle2D getCircle3() {
		return circle3;
	}
}
