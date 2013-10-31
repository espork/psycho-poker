package model;

public class Result {
	
	private Hand finalHand;
	
	
	public Result(Hand hand) {
		this.finalHand = hand;
	}


	public Hand getFinalHand() { return finalHand; }
	
	public String toString () {
		StringBuilder stringBuilder = new StringBuilder();
		for(Card card :finalHand.getCards())
			stringBuilder.append(card.toString() + " ");
		
		stringBuilder.append(" - Melhor Jogo : " + finalHand.bestType().getName());
		
		return stringBuilder.toString();
	}
}
