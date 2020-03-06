public class Driver
{
	public static void main(String[] args)
	{
		Deck d1 = new Deck();
		d1.shuffle();
		d1.printDeck();

		Card c1 = d1.dealCard();

		Card c2 = d1.dealCard();

		Card c3 = d1.dealCard();
	
		Card c4 = d1.dealCard();

		Card c5 = d1.dealCard();
	
		Hand h1 = new Hand();
		h1.addCard(c1);
		h1.addCard(c2);
		h1.addCard(c3);
		h1.addCard(c4);
		h1.addCard(c5);

		System.out.println("Before sorting: " + h1.hand);
		h1.sortBySuit();
		System.out.println("After sorting: " + h1.hand);
		h1.sortByValue();
		System.out.println("After sorting again: " + h1.hand);

	}	
}
