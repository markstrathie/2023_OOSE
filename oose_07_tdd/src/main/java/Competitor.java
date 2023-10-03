import java.util.Random;

public class Competitor {
    public int levelOfRisk;
    private Hand hand;
    private CompetitorType competitorType;
    private String name;
    private Boolean winner = false;

    public Competitor(CompetitorType competitorType, String name, Integer levelOfRisk){
        this.competitorType = competitorType;
        this.name = name;
        int risk;
        Random rand = new Random();
        if (levelOfRisk == 0){
            risk = 11 + rand.nextInt() % 8;
        } else {
            risk = levelOfRisk;
        }
        this.levelOfRisk = risk;
        this.winner = false;
    }

    public void setWinner(Boolean status){
        this.winner = status;
    }

    public Boolean hasWon(){
        return winner;
    }

    public boolean hasHand(){
        return hand != null;
    }

    public CompetitorType getPlayerType(){
        return competitorType;
    }

    public void setHand(Hand hand){
        this.hand = hand;
    }

    public String getName() { return this.name;}

    public Hand getHand(){
        return this.hand;
    }

}
