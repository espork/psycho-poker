package core;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Card;
import model.Deck;
import model.Hand;
import model.Player;
import model.Result;



public class Game {
	
	private static final String PLAYER_LINE = "^(("+Card.PATTERN+".?){5})(("+Card.PATTERN+".?){5})$";
	
	private List<Player> players;
	List<Result> outPut = new ArrayList<Result>();
	
	private Game(List<Player> players) { this.players = players; }
	
	public static Game from(String input) {
		
		List<Player> players = new ArrayList<Player>();
		
		Pattern pattern = Pattern.compile(PLAYER_LINE,Pattern.MULTILINE);
		
		Matcher matcher = pattern.matcher(input);
		
		 while (matcher.find())
			 players.add(new Player(Hand.from(matcher.group(1)), Deck.from(matcher.group(3))));
		 
		 return new Game(players);
	}
	
	public Game start() {
		
		for(Player player : players)
			outPut.add(new Result(player.play().getNewHand()));
		
		return this;
	}
	
	public List<Result> result() { return this.outPut ;}
}
