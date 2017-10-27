import java.util.ArrayList;
import java.util.List;

/**
 * creates a new game with two players
 * @author Ransom Reed
 * @author Chase Flowers
 * @author JT Schexnayder
 * @author Mubby Adeliyi
 *
 */

public class Wargame {
	
	private Deck deck = new Deck();
	ArrayList<Card> warPile = new ArrayList<Card>();

	public Wargame() {
		this.deck.shuffle();
	}
	
	Player player1 = new Player();
	Player player2 = new Player();
	Card card1 = null;
	Card card2 = null;
	int movecount = 0;
	
	String gameState = "";
	int lengthUnplayed = 26;
	

/**
 * deals cards to each players unplayed pile until the deck is empty
 */
	public void deal() { 
		while (! this.deck.isEmpty()){
			player1.addToUnplayedPile(this.deck.deal());
			player2.addToUnplayedPile(this.deck.deal());
               
		}
	}

/**
 * 
 *  @return gameState
 */
	public String toString() {
		return gameState;
	}

/**
 * 
 * @return card1
 */
	public Card getCard1() {
		return card1;
		
	}
	
/**
 * 	
 * @return card2
 */
	public Card getCard2() {
		return card2;
		
	}
	
/**
 * displays the game's current state and moves through one user event
 * directs cards to proper piles
 */
	public void move() {
		movecount += 1;
	    card1 = player1.getCard();
	    card2 = player2.getCard();

		gameState = "Player 1: \n" + "Current Card: " + card1.toString() + "\n Unplayed Pile: " 
		            + player1.unplayedCount() + "\n War Pile: " + this.warPile.size() + "\n Winnings Pile: "
		            + player1.winningsCount() + "\n \n " + "Player 2: \n" + "Current Card: " + 
		            card2.toString() + "\n Unplayed Pile: " 
		            + player2.unplayedCount() + "\n War Pile: " + this.warPile.size() + "\n Winnings Pile: "
		            + player2.winningsCount() + "\n \n "
		            + "move count: " + movecount + "\n";
		this.warPile.add(card1);
		this.warPile.add(card2);    
		if (card1.getRank() == card2.getRank()) {
			gameState += "\n Cards added to war pile";
		}
		else if (card1.getRank() > card2.getRank()) {
			this.transferCards(player1);
			gameState += "\n Cards go to player1";
		}
		else {
			this.transferCards(player2);
			gameState += "\n Cards go to player2";

			}
		
	}
	
	
/**
 * Transfers cards from war pile to a players winnings pile.
 * @param p is the player receiving the transferred cards.
 */
	public void transferCards(Player p) {
		while (! this.warPile.isEmpty()) {
			p.addToWinningsPile(this.warPile.remove(0));
		}
	}
	
/**
 * Checks to see if either unplayed pile is empty.
 * If one or both piles are empty, counts piles and determines a winner 
 * @return either tie, null if neither unplayed pile is empty, 
 * or winner and by how much
 */
	public boolean winner() {
		if ( player1.isDone() || player2.isDone()) {
			int count1 = player1.winningsCount();
			int count2 = player2.winningsCount();
			if (count1 > count2) {
				System.out.println("Player 1 wins, " + count1 + " to " + count2 +"!");
				return true;
			}
			if (count1 < count2) {
				System.out.println("Player 2 wins, " + count2 + " to " + count1 +"!");
				return true;
			}
			else {
				System.out.println("Game ends in a tie!\n");
				return true;
		}
	   } 
	   else {
		   return false;
	   }
   }
}
	

