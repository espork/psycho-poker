package classifier.impl;

import model.Card;
import model.Hand;
import classifier.HandClassifier;

public class TwoPairsClassifier implements HandClassifier {

	@Override
	public boolean isClassified(Hand hand) {
		
		hand.order();
		
		Card cardReferencONe = null ;

		for(Card card : hand.getCards()){
			
			if( numberOfOccurences(card, hand) >= 2) {
				if(cardReferencONe == null)
					cardReferencONe = card;
				else if(!card.hasSameValueOf(cardReferencONe))
					return true;
				
			}
			
		}
			
		return false;
	}
	
	private int numberOfOccurences(Card card, Hand hand) {
		
		int number = 0;
		
		for(Card cardToCompare : hand.getCards())
			if(cardToCompare.hasSameValueOf(card)) number ++;
		
		return number;
	}

}
