package rubinstein.weatherForecast;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LocationFrame extends JFrame {
	String location;
	JTextField locationField;

	public LocationFrame() {
		setTitle("Location");
		setSize(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(3, 0));
		setLocationRelativeTo(null);

		JLabel txt = new JLabel("Enter location: ");

		add(txt);

		locationField = new JTextField();

		add(locationField);

		JButton save = new JButton("Save");

		add(save);
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				location = locationField.getText();

				try {
					WeatherFrame frame = new WeatherFrame(location);
					setVisible(false);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		pack();
		setVisible(true);
	}

	public String getLoc() {
		return location;
	}

}
