package rubinstein.weatherForecast;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JPanel;

public class Graph extends JPanel {
	private final List<Double> temps;

	int PAD = 50;

	public Graph(List<Double> temps) {
		this.temps = temps;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		int width = getWidth();
		int height = getHeight();
		g2.drawLine(PAD, PAD, PAD, height - PAD);
		// draw y axis
		g2.drawLine(PAD, height - PAD, width - PAD, height - PAD);

		// draw x axis
		double xConversion = (double) (width - 2 * PAD) / (temps.size() - 1);
		double yConversion = (height - 2 * PAD) / getMax();
		// Mark temps points.
		g2.setPaint(Color.BLUE);
		for (int i = 0; i < temps.size(); i++) {
			double x = PAD + i * xConversion;
			double y = height - PAD - yConversion * temps.get(i);
			if (i != 0) {
				double prevX = PAD + (i - 1) * xConversion;
				double prevY = height - PAD - yConversion * temps.get(i - 1);
				g2.drawLine((int) x, (int) y, (int) prevX, (int) prevY);
			}
			g2.fillRect((int) x - 2, (int) y - 2, 4, 4);
		}

	}

	private double getMax() {
		double max = -Integer.MAX_VALUE;
		for (double t : temps) {
			if (t > max) {
				max = t;
			}
		}
		return max;
	}
}
