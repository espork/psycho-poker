import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import model.Hand;
import model.HandType;

import org.junit.Test;



public class HandTest {
	
	
	@Test
	public void shoudBuildCorrectHand(){
		
		Hand hand = Hand.from("3H 5H 2D JS 6C");
		
		assertEquals("The hand size should be 5", 5, hand.size());
	}
	
	@Test
	public void shouldReturSequentialWithAceAndTwo() {
		
		Hand hand = Hand.from("3H 5H 2H 4H AH");
		
		assertTrue("The hand should be sequencial", hand.isSequential());
	}
	
	@Test
	public void shouldNotReturSequentialWithRepeatedValue() {
		
		Hand hand = Hand.from("3H 3H 2H 4H AH");
		
		assertFalse("The hand should not be sequencial", hand.isSequential());
	}
	
	@Test
	public void shouldReturSequentialWithAceAndKing() {
		
		Hand hand = Hand.from("KH TH QH JH AH");
						
		assertTrue("The hand should be sequencial", hand.isSequential());
	}
	
	@Test
	public void shouldReturSequentialWithoutAce() {
		
		Hand hand = Hand.from("KH TH QH JH 9H");
		
		assertTrue("The hand should be sequencial", hand.isSequential());
	}
	
	@Test
	public void shouldReturnStratigthFlush () {
		
		Hand hand = Hand.from("TH JH QH KH AH");
		
		assertEquals("The type of hand should be straigth flush", HandType.STRAIGHT_FLUSH, hand.bestType());
	}
	
	@Test
	public void shouldNotReturnStratigthFlush() {
		
		Hand hand = Hand.from("2H JH QH KH AH");
		
		assertTrue("The type of hand should not be straigth flush", HandType.STRAIGHT_FLUSH != hand.bestType());
	}
	
	@Test
	public void shouldReturnFourOfAkindInFirtPosition() {
		
		Hand hand = Hand.from("2D 3D 3H 3S 3C");
		
		assertEquals("The type of hand should be straigth flush", HandType.FOUR_OF_A_KIND, hand.bestType());
	}
	
	
	@Test
	public void shouldReturnFullHouse() {
		
		Hand hand = Hand.from("2H 2S 3H 3S 3C");
		
		assertEquals("The type of hand should be full house", HandType.FULL_HOUSE, hand.bestType());
		
	}
	
	
	@Test
	public void shouldReturnFlush() {
		
		Hand hand = Hand.from("2H 5H 7H AH 6H");
		
		assertEquals("The type of hand should be full house", HandType.FLUSH, hand.bestType());
	}
	
	@Test
	public void shouldReturnStraight() {
		
		Hand hand = Hand.from("3H 4S 2D AC 5H");
		
		assertEquals("The type of hand should be straight", HandType.STRAIGHT, hand.bestType());
	}
	
	@Test
	public void shouldReturnFourOfAkind() {
		
		Hand hand = Hand.from("2H JS 2D 2C 9H");
		
		assertEquals("The type of hand should be three of a kind", HandType.THREE_OF_A_KIND, hand.bestType());
	}
	
	@Test
	public void shouldReturnTwoPairs() {
		
		Hand hand = Hand.from("AH 2S 3D 2C 3H");
		
		assertEquals("The type of hand should be two pairs", HandType.TWO_PAIRS, hand.bestType());
	}
	
	@Test
	public void shouldReturnOnePairs() {
		
		Hand hand = Hand.from("AH JS 3D JC 2H");
		
		assertEquals("The type of hand should be two pairs", HandType.ONE_PAIR, hand.bestType());
	}
}
