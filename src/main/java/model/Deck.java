package model;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Deck {

	private List<Card> cards = new ArrayList<Card>();
	
	public Deck (List<Card> cards) { this.cards = cards; }
	
	public List<Card> getCards() { return cards; }
	
	private Deck(){}
	
	public static Deck from(String cards) {
		
		
		Deck deck = new Deck();
		
		Matcher matcher = Pattern.compile(Card.PATTERN).matcher(cards);
		
		while (matcher.find()) {
			 
			 String card = matcher.group();
			 deck.getCards().add(Card.from(card));
		 }
		
		return deck;
	}
	
	public List<Card> get(int numberOfCards) {
		
		List<Card> cardsToReturn = new ArrayList<Card>();
		for(int index = 0; index < numberOfCards ; index ++ )
			cardsToReturn.add(this.cards.get(index));
			
		return cardsToReturn;
	}
}
