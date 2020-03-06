public class Card
{
	// SUITS
	public final static int SPADES = 0;
	public final static int HEARTS = 1;
	public final static int DIAMONDS = 2;
	public final static int CLUBS = 3;


	// CARD VALUES 	
	public final static int ACE = 1;
	public final static int JACK = 11;
	public final static int QUEEN = 12;
	public final static int KING = 13;

	private final int suit; // The suit of this card
	private final int value; // the value of this card

	// CONSTRUCTOR
	public Card(int value, int suit)
	{
		this.value = value;			
		this.suit = suit;	
	}

	// GETTERS	
	public int getSuit()
	{
		return suit;
	}

	public int getValue()
	{
		return value;
	}

	public String getSuitAsString()
	{
		switch (suit)
		{
			case SPADES: return "Spades";
			case HEARTS: return "Hearts";
			case DIAMONDS: return "Diamonds";
			case CLUBS: return "Clubs";
			default:	   return "??";
		}	
	} // end getSuitAsString

	public String getValueAsString()
	{
		switch (value)
		{
			case 1: return "Ace";
			case 2: return "2";
			case 3: return "3";
			case 4: return "4";
			case 5: return "5";
			case 6: return "6";
			case 7: return "7";
			case 8: return "8";
			case 9: return "9";
			case 10: return "10";
			case 11: return "Jack";
			case 12: return "Queen";
			case 13: return "King";
			default: return "??";
		}	
	} // end getValueAsString

	// TOSTRING
	public String toString()	
	{
		// Return a String representation of this card,
		// such as "10 of Hearts" or "Queen of Spades"
		return getValueAsString() + " of " + getSuitAsString();
	} 

} // end class CARD


