package rubinstein.PI;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class PIFrame extends JFrame {
	public PIFrame() {
		setTitle("PI");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setVisible(true);

		PI piCalc = new PI();
		double pi = piCalc.getPi();
	}

	public static void main(String[] args) {
		PIFrame frame = new PIFrame();
	}

}
