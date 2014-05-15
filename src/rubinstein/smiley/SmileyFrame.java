package rubinstein.smiley;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class SmileyFrame extends JFrame {
	public SmileyFrame() {

		setTitle("SMILE");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		add(new SmileyFace(), BorderLayout.CENTER);

		setVisible(true);
	}

	public static void main(String[] args) {
		SmileyFrame frame = new SmileyFrame();

	}
}
