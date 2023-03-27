package ca.sheridancollege.project;

public class UnoCard extends Card {
    /**
    * Class for cards for Uno
    * 
    * @author Blend Mustafa March 2023
    */
    public enum Color {
        RED, YELLOW, GREEN, BLUE
    }

    public enum Value {
        ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, SKIP, REVERSE, DRAW_TWO, DRAW_FOUR, WILD_CARD
    }
    
    private final Color color;
    private final Value value;

    public UnoCard(Color color, Value value) {
        this.color = color;
        this.value = value;
    }

    public Value getValue() {
        return this.value;
    }

    public Color getColour() {
        return this.color;
    }
    
    @Override
    public String toString(){
        return "";
    }
}