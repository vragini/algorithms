import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;


public class PokerHandsTest {
	@Test
	public void testHighCardCaseOne() {
		
		List<PokerHands.Card> blackCards = new ArrayList<>();
		blackCards.add(new PokerHands.Card("AD"));
		blackCards.add(new PokerHands.Card("TD"));
		blackCards.add(new PokerHands.Card("9S"));
		blackCards.add(new PokerHands.Card("5C"));
		blackCards.add(new PokerHands.Card("4C"));
	
		List<PokerHands.Card> whiteCards = new ArrayList<>();
		whiteCards.add(new PokerHands.Card("KC"));
		whiteCards.add(new PokerHands.Card("QD"));
		whiteCards.add(new PokerHands.Card("JC"));
		whiteCards.add(new PokerHands.Card("8H"));
		whiteCards.add(new PokerHands.Card("7H"));
		
		Assert.assertEquals("Black wins", new PokerHands().getWinner(blackCards, whiteCards));

	}
	
	@Test
	public void testHighCardCaseTwo() {
		
		List<PokerHands.Card> blackCards = new ArrayList<>();
		blackCards.add(new PokerHands.Card("AD"));
		blackCards.add(new PokerHands.Card("2D"));
		blackCards.add(new PokerHands.Card("3D"));
		blackCards.add(new PokerHands.Card("4D"));
		blackCards.add(new PokerHands.Card("6D"));
	
		List<PokerHands.Card> whiteCards = new ArrayList<>();
		whiteCards.add(new PokerHands.Card("AC"));
		whiteCards.add(new PokerHands.Card("2C"));
		whiteCards.add(new PokerHands.Card("3C"));
		whiteCards.add(new PokerHands.Card("4C"));
		whiteCards.add(new PokerHands.Card("5C"));
		
		Assert.assertEquals("Black wins", new PokerHands().getWinner(blackCards, whiteCards));

	}
	
	@Test
	public void testHighCardCaseThree() {
		
		List<PokerHands.Card> blackCards = new ArrayList<>();
		blackCards.add(new PokerHands.Card("2D"));
		blackCards.add(new PokerHands.Card("3D"));
		blackCards.add(new PokerHands.Card("4D"));
		blackCards.add(new PokerHands.Card("5D"));
		blackCards.add(new PokerHands.Card("7D"));
		
		
		List<PokerHands.Card> whiteCards = new ArrayList<>();
		whiteCards.add(new PokerHands.Card("2C"));
		whiteCards.add(new PokerHands.Card("3C"));
		whiteCards.add(new PokerHands.Card("4C"));
		whiteCards.add(new PokerHands.Card("6C"));
		whiteCards.add(new PokerHands.Card("7C"));
		
		Assert.assertEquals("White wins", new PokerHands().getWinner(blackCards, whiteCards));

	}
	
	@Test
	public void testHighCardCaseTie() {
		
		List<PokerHands.Card> blackCards = new ArrayList<>();
		blackCards.add(new PokerHands.Card("2D"));
		blackCards.add(new PokerHands.Card("3D"));
		blackCards.add(new PokerHands.Card("4D"));
		blackCards.add(new PokerHands.Card("5D"));
		blackCards.add(new PokerHands.Card("6D"));
		
		
		List<PokerHands.Card> whiteCards = new ArrayList<>();
		whiteCards.add(new PokerHands.Card("2C"));
		whiteCards.add(new PokerHands.Card("3C"));
		whiteCards.add(new PokerHands.Card("4C"));
		whiteCards.add(new PokerHands.Card("5C"));
		whiteCards.add(new PokerHands.Card("6C"));
		
		Assert.assertEquals("Tie", new PokerHands().getWinner(blackCards, whiteCards));

	}
}

