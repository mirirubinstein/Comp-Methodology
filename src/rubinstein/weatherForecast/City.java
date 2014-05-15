package rubinstein.weatherForecast;

public class City {
	private String id;
	private String name;
	private final Coord coord = new Coord();
	private String country;
	private int population;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Coord getCoord() {
		return coord;
	}

	public String getCountry() {
		return country;
	}

	public int getPopulation() {
		return population;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", coord=" + coord
				+ ", country=" + country + ", population=" + population + "]";
	}
}
