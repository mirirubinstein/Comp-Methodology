package rubinstein.PI;

import javax.swing.JTextArea;

public class PICalcThread extends Thread {// not used anymore
	private final JTextArea area;

	public PICalcThread(JTextArea area) {
		this.area = area;
	}

	@Override
	public void run() {
		super.run();

		double pi = 0;

		for (int i = 1; i < 1000000; i++) {
			double numerator = Math.pow(-1, i + 1);
			double denominator = (2 * i) - 1;
			double answer = 4 * numerator / denominator;
			pi += answer;
			area.setText(String.valueOf(pi));
		}

	}
}
