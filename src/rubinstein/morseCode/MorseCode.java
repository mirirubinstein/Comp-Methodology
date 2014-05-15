package rubinstein.morseCode;

import java.util.HashMap;
import java.util.Map;

public class MorseCode {
	private final Map<String, String> charToCode;

	// private final Map<String, Character> codeToChar;

	public MorseCode() {
		charToCode = new HashMap<String, String>();
		// codeToChar = new HashMap<String, Character>();

		Alphabet[] alph = Alphabet.values();
		for (Alphabet a : alph) {
			charToCode.put(a.getCharValue(), a.getMorseValue());
			charToCode.put(a.getMorseValue(), a.getCharValue());
		}
	}

	public String toMorseCode(String text) {
		String input = text.trim();
		StringBuilder morseCode = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			String c = Character.toString(input.toUpperCase().charAt(i));

			String code = charToCode.get(c);
			morseCode.append(code);
			morseCode.append(" ");
		}
		return morseCode.toString().trim();
	}

	public String toPlainText(String input) {
		StringBuilder text = new StringBuilder();
		String[] letters = input.split("\\s");

		for (int i = 0; i < letters.length; i++) {
			String s = letters[i];
			String c = charToCode.get(s);
			text.append(c);

		}
		return text.toString();
	}
}
