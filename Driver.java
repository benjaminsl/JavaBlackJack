public class Driver
{
	public static void main(String[] args)
	{
		Deck d1 = new Deck();
		d1.shuffle();

		Card c1 = d1.dealCard();
		Card c2 = d1.dealCard();

		//Card c3 = d1.dealCard();
	
		//Card c4 = d1.dealCard();

		//Card c5 = d1.dealCard();
	
		BlackjackHand bjh1 = new BlackjackHand();
		bjh1.addCard(c1);
		bjh1.addCard(c2);
		// bjh1.addCard(c3);
		// bjh1.addCard(c4);
		//bjh1.addCard(c5);

		// System.out.println("Before sorting: " + bjh1.hand);
		// bjh1.sortBySuit();
		// System.out.println("After sorting: " + bjh1.hand);
		bjh1.sortByValue();
		System.out.println("After sorting again: " + bjh1.hand);

		System.out.println(bjh1.getBlackjackValue());
	}	
}
