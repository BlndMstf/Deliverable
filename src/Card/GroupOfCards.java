

package Card;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class is Software Design SYST17796 18401
 *
 * @author Mehmet Sakalli
 */
public class GroupOfCards {
    private final int size;
    //protected final Card[] cards;
    private final ArrayList<Card> cards;

    public GroupOfCards(int size) {
        this.size = size;
        //this.cards = new Card[size];
        this.cards = new ArrayList<>();
    }

    public int getSize() {
        return size;
    }

    public void setCard(int index, Card card) {
        //cards[index] = card;
        cards.set(index, card);
    }

    public Card getCard(int index) {
        //return cards[index];
        return cards.get(index);
    }

    public void shuffleCards() {
        /*
        Random random = new Random();
        for (int i = size - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }*/
        Collections.shuffle(cards);
    }
}
