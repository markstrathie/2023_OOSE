import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardGame {

    protected Integer noOfCards = 2;
    protected Deck deck;
    protected List<Competitor> competitors;
    protected Scanner userInput = new Scanner(System.in);
    protected LoadConfig loadConfig = new LoadConfig();
    protected List<String> storedOutput = new ArrayList<String>();
    protected boolean finishGame = false;
    protected int winningScore = 0;

    protected void setNoOfCards(Integer noOfCards) {
        this.noOfCards = noOfCards;
    }
    protected void setFinishGame(boolean finshGame){
        this.finishGame = finshGame;
    }
    protected Deck getDeck() {
        return deck;
    }

    protected void print(String message){
        storedOutput.add(message);
        System.out.println(message);
    }

    protected String generateHelp(){
        return "";
    }

    protected void help(){
        print(generateHelp());
    }

    protected String getString(){
        return userInput.nextLine();
    }

    protected int getInteger(){
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

    protected void createHumanPlayer(){
        print("What is your name");
        String name = getString();
        competitors.add(new Competitor(CompetitorType.USER,name,0));
    }

    protected List<String> getComputerPlayersNames(){
        return loadConfig.getConfig();
    }

    protected void createComputerCompetitors(List<String> computerNames) {
        int numberOfComputerPlayers = computerNames.size();
        Competitor dealer = new Competitor(CompetitorType.DEALER,computerNames.remove(0),17);
        competitors.add(dealer);
        for (int counter=1;counter < numberOfComputerPlayers ;counter++){
            competitors.add(new Competitor(CompetitorType.COMPUTER,computerNames.remove(0),0));
        }
    }

    protected int getNumberOfPlayers(){
        print("How many competitors, minimum of two?");
        return getInteger();
    }

    protected void initiatePlayers(){
        competitors.clear();
        createHumanPlayer();
        createComputerCompetitors(getComputerPlayersNames());
    }

    protected void resetPlayers(){
        for (Competitor competitor : competitors){
            competitor.setWinner(false);
        }
    }

    protected void dealCards(){
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

    protected void afterInitiate(){

    }

    protected void initiate(){
        initiatePlayers();
        deck.shuffleDeck();
        dealCards();
        afterInitiate();
    }

    protected boolean hasPlayerWon(Competitor competitor){
        boolean aPlayerHasWon = false;
        int currentScore = getScore(competitor.getHand());
        if (currentScore > winningScore){
            aPlayerHasWon = true;
            winningScore = currentScore;
        }
        return aPlayerHasWon;
    }

    protected Competitor determineWinner(List<Competitor> competitors){
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

    protected Competitor getCompetitor(int index){
        return competitors.get(index);
    }


    protected void beforePlayOfRound(){

    }

    protected void afterPlayOfRound(){

    }

    protected void play(){
        initiate();
        Integer counterOfPlayers = 0;
        while (!competitors.get(counterOfPlayers).hasWon() && !finishGame){
            beforePlayOfRound();
            playerPlaysHand(competitors.get(counterOfPlayers));
            counterOfPlayers = (counterOfPlayers + 1) % competitors.size();
            afterPlayOfRound();
        }
        resetPlayers();
        Competitor winner = determineWinner(competitors);
        showPlayers();
    }

    protected int getScore(Hand hand){
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


    protected void showPlayers(){
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
