package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class is Software Design SYST17796 18401
 *
 * @author Mehmet Sakalli
 * @author Blend Mustafa
 */
public class DrawPile{
    private final DiscardPile discardPile;
    
    private final ArrayList<UnoCard> cards;

    public DrawPile(DiscardPile discardPile) {
        this.discardPile = discardPile;
        this.cards = new ArrayList<>();
    }
    
    public ArrayList getCards(){
        return cards;
    }

    public void fill() {
        for (UnoCard.Color color : UnoCard.Color.values()) {
            // add new cards to the pile
            for (UnoCard.Value value : UnoCard.Value.values()) {
                UnoCard card = new UnoCard(color, value);
                cards.add(card);
            }
        }
        Collections.shuffle(cards);
    }


    public UnoCard drawCard() {
        if (cards.isEmpty()) {
            refill();
        }
        UnoCard drawnCard = (UnoCard) cards.get(cards.size()-1);
        cards.remove(cards.size()-1);
        return drawnCard;
    }

    private void refill() {
        UnoCard topCard;
        topCard = (UnoCard) discardPile.getTopCard();
        //discardPile.clear(); this code wasn't working and I'm not sure what it's supposed to do in the first place
        cards.add(topCard);
        Collections.shuffle(cards);
    }
}
