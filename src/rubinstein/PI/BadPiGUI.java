package rubinstein.PI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class BadPiGUI extends JFrame implements ActionListener, Runnable {
	// not so bad anymore
	private final JButton button;
	private final JTextArea area;

	public BadPiGUI() {
		button = new JButton("Start");
		area = new JTextArea();

		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(button, BorderLayout.SOUTH);
		add(area, BorderLayout.CENTER);
		button.addActionListener(this);

	}

	public static void main(String[] args) {
		BadPiGUI gui = new BadPiGUI();
		gui.setVisible(true);

	}

	@Override
	public void run() {
		double pi = 0;

		for (int i = 1; i < 1000000; i++) {
			double numerator = Math.pow(-1, i + 1);
			double denominator = (2 * i) - 1;
			double answer = 4 * numerator / denominator;
			pi += answer;
			area.setText(String.valueOf(pi));
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread t = new Thread(this);
		t.start();

	}

}
