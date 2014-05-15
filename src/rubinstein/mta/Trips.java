package rubinstein.mta;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Trips {
	private final List<Trip> trips;

	public Trips() throws IOException {
		trips = new ArrayList<Trip>();
		CSVReader reader = new CSVReader(new FileReader("trips.txt"), ',', '"',
				1);
		String[] nextLine;
		while ((nextLine = reader.readNext()) != null) {
			// System.out.println(nextLine[2] + "\t" + nextLine[0] + "\t" +
			// nextLine[6]);
			Trip trip = new Trip(nextLine[2], nextLine[0], nextLine[6]);
			trips.add(trip);
		}

	}

	public Trip getTrip(String shapeId) {
		for (Trip t : trips) {
			if (shapeId.equals(t.getShapeId())) {
				return t;
			}
		}
		return null;
	}

}
