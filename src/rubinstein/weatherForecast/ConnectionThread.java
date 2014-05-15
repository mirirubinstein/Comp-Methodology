package rubinstein.weatherForecast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.google.gson.Gson;

public class ConnectionThread extends Thread {

	private final WeatherFrame frame;
	private final String location;
	private BufferedReader reader;

	public ConnectionThread(WeatherFrame frame, String location)
			throws IOException {
		this.location = location;
		this.frame = frame;
	}

	@Override
	public void run() {
		super.run();
		URL url;

		final String urlString = "http://api.openweathermap.org/data/2.5/forecast?q="
				+ location + "&mode=json&units=imperial";

		List<Double> tempList;

		try {
			url = new URL(urlString);

			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(in));

			Gson gson = new Gson();
			final Conditions c = gson.fromJson(reader, Conditions.class);
			tempList = c.getAllTemps();
			Graph graph = new Graph(tempList);
			frame.add(graph);
			frame.setVisible(true);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
