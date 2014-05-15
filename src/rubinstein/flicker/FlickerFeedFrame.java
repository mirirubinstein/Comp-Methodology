package rubinstein.flicker;

import java.awt.FlowLayout;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class FlickerFeedFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public FlickerFeedFrame() throws IOException {
		setTitle("Flicker");
		setSize(800, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		Thread t1 = new DownloadFlickerFeedThread(this);
		t1.start();

		JScrollPane scroll = new JScrollPane();
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scroll);

		setVisible(true);
	}

	/**
	 * Runs a LoadImageThread for each image in the feed
	 * 
	 * @throws MalformedURLException
	 */
	public void loadImages(final FlickerFeed feed) throws MalformedURLException {
		Items[] items = feed.getItems();
		for (Items i : items) {
			JLabel label = new JLabel();
			add(label);
			Thread t1 = new DownloadImageThread(label, i.getMedia().getM());
			t1.start();
		}
	}

	public static void main(final String args[]) throws IOException {
		new FlickerFeedFrame().setVisible(true);

	}

}
