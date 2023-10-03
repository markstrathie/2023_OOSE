import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompetitorTest {
    Competitor competitor = new Competitor(CompetitorType.USER, "Derek",0);
    @Test
    void hasWon() {
        competitor.setWinner(true);
        assertTrue(competitor.hasWon());
    }

    @Test
    void hasWonNot() {
        competitor.setWinner(false);
        assertFalse(competitor.hasWon());
    }

    @Test
    void hasHand() {
        Hand hand = new Hand("S3,S4,D5");
        competitor.setHand(hand);
        assertTrue(competitor.hasHand());
    }

    @Test
    void hasHandNot() {
        Hand hand = new Hand("S3,S4,D5");
        competitor.setHand(null);
        assertFalse(competitor.hasHand());
    }

    @Test
    void getPlayerType() {
        assertEquals(CompetitorType.USER, competitor.getPlayerType());
    }

    @Test
    void getName() {
        assertEquals("Derek", competitor.getName());
    }

    @Test
    void getHand() {
        Hand hand = new Hand("S3,S4,D5");
        competitor.setHand(hand);
        assertEquals(hand, competitor.getHand());
    }
}