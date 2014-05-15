package rubinstein.mta;

import java.awt.Color;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Routes {
	private final List<Route> routes;

	public Routes() throws IOException {
		routes = new ArrayList<Route>();
		CSVReader reader = new CSVReader(new FileReader("routes.txt"), ',',
				'"', 1);
		String[] nextLine;
		while ((nextLine = reader.readNext()) != null) {
			Route route;
			if (!"".equals(nextLine[7])) {
				route = new Route(nextLine[0], Color.decode("#"
						+ nextLine[7].trim()));
				routes.add(route);
				// System.out.println(nextLine[0] + "\t" + nextLine[7]);
				// Color.decode(nextLine[7]
			} /*
			 * else { route = new Route(nextLine[0], Color.decode(nextLine[7]));
			 * }
			 * 
			 * routes.add(route);
			 */
		}
		reader.close();
	}

	public Route getRoute(String id) {
		for (Route r : routes) {
			if (id.equals(r.getRouteId())) {
				// System.out.println(r.getRouteId());
				return r;
			}
		}
		return null;
	}

	public Color getColor(String routeId) {
		Route route = getRoute(routeId);
		if (route == null) {
			return Color.BLACK;
		}
		return route.getRouteColor();
	}

}
