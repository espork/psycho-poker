package classifier.impl;

import model.Card;
import model.Hand;
import model.HandType;
import classifier.HandClassifier;

public class FullHouseClassifier implements HandClassifier {

	@Override
	public boolean isClassified(Hand hand) {
		
		hand.order();
		boolean hasThree = false;
		boolean hasTwo = false;
		
		int occurrences = 0;
		for(Card card : hand.getCards()){
			
			occurrences = hand.numberOfOccurences(card);
			if(occurrences == 2) hasTwo = true;
			else if (occurrences == 3) hasThree = true;
			
			if (hasTwo && hasThree) return true;
		}
			
		return false;
	}
	
	@Override
	public HandType type() { return HandType.FULL_HOUSE; }

	@Override
	public Integer priority() { return HandType.FULL_HOUSE.ordinal(); }
}
