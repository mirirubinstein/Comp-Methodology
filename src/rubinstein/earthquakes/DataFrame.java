package rubinstein.earthquakes;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class DataFrame extends JFrame {
	private final JPanel panel;

	private final JList list;

	public DataFrame() {
		setTitle("Earthquake Data");
		setSize(300, 300);
		setBackground(Color.cyan);

		// Create a panel to hold all other components
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		getContentPane().add(panel);

		list = new JList();// ??
		Thread t1 = new ConnectionThread(this, list);
		t1.start();

		panel.add(list, BorderLayout.CENTER);
	}

}
