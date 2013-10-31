package classifier.impl;
import model.Card;
import model.Hand;
import classifier.HandClassifier;



public class FourOfAkindClassifier  implements HandClassifier{

	@Override
	public boolean isClassified(Hand hand) {
		
		for(Card card : hand.getCards())
			if(hasFourCardsOf(card,hand)) return true;
		
		return false;
	}

	private boolean hasFourCardsOf(Card card,Hand hand) {
		int count = 0;
		for(Card cardToCompare : hand.getCards())
			if(card.hasSameValueOf(cardToCompare)) count++;
		
		return count >=4;
	}
}
