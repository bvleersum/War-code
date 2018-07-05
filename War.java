/*
Name:  Bas van Leersum
Date:  3/9/2018
Description:  This program has the code for the card game War in it.
Sources Cited: 
*/

package cardGame;

import java.io.IOException;

public class War {
	//making global variables so that they can be used in the compare method
	static int player_score = 0;
	static int computer_score = 0;
	
	public static void main(String[] args) {
		//initializing the deck
		Deck d = new Deck();
		//shuffling the deck
		d.shuffle();
		
		//going through this loop until the deck is empty
		while(!(d.isEmpty()))
		{
			
			//pulling 1 card for the player and 1 card for the computer
			Card player = d.draw();
			Card computer = d.draw();
			
			//telling the user which cards were drawn
			System.out.println("The player drew a " + player.getRank() + " of " + player.getSuit());
			System.out.println("The computer drew a " + computer.getRank() + " of " + computer.getSuit());
			//having the user press enter to continue 
			System.out.println("Press enter to continue");
			promptEnterKey();
			
			//sending the player's and computer's rank of the card to the compare method 
			//the 2 is for the possible increased score
			if (compare(player.getRank(),computer.getRank(), 2) == 1)
			{
				//check if the deck is empty
				if (d.isEmpty() == false)
				{
					System.out.println("There is a WAR! both players will pick 2 more cards if possible.");
					System.out.println("Press enter to continue");
					promptEnterKey();
					
					//two more cards are drawn
					Card player_war1 = d.draw();
					Card computer_war1 = d.draw();
					
					//another check if the deck is empty
					if (d.isEmpty() == false)
					{
						//two more cards are drawn
						Card player_war2 = d.draw();
						Card computer_war2 = d.draw();
						
						//outputting the values and suits of all these cards
						System.out.println("The player drew a " + player_war1.getRank() + " of " + player_war1.getSuit());
						System.out.println("The player drew a " + player_war2.getRank() + " of " + player_war2.getSuit());
						System.out.println("The computer drew a " + computer_war1.getRank() + " of " + computer_war1.getSuit());
						System.out.println("The computer drew a " + computer_war2.getRank() + " of " + computer_war2.getSuit());
						System.out.println();
						
						//comparing the first two war cards, with possible increase of 6
						if (compare(player_war1.getRank(),computer_war1.getRank(), 6) == 1)
						{
							//comparing the second two war cards, with possible increase of 6
							if (compare(player_war2.getRank(),computer_war2.getRank(), 6) == 1)
							{
								//if there is another tie both players keep their cards
								player_score += 3;
								computer_score += 3;
							}
						}
					}
					else
					{
						//if the deck ran out of cards before drawing the second war card
						//the first war card get compared and increases the value by only 4
						if (compare(player_war1.getRank(),computer_war1.getRank(), 4) == 1)
						{
							//if a tie both players keep their cards
							player_score += 2;
							computer_score += 2;
						}
					}
				}
				else
				{
					//no more cards were left in the deck so both players keep their card.
					player_score += 1;
					computer_score += 1;
				}
			}
			
			//outputting player's and computer's current score
			System.out.println("The player's score is: "+ player_score);
			System.out.println("The computer's score is: "+ computer_score);
			System.out.println("Press enter to continue");
			promptEnterKey();
		
		}
		//outputting the final scores
		System.out.println("The player's final score is: "+player_score);
		System.out.println("The computer's final score is: " + computer_score);
		System.out.println();
		if (player_score > computer_score)
			System.out.println("You won this game of WAR!");
		else if (player_score < computer_score)
			System.out.println("The computer won this game of WAR!");
		else
			System.out.println("This game of WAR ended in a tie.");
	}
	
	//method to have the user press a key to continue
	public static void promptEnterKey(){ try {
	    System.in.read(new byte[2]);
	}
	catch (IOException e) {
	    e.printStackTrace();
	} 
	}
	
	//method to compare the card ranks
	//takes in both ranks and the amount of increase in points
	public static int compare(int player, int computer, int increase) 
	{
		//comparing ranks 
		if (player > computer)
		{
			//increasing the score if true
			player_score += increase;
			return 0;
		}
		//comparing ranks
		else if (player < computer)
		{
			//increasing the score if true
			computer_score += increase;
			return 0;
		}
		else
			//if it is a tie it returns a 1
			return 1;	
	}
}
