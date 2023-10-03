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
		Card card2 = new Card("H6");
		Card card3 = new Card("H5");
		sevensTableHands[0].add(card2);
		sevensTableHands[0].add(card3);
		assertFalse(sevens.playToTable(card, sevensTableHands));
	}


	@Test
	void testPlayToTablePlayASevenCheckCard() {
		Card card = new Card("H7");
		sevens.playToTable(card, sevensTableHands);
		assertTrue(sevensTableHands[0].getHandOfCards().contains(card));
	}


	@Test
	void testPlayToTablePlayASixWithASeven() {
		Card card = new Card("H7");
		Card card2 = new Card("H6");
		sevens.playToTable(card, sevensTableHands);
		assertTrue(sevens.playToTable(card2, sevensTableHands));
	}


	@Test
	void testPlayToTablePlayAFiveWithNoSix() {
		Card card = new Card("H7");
		Card card2 = new Card("H5");
		sevens.playToTable(card, sevensTableHands);
		assertFalse(sevens.playToTable(card2, sevensTableHands));
	}


	@Test
	void testPlayToTablePlayASixCheckCard() {
		Card card = new Card("H7");
		Card card2 = new Card("H6");
		sevens.playToTable(card, sevensTableHands);
		sevens.playToTable(card2, sevensTableHands);
		assertTrue(sevensTableHands[0].getHandOfCards().contains(card2));
	}


	@Test
	void testPlayToTablePlayAnEightWithASeven() {
		Card card = new Card("H7");
		Card card2 = new Card("H8");
		sevens.playToTable(card, sevensTableHands);
		assertTrue(sevens.playToTable(card2, sevensTableHands));
	}


	@Test
	void testPlayToTablePlayANineWithNoEight() {
		Card card = new Card("H7");
		Card card2 = new Card("H9");
		sevens.playToTable(card, sevensTableHands);
		assertFalse(sevens.playToTable(card2, sevensTableHands));
	}


	@Test
	void testPlayToTablePlayAnEightCheckCard() {
		Card card = new Card("H7");
		Card card2 = new Card("H8");
		sevens.playToTable(card, sevensTableHands);
		sevens.playToTable(card2, sevensTableHands);
		assertTrue(sevensTableHands[0].getHandOfCards().contains(card2));
	}

	@Test
	void testPlayerHasWonTrue()  {
		Competitor competitor = new Competitor(CompetitorType.USER, "Test", 0);
		competitor.setWinner(true);
		sevens.setFinishGame(true);
		Hand hand = competitor.getHand();
		assertEquals([], hand);
	}

	@Test
	void testPlayerHasWonFalse()  {
		fail("Not yet implemented"); //Remove
	}

	@Test
	void testDetermineWinner(){
		fail("Not yet implemented"); //Remove
	}

}