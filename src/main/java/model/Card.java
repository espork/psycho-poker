package model;

public class Card implements Comparable<Card> {

	private Suit suit;
	private CardValue value;
	
	private Card(Suit suit, CardValue value) {
		this.suit = suit;
		this.value = value;
	}
	
	
	public Suit getSuit() { return suit; }
	
	public CardValue getValue() { return value; }
	
	public int getIntValue() { return this.value.getIntValue(); }

	@Override
	public int compareTo(Card other) {  return this.getValue().compareTo(other.getValue());  }

	public boolean hasSameValueOf(Card card) { return this.value.compareTo(card.getValue()) ==  0 ; }
	
	public String toString() { return value.getSymbol() + suit.getValue(); }
	
	public static Card from(String card) {
		
		Suit cardSuit = null;
		CardValue cardValue = null;
		
		for(CardValue value : CardValue.values()){
			if(value.getSymbol().equals(String.valueOf(card.charAt(0)))) { 
				cardValue = value;
				break;
			}
			
		}
		
		for(Suit suit : Suit.values()) {
			if(suit.getValue().equals(String.valueOf(card.charAt(1)))) {
				cardSuit = suit;
				break;
			}
		}
		
		
		return new Card(cardSuit, cardValue);
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (suit != other.suit)
			return false;
		if (value != other.value)
			return false;
		return true;
	}
}
