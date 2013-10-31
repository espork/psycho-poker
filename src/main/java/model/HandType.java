package model;

public enum HandType {

	STRAIGHT_FLUSH("straight-flush"),
	FOUR_OF_A_KIND("four-of-a-kind"),
	FULL_HOUSE("full-house"),
	FLUSH("flush"),
	STRAIGHT("straight"),
	THREE_OF_A_KIND("three-of-a-kind"),
	TWO_PAIRS("tow-pairs"),
	ONE_PAIR("one-pairs"),
	HIGHEST_CARD("highest-card");
	
	HandType(String name) {
		this.name = name;
	}
	
	private String name;
	
	public String getName() { return name; }
	
}
