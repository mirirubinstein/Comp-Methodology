package rubinstein.weatherForecast;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CityPanel extends JPanel {
	private final JLabel label;
	private final JTextField city;
	private final JButton button;

	public CityPanel() {

		// setLayout(new BorderLayout());
		label = new JLabel("Enter the city: ");
		// label.setSize(100, 24);
		add(label, BorderLayout.NORTH);
		city = new JTextField();
		// city.setSize(100, 24);
		add(city, BorderLayout.NORTH);
		button = new JButton("Enter");
		add(button, BorderLayout.NORTH);

		setVisible(true);
	}
}
