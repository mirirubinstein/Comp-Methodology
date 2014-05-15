package rubinstein.dictionary;

public enum Alphabet {
	A('A'), B('B'), C('C'), D('D'), E('E'), F('F'), G('G'), H('H'), I('I'), J(
			'J'), K('K'), L('L'), M('M'), N('N'), O('O'), P('P'), Q('Q'), R('R'), S(
			'S'), T('T'), U('U'), V('V'), W('W'), X('X'), Y('Y'), Z('Z');

	private final char charValue;

	private Alphabet(final char charValue) {
		this.charValue = charValue;
	}

	public char getChar() {
		return charValue;
	}

}
