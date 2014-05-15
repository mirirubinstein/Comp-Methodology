package rubinstein.clock;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JComponent;

public class Clock extends JComponent {
	final int degPerMin = 360 / 60;

	@Override
	public void paintComponent(Graphics g) {
		int radius = 150;
		int x = getWidth() / 2;
		int y = getHeight() / 2;
		double fullCircle = Math.PI * 2;

		Calendar cal = new GregorianCalendar();
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);

		g.drawOval(x - radius, y - radius, 300, 300);
		g.setColor(Color.RED);
		g.drawLine(x, y, x
				+ (int) (Math.sin(second * (2 * Math.PI / 60)) * 140), y
				- (int) (Math.cos(second * (2 * Math.PI / 60)) * 140));// second
		// hand
		g.drawLine(x, y, x
				+ (int) (Math.sin(minute * (2 * Math.PI / 60)) * 130), y
				- (int) (Math.cos(minute * (2 * Math.PI / 60)) * 130));// min
																		// hand
		g.drawLine(
				x,
				y,
				x
						+ (int) (Math.sin((hour + minute / 60)
								* (2 * Math.PI / 12)) * 115),
				y
						- (int) (Math.cos((hour + minute / 60)
								* (2 * Math.PI / 12)) * 115));// hr
		// hand
		g.setColor(Color.BLUE);
		g.drawString("3", x + radius - 10, y + 3);
		g.drawString("6", x - 3, y + radius - 3);
		g.drawString("9", x - radius + 3, y + 5);
		g.drawString("12", x - 5, y - radius + 12);

	}
}
