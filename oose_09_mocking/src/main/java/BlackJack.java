import java.util.ArrayList;
import java.util.List;

public class BlackJack extends CardGame {
    private int maxScore = 21;
    private int noOfCards = 2;

    public BlackJack(){
        super();
    }
    public BlackJack(String override){
        super(override);
    }

    protected String generateHelp(){
        String help = "Please select one of the following options\n";
        for (BlackJackActions action : BlackJackActions.values()) {
            help += action.display() + "\n";
        }
        return help;
    }

    protected BlackJackActions getPlayerAction(Competitor competitor){
        String userChoice = " ";
        BlackJackActions userAction;
        help();
        if (competitor.hasHand()) {
            print(competitor.getHand().toString());
        }
        userChoice = getString();
        userAction = BlackJackActions.getAction(userChoice.substring(0,1).toUpperCase());
        print("You chose " + userAction.display());
        return userAction;
    }

    protected void userPlays(Competitor competitor, Deck deck){
        BlackJackActions userAction = BlackJackActions.PLAY;

        while (getScore(competitor.getHand()) <= maxScore && userAction != BlackJackActions.STICK){
            userAction = getPlayerAction(competitor);
            if (userAction == BlackJackActions.TWIST){
                competitor.getHand().add(deck.playACard());
            }
        }
        setFinishGame(true);
    }

    protected void computerPlays(Competitor competitor, Deck deck){
        Hand hand = competitor.getHand();
        while (getScore(hand) <= competitor.levelOfRisk){
            hand.add(deck.playACard());
        }
    }

    protected Competitor determineWinner(List<Competitor> players){
        Integer winningScore = 0;
        Competitor winningPlayer = null;
        int currentScore = 0;
        for (Competitor player : players){
            currentScore = getScore(player.getHand());
            if (currentScore <= maxScore && currentScore > winningScore){
                winningPlayer = player;
                winningScore = currentScore;
            }
        }
        if (winningPlayer != null) {
            winningPlayer.setWinner(true);
        }
        return winningPlayer;
    }


    public int getScore(Hand hand){
        int score = 0;
        Boolean hasAnAce = false;
        for (Card card: hand.getHandOfCards()){
            if (card.getCardFace() == CardFace.ACE){
                hasAnAce = true;
            }
            score += card.getCardFace().getValue();
        }
        if (score > maxScore && hasAnAce){
            score -= CardFace.ACE.getValue() - 1;
        }
        return score;
    }

    public static void main(String[ ] args) {
        BlackJack blackJack = new BlackJack();
        blackJack.setNoOfCards(blackJack.noOfCards);
        blackJack.play();
    }


}
