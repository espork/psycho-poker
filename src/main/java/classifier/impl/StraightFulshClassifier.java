package classifier.impl;
import model.Hand;
import model.HandType;
import classifier.HandClassifier;


public class StraightFulshClassifier implements HandClassifier {

	@Override
	public boolean isClassified(Hand hand) {
		return hand.hasSameSuits() && hand.isSequential();
	}
	
	
	@Override
	public HandType type() { return HandType.STRAIGHT_FLUSH; }

	@Override
	public Integer priority() { return HandType.STRAIGHT_FLUSH.ordinal(); }
}
