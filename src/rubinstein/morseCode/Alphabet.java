package rubinstein.morseCode;

public enum Alphabet {

	A("A", ".-"), B("B", "-..."), C("C", "-.-."), D("D", "-.."), E("E", "."), F(
			"F", "..-."), G("G", "--."), H("H", "...."), I("I", ".."), J("J",
			".---"), K("K", "-.-"), L("L", ".-.."), M("M", "--"), N("N", "-."), O(
			"O", "---"), P("P", ".--."), Q("Q", "--.-"), R("R", ".-."), S("S",
			"..."), T("T", "-"), U("U", "..-"), V("V", "...-"), W("W", ".--"), X(
			"X", "-..-"), Y("Y", "-.--"), Z("Z", "--.."), ZERO("0", "-----"), ONE(
			"1", ".----"), TWO("2", "..---"), THREE("3", "...--"), FOUR("4",
			"....-"), FIVE("5", "....."), SIX("6", "-...."), SEVEN("7", "--..."), EIGHT(
			"8", "---.."), NINE("9", "----."), SPACE(" ", "/");

	private final String morseValue;
	private final String charValue;

	private Alphabet(final String StringValue, final String alphabet) {
		this.charValue = StringValue;
		this.morseValue = alphabet;
	}

	public String getMorseValue() {
		return morseValue;
	}

	public String getCharValue() {
		return charValue;
	}
}
