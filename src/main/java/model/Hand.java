package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
	
	private static Map<HandType,HandClassifier> map = new HashMap<HandType, HandClassifier>();
	
	static {
		map.put(HandType.STRAIGHT_FLUSH, new StraightFulshClassifier());
		map.put(HandType.FOUR_OF_A_KIND, new FourOfAkindClassifier());
		map.put(HandType.FULL_HOUSE, new FullHouseClassifier());
		map.put(HandType.FLUSH, new FlushClassifier());
		map.put(HandType.STRAIGHT, new StraightClassifier());
		map.put(HandType.THREE_OF_A_KIND, new ThreeOfAkindClassifier());
		map.put(HandType.TWO_PAIRS, new TwoPairsClassifier());
		map.put(HandType.ONE_PAIR, new OnePairClassifier());
	}
	
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
		
		Pattern pattern = Pattern.compile("([2-9|(T|J|Q|K|A)][H|S|C|D])");
		Matcher matcher = pattern.matcher(cards);
		
		while (matcher.find())
			 hand.addCard(Card.from(matcher.group()));
		
		return hand;
	}
	
	public HandType bestType() {
		for(HandType type : HandType.values())
			if(map.get(type)!=null && map.get(type).isClassified(this)) return type;
		
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
	
}
