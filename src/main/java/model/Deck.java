package model;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Deck {

	private List<Card> cards = new ArrayList<Card>();
	
	public Deck (List<Card> cards) { this.cards = cards; }
	
	public List<Card> getCards() { return cards; }
	
	private Deck(){}
	
	public static Deck from(String cards) {
		
		
		Deck deck = new Deck();
		
		Pattern pattern = Pattern.compile("([2-9|(T|J|Q|K|A)][H|S|C|D])");
		Matcher matcher = pattern.matcher(cards);
		
		while (matcher.find()) {
			 
			 String card = matcher.group();
			 deck.getCards().add(Card.from(card));
		 }
		
		return deck;
	}
	
	public List<Card> get(int numberOfCards) {
		
		List<Card> cardsToReturn = new ArrayList<Card>();
		for(int index = 0; index < numberOfCards ; index ++ )
			cardsToReturn.add(this.cards.get(index));
			
		return cardsToReturn;
	}
	
	
	  	private int numeros[] = {1,2,3,4,5,6,7,8,9,10};  
	    private int quantidade = 4;  
	    private int resultado[] = new int[4];  
	  
	    private int count = 0;  
	  
	    private void busca(int inicio,int fim, int profundidade){  
	  
	        if ( (profundidade + 1) >= quantidade)  
	        for(int x = inicio; x <= fim; x++){  
	            resultado[profundidade] = numeros[x];  
	            // faz alguma coisa com um dos resultados possiveis  
	            count++;  
	            System.out.println(resultado[0] + ", " + resultado[1] + ", " + resultado[2] + ", "+ resultado[3] + "\n");  
	        }  
	    else  
	        for(int x = inicio; x <= fim; x++){  
	            resultado[profundidade] = numeros[x];  
	            busca(x + 1,fim + 1,profundidade + 1);  
	        }  
	    }  
	  
	    public static void main(String args[]){  
	  
	        Deck comb = new Deck();  
	        comb.busca(0, (10-4), 0);  
	        System.out.println("Total de combinacoes: " + comb.count);  
	  
	    } 
}
