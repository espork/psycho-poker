package model;

import java.util.Arrays;
import java.util.List;

import utils.CardCombinator;


public class Player {

	private Hand hand;
	private Deck deck;
	private Hand newHand;
	
	public Player(Hand hand, Deck deck) {
		this.hand = hand;
		this.deck = deck;
	}
	
	public Hand getHand() { return hand; }
	public Hand getNewHand() { return this.newHand ; }
	
	public Player play() {
	  hand.order();
	  Hand auxHand = new Hand();
	  
	  for(HandType handType : HandType.values()) {
		  	
		  	auxHand.clear();
			if(hand.bestType() == handType){
				newHand = hand;
				return this;
			}
			
			if(auxHand.addCards(deck.get(hand.size())).bestType() == handType){
				newHand = auxHand;
				return this;
			}
			
			auxHand.clear();
			
			CardCombinator combinator = CardCombinator.from(hand.getCards());
			for(int number = 1 ; number <this.hand.size() ; number ++){
				
				List<Card[]> combinations = combinator.withRate(number).combine();
				
				for(Card[] combination : combinations){
					
					if(auxHand.addCards((List<Card>)Arrays.asList(combination)).addCards(deck.get(hand.size() -auxHand.size())).bestType() == handType) {
						newHand = auxHand;
						return this;
					}
					
					auxHand.clear();
				}
			}
		}
	  
	  return this;
	}
	
	
}
