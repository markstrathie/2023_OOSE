import java.util.List;

public class player {
    private String name;
    private Hand hand_of_cards;

    public player(String name, Hand hand_of_cards){
        this.name = name;
        this.hand_of_cards = hand_of_cards;
    }

    public Card play_a_card(String card){
        Card hasCard = null;
        List<Card> cards = hand_of_cards.getHandOfCards();
        int counter = 0;
        int found_counter = -1;
        for (Card c : cards){
            if (c.toString() == card){
                found_counter = counter;
            }
            counter ++;
        }
        if (found_counter >= 0){
            hasCard = hand_of_cards.playACard(found_counter);
        }
        return hasCard ;
    }


}
