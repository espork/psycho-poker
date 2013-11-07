package model;

import java.util.HashMap;
import java.util.Map;

public enum Suit {

	CLUBS("C","Clubs"),
	DIAMOND("D","Diamond"),
	HEARTH("H","Hearth"),
	SPADE("S","Spade");
	
	Suit(String value, String name) {
		this.value = value;
		this.name = name;
	}
	
	private String value;
	private String name;
	private static Map<String, Suit> valuelMap = new HashMap<String, Suit>();
	
	static {
		for(Suit suit : Suit.values())
			valuelMap.put(suit.getValue(), suit);
	}
	
	public String getValue() { return value; }
	public String getName() { return name; }
	
	public static Suit getByValue(String value){ return Suit.valuelMap.get(value); }
}
