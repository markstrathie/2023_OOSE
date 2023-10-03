import java.util.ArrayList;

public class Snap extends CardGame{

    private int noOfCards = 0;
    Hand tableHand = new Hand();
    private boolean snapOnSuit = true;

    public void setSnapOnSuit(boolean snapOnSuit){
        this.snapOnSuit = snapOnSuit;
    }

    protected String generateHelp(){
        return "Please enter a card to (P)lay or (S)nap.";
    }

    protected void userPlays(Competitor competitor, Deck deck){
        if (tableHand.size() == 0) {
            tableHand.add(competitor.getHand().playACard(0));
        }
        print("Table hand " + tableHand.getLastCard());
        Card userCard = competitor.getHand().playACard(0);
        print("User plays " + userCard.toString());
        help();
        String userChoice = getString();
        if (userChoice.equals("S") && isSnap(tableHand.getLastCard(), userCard, snapOnSuit)){
            setFinishGame(true);
        } else if (userChoice.equals("S")) {
            print("It was not snap");
        }
        tableHand.add(userCard);
    }

    protected boolean isSnap(Card previousCard, Card currentCard, boolean snapOnSuit){
        boolean cardsMatch = false;
        if (snapOnSuit && previousCard.getSuit() == currentCard.getSuit()) {
            cardsMatch = true;
        } else if (!snapOnSuit && previousCard.getCardFace() == currentCard.getCardFace()){
            cardsMatch = true;
        }
        return cardsMatch;
    }

    protected void computerPlays(Competitor competitor, Deck deck){
        Card computerCard = competitor.getHand().playACard(0);
        //output("Computer plays " + computerCard.toString());
        tableHand.add(computerCard);
    }

    protected Competitor determineWinner(ArrayList<Competitor> competitors) {
        Competitor winningCompetitor = null;
        for (Competitor competitor : competitors) {
            if (competitor.hasWon()){
                winningCompetitor = competitor;
            }
        }
        return winningCompetitor;
    }

    public static void main(String[ ] args) {
        Snap snap = new Snap();
        snap.setNoOfCards(snap.noOfCards);
        snap.play();
    }
}
