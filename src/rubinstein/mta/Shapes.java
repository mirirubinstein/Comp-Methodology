package rubinstein.mta;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Shapes {
	private final List<Shape> shapes;
	private final double maxLatitude;
	private final double maxLongitude;
	private final double minLatitude;
	private final double minLongitude;

	public Shapes() throws IOException {
		shapes = new ArrayList<Shape>();
		CSVReader reader = new CSVReader(new FileReader("shapes.txt"), ',',
				'"', 1);
		List<Double> latitude = new ArrayList<Double>();
		List<Double> longitude = new ArrayList<Double>();
		String[] nextLine;
		while ((nextLine = reader.readNext()) != null) {
			// System.out.println(nextLine[0] + "\t" + nextLine[1] + "\t" +
			// nextLine[2]);

			latitude.add(Double.parseDouble(nextLine[1]));
			longitude.add(Double.parseDouble(nextLine[2]));
			Shape shape = new Shape(nextLine[0],
					Double.parseDouble(nextLine[1]),
					Double.parseDouble(nextLine[2]));
			shapes.add(shape);
		}
		// System.out.println(latitude.toString());
		maxLatitude = Collections.max(latitude);
		// System.out.println(maxLatitude);
		maxLongitude = Collections.max(longitude);
		// System.out.println(maxLongitude);
		minLatitude = Collections.min(latitude);
		minLongitude = Collections.min(longitude);
	}

	public List<Shape> getShapes(String id) {
		List<Shape> shapesList = new ArrayList<Shape>();
		for (Shape s : shapes) {
			if (id.equals(s.getShapeId())) {
				shapesList.add(s);
			}
		}
		return shapesList;
	}

	public List<Shape> getAllShapes() {
		return shapes;
	}

	public List<String> getShapeIds() {
		List<String> ids = new ArrayList<String>();
		for (Shape s : shapes) {
			if (!ids.contains(s.getShapeId())) {
				ids.add(s.getShapeId());
			}
		}
		return ids;
	}

	public double getMaxLatitude() {
		return maxLatitude;
	}

	public double getMaxLongitude() {
		return maxLongitude;
	}

	public double getMinLatitude() {
		return minLatitude;
	}

	public double getMinLongitude() {
		return minLongitude;
	}

}
