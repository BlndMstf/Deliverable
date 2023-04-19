

package Card;

/**
 * This class is Software Design SYST17796 18401
 *
 * @author Mehmet Sakalli
 * @author Blend Mustafa
 */
public class DiscardPile {
    private UnoCard topCard;

    public DiscardPile() {
        topCard = null;
    }

    public UnoCard getTopCard() {
        return topCard;
    }

    public void setTopCard(UnoCard card) {
        topCard = card;
    }
}
