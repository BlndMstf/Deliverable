

package Card;

/**
 * This class is Software Design SYST17796 18401
 *
 * @author Mehmet Sakalli
 * @author Blend Mustafa
 */
public class UnoPlayer {
    private String name;
    private Hand hand;
    
    public UnoPlayer(String name) {
        this.name = name;
        this.hand = new Hand();
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Hand getHand() {
        return this.hand;
    }
    
    public void setHand(Hand hand) {
        this.hand = hand;
    }
    
    public void drawCard(DrawPile drawPile) {
        UnoCard card = drawPile.drawCard();
        this.hand.addCard(card);
    }
    
    public boolean playCard(UnoCard card, DiscardPile discardPile) {
        if (!this.hand.containsCard(card)) {
            return false;
        }
        if (!card.isValidMove(discardPile.getTopCard())) {
            return false;
        }
        this.hand.removeCard(this.getHand().getCards().indexOf(card));
        discardPile.setTopCard((UnoCard)card);
        return true;
    }
}
