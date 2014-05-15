package rubinstein.flicker;

import java.net.MalformedURLException;

import javax.swing.Icon;
import javax.swing.JLabel;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;

public class DownloadFlickerFeedThreadTest {

	@Test
	public void testCallLoadImages() throws MalformedURLException {
		FlickerFeedFrame frame = Mockito.mock(FlickerFeedFrame.class);
		DownloadFlickerFeedThread thread = new DownloadFlickerFeedThread(frame);

		VerificationMode never = Mockito.never();

		Mockito.verify(frame, never).loadImages(Mockito.any(FlickerFeed.class));

		thread.run();

		VerificationMode once = Mockito.times(1);

		Mockito.verify(frame, once).loadImages(Mockito.any(FlickerFeed.class));

	}

	@Test
	public void testCallsLoadImages() throws MalformedURLException {
		final JLabel label = Mockito.mock(JLabel.class);
		DownloadImageThread thread = new DownloadImageThread(
				label,
				"https://api.flickr.com/services/feeds/photos_public.gne?id=20952345@N03&format=json");

		Mockito.verify(label, Mockito.never()).setIcon(Mockito.any(Icon.class));

	}

}
