package rubinstein.triangle;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

	@Test
	public void test1() {
		Triangle triangle = new Triangle(5);
		// System.out.println(triangle.toString());
		String t1 = triangle.toString();
		String expected = "    *" + "\n   * *" + "\n  *   *" + "\n *     *"
				+ "\n*********";
		Assert.assertEquals(t1, expected);
	}

	@Test
	public void test2() {
		Triangle triangle = new Triangle(2);
		// System.out.println(triangle.toString());
		String t2 = triangle.toString();
		String expected = " *" + "\n***";
		Assert.assertEquals(t2, expected);
	}

	@Test
	public void test3() {
		Triangle triangle = new Triangle(0);
		// System.out.println(triangle.toString());
		String t3 = triangle.toString();
		String expected = "Invalid height";
		Assert.assertEquals(t3, expected);
	}

	@Test
	public void test4() {
		Triangle triangle = new Triangle(-5);
		// System.out.println(triangle.toString());
		String t4 = triangle.toString();
		String expected = "Invalid height";
		Assert.assertEquals(t4, expected);
	}

}
