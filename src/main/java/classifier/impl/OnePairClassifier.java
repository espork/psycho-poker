package classifier.impl;

import model.Card;
import model.Hand;
import model.HandType;
import classifier.HandClassifier;

public class OnePairClassifier implements HandClassifier {

	@Override
	public boolean isClassified(Hand hand) {
		
		hand.order();
		
		for(Card card : hand.getCards())
			if( hand.numberOfOccurences(card) >= 2)
				return true;
			
		return false;
	}
	
	@Override
	public HandType type() { return HandType.ONE_PAIR; }

	@Override
	public Integer priority() { return HandType.ONE_PAIR.ordinal(); }
}
