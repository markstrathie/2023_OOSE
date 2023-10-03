import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SevensTest {

	Sevens sevens = new Sevens();
	Hand[] sevensTableHands = sevens.createEmptyTableHands();

	@Test
	void testCreateEmptyTableHandsSize() {
		assertEquals(4, sevensTableHands.length);
	}


	@Test
	void testPlayToTablePlayASevenToEmpty() {
		Card card = new Card("H7");
		assertTrue(sevens.playToTable(card, sevensTableHands));
	}


	@Test
	void testPlayToTablePlayASevenNotEmpty() {
		Card card = new Card("H7");
		Hand sevensHand = sevens.getSuitHand(card, sevensTableHands);
		sevensHand.add(new Card("H6"));
		assertFalse(sevens.playToTable(card, sevensTableHands));
	}


	@Test
	void testPlayToTablePlayASevenCheckCard() {
		Card card = new Card("H7");
		boolean played = sevens.playToTable(card, sevensTableHands);
		Hand sevensHand = sevens.getSuitHand(card, sevensTableHands);
		assertEquals(card, sevensHand.getLastCard());
	}


	@Test
	void testPlayToTablePlayASixWithASeven() {
		Card card = new Card("H7");
		sevens.playToTable(card, sevensTableHands);
		Card newCard = new Card("H6");
		assertTrue(sevens.playToTable(newCard, sevensTableHands));
	}


	@Test
	void testPlayToTablePlayAFiveWithNoSix() {
		Card card = new Card("H7");
		sevens.playToTable(card, sevensTableHands);
		Card newCard = new Card("H5");
		assertFalse(sevens.playToTable(newCard, sevensTableHands));
	}


	@Test
	void testPlayToTablePlayASixCheckCard() {
		Card card = new Card("H7");
		sevens.playToTable(card, sevensTableHands);
		Card newCard = new Card("H6");
		boolean played = sevens.playToTable(newCard, sevensTableHands);
		Hand sevensHand = sevens.getSuitHand(card, sevensTableHands);
		assertEquals(newCard, sevensHand.getFirstCard());
	}


	@Test
	void testPlayToTablePlayAnEightWithASeven() {
		Card card = new Card("H7");
		sevens.playToTable(card, sevensTableHands);
		Card newCard = new Card("H8");
		assertTrue(sevens.playToTable(newCard, sevensTableHands));
	}


	@Test
	void testPlayToTablePlayANineWithNoEight() {
		Card card = new Card("H7");
		sevens.playToTable(card, sevensTableHands);
		Card newCard = new Card("H9");
		assertFalse(sevens.playToTable(newCard, sevensTableHands));
	}


	@Test
	void testPlayToTablePlayAnEightCheckCard() {
		Card card = new Card("H7");
		sevens.playToTable(card, sevensTableHands);
		
		Card newCard = new Card("H8");
		boolean played = sevens.playToTable(newCard, sevensTableHands);
		Hand sevensHand = sevens.getSuitHand(newCard, sevensTableHands);
		assertEquals(newCard, sevensHand.getLastCard());
	}

	@Test
	void testPlayerHasWonTrue()  {
		Competitor winner = new Competitor(CompetitorType.USER, "Mr Win", 0);
		Hand winnerHand = new Hand();
		winner.setHand(winnerHand);
		assertTrue(sevens.hasPlayerWon(winner));
	}

	@Test
	void testPlayerHasWonFalse()  {
		Competitor looser = new Competitor(CompetitorType.DEALER, "Mr Dealer", 5);
		Hand looserHand = new Hand ("S5,S6");
		looser.setHand(looserHand);
		assertFalse(sevens.hasPlayerWon(looser));
	}

	@Test
	void testDetermineWinner(){
		Competitor winner = new Competitor(CompetitorType.USER, "Mr Win", 0);
		Competitor looser = new Competitor(CompetitorType.DEALER, "Mr Dealer", 5);
		Hand winnerHand = new Hand();
		Hand looserHand = new Hand ("S5,S6");
		winner.setHand(winnerHand);
		looser.setHand(looserHand);
		ArrayList<Competitor> competitors = new ArrayList<Competitor>();
		competitors.add(winner);
		competitors.add(looser);
		assertEquals(winner, sevens.determineWinner(competitors));
	}

}