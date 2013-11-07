package classifier.impl;

import model.Hand;
import model.HandType;
import classifier.HandClassifier;

public class FlushClassifier implements HandClassifier{

	@Override
	public boolean isClassified(Hand hand) {
		return hand.hasSameSuits();
	}

	@Override
	public HandType type() { return HandType.FLUSH; }

	@Override
	public Integer priority() { return HandType.FLUSH.ordinal(); }

	
	
}
