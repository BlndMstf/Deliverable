

package Card;

/**
 * This class is Software Design SYST17796 18401
 *
 * @author Mehmet Sakalli
 */
public class UnoCard extends Card {
    private final Color color;
    private final Value value;

    public UnoCard(Color color, Value value) {
        super(color.toString(), value.toString());
        this.color = color;
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public String toString() {
        return color + " " + value;
    }

    public enum Color {
        RED, YELLOW, GREEN, BLUE
    }

    public enum Value {
        ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE,
        SKIP, REVERSE, DRAW_TWO, WILD_CARD, DRAW_FOUR
    }
    
    public boolean isValidMove(Card card) {
        return false;
    }
}

