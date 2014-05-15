package rubinstein.weather;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WeatherFrame extends JFrame {
	String location;
	JTextField locationField;

	public WeatherFrame() {
		setTitle("Weather");
		setSize(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(3, 0));

		JLabel txt = new JLabel("Enter location: ");

		add(txt);

		locationField = new JTextField();
		add(locationField);

		JButton save = new JButton("Save");

		add(save);

		pack();
		setVisible(true);
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				location = locationField.getText();
			}
		});
	}

	public String getLoc() {
		return location;
	}

}
