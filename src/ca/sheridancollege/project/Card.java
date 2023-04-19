


/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Mehmet Yunus Sakalli
 * Youngje Bae
 * Blend Mustafa
 */
package ca.sheridancollege.project;

public abstract class Card {
    private final String suit;
    private final String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
