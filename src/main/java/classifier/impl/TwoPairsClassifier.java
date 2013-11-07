package classifier.impl;

import model.Card;
import model.Hand;
import model.HandType;
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
	
	
	@Override
	public HandType type() { return HandType.TWO_PAIRS; }

	@Override
	public Integer priority() { return HandType.TWO_PAIRS.ordinal(); }
}
