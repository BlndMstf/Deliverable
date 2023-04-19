

package Card;

/**
 * This class is Software Design SYST17796 18401
 *
 * @author Mehmet Sakalli
 * @author Blend Mustafa
 */
public class PlayerActions {
    private UnoPlayer currentPlayer;
    private DiscardPile discardPile;
    private DrawPile drawPile;

    public PlayerActions(UnoPlayer player, DiscardPile discardPile, DrawPile drawPile) {
        this.currentPlayer = player;
        this.discardPile = discardPile;
        this.drawPile = drawPile;
    }

    // Method to check if a card can be played
    public boolean canPlayCard(UnoCard card) {
        // Check if card matches the color or value of the top card on the discard pile
        UnoCard topCard = (UnoCard) discardPile.getTopCard();
        return card.getColor() == topCard.getColor() || card.getValue() == topCard.getValue();
    }

    // Method to play a card
    public void playCard(UnoCard card) {
        // Remove card from player's hand and add it to the discard pile
        currentPlayer.getHand().removeCard(currentPlayer.getHand().getCards().indexOf(card));
        discardPile.setTopCard(card);
        System.out.println(currentPlayer.getName() + " played " + card);

        // Check if card has any special properties
        switch (card.getValue()) {
            case SKIP:
                // Skip the next player's turn
                System.out.println("Skipping next player's turn");
                break;
            case REVERSE:
                // Reverse the order of play
                System.out.println("Reversing order of play");
                break;
            case DRAW_TWO:
                // Next player draws two cards and skips their turn
                System.out.println("Next player draws two cards and skips their turn");
                break;
            case DRAW_FOUR:
                // Next player draws four cards, changes color, and skips their turn
                System.out.println("Next player draws four cards, changes color, and skips their turn");
                break;
            case WILD_CARD:
                // Prompt user to choose a new color
                System.out.println("Choosing new color");
                break;
            default:
                // Do nothing
                break;
        }
    }

    // Method to draw a card
    public void drawCard() {
        // Draw a card from the draw pile and add it to the player's hand
        UnoCard card = drawPile.drawCard();
        currentPlayer.getHand().addCard(card);
        System.out.println(currentPlayer.getName() + " drew " + card);
    }
}
