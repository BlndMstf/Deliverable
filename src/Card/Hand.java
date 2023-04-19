

package Card;
import java.util.ArrayList;

/**
 * This class is Software Design SYST17796 18401
 *
 * @author Mehmet Sakalli
 */
public class Hand {
    private final ArrayList<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }
    
    public ArrayList getCards(){
        return this.cards;
    }

    public int getSize() {
        return cards.size();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card getCard(int index) {
        return cards.get(index);
    }

    public void removeCard(int index) {
        cards.remove(index);
    }

    public boolean containsCard(Card card) {
        return cards.contains(card);
    }

    public void clear() {
        cards.clear();
    }
}
