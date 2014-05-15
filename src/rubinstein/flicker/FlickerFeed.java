package rubinstein.flicker;

import java.util.Arrays;

/**
 * The class that represents the json feed from Flicker
 */
public class FlickerFeed {
	private final Items[] items = new Items[20];

	public Items[] getItems() {
		return items;
	}

	@Override
	public String toString() {
		return "FlickerFeed [items=" + Arrays.toString(items) + "]";
	}

}
