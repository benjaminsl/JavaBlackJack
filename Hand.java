import java.util.ArrayList;

public class Hand
{
	public ArrayList<Card> hand;

	public Hand()
	{
		hand = new ArrayList<Card>();
	}

	public void clear()
	{
		hand.clear();
	}

	public void addCard(Card c)
	{
		if (c != null)
			hand.add(c);
	}

	public void removeCard(Card c)
	{
		hand.remove(c);
	}

	public void removeCard(int posistion)
	{
		if (posistion >= 0 && posistion < hand.size())
		{
			hand.remove(posistion);
		}
	}

	public int getCardCount()
	{
		return hand.size();
	}

	public Card getCard(int position)
	{
		// Get the card from the hand in given posisiton,
		// where positions are numbered starting from 0.
		if (position >= 0 && position < hand.size())
			return hand.get(position);
		else
			return null;
	}

	// ************************************************************************** //
	// ************************************************************************** //

	public void sortBySuit()
	{
		ArrayList<Card> newHand = new ArrayList<Card>();

		while (hand.size() > 0)
		{
			int position = 0; // position of minimal card
			
			Card c = hand.get(0); // minimal card
		
			for (int i = 1; i < hand.size(); i++)
			{
				Card c1 = hand.get(i);

				if (c1.getSuit() < c.getSuit() || 
							(c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue()) )
				{
					position = i;
					c = c1;
				} // end if

			} // end for	

			hand.remove(position);
			newHand.add(c);	
		}

		hand = newHand;

	}	 // end sortBySuit

	// ************************************************************************** //
	// ************************************************************************** //

	public void sortByValue()
	{
		ArrayList<Card> newHand = new ArrayList<Card>();

		while (hand.size() > 0)
		{
			int position = 0; // position of minimal card
			
			Card c = hand.get(0); // minimal card

			for (int i = 1; i < hand.size(); i++)
			{
				Card c1 = hand.get(i);

				if (c1.getValue() < c.getValue() ||
							(c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit()) )
				{
					position = i;
					c = c1;
				}
			} // end for
			hand.remove(position);
			newHand.add(c);
		} // end while	
		hand = newHand;
	} // end sortByValue

	// ************************************************************************** //
	// ************************************************************************** //
	

} // end class Hand












