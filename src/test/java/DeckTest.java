import static org.junit.Assert.assertEquals;

import java.util.List;

import model.Card;
import model.Deck;

import org.junit.Test;



public class DeckTest {
	
	
	@Test
	public void shoudBuildCorrectDeck(){
		
		Deck deck = Deck.from("4S 5D AH JH KC");
		
		assertEquals("The deck size should be 5", 5, deck.getCards().size());
	}
	
	@Test
	public void shoudReturnCards(){
		
		Deck deck = Deck.from("4S 5D AH JH KC");
		
		List<Card> cards = deck.get(3);
		
		assertEquals("The cads size should be 3", 3, cards.size());
		assertEquals("The first card shoud be 4S",Card.from("4S"), cards.get(0));
		assertEquals("The first card shoud be 5S",Card.from("5D"), cards.get(1));
		assertEquals("The first card shoud be 5S",Card.from("AH"), cards.get(2));
	}
}



