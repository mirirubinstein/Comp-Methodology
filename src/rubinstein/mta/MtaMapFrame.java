package rubinstein.mta;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;

public class MtaMapFrame extends JFrame {
	public MtaMapFrame() {

		setTitle("MAP");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		try {
			Shapes shapes = new Shapes();
			Trips trips = new Trips();
			Routes routes = new Routes();

			add(new Map(shapes, trips, routes), BorderLayout.CENTER);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		setVisible(true);
	}

	public static void main(String[] args) {
		MtaMapFrame map = new MtaMapFrame();
	}
}
