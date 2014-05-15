package rubinstein.weather;

public class Weather {

	private double id;
	private String main;
	private String description;
	private String icon;

	public double getId() {
		return id;
	}

	public String getMain() {
		return main;
	}

	public String getDescription() {
		return description;
	}

	public String getIcon() {
		return icon;
	}

	@Override
	public String toString() {
		return "Weather [id=" + id + ", main=" + main + ", description="
				+ description + ", icon=" + icon + "]";
	}

}
