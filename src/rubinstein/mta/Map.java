package rubinstein.mta;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JComponent;

public class Map extends JComponent {
	private final Trips trips;
	private final Routes routes;
	private final Shapes shapes;

	public Map(Shapes shapes, Trips trips, Routes routes) {
		this.shapes = shapes;
		this.trips = trips;
		this.routes = routes;
	}

	@Override
	public void paintComponent(Graphics g) {

		double maxLat = shapes.getMaxLatitude();
		double minLat = shapes.getMinLatitude();
		double maxLong = shapes.getMaxLongitude();
		double minLong = shapes.getMinLongitude();

		double mapWidth = this.getWidth();
		double mapHeight = this.getHeight();

		// List<Shape> listShapes = shapes.getAllShapes();
		List<String> shapeIds = shapes.getShapeIds();

		for (String shapeId : shapeIds) {
			List<Shape> listShapes = shapes.getShapes(shapeId);

			Trip trip = trips.getTrip(shapeId);
			if (trip != null) {
				Color color = routes.getColor(trip.getRouteId());
				g.setColor(color);
				for (int i = 1; i < listShapes.size(); i++) {
					Shape shapeBefore = listShapes.get(i - 1);
					Shape currentShape = listShapes.get(i);

					// String shapeBeforeId = shapeBefore.getShapeId();
					// Trip tripBefore = trips.getTrip(shapeBeforeId);

					int dimension = (int) Math.min(mapWidth, mapHeight);

					double x = (currentShape.getLatitude() - minLat)
							* dimension / (maxLat - minLat);
					double y = (currentShape.getLongitude() - minLong)
							* dimension / (maxLong - minLong);
					double xBefore = (shapeBefore.getLatitude() - minLat)
							* dimension / (maxLat - minLat);
					double yBefore = (shapeBefore.getLongitude() - minLong)
							* dimension / (maxLong - minLong);
					g.drawLine((int) xBefore, (int) yBefore, (int) x, (int) y);
					/*
					 * if (trip != null && tripBefore != null) { Route route =
					 * routes.getRoute(trip.getRouteId()); Route routeBefore =
					 * routes .getRoute(tripBefore.getRouteId()); if
					 * (trip.getRouteId().equals(tripBefore.getRouteId())) { //
					 * g.setColor(route.getRouteColor()); g.drawLine((int) x,
					 * (int) y, (int) xBefore, (int) yBefore);
					 * 
					 * }
					 * 
					 * }
					 */
				}
			}
		}
	}
}
