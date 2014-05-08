package rubinstein.tictactoe;


public enum Symbol {
	X('X'), O('O');

	private final char asChar;

	private Symbol(char asChar) {
		this.asChar = asChar;
	}

	public Symbol getSymbol() {
		return getSymbol();
	}

	public static Symbol valueOf(char x) {
		Symbol sym = null;
		if (x == 'x' || x == 'X')
			sym = X;
		else if (x == 'o' || x == 'O')
			sym = O;
		return sym;
	}

}
