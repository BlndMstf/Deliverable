

package Card;

/**
 * This class is Software Design SYST17796 18401
 *
 * @author Mehmet Sakalli
 */
public class Turn {
    private UnoPlayer player;
    private boolean playedCard;
    private boolean drewCard;
    
    public Turn(UnoPlayer player) {
        this.player = player;
        this.playedCard = false;
        this.drewCard = false;
    }
    
    public UnoPlayer getPlayer() {
        return this.player;
    }
    
    public boolean hasPlayedCard() {
        return this.playedCard;
    }
    
    public void setPlayedCard(boolean playedCard) {
        this.playedCard = playedCard;
    }
    
    public boolean hasDrewCard() {
        return this.drewCard;
    }
    
    public void setDrewCard(boolean drewCard) {
        this.drewCard = drewCard;
    }
}

