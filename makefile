all:
	cls
	javac Card.java
	javac Deck.java
	javac Hand.java
	javac BlackjackHand.java
	javac PlayBlackJack.java
	java PlayBlackJack 

hand:
	javac Hand.java
	javac BlackjackHand.java
	java PlayBlackJack 

driver:
	javac PlayBlackJack.java
	java PlayBlackJack
