package rubinstein.mta;

public class Shape {
	private final String shapeId;
	private final double latitude;
	private final double longitude;

	// private double x;
	// private double y;

	public Shape(String shapeId, double latitude, double longitude) {
		this.shapeId = shapeId;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getShapeId() {
		return shapeId;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	/*
	 * public double getX() { return x; }
	 * 
	 * public double getY() { return y; }
	 */
}
