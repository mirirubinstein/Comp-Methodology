package rubinstein.earthquakes;


public class EarthquakeData {
	private String magnitude;
	private String location;

	public String getMagnitude() {
		return magnitude;
	}

	public String getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return "EarthquakeData [magnitude=" + magnitude + ", location="
				+ location + "]";
	}

}
