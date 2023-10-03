import java.util.ArrayList;
import java.util.Scanner;

public class CardGame {

    protected Integer noOfCards = 2;
    protected Deck deck;
    public ArrayList<Competitor> competitors;
    private Scanner userInput = new Scanner(System.in);
    protected boolean finshGame = false;
    private int winningScore = 0;

    public void setNoOfCards(Integer noOfCards) {
        this.noOfCards = noOfCards;
    }
    public void setFinishGame(boolean finshGame){
        this.finshGame = finshGame;
    }
    public Deck getDeck() {
        return deck;
    }

    public void print(String message){
        System.out.println(message);
    }

    protected String generateHelp(){
        return "";
    }

    protected void help(){
        print(generateHelp());
    }

    public String getString(){
        return userInput.nextLine();
    }

    public int getInteger(){
        int result = -1;
        int counter = 0;
        int maxCounter = 5;
        do {
            try {
                result = Integer.parseInt(getString());
            } catch (NumberFormatException exception) {
                // Display.Output expected NumberFormatException.
                print("Please enter a integer");
            }
        } while (result < 0 && counter < maxCounter);

        return result;
    }


    public CardGame(){
        this.deck = new Deck();
        this.competitors = new ArrayList<Competitor>();
    }

    public CardGame(String override){
        this.deck = new Deck(override);
        this.competitors = new ArrayList<Competitor>();
    }

    private void createHumanPlayer(){
        print("What is your name");
        String name = getString();
        competitors.add(new Competitor(CompetitorType.USER,name,0));
    }

    private void createComputerCompetitors(Integer noOfCompetitors) {
        Competitor dealer = new Competitor(CompetitorType.DEALER,"Dealer 1",17);
        competitors.add(dealer);
        for (int counter=2;counter < noOfCompetitors;counter++){
            competitors.add(new Competitor(CompetitorType.COMPUTER,"Comp" + counter,0));
        }
    }

    public void initiatePlayers(){
        competitors.clear();
        createHumanPlayer();
        print("How many competitors, minimum of two?");
        int noOfCompetitors = getInteger();
        createComputerCompetitors(noOfCompetitors);
    }

    public void resetPlayers(){
        for (Competitor competitor : competitors){
            competitor.setWinner(false);
        }
    }

    public void dealCards(){
        boolean allCards = false;
        int noOfCards;
        if (this.noOfCards == 0) {
            noOfCards = (int) Math.floor(deck.size()/ competitors.size());
            allCards = true;
        } else {
            noOfCards = this.noOfCards;
        }
        for (Competitor competitor : competitors){
            Hand hand = new Hand();
            hand = dealHand(hand,noOfCards);
            competitor.setHand(hand);
        }
        if (allCards){
            for (Competitor competitor : competitors){
                if (deck.size() > 0){
                    competitor.getHand().add(deck.playACard());
                }
            }
        }
    }

    protected Hand dealHand(Hand hand, int noOfCards){

        for (int cardCounter=0;cardCounter<noOfCards;cardCounter++){
            if (deck.size() > 0) {
                hand.add(deck.playACard());
            }
        }
        return hand;
    }


    public void initiate(){
        initiatePlayers();
        deck.shuffleDeck();
        dealCards();
    }

    protected boolean hasPlayerWon(Competitor competitor){
        boolean aPlayerHasWon = false;
        int currentScore = getScore(competitor.getHand());
        if (currentScore > winningScore){
            aPlayerHasWon = true;
            competitor.setWinner(true);
            winningScore = currentScore;
        }
        return aPlayerHasWon;
    }

    protected Competitor determineWinner(ArrayList<Competitor> competitors){
        winningScore = 0;
        Competitor winningCompetitor = null;
        int currentScore = 0;
        for (Competitor competitor : competitors){
            if (hasPlayerWon(competitor)) {
                winningScore = currentScore;
                winningCompetitor = competitor;
            }
        }
        return winningCompetitor;
    }

    public void play(){
        initiate();
        Integer counterOfPlayers = 0;
        while (!competitors.get(counterOfPlayers).hasWon() && !finshGame){
            playerPlaysHand(competitors.get(counterOfPlayers));
            counterOfPlayers = (counterOfPlayers + 1) % competitors.size();
        }
        resetPlayers();
        Competitor winner = determineWinner(competitors);
        showPlayers();
    }

    public int getScore(Hand hand){
        return 0;
    }

    protected void userPlays(Competitor competitor, Deck deck){}

    protected void computerPlays(Competitor competitor, Deck deck){}

    protected void playerPlaysHand(Competitor competitor){
        if (competitor.getPlayerType() == CompetitorType.USER){
            userPlays(competitor, deck);
        } else {
            computerPlays(competitor, deck);
        }
    }


    public void showPlayers(){
        String theWinner = "";
        for (Competitor competitor : competitors){
            if (competitor.hasWon()){
                theWinner = "The winner is ";
            } else {
                theWinner = "";
            }
            print(theWinner + competitor.getName() + " - " + competitor.getHand().toString());
        }
    }

    public static void main(String[ ] args) {
        CardGame cardGame = new CardGame();
        cardGame.play();
        cardGame.showPlayers();


    }
}
