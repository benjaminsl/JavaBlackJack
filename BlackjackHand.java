/* A subclass of the Hand class that represents a hand of cards
	 in the game of Blackjack. To the methods inherited from Hand
	 it adds the method getBlackjackHand(), which returns the value
	 of the hand for the game of Blackjack.
*/

public class BlackjackHand extends Hand
{
	public int getBlackjackValue()
	{
			// Returns the value of this hand
			// for the game of Blackjack

			int valueOfHand = 0;	// the value of the hand		
			boolean isThereAnAce = false; // This will be set to true if the hand contains an ace
			int howManyCardsInHand = this.getCardCount();		// the number of cards in the hand

			for (int i = 0; i < howManyCardsInHand; i++)
			{
				// Add the value of the i-th card in the hand
				Card card; // the ith card
				int cardValue; // the blackjack value of the i-th card
				card = this.getCard(i); // assign the ith card to the variable card
				cardValue = card.getValue(); // the normal value, 1 to 13

				/* change value of jack, queen, or king back to 10 */
				if (cardValue > 10)
					cardValue = 10;			

				/* if the card value is 1, there is an ace somewhere */
				if (cardValue == 1)
					isThereAnAce = true;
		
				valueOfHand = valueOfHand + cardValue;
			}

			// Now, valueofHand is counting aces only as 1.
			// We're about to change that.
			// If there is an ace AND if changing its value from
			// 1 to 11 would leave the score less than or equal to 21,
			// , then do change the value from 1 to 11. Do this by
			//	adding 10 valueOfHand.
			if (isThereAnAce == true && valueOfHand + 10 <= 21)
			{
				valueOfHand = valueOfHand = 10;
			}

			return valueOfHand;
	}  // end getBlackjackValue()	

	public String handStatus()
	{
		this.sortByValue();	
		return ("Your hand: " + this.hand + "\n" +
					 "Your hand's value is " + this.getBlackjackValue() + ".");
	}

	public void hit(Deck deck)
	{
		Card newCard = deck.dealCard();
		this.addCard(newCard);
	} // end hit

} // end class BlackjackHand






















