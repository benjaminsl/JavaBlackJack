all:
	cls
	javac Card.java
	javac Deck.java
	javac Driver.java
	javac Hand.java
	javac BlackjackHand.java
	java Driver

hand:
	javac Hand.java
	javac BlackjackHand.java
	java Driver
