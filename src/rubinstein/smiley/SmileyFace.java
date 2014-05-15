package rubinstein.smiley;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileyFace extends JComponent {
	@Override
	public void paintComponent(Graphics g) {
		g.drawLine(0, 0, this.getWidth(), this.getHeight());
		g.drawLine(0, this.getHeight(), this.getWidth(), 0);
		g.setColor(Color.BLUE);
		g.fillOval(300, 300, 100, 100);// fills the shape
		// the first 2 parameter is the x, y from the corner, where your circle
		// should be drawn
		g.setColor(Color.GREEN);
		g.drawOval(getWidth() / 2 - 50, getHeight() / 2 - 50, 100, 100);
	}
}
