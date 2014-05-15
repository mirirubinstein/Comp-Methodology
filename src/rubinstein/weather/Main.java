package rubinstein.weather;

public class Main {
	private double temp;
	private double pressure;
	private double humidity;
	private double temp_min;
	private double temp_max;

	public double getTemp() {
		return temp;
	}

	public double getPressure() {
		return pressure;
	}

	public double getHumidity() {
		return humidity;
	}

	public double getTemp_min() {
		return temp_min;
	}

	public double getTemp_max() {
		return temp_max;
	}

	@Override
	public String toString() {
		return "Main [temp=" + temp + ", pressure=" + pressure + ", humidity="
				+ humidity + ", temp_min=" + temp_min + ", temp_max="
				+ temp_max + "]";
	}

}
