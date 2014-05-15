package rubinstein.mta;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TripsTest {
	@Test
	public void testConstructors() throws IOException {
		new Shapes();
	}

	@Test
	public void testGetShapes() throws IOException {
		final Shapes shapes = new Shapes();
		final List<Shape> shapesList = shapes.getShapes("1..S03R");
		Assert.assertNotNull("shapeId = 1..S03R not found", shapesList);
		// Assert.assertNotSame(0, shapesList.size());
	}
}
