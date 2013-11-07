package classifier.impl;

import model.Card;
import model.Hand;
import model.HandType;
import classifier.HandClassifier;

public class ThreeOfAkindClassifier implements HandClassifier{

	@Override
	public boolean isClassified(Hand hand) {
		
		for(Card card : hand.getCards())
			if(hand.numberOfOccurences(card) >=3) return true;
		
		return false;
	}
	
	
	@Override
	public HandType type() { return HandType.THREE_OF_A_KIND; }

	@Override
	public Integer priority() { return HandType.THREE_OF_A_KIND.ordinal(); }
}
