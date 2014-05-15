package rubinstein.ufo;

public class ZipCode {
	private final String zip;
	private final String city;
	private final String state;

	public ZipCode(String zip, String city, String state) {
		this.zip = zip;
		this.city = city;
		this.state = state;
	}

	@Override
	public String toString() {
		return "ZipCode [zip=" + zip + ", city=" + city + ", state=" + state
				+ "]";
	}

	public String getZip() {
		return zip;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}
}
