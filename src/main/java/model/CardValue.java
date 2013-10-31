package model;

public enum CardValue {

	
	DOUCE("Douce","2"),
	THREE("Three","3"),
	FOUR("Four","4"),
	FIVE("Five","5"),
	SIX("Six","6"),
	SEVEN("Seven","7"),
	EIGHT("Eight","8"),
	NINE("Nine","9"),
	TEN("Ten","T"),
	JACK("Jack","J"),
	QUEEN("Queen","Q"),
	KING("King","K"),
	ACE("Ace","A");
	
	
	CardValue(String name,String symbol) {
		this.name = name;
		this.symbol = symbol;
	}
	
	private String name;
	private String symbol;
	
	public String getName() { return name; }
	public String getSymbol() { return symbol; }
	public int getIntValue() { return this.ordinal(); }
}
