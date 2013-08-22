import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
        HIGHCARD, PAIR, TWOPAIR;
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
        	case TWOPAIR:
        		cmp = cmpByHighCard(whiteHand, blackHand);
        		if(cmp==0){
        			cmp = cmpByHighCard(whiteHand.subList(0, 2), blackHand.subList(0, 2));
        		}
        		if(cmp==0){
        			List<Card> wRemaining = new ArrayList<>(whiteCards);
            		List<Card> bRemaining = new ArrayList<>(blackCards);
            		wRemaining.removeAll(whiteHand);
            		bRemaining.removeAll(blackHand);
        			cmp = cmpByHighCard(wRemaining, bRemaining);
        		}
        		break;
        	case PAIR:
        		List<Card> wRemaining = new ArrayList<>(whiteCards);
        		List<Card> bRemaining = new ArrayList<>(blackCards);
        		wRemaining.removeAll(whiteHand);
        		bRemaining.removeAll(blackHand);
        		cmp = cmpByRecursiveHighCard(wRemaining,bRemaining );
        		break;
			case HIGHCARD:
				cmp = cmpByRecursiveHighCard(whiteCards, blackCards);
				break;
			}
        }
        winner = cmp > 0 ? WHITE : cmp < 0 ? BLACK : TIE;
        return winner;
	}

	private int cmpByHighCard(List<Card> hand1, List<Card> hand2) {
		Card wc = hand1.get(hand1.size()-1);
		Card bc = hand2.get(hand2.size()-1);
		return wc.compareTo(bc);
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
        if(isTwoPair(cards,hand)) {
        	h=Hand.TWOPAIR;
        }else if(isPair(cards,hand)) {
        	h=Hand.PAIR;
        } else {
        	h= Hand.HIGHCARD;
        }
        return h;
	}
	
	private boolean isTwoPair(List<Card> cards, List<Card> hand) {
		Collections.sort(cards);
		Iterator<Card> iterator = cards.iterator();
		Card prev = iterator.next();
		
		while(iterator.hasNext()) {
			Card c = iterator.next();
			if(prev.rank.getValue() == c.rank.getValue()) {
				hand.add(prev);
				hand.add(c);
				if(iterator.hasNext()){
					c= iterator.next();
				}
			}
			prev= c;
		}
		if(hand.size()==4) {
			return true;
		}
		return false;
	}

	private boolean isPair(List<Card> cards, List<Card> hand) {
		Collections.sort(cards);
		Iterator<Card> iterator = cards.iterator();
		Card prev = iterator.next();
		
		while(iterator.hasNext()) {
			Card c = iterator.next();
			
			if(prev.rank.getValue() == c.rank.getValue()) {
				hand.add(prev);
				hand.add(c);
				break;
			}
			prev = c;
		}
		if(hand.size()==2) {
			return true;
		}
		return false;
	}

	private void reset() {
        whiteCards.clear();
        whiteHand.clear();
        blackCards.clear();
        blackHand.clear();
    }
}
