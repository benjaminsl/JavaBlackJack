/* This is the driver file for the Java Blackjack Game. */
/* Author: Benjamin Leach */
import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayBlackJack 
{
	// Is the hand the hand of a dealer?
	private Boolean dealer = false;

	public void handStatus(BlackjackHand blackjackHand)
	{
			blackjackHand.sortByValue();
			System.out.println("Your hand: " + blackjackHand);
			System.out.println("Your hand's value: " + blackjackHand.getBlackjackValue());
	}
		
	public static void main(String[] args)
	{
		// make the deck
		Deck deck = new Deck();
		// shuffle the deck
		deck.shuffle();

		// create the hands of the dealer and player
		BlackjackHand player = new BlackjackHand();
		BlackjackHand dealer = new BlackjackHand();

		// deal cards from the deck to the dealer and the player. 
		// The first dealer's card is hidden for now 
		System.out.println();

		Card c1 = deck.dealCard();
		player.addCard(c1);
		System.out.println("You were dealt a " + c1 + ".");
		System.out.println();

		Card c2 = deck.dealCard();
		dealer.addCard(c2);
		System.out.println("Dealer was dealt a card. The card is hidden for now.");
		System.out.println();

		Card c3 = deck.dealCard();
		player.addCard(c3);
		System.out.println("You were dealt a " + c3 + ".");
		System.out.println();

		Card c4 = deck.dealCard();
		dealer.addCard(c4);
		System.out.println("Dealer were dealt a " + c4 + ".");
		System.out.println();

		System.out.println(player.handStatus());

		// Create scanner object
		Scanner scanner = new Scanner(System.in);
		char playerOption;

		// Loop through the hit or stand option until player decides to stand or player busts
		do
		{
			try
			{
				System.out.println();
				System.out.println("Hit or Stand?: " );
				playerOption = scanner.next().charAt(0); // returns the next token/word in the string	
				System.out.println(playerOption);
		
				// check input and make sure its either 'h' or 's'	
				while (playerOption != 'h' && playerOption != 's')
				{
					System.out.println("Please enter either 'h' for hit of 's' for stand: ");
					playerOption = scanner.next().charAt(0); // returns the next token/word in the string	
					System.out.println(playerOption);
				}
			} // end try

			catch (InputMismatchException inputMismatchException)
			{
				System.out.println("You must enter either 'h' for hit or 's' for stand.");
			}
		} while (player.getBlackjackValue() < 21); // end do
	}	

} // end PlayBlackJack.java
