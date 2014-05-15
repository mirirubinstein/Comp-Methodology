package rubinstein.weather;

import com.google.gson.annotations.SerializedName;

public class Rain {

	@SerializedName("3h")
	private double threeHour;

	public double getThreeHour() {
		return threeHour;
	}

	@Override
	public String toString() {
		return "Rain [threeHour=" + threeHour + "]";
	}

}
