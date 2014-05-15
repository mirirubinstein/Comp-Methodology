package rubinstein.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

public class WeatherConnection {

	public static void main(String[] args) throws IOException {
		WeatherFrame frame = new WeatherFrame();
		String country = "brooklyn, ny";

		URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q="
				+ country);

		URLConnection connection = url.openConnection();

		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		Gson gson = new Gson();
		final Conditions c = gson.fromJson(reader, Conditions.class);
		System.out.println(c.toString());

	}
}
