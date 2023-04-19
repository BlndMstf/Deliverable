

package Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * This class is Software Design SYST17796 18401
 *
 * @author Mehmet Sakalli
 * @author Blend Mustafa
 */
public class PlayerActions {
    private UnoPlayer currentPlayer;
    private ArrayList <UnoPlayer> players = new ArrayList <>();
    private DiscardPile discardPile;
    private DrawPile drawPile;
    Scanner scanner = new Scanner(System.in);

    public PlayerActions(UnoPlayer player, ArrayList <UnoPlayer> players, DiscardPile discardPile, DrawPile drawPile) {
        this.currentPlayer = player;
        this.discardPile = discardPile;
        this.drawPile = drawPile;
        this.players = players;
    }

    // Method to check if a card can be played
    public boolean canPlayCard(UnoCard card) {
        // Check if card matches the color or value of the top card on the discard pile
        UnoCard topCard = (UnoCard) discardPile.getTopCard();
        if (card.getValue() == UnoCard.Value.WILD_CARD) {
            return true; // Wild cards can always be played
        } else if (card.getColor() == topCard.getColor() || card.getValue() == topCard.getValue()) {
            return true; // Card matches color or value of top card
        } else {
            return false; // Player cannot play any cards
        }
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
                skipTurn();
                break;
            case REVERSE:
                // Reverse the order of play
                System.out.println("Reversing order of play");
                reverseOrder();
                break;
            case DRAW_TWO:
                // Next player draws two cards and skips their turn
                System.out.println("Next player draws two cards and skips their turn");
                drawCards(2);
                skipTurn();
                break;
            case DRAW_FOUR:
                // Next player draws four cards, changes color, and skips their turn
                System.out.println("Next player draws four cards, changes color, and skips their turn");
                drawCards(4);
                chooseColor();
                skipTurn();
                break;
            case WILD_CARD:
                // Prompt user to choose a new color
                System.out.println("Choosing new color");
                chooseColor();
                break;
            default:
                // Do nothing
                break;
        }
    }
    
    // Method to draw a card
    public void drawCards(int numCards) {
        // Draw the specified number of cards from the draw pile and add them to the player's hand
        for (int i = 0; i < numCards; i++) {
            UnoCard card = drawPile.drawCard();
            nextPlayer().getHand().getCards().add(card);
        }
    }
    
    public void playerDrawsCard () {
        UnoCard card = drawPile.drawCard();
        currentPlayer.getHand().getCards().add(card);
    }
    public void chooseColor() {
        // Prompt user to choose a color
        System.out.println("Choose a color (Red, Green, Blue, or Yellow): ");
        String input = scanner.nextLine();
    
        // Validate user input
        while (!input.equalsIgnoreCase("red") && !input.equalsIgnoreCase("green")
                && !input.equalsIgnoreCase("blue") && !input.equalsIgnoreCase("yellow")) {
            System.out.println("Invalid color. Choose a color (Red, Green, Blue, or Yellow): ");
            input = scanner.nextLine();
        }
    
        // Set the new color for the top card in the discard pile
        UnoCard topCard = discardPile.getTopCard();
        if (topCard.getValue() == UnoCard.Value.WILD_CARD || topCard.getValue() == UnoCard.Value.DRAW_FOUR) {
            topCard.setColor(UnoCard.Color.valueOf(input.toUpperCase()));
        }
    
        System.out.println("New color is " + input.toUpperCase());
    }
    

    private UnoPlayer nextPlayer() {
        // Increment the currentPlayerIndex to get the index of the next player
        // Assuming you have a List<Player> called players and a Player called currentPlayer
        int currentPlayerIndex = players.indexOf(currentPlayer);
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        // Return the next player in the list
        return players.get(currentPlayerIndex);
    }

    public void skipTurn() {
        // Increment the index to the next player, but don't play their turn
        System.out.println(currentPlayer.getName() + " skips their turn");
        currentPlayer = nextPlayer();
    }
    
    public void reverseOrder() {
        Collections.reverse(players);
        skipTurn();
    }

    public void setColor(UnoCard.Color color) {
        discardPile.getTopCard().setColor(color);
        System.out.println("The new color is " + color.toString());
    }
    
    
}
