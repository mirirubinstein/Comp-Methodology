package rubinstein.weather;

import java.util.Arrays;

public class Conditions {
	Coord coord = new Coord();
	Sys sys = new Sys();
	Weather[] weather = new Weather[10];
	String base = new String();
	Main main = new Main();
	Wind wind = new Wind();
	Rain rain = new Rain();
	Clouds clouds = new Clouds();
	long dt;
	long id;
	String name = new String();
	int cod;

	@Override
	public String toString() {
		return "Conditions [coord=" + coord + ", sys=" + sys + ", weather="
				+ Arrays.toString(weather) + ", base=" + base + ", main="
				+ main + ", wind=" + wind + ", rain=" + rain + ", clouds="
				+ clouds + ", dt=" + dt + ", id=" + id + ", name=" + name
				+ ", cod=" + cod + "]";
	}

}
