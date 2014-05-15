package rubinstein.stocks;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import au.com.bytecode.opencsv.CSVReader;

public class AmexData {
	// private final List<DailyPrice> data;
	private final HashMap<String, List<DailyPrice>> map = new HashMap<String, List<DailyPrice>>();

	public AmexData() throws IOException, ParseException {
		// data = new ArrayList<DailyPrice>();
		CSVReader reader = null;
		String files;
		File folder = new File("resources/amex");
		File[] listOfFiles = folder.listFiles();

		for (int i = 9; i < 13; i++) {

			if (listOfFiles[i].isFile()) {
				reader = new CSVReader(new FileReader(listOfFiles[i]), ',',
						'"', 1);
			}

			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				DailyPrice price;
				Date date;
				Calendar cal = Calendar.getInstance();
				StringTokenizer tokens = new StringTokenizer(nextLine[2], "-");
				while (tokens.hasMoreTokens()) {
					int month = Integer.parseInt(tokens.nextToken());
					int day = Integer.parseInt(tokens.nextToken());
					int year = Integer.parseInt(tokens.nextToken());
					cal.set(year, month - 1, day, 0, 0);
				}
				date = cal.getTime();
				// DateFormat formatter = new SimpleDateFormat("M/dd/yyyy");
				// date = formatter.parse(nextLine[2]);

				price = new DailyPrice(nextLine[0], nextLine[1], date,
						Double.parseDouble(nextLine[3]),
						Double.parseDouble(nextLine[4]),
						Double.parseDouble(nextLine[5]),
						Double.parseDouble(nextLine[6]),
						Integer.parseInt(nextLine[7]),
						Double.parseDouble(nextLine[8]));
				if (map.containsKey(price.getSymbol())) {
					List<DailyPrice> list = map.get(price.getSymbol());
					list.add(price);
					map.put(price.getSymbol(), list);
				} else {
					List<DailyPrice> list = new ArrayList<DailyPrice>();
					list.add(price);
					map.put(price.getSymbol(), list);
				}
			}
		}
		reader.close();
	}

	public boolean contains(String symbol) {
		return map.containsKey(symbol);
	}

	public List<DailyPrice> getPrices(String symbol) {
		List<DailyPrice> list = new ArrayList<DailyPrice>();
		if (!map.containsKey(symbol)) {
			return list;
		}
		list = map.get(symbol);
		DateComparator compare = new DateComparator();
		Collections.sort(list, compare);
		return list;
	}

	public List<DailyPrice> getPrices(String symbol, Date startDate,
			Date endDate) {
		List<DailyPrice> list2 = new ArrayList<DailyPrice>();
		if (!map.containsKey(symbol)) {
			return list2;
		}
		List<DailyPrice> list = getPrices(symbol);

		DateComparator compare = new DateComparator();
		endDate.setDate(endDate.getDate() + 1);
		for (DailyPrice d : list) {
			if (d.getDate().before(endDate) && d.getDate().after(startDate)) {
				list2.add(d);

			}
		}
		Collections.sort(list, compare);
		return list2;
	}
}
