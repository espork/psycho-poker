package classifier.impl;
import model.Hand;
import classifier.HandClassifier;


public class StraightFulshClassifier implements HandClassifier {

	@Override
	public boolean isClassified(Hand hand) {
		return hand.hasSameSuits() && hand.isSequential();
	}
}
