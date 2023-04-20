package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * This class represents the discard pile in a game of UNO.
 */
public class DiscardPile {

    private final ArrayList<UnoCard> cards = new ArrayList<>();
    private UnoCard topCard; // Top card of the discard pile

    public DiscardPile() {
    }

    public UnoCard getTopCard() {
        return topCard;
    }

    public ArrayList<UnoCard> getCards() {
        return cards;
    }

    public void setTopCard(UnoCard card) {
        topCard = card;
    }

    public void addCard(UnoCard card) {
        cards.add(card);
        topCard = card; // Set the added card as the new top card
    }

    public void clear() {
        cards.clear();
        topCard = null;
    }
}
