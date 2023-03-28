package ca.sheridancollege.project;
/**
 * Discard pile, this is the pile where players discard their cards
 *
 * @author Blend Mustafa March 2023
 */
public class DiscardPile {
    Card topCard;

	public Card getTopCard() {
		return this.topCard;
	}

	/**
	 * 
	 * @param topCard
	 */
	public void setTopCard(Card topCard) {
		this.topCard = topCard;
	} //this represents the top card in the discard pile, this is the card that is important for players to know
}
