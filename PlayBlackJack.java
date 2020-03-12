/* This is the driver file for the Java Blackjack Game. */
/* Author: Benjamin Leach */
import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayBlackJack 
{

	boolean gameOver = false;

	// a method to deal a card from the deck and add it to the a hand	
	public void takeTurn(Deck deck, BlackjackHand blackjackHand)
	{
		System.out.println();

		Card card = deck.dealCard();
		blackjackHand.addCard(card);
		boolean dealer = blackjackHand.checkIfDealer();

		if (dealer == true)
		{
				// if it's the dealers first card, don't show it to the player
				if (blackjackHand.getCardCount() == 1)
				{
					System.out.println("Dealer was dealt a hidden card."); 
				}
		
				// if it's the dealers 2nd, 3rd, 4th, card etc., show the player	
				else 
				{
					System.out.println("Dealer was dealt a " + card + ".");
				}	
		} // end if
		
		else
		{
				System.out.println("You were dealt a " + card + ".");
		}

		System.out.println();
	}

	// a method to check if the game is over
	public boolean checkPlayerBust(BlackjackHand player)
	{
		boolean playerBust = false;

		if (player.getBlackjackValue() > 21)
		{
			System.out.println("Bust.");
			System.out.println("Player Loses.");
			playerBust = true;
		}

		return playerBust;
	}

	// compare the value of the hands, and see if anyone has won yet
	public String checkIfHandWon(BlackjackHand player, BlackjackHand dealer)
	{
		if ((dealer.getBlackjackValue() > player.getBlackjackValue()) && dealer.getBlackjackValue() <= 21)
		{
			return "Dealer";	
		}

		else if (dealer.getBlackjackValue() > 21)
		{
			return "DealerBusts";
		}

		else if (dealer.getBlackjackValue() == player.getBlackjackValue())
		{
			return "Push";
		} 
	
		return "NoWin";
	} // end checkIfHandWon
		
	public static void main(String[] args)
	{
		// create a game
		PlayBlackJack blackJackGame = new PlayBlackJack();
		// make the deck
		Deck deck = new Deck();
		// shuffle the deck
		deck.shuffle();

		boolean playerBust = false;
		boolean gameOver = false;

		// create the hands of the dealer and player
		BlackjackHand player = new BlackjackHand();
		BlackjackHand dealer = new BlackjackHand();
		dealer.makeDealer();
		player.setWhoseHand("Player");
		dealer.setWhoseHand("Dealer");

		System.out.println();

		blackJackGame.takeTurn(deck, player);
		blackJackGame.takeTurn(deck, dealer);
		blackJackGame.takeTurn(deck, player);
		blackJackGame.takeTurn(deck, dealer);
		
		System.out.println(player.handStatus());

		// Create scanner object
		Scanner scanner = new Scanner(System.in);
		char playerOption;

		/*********************************/
		/* PLAYER'S TIME TO HIT OR STAND */
		/*********************************/

		// Loop through the hit or stand option until player decides to stand or player busts
		do
		{
			try
			{
				System.out.println();
				System.out.print("Hit or Stand?: " );
				playerOption = scanner.next().charAt(0); // returns the next token/word in the string	
		
				// check input and make sure its either 'h' or 's'	
				while (playerOption != 'h' && playerOption != 's')
				{
					System.out.println("Please enter either 'h' for hit of 's' for stand: ");
					playerOption = scanner.next().charAt(0); // returns the next token/word in the string	
					System.out.println(playerOption);
				}

				if (playerOption == 'h')
				{
					blackJackGame.takeTurn(deck, player);
					System.out.println(player.handStatus());
				}

				if (playerOption == 's')
				{
					break;
				}	
		
			} // end try

			catch (InputMismatchException inputMismatchException)
			{
				System.out.println("You must enter either 'h' for hit or 's' for stand.");
			}

		} while (player.getBlackjackValue() < 21); // end do

		/*************************************/
		/* END PLAYER'S TIME TO HIT OR STAND */
		/*************************************/

		/***************************************/
		/* DEALER HIT'S UNTIL WIN, BUST, OR 21 */
		/***************************************/

		gameOver = blackJackGame.checkPlayerBust(player);

		if (gameOver == false)
		{
			String didAnyoneWin;
	
			System.out.println();
			System.out.println("************");
			System.out.println("DEALER PLAYS");
			System.out.println("************");
			System.out.println();

			System.out.print("Dealer's other card: ");
			dealer.showFirstCard();
			System.out.println("Dealer's Value: " + dealer.getBlackjackValue());

			
			didAnyoneWin = blackJackGame.checkIfHandWon(player, dealer);
			
			/*****************************/
			/*** CHECK FIRST TWO CARDS ***/
			/*****************************/

			if (didAnyoneWin == "Dealer")
			{
				System.out.println("Dealer Won.");
			}

			else if (didAnyoneWin == "Push")
			{
				System.out.println("Push.");
			}

			else if (didAnyoneWin == "DealerBusts")
			{
				System.out.println("You Won.");
			}

			/*********************************/
			/*** END CHECK FIRST TWO CARDS ***/
			/*********************************/

			while (didAnyoneWin == "NoWin")
			{
				blackJackGame.takeTurn(deck, dealer);	
				System.out.println(dealer.handStatus());
				System.out.println();

				// check to see if any hand won
				didAnyoneWin = blackJackGame.checkIfHandWon(player, dealer);

				if (didAnyoneWin == "Dealer")
				{
					System.out.println("Dealer Won.");
				}

				else if (didAnyoneWin == "Push")
				{
					System.out.println("Push.");
				}

				else if (didAnyoneWin == "DealerBusts")
				{
					System.out.println("You Won.");
				}

			} // end while 
			
		} // end if	

	} // end main

} // end PlayBlackJack.java
