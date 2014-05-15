package rubinstein.weatherForecast;

public class Lists {
	private long dt;
	private final Main main = new Main();
	private final Weather[] weather = new Weather[10];
	private final Clouds clouds = new Clouds();
	private final Wind wind = new Wind();
	private final Rain rain = new Rain();
	private final Sys sys = new Sys();
	private String dt_txt;

	public long getDt() {
		return dt;
	}

	public Main getMain() {
		return main;
	}

	public Weather[] getWeather() {
		return weather;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public Wind getWind() {
		return wind;
	}

	public Rain getRain() {
		return rain;
	}

	public Sys getSys() {
		return sys;
	}

	public String getDt_txt() {
		return dt_txt;
	}

	@Override
	public String toString() {
		return "List [dt=" + dt + ", main=" + main + ", weather=" + weather
				+ ", clouds=" + clouds + ", wind=" + wind + ", rain=" + rain
				+ ", sys=" + sys + ", dt_txt=" + dt_txt + "]";
	}

}
