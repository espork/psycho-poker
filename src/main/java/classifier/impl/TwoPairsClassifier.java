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
			
			if( hand.numberOfOccurences(card)>= 2) {
				if(cardReferencONe == null)
					cardReferencONe = card;
				else if(!card.hasSameValueOf(cardReferencONe))
					return true;
				
			}
			
		}
			
		return false;
	}
}
