all:
	cls
	javac Card.java
	javac Deck.java
	javac PlayBlackJack.java
	javac Hand.java
	javac BlackjackHand.java
	java PlayBlackJack 

hand:
	javac Hand.java
	javac BlackjackHand.java
	java PlayBlackJack 
