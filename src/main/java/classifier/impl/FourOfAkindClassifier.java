package classifier.impl;
import model.Card;
import model.Hand;
import classifier.HandClassifier;



public class FourOfAkindClassifier  implements HandClassifier{

	@Override
	public boolean isClassified(Hand hand) {
		
		for(Card card : hand.getCards())
			if(hand.numberOfOccurences(card)>=4) return true;
		
		return false;
	}
}
