public class PlayBlackJack 
{
	public static void main(String[] args)
	{
		Deck d1 = new Deck();
		d1.shuffle();

		Card c1 = d1.dealCard();
		Card c2 = d1.dealCard();

		BlackjackHand bjh1 = new BlackjackHand();
		bjh1.addCard(c1);
		bjh1.addCard(c2);

		bjh1.sortByValue();
		System.out.println("After sorting again: " + bjh1.hand);
		System.out.println(bjh1.getBlackjackValue());

		bjh1.hit(d1);

		bjh1.sortByValue();
		System.out.println("After sorting again: " + bjh1.hand);
		System.out.println(bjh1.getBlackjackValue());
	}	
}
