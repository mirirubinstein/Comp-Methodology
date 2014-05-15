package rubinstein.weatherForecast;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;

public class WeatherFrame extends JFrame {
	private final String location;

	public WeatherFrame(String location) throws IOException {
		this.location = location;

		setTitle("Weather Forecast");
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		Thread t1 = new ConnectionThread(this, location);
		t1.start();

		setVisible(true);
	}
}
