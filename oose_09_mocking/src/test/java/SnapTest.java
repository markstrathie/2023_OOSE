import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnapTest {

    Snap snap = new Snap();

    @Test
    void testIsSnapSameSuitCheckSuit() {
        Card card = new Card(Suit.CLUBS, CardFace.TEN);
        Card nextCard = new Card(Suit.CLUBS, CardFace.NINE);
        Boolean checkSuit = Boolean.TRUE;
        assertTrue(snap.isSnap(card, nextCard, checkSuit));
    }

    @Test
    void testIsSnapSameRankCheckSuit() {
        Card card = new Card(Suit.CLUBS, CardFace.FIVE);
        Card nextCard = new Card(Suit.HEARTS, CardFace.FIVE);
        Boolean checkSuit = Boolean.TRUE;
        assertFalse(snap.isSnap(card, nextCard, checkSuit));
    }


    @Test
    void testIsSnapSameRankCheckRank() {
        Card card = new Card(Suit.CLUBS, CardFace.FIVE);
        Card nextCard = new Card(Suit.HEARTS, CardFace.FIVE);
        Boolean checkSuit = Boolean.FALSE;
        assertTrue(snap.isSnap(card, nextCard, checkSuit));
    }

    @Test
    void testIsSnapSameSuitCheckRank() {
        Card card = new Card(Suit.CLUBS, CardFace.TEN);
        Card nextCard = new Card(Suit.CLUBS, CardFace.NINE);
        Boolean checkSuit = Boolean.FALSE;
        assertFalse(snap.isSnap(card, nextCard, checkSuit));
    }
}