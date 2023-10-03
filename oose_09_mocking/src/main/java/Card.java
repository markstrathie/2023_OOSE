import java.util.HashMap;

public class Card {

    private Suit suit;
    private CardFace cardFace;

    public Card(Suit suit, CardFace cardFace){
        this.suit = suit;
        this.cardFace = cardFace;
    }

    public Card(String card){
        this.suit = Suit.getSuit(card.substring(0,1));
        this.cardFace = CardFace.getCardRank(card.substring(1,card.length()));
    }

    public Suit getSuit(){
        return suit;
    }

    public CardFace getCardFace(){
        return cardFace;
    }

    public String displayCamelCase(){
        return suit.displayCamelCase() + " " + cardFace.displayCamelCase();
    }

    public String displayOf(){
        return cardFace.displayCamelCase() + " of " + suit.displayCamelCase();
    }

    public String toString(){
        return suit + cardFace.toString();
    }

}
