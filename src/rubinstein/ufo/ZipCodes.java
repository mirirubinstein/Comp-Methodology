package rubinstein.ufo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class ZipCodes {
	private final List<ZipCode> zipCodes;

	public ZipCodes() throws IOException {
		zipCodes = new ArrayList<ZipCode>();
		CSVReader reader = new CSVReader(new FileReader("ZIP_CODES.txt"), ',');
		String[] nextLine;
		while ((nextLine = reader.readNext()) != null) {
			String zip = nextLine[0];
			String city = nextLine[3];
			String state = nextLine[4];
			// System.out.println(nextLine[0] + "\t" + nextLine[3] + "\t"
			// + nextLine[4]);
			zipCodes.add(new ZipCode(zip, city, state));
		}
	}

	public List<ZipCode> getZipCodes() {
		return zipCodes;
	}
}
