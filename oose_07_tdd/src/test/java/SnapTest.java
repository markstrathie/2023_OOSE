import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnapTest {

    Snap snap = new Snap();

    @Test
    void testIsSnapSameSuitCheckSuit() {
        Card firstCard = new Card(Suit.HEARTS, CardFace.JACK);
        Card secondCard = new Card(Suit.HEARTS, CardFace.FIVE);
        assertTrue(snap.isSnap(firstCard, secondCard, true));
    }

    @Test
    void testIsSnapSameRankCheckSuit() {
        Card firstCard = new Card(Suit.HEARTS, CardFace.JACK);
        Card secondCard = new Card(Suit.SPADES, CardFace.JACK);
        assertFalse(snap.isSnap(firstCard, secondCard, true));
    }


    @Test
    void testIsSnapSameRankCheckRank() {
        Card firstCard = new Card(Suit.HEARTS, CardFace.JACK);
        Card secondCard = new Card(Suit.SPADES, CardFace.JACK);
        assertTrue(snap.isSnap(firstCard, secondCard, false));
    }

    @Test
    void testIsSnapSameSuitCheckRank() {
        Card firstCard = new Card(Suit.HEARTS, CardFace.JACK);
        Card secondCard = new Card(Suit.HEARTS, CardFace.FIVE);
        assertFalse(snap.isSnap(firstCard, secondCard, false));
    }
}