package ca.sheridancollege.project;

public class UnoPlayer extends Player { /**
	 * Player has a hand that belongs to them
	 * @param name
	 */
    
    protected UnoPlayer(String name) {
        super(name);
    }

	public Hand getHand() {
		return this.hand;
	}

	/**
	 * 
	 * @param hand
	 */
	public void setHand(Hand hand) {
		this.hand = hand;
	}
}