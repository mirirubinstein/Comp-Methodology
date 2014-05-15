package rubinstein.mta;

import java.awt.Color;

public class Route {
	private final String routeId;
	private final Color routeColor;

	public Route(String routeId, Color routeColor) {
		this.routeId = routeId;
		this.routeColor = routeColor;
		// this.routeColor = Color.decode(routeColor.toUpperCase());
	}

	public String getRouteId() {
		return routeId;
	}

	public Color getRouteColor() {
		return routeColor;
	}

}
