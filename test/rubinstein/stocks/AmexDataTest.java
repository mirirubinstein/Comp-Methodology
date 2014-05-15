package rubinstein.stocks;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AmexDataTest {

	@Test
	public void testConstructor() throws IOException, ParseException {
		AmexData data = new AmexData();
	}

	@Test
	public void testContainsTrue() throws IOException, ParseException {
		AmexData data = new AmexData();

		Assert.assertTrue(data.contains("BNX"));
	}

	@Test
	public void testContainsFalse() throws IOException, ParseException {
		AmexData data = new AmexData();
		Assert.assertFalse(data.contains("ABP"));
	}

	@Test
	public void testEmptyList() throws IOException, ParseException {
		AmexData data = new AmexData();
		Date startDate = new Date(120, 3, 2);
		Date endDate = new Date(120, 3, 20);
		List<DailyPrice> actual = data.getPrices("BNX", startDate, endDate);
		List<DailyPrice> expected = new ArrayList<DailyPrice>();
		Assert.assertEquals(expected, actual);

	}

	@Test
	public void testNonExistantSymbol() throws IOException, ParseException {
		AmexData data = new AmexData();
		List<DailyPrice> actual = data.getPrices("B");
		List<DailyPrice> expected = new ArrayList<DailyPrice>();
		Assert.assertEquals(expected, actual);
	}

	/*
	 * @Test public void testGetPricesSymbol() throws IOException,
	 * ParseException { AmexData data = new AmexData(); List<DailyPrice> actual
	 * = data.getPrices("AZ"); List<DailyPrice> expected = new
	 * ArrayList<DailyPrice>(); Date date = new Date(); Calendar cal =
	 * Calendar.getInstance(); cal.set(2014, 3, 2, 0, 0); date = cal.getTime();
	 * DailyPrice x = new DailyPrice("AMEX", "AZ", date, 2, 2, 2, 2, 2, 2);
	 * expected.add(x); // System.out.println("X: " + x.toString()); //
	 * System.out.println(expected.toString()); //
	 * System.out.println(actual.toString()); Assert.assertEquals(expected,
	 * actual); // Assert.assertTrue(expected.equals(actual)); }
	 * 
	 * @Test public void testGetPricesDateRange() throws IOException,
	 * ParseException { AmexData data = new AmexData(); Date startDate = new
	 * Date(114, 3, 2); Date endDate = new Date(114, 3, 20); //
	 * System.out.println(startDate.toString()); //
	 * System.out.println(endDate.toString());
	 * 
	 * List<DailyPrice> actual = data.getPrices("AY", startDate, endDate);
	 * List<DailyPrice> expected = new ArrayList<DailyPrice>();
	 * 
	 * Date date = new Date(); Calendar cal = Calendar.getInstance();
	 * cal.set(2014, 3, 7, 0, 0); date = cal.getTime(); DailyPrice x1 = new
	 * DailyPrice("AMEX", "AY", date, 2, 2, 2, 2, 2, 2); expected.add(x1);
	 * 
	 * cal.set(2014, 3, 20, 0, 0); date = cal.getTime(); DailyPrice x2 = new
	 * DailyPrice("AMEX", "AY", date, 2, 2, 2, 2, 2, 2); expected.add(x2);
	 * 
	 * cal.set(2014, 3, 2, 0, 0); date = cal.getTime(); DailyPrice x3 = new
	 * DailyPrice("AMEX", "AY", date, 2, 2, 2, 2, 2, 2); expected.add(x3);
	 * 
	 * DateComparator compare = new DateComparator(); Collections.sort(expected,
	 * compare); System.out.println(expected.toString());
	 * System.out.println(actual.toString());
	 * 
	 * Assert.assertEquals(expected, actual); }
	 */
}
