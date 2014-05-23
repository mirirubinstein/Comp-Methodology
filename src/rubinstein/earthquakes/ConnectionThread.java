package rubinstein.earthquakes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.swing.JList;

import com.google.gson.Gson;

public class ConnectionThread extends Thread {
	private final DataFrame frame;
	private BufferedReader reader;
	private JList list;

	public ConnectionThread(DataFrame frame, JList list) {
		this.frame = frame;
		this.list = list;

	}

	@Override
	public void run() {
		super.run();
		try {
			URL url = new URL(
					"http://earthquake-report.com/feeds/recent-eq?json");

			URLConnection connection = url.openConnection();

			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			Gson gson = new Gson();
			EarthquakeList data = gson.fromJson(reader, EarthquakeList.class);
			ArrayList<String> stringData = new ArrayList<String>();
			for (EarthquakeData d : data) {
				stringData.add(d.getMagnitude() + "\t" + d.getLocation());
			}
			list = new JList(stringData.toArray());// ??
			frame.add(list);
			while (true) {
				list.repaint();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
