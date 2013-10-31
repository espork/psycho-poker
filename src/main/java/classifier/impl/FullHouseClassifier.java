package classifier.impl;

import model.Card;
import model.Hand;
import classifier.HandClassifier;

public class FullHouseClassifier implements HandClassifier {

	@Override
	public boolean isClassified(Hand hand) {
		
		hand.order();
		boolean hasThree = false;
		boolean hasTwo = false;
		
		int occurrences = 0;
		for(Card card : hand.getCards()){
			
			occurrences = numberOfOccurences(card, hand);
			if(occurrences == 2) hasTwo = true;
			else if (occurrences == 3) hasThree = true;
			
			if (hasTwo && hasThree) return true;
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
