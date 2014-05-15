package rubinstein.weatherForecast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Conditions {
	private String cod;
	private double message;
	private final City city = new City();
	private double cnt;

	@SerializedName("list")
	private final Lists[] theList = new Lists[14];

	public String getCod() {
		return cod;
	}

	public double getMessage() {
		return message;
	}

	public City getCity() {
		return city;
	}

	public double getCnt() {
		return cnt;
	}

	public Lists[] getTheList() {
		return theList;
	}

	@Override
	public String toString() {
		return "Conditions [cod=" + cod + ", message=" + message + ", city="
				+ city + ", cnt=" + cnt + ", TheList="
				+ Arrays.toString(theList) + "]";
	}

	public List<Double> getAllTemps() {
		Lists[] list = theList;
		List<Double> tempList = new ArrayList<Double>();
		for (Lists l : list) {
			tempList.add(l.getMain().getTemp());
			// System.out.println(l.getMain().getTemp());
		}
		return tempList;
	}

}
