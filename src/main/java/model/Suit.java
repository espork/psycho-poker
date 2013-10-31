package model;

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
	
	public String getValue() { return value; }
	public String getName() { return name; }
}
