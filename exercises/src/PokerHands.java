import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;




public class PokerHands {
	
	public static class Card implements Comparable<Card> {
		public static enum Rank {
			TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,
			JACK, QUEEN, KING, ACE;

			public int getValue() {
				return ordinal()+2;
			}
		}
		
		public static enum Suit {
			CLUBS, DIAMONDS, HEARTS, SPADES;
		}
		
		private Rank rank;
		private Suit suit;
		
		public Card(String s) {
			
			char rn = s.charAt(0);
            char st = s.charAt(1);
 
            if (rn >= '2' && rn <= '9') {
                rank = Rank.values()[rn - '0' - 2];
            } else {
                switch (rn) {
                    case 'T':
                        rank = Rank.TEN;
                        break;
                    case 'J':
                        rank = Rank.JACK;
                        break;
                    case 'Q':
                        rank = Rank.QUEEN;
                        break;
                    case 'K':
                        rank = Rank.KING;
                        break;
                    case 'A':
                        rank = Rank.ACE;
                        break;
                    default:
                        break;
                }
            }
            switch (st) {
            case 'C':
                suit = Suit.CLUBS;
                break;
            case 'D':
                suit = Suit.DIAMONDS;
                break;
            case 'H':
                suit = Suit.HEARTS;
                break;
            case 'S':
                suit = Suit.SPADES;
                break;
            default:
                break;
            }
		}

		@Override
		public int compareTo(Card o) {
			if(rank.getValue() < o.rank.getValue()) {
				return -1;
			} else if (rank.getValue() > o.rank.getValue()) {
				return 1;
			}
			return 0;
		}
		
		@Override
		public boolean equals(Object o) {
			if(this==o) {
				return true;
			} else if (o==null) {
				return false;
			} else if (!(o instanceof Card)) {
				return false;
			}
			Card c = (Card)o;
			return (rank==c.rank && suit==c.suit);
		}
		
		@Override
		public int hashCode() {
			return 42;
		}
		
		@Override
		public String toString() {
			return rank +" of" + suit;
		}
	}
		
	private static enum Hand {
        HIGHCARD, PAIR, TWOPAIR, THREEOFAKIND, STRAIGHT, FLUSH, FULLHOUSE,
        FOUROFAKIND, STRAIGHTFLUSH;
    }
 
    private static final String TIE = "Tie";
    private static final String WHITE = "White wins";
    private static final String BLACK = "Black wins";
 
    private List<Card> whiteCards = new ArrayList<Card>();
    private List<Card> whiteHand = new ArrayList<Card>();
    private List<Card> blackCards = new ArrayList<Card>();
    private List<Card> blackHand = new ArrayList<Card>();
    
	public String getWinner(List<Card> black, List<Card> white) {
		reset();
		blackCards = black;
		whiteCards = white;
		Hand whType = getHand(whiteCards, whiteHand);
        Hand bhType = getHand(blackCards, blackHand);
        String winner;
 
        int cmp = whType.compareTo(bhType);
        if(cmp==0) {
        	switch (whType) {
			case HIGHCARD:
				cmp = cmpByRecursiveHighCard(whiteCards, blackCards);
				break;
			}
        }
        winner = cmp > 0 ? WHITE : cmp < 0 ? BLACK : TIE;
        return winner;
	}

	private int cmpByRecursiveHighCard(List<Card> hand1,List<Card> hand2) {
		int cmp = 0;
        ListIterator<Card> it1 = hand1.listIterator(hand1.size());
        ListIterator<Card> it2 = hand2.listIterator(hand2.size());
        while (it1.hasPrevious() && it2.hasPrevious()) {
            Card c1 = it1.previous();
            Card c2 = it2.previous();
            cmp = c1.compareTo(c2);
            if (cmp != 0) {
                break;
            }
        }
        return cmp;
	}

	private Hand getHand(List<Card> cards, List<Card> hand) {
		Collections.sort(cards);
        Hand h;
        h= Hand.HIGHCARD;
        return h;
	}
	
	private void reset() {
        whiteCards.clear();
        whiteHand.clear();
        blackCards.clear();
        blackHand.clear();
    }
}
