import java.util.ArrayList;
import java.util.List;

/**
 * instantiates an instance of the class player
 * @author Ransom Reed
 * @author Chase Flowers
 * @author JT Schexnayder
 * @author Mubby Adeliyi
 */
public class Player extends Deck {
		ArrayList<Card> unplayedPile = new ArrayList<Card>();
		ArrayList<Card> winningsPile = new ArrayList<Card>();
		

		public Player() {
			super();
		}
	
/**
 * Adds Card to the unplayed pile list.
 */	
		public void addToUnplayedPile(Card c) {
			unplayedPile.add(0, c);
		}
	
/**
 * Adds Card to the winnings pile list.
 */
		public void addToWinningsPile(Card c) {
				winningsPile.add(0, c);
			
		}
		
/**
 * Removes Card from the unplayed pile list
 */
		public Card getCard() {
			return unplayedPile.remove(0);
			
		}
		

		
/**
 * counts the size of the winnings pile list
 * @return an int for the size of of winningsPile
 */
		public int winningsCount() {
			int winningsCount = winningsPile.size();
			return winningsCount;
		}
		
		public int unplayedCount() {
			int unplayedCount = unplayedPile.size();
			return unplayedCount;
		}
		
		
/**
 * Checks to see if the unplayed pile list is empty
 * @return true if the game is over, false if the game is not over
 */
		public Boolean isDone() {
			if (unplayedPile.isEmpty()) {
				return true;
			}
			else {
				return false;
			}
		}
		
}

