package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class represents the draw pile of Uno cards.
 */
public class DrawPile {
    private final DiscardPile discardPile;
    private final ArrayList<UnoCard> cards;

    /**
     * Constructs a new draw pile with the given discard pile.
     *
     * @param discardPile the discard pile
     */
    public DrawPile(DiscardPile discardPile) {
        this.discardPile = discardPile;
        this.cards = new ArrayList<>();
    }

    /**
     * Returns the list of cards in the draw pile.
     *
     * @return the list of cards
     */
    public ArrayList<UnoCard> getCards() {
        return cards;
    }

    /**
     * Fills the draw pile with the standard deck of Uno cards.
     */
    public void fill() {
        // Add 2 of each color and value except for Wild Card and Draw Four
        for (int i = 0; i < 2; i++) {
            for (UnoCard.Color color : UnoCard.Color.values()) {
                for (UnoCard.Value value : UnoCard.Value.values()) {
                    if (value == UnoCard.Value.WILD_CARD || value == UnoCard.Value.DRAW_FOUR) {
                        continue; // Skip Wild Card and Draw Four
                    }
                    UnoCard card = new UnoCard(color, value);
                    cards.add(card);
                }
            }
        }

        // Add 4 Wild Cards and 4 Draw Fours
        for (int i = 0; i < 4; i++) {
            UnoCard wildCard = new UnoCard(UnoCard.Color.NONE, UnoCard.Value.WILD_CARD);
            UnoCard drawFour = new UnoCard(UnoCard.Color.NONE, UnoCard.Value.DRAW_FOUR);
            cards.add(wildCard);
            cards.add(drawFour);
        }

        Collections.shuffle(cards);
    }

    /**
     * Refills the draw pile with the cards from the discard pile, except for the top card,
     * which is set as the new top card of the discard pile.
     */
    private void refill() {
        UnoCard topCard = discardPile.getTopCard();
        cards.addAll(discardPile.getCards());
        discardPile.clear();

        // Check if the top card is a Wild Card or Draw Four
        if (topCard.getValue() == UnoCard.Value.WILD_CARD || topCard.getValue() == UnoCard.Value.DRAW_FOUR) {
            cards.add(topCard);
            Collections.shuffle(cards);
            topCard = drawCard();
        }

        discardPile.setTopCard(topCard);
    }
}
    /**
     * Draws a card from the draw pile. If the draw pile is empty, the draw pile is refilled
     * with the cards from the discard pile, except for the top card, which is set as the new
     * top card of the
