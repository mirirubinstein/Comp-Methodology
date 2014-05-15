package rubinstein.dictionary;

import org.junit.Assert;
import org.junit.Test;


public class DictionaryTest {

	@Test
	public void testExists() throws Exception {
		Dictionary dict = new Dictionary();
		Boolean code = dict.exists("penetrance");
		Assert.assertTrue(code);
	}
	@Test
	public void testNotExists() throws Exception {
		Dictionary dict = new Dictionary();
		Boolean code = dict.exists("PENERANCEsdfffs");
		Assert.assertFalse(code);
	}
}
