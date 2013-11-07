package classifier;

import model.Hand;
import model.HandType;



public interface HandClassifier {

	boolean isClassified(Hand hand);
	HandType type();
	Integer priority();
}
