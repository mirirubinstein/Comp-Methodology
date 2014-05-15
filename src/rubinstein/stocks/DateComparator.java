package rubinstein.stocks;

import java.util.Comparator;
import java.util.Date;

import rubinstein.stocks.DailyPrice;

class DateComparator implements Comparator<DailyPrice> {
	@Override
	public int compare(DailyPrice d1, DailyPrice d2) {
		return d1.getDate().compareTo(d2.getDate());
	}

	public int compare(Date d1, Date d2) {
		return d1.compareTo(d2);
	}
}
