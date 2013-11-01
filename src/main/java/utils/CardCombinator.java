package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Card;



public class CardCombinator {
	  
	  private Card result[] = null;
	  private Card elements[];
	  private int rate;
	  
	  
	  private CardCombinator(Card[] cards) {
		  this.elements = cards;
	  }
	  
	  public static CardCombinator from (List<Card> cards) {
		  
		  Card[] arrayCard = new Card[cards.size()];
		  for(int index = 0 ; index < cards.size() ; index++)
			  arrayCard[index] = cards.get(index);
		  
		  return new CardCombinator(arrayCard); 
	  }
	  
	  public CardCombinator withRate(int rate) {
		  this.rate = rate;
		  this.result = new Card[rate];
		  return this;
	  }
	  
	  public List<Card[]> combine() { return this.combine(0, this.elements.length - rate, 0); }
	  
	  
	  private List<Card[]> combine(int beginning,int end, int depth){
		  
		  	List<Card[]> combinations = new ArrayList<Card[]>();
		  	
	        if ( (depth + 1) >= rate){  
		        for(int x = beginning; x <= end; x++){  
		        	result[depth] = elements[x];
		            
		        	combinations.add(Arrays.copyOf(result, result.length));
		        }
		        
		        return combinations;
	        }    
		    else { 
		        for(int x = beginning; x <= end; x++){
		        	
		        	result[depth] = elements[x];  
		        	combinations.addAll(combine(x + 1,end + 1,depth + 1));  
		        }
		    }
	        
	        return combinations;
	    }
}
