package rubinstein.morseCode;

import org.junit.Assert;
import org.junit.Test;

public class MorseCodeTest {
	MorseCode morseCode = new MorseCode();

	@Test
	public void testAlphabetToMorseCode() {

		String alphabet = ("abcdefghijklmnopqrstuvwxy Z");
		String code = morseCode.toMorseCode(alphabet);
		String expected = ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- / --..";

		Assert.assertEquals(expected, code);
	}

	@Test
	public void testMorseCodeToAlphabet() {
		String morse = (".... .. / .... --- .-- / .- .-. . / -.-- --- ..-");
		String code = morseCode.toPlainText(morse);
		String expected = ("HI HOW ARE YOU");
		Assert.assertEquals(expected, code);
	}

}
