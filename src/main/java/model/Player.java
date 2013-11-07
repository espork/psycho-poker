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
	  Hand experimentalHand = new Hand();
	  
	  for(HandType handType : HandType.values()) {
		  	
		  	experimentalHand.clear();
			if(hand.bestType() == handType){
				newHand = hand;
				return this;
			}
			
			if(experimentalHand.addCards(deck.get(hand.size())).bestType() == handType){
				newHand = experimentalHand;
				return this;
			}
			
			experimentalHand.clear();
			
			CardCombinator combinator = CardCombinator.from(hand.getCards());
			for(int number = 1 ; number <this.hand.size() ; number ++){
				
				List<Card[]> combinations = combinator.withRate(number).combine();
				
				for(Card[] combination : combinations){
					
					if(experimentalHand.addCards((List<Card>)Arrays.asList(combination)).addCards(deck.get(hand.size() -experimentalHand.size())).bestType() == handType) {
						newHand = experimentalHand;
						return this;
					}
					
					experimentalHand.clear();
				}
			}
		}
	  
	  return this;
	}
	
	
}
