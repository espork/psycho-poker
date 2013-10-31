package classifier.impl;

import model.Hand;
import classifier.HandClassifier;

public class FlushClassifier implements HandClassifier{

	@Override
	public boolean isClassified(Hand hand) {
		return hand.hasSameSuits();
	}

	
	
}
