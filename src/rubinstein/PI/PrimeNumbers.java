package rubinstein.PI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class PrimeNumbers extends JFrame implements ActionListener, Runnable {
	// not so bad anymore
	private final JButton button;
	private final JTextArea area;

	public PrimeNumbers() {
		button = new JButton("Start");
		area = new JTextArea();

		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(button, BorderLayout.SOUTH);
		add(area, BorderLayout.CENTER);
		button.addActionListener(this);

	}

	public static void main(String[] args) {
		PrimeNumbers gui = new PrimeNumbers();
		gui.setVisible(true);

	}

	@Override
	public void run() {
		area.append("\n1");

		for (int i = 2; i < 10000000; i++) {
			boolean found = false;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					found = false;
				} else {
					found = true;

				}
			}
			if (!found) {
				area.append("\n");
				area.append(String.valueOf(i));
			}

		}
	}

	boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread t = new Thread(this);
		t.start();

	}

}
