import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import model.HandType;
import model.Result;

import org.junit.Test;

import core.Game;


public class GameTest {
	
	
	@Test 
	public void shouldBuildAllLines(){
		StringBuilder input = new StringBuilder("TH JH QH KH AH QC QD QS 2S 6S\n")
										.append("2H 2S 3H 3S 3C 2D 3D 6C 9C TH\n")
										.append("2H 2S 3H 3S 3C 2D 9C 3D 6C TH\n")
										.append("2H AD 5H AC 7H AH 6H 9H 4H 3C\n")
										.append("AC 2D 9C 3S KD 5S 4D KS AS 4C\n")
										.append("KS AH 2H 3C 4H KC 2C TC 2D AS\n")
										.append("AH 2C 9S AD 3C QH KS JS JD KD\n")
										.append("6C 9C 8C 2D 7C 2H TC 4C 9S AH\n")
										.append("3D 5S 2H QD TD 6S KH 9H AD QH\n");
		

		List<Result> outPut = Game.from(input.toString()).start().result();

		assertTrue("Result should be Straigth Flush",outPut.size() == 9);
	}
	
	@Test 
	public void shouldReturnHandStraighFlush(){
		StringBuilder input = new StringBuilder("TH JH QH KH AH QC QD QS 2S 6S\n");
		
		List<Result> outPut = Game.from(input.toString()).start().result();

		assertEquals("Result should be Straigth Flush",HandType.STRAIGHT_FLUSH,outPut.get(0).getFinalHand().bestType());
	}
	
	@Test 
	public void shouldReturnDeckStraighFlush(){
		StringBuilder input = new StringBuilder("QC QD QS 2S 6S TH JH QH KH AH\n");
		

		List<Result> outPut = Game.from(input.toString()).start().result();

		assertEquals("Result should be Straigth Flush",HandType.STRAIGHT_FLUSH,outPut.get(0).getFinalHand().bestType());
	}
	
	@Test
	public void sholdReturnStraigthFlushHand() {
		
		StringBuilder input = new StringBuilder("TH 9H QC QD QS QH KH AH JH 6S\n")
										.append("TH JH QC QD QS QH KH AH 2S 6S\n");
										
		
		List<Result> outPut = Game.from(input.toString()).start().result();
		
		for(Result result : outPut)
			assertEquals("Result should be Straigth Flush",HandType.STRAIGHT_FLUSH,result.getFinalHand().bestType());
	}
	
	
	@Test
	public void shouldReturnFourOfAkind() {
		
		StringBuilder input = new StringBuilder("2H 2S 3H 3S 3C 2D 3D 6C 9C TH\n");

		List<Result> outPut = Game.from(input.toString()).start().result();

		for(Result result : outPut)
			assertEquals("Result should be Fourk of a Kind",HandType.FOUR_OF_A_KIND,result.getFinalHand().bestType());
	}
	
	@Test
	public void shouldReturnFullHouse() {
		
		StringBuilder input = new StringBuilder("2H 2S 3H 3S 3C 2D 9C 3D 6C TH\n");

		List<Result> outPut = Game.from(input.toString()).start().result();

		for(Result result : outPut)
			assertEquals("Result should be Fourk of a Kind",HandType.FULL_HOUSE,result.getFinalHand().bestType());
	}
	
	@Test
	public void shouldReturnFlush() {
		
		StringBuilder input = new StringBuilder("2H AD 5H AC 7H AH 6H 9H 4H 3C\n");

		List<Result> outPut = Game.from(input.toString()).start().result();

		for(Result result : outPut)
			assertEquals("Result should be Flush",HandType.FLUSH,result.getFinalHand().bestType());
	}
	
	@Test
	public void shouldReturnStraight() {
		
		StringBuilder input = new StringBuilder("AC 2D 9C 3S KD 5S 4D KS AS 4C\n");

		List<Result> outPut = Game.from(input.toString()).start().result();

		for(Result result : outPut)
			assertEquals("Result should be Flush",HandType.STRAIGHT,result.getFinalHand().bestType());
	}
	
	@Test
	public void shouldReturnThreeOfAkind() {
		
		StringBuilder input = new StringBuilder("KS AH 2H 3C 4H KC 2C TC 2D AS\n");

		List<Result> outPut = Game.from(input.toString()).start().result();

		for(Result result : outPut)
			assertEquals("Result should be Flush",HandType.THREE_OF_A_KIND,result.getFinalHand().bestType());
	}
	
	@Test
	public void shouldReturnTwoPairs() {
		
		StringBuilder input = new StringBuilder("AH 2C 9S AD 3C QH KS JS JD KD\n");

		List<Result> outPut = Game.from(input.toString()).start().result();

		for(Result result : outPut)
			assertEquals("Result should be Flush",HandType.TWO_PAIRS,result.getFinalHand().bestType());
	}
	
	@Test
	public void shouldReturnOnePair() {
		
		StringBuilder input = new StringBuilder("6C 9C 8C 2D 7C 2H TC 4C 9S AH\n");

		List<Result> outPut = Game.from(input.toString()).start().result();

		for(Result result : outPut)
			assertEquals("Result should be Flush",HandType.ONE_PAIR,result.getFinalHand().bestType());
	}
	
	@Test
	public void shouldReturnHighestCard() {
		
		StringBuilder input = new StringBuilder("3D 5S 2H QD TD 6S KH 9H AD QH\n");

		List<Result> outPut = Game.from(input.toString()).start().result();

		for(Result result : outPut)
			assertEquals("Result should be Flush",HandType.HIGHEST_CARD,result.getFinalHand().bestType());
	}
}
