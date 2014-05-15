package rubinstein.clock;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class ClockFrame extends JFrame {
	public ClockFrame(Clock clock) {
		setTitle("Clock");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		add(clock, BorderLayout.CENTER);

		setVisible(true);
	}

	public static void main(String[] args) {

		Clock clock = new Clock();
		ClockFrame frame = new ClockFrame(clock);
		Thread t1 = new ClockThread(clock);

		t1.start();

	}
}
