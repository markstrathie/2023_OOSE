import java.util.ArrayList;

public class Sevens extends CardGame{

    private int noOfCards = 0;
    private Hand[] sevenTableHands = createEmptyTableHands();

    protected String generateHelp(){
        return "Please enter a card to play.";
    }

    protected void displayTableHands(){
        int counter = 0;
        for (Hand hand : sevenTableHands){
            print(Suit.values()[counter].displayCamelCase() + " " + hand.toString());
            counter += 1;
        }
    }

    protected void userPlays(Competitor competitor, Deck deck){
        displayTableHands();
        print("Your hand is");
        print(competitor.getHand().toString());
        help();
        boolean cardPlayed = false;
        String userCardRaw = "";
        Card userCard = null;
        while (!cardPlayed && competitor.getHand().size() > 0) {
            userCardRaw = getString();
            userCard = competitor.getHand().findACard(userCardRaw);
            if (userCard == null) {
                if (userCardRaw.length() >= 2) {
                    print("Card not found in your hand");
                }
                cardPlayed = true;
            } else {
                cardPlayed = playToTable(userCard, sevenTableHands);
                if (cardPlayed) {
                    cardPlayed = competitor.getHand().playACard(userCard);
                }
            }
        }
        hasPlayerWon(competitor);
    }

    protected void computerPlays(Competitor competitor, Deck deck){
        boolean cardPlayed = false;
        int counter = 0;
        ArrayList<Card> compupterHand = competitor.getHand().getHandOfCards();
        while (!cardPlayed && counter < compupterHand.size()){
            cardPlayed = playToTable(compupterHand.get(counter), sevenTableHands);
            if (cardPlayed){
                compupterHand.remove(counter);
            }
            counter += 1;
        }
        hasPlayerWon(competitor);
    }

    protected boolean hasPlayerWon(Competitor competitor){
        boolean aPlayerHasWon = false;
        if (competitor.getHand().size() == 0){
            competitor.setWinner(true);
            aPlayerHasWon = true;
        }
        return aPlayerHasWon;
    }

    protected Competitor determineWinner(ArrayList<Competitor> competitors) {
        Competitor winningCompetitor = null;
        for (Competitor competitor : competitors) {
            if (hasPlayerWon(competitor)){
                winningCompetitor = competitor;
            }
        }
        return winningCompetitor;
    }

    protected Hand[] createEmptyTableHands(){
        Hand[] sevensTableHands = new Hand[]{new Hand(), new Hand(), new Hand(), new Hand()};
        return sevensTableHands;
    }

    protected Hand getSuitHand(Card card, Hand[] sevenTableHands){
        return sevenTableHands[card.getSuit().ordinal()];
    }

    protected boolean playToTable(Card card, Hand[] sevenTableHands){
        boolean cardHasBeenPlayed = false;
        Hand sevensHand = getSuitHand(card, sevenTableHands);
        if (sevensHand.size() == 0 && card.getCardFace() == CardFace.SEVEN){
            cardHasBeenPlayed = true;
            sevensHand.add(card);
        } else if (sevensHand.size() > 0 && card.getCardFace() != CardFace.SEVEN){
            if (sevensHand.getFirstCard().getCardFace().getRank() == (card.getCardFace().getRank() + 1 )){
                cardHasBeenPlayed = true;
                sevensHand.addAtStart(card);
            } else if ( sevensHand.getLastCard().getCardFace().getRank() == (card.getCardFace().getRank() -1)) {
                cardHasBeenPlayed = true;
                sevensHand.add(card);
            }
        }
        return cardHasBeenPlayed;
    }

    public static void main(String[ ] args) {
        Sevens sevens = new Sevens();
        sevens.setNoOfCards(sevens.noOfCards);
        sevens.play();
    }
}
