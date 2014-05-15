package rubinstein.flicker;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Loads a single image from a url into a JLabel
 */
public class DownloadImageThread extends Thread {
	JLabel label;
	String url;

	public DownloadImageThread(final JLabel label, final String url)
			throws MalformedURLException {
		// downloads 1 image and puts it in 1 label, you need 20 of these
		this.label = label;
		this.url = url;

	}

	@Override
	public void run() {
		super.run();

		try {
			label.setIcon(new ImageIcon(new URL(url)));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
