package model;

import java.util.HashMap;
import java.util.Map;


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
	private static Map<String, CardValue> symbolMap = new HashMap<String, CardValue>();
	
	static {
		for(CardValue cardValue : CardValue.values())
			symbolMap.put(cardValue.getSymbol(), cardValue);
	}
	
	public String getName() { return name; }
	public String getSymbol() { return symbol; }
	public int getIntValue() { return this.ordinal(); }
	
	public static CardValue getBySymbol(String symbol){ return CardValue.symbolMap.get(symbol); }
}
