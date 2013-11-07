package classifier.impl;

import model.Hand;
import model.HandType;
import classifier.HandClassifier;

public class StraightClassifier implements HandClassifier{

	@Override
	public boolean isClassified(Hand hand) {
		return hand.isSequential();
	}
	
	
	@Override
	public HandType type() { return HandType.STRAIGHT; }

	@Override
	public Integer priority() { return HandType.STRAIGHT.ordinal(); }
}
