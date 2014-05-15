package rubinstein.ufo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class ListSightings {
	public static void main(String[] args) throws IOException {
		Gson gson = new Gson();

		final FileReader reader = new FileReader("ufo_awesome.json");
		final SightingList list = gson.fromJson(reader, SightingList.class);
		Map<String, List<Sighting>> map = new HashMap<>();

		for (Sighting s : list) {
			String location = s.getLocation();
			List<Sighting> sightings = map.get(location);
			if (sightings == null) {
				sightings = new ArrayList<Sighting>();
			}
			sightings.add(s);
			map.put(location, sightings);// dont rlly need this.. why?
		}

		ZipCodes zip = new ZipCodes();
		ArrayList<ZipCode> codes = (ArrayList<ZipCode>) zip.getZipCodes();

		for (Sighting s : list) {
			if ("19950115".equals(s.getSightedAt())) {
				String location = s.getLocation();
				String delims = "[,]";
				String[] tokens = location.split(delims);

				for (ZipCode z : codes) {
					if (tokens[0].trim().toUpperCase()
							.equals(z.getCity().trim())
							&& tokens[1].trim().toUpperCase()
									.equals(z.getState().trim())) {
						System.out.println(z.getZip());
					}
				}
			}
		}

	}
}
