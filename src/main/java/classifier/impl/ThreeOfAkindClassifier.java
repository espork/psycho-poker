package classifier.impl;

import model.Card;
import model.Hand;
import classifier.HandClassifier;

public class ThreeOfAkindClassifier implements HandClassifier{

	@Override
	public boolean isClassified(Hand hand) {
		
		for(Card card : hand.getCards())
			if(hand.numberOfOccurences(card) >=3) return true;
		
		return false;
	}
}
