package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import classifier.HandClassifier;
import classifier.impl.FlushClassifier;
import classifier.impl.FourOfAkindClassifier;
import classifier.impl.FullHouseClassifier;
import classifier.impl.OnePairClassifier;
import classifier.impl.StraightClassifier;
import classifier.impl.StraightFulshClassifier;
import classifier.impl.ThreeOfAkindClassifier;
import classifier.impl.TwoPairsClassifier;

public class Hand {
	
	
	private static List<HandClassifier> classifiers = new ArrayList<HandClassifier>();
	
	private List<Card> cards = new ArrayList<Card>();
	
	public List<Card> getCards() { return cards; }
	
	public int size () { return this.cards.size(); }
	
	public void order() {  Collections.sort(cards); }
	
	public void clear() {  this.cards.clear(); }
	
	public Card getCardAt(int index) { return  this.cards.get(index) ; }
	
	public boolean contains(Card card) { return this.cards.contains(card); }
	
	public boolean contains(CardValue value) {
		for(Card card : this.cards)
			if(card.getValue() == value) return true ;
		return false;
	}
	
	public Hand addCard(Card card) {
		this.cards.add(card);
		return this;
	}
	
	public Hand addCards(List<Card> cards) {
		this.cards.addAll(cards);
		return this;
	}
	
	
	public static Hand from(String cards) {
		
		Hand hand = new Hand();
		
		Matcher matcher = Pattern.compile(Card.PATTERN).matcher(cards);
		
		while (matcher.find())
			 hand.addCard(Card.from(matcher.group()));
		
		return hand;
	}
	
	public HandType bestType() {
		for(HandClassifier classifier : classifiers)
			if(classifier.isClassified(this)) return classifier.type();
		
		return HandType.HIGHEST_CARD;
	}
	
	public boolean hasSameSuits() {
		Suit reference = this.cards.get(0).getSuit();
		
		for(Card card : this.cards)
			if(!reference.equals(card.getSuit())) return false;
		
		return true;
	}
	
	public boolean isSequential() {
		
		this.order();
		
		int maxIndex = (this.contains(CardValue.ACE) && this.contains(CardValue.DOUCE)) ? this.size()-1 
																							: this.size();
		for(int i=1;i<maxIndex;i++)
			if(this.getCardAt(i).getIntValue() - this.getCardAt(i-1).getIntValue() != 1)
				return false;
		
		return true;

	}
	
	public int numberOfOccurences(Card card) {
		
		int number = 0;
		
		for(Card cardToCompare : this.getCards())
			if(cardToCompare.hasSameValueOf(card)) number ++;
		
		return number;
	}
	

	static {
		
		classifiers.add(new StraightFulshClassifier());
		classifiers.add(new FourOfAkindClassifier());
		classifiers.add(new FullHouseClassifier());
		classifiers.add(new FlushClassifier());
		classifiers.add(new StraightClassifier());
		classifiers.add(new ThreeOfAkindClassifier());
		classifiers.add(new TwoPairsClassifier());
		classifiers.add(new OnePairClassifier());
		
		Collections.sort(classifiers, new Comparator<HandClassifier>() {

			@Override
			public int compare(HandClassifier classifier, HandClassifier otherClassifier) {
				
				return classifier.priority().compareTo(otherClassifier.priority());
			}
		});
	}
	
}
