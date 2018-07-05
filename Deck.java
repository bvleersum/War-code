/*
Name:  Bas van Leersum
Date:  3/9/2018
Description:  This program has the code for the card game War in it.
Sources Cited: 
*/

package cardGame;

import java.util.Random;

public class Deck {
	private Card[] deck;
	private int top;
	
	public Deck()
	{
		//initializing array and top variable
		deck = new Card[52];
		top = 0;
		
		//going through all the 52 spots in the array
		for (int i = 0; i < 52; i++)
		{
			//setting each array location to a value and suit
			if (i <13)
			{
				deck[i] =  new Card(i+2,'H');
			}
			else if (i<26)
			{
				deck[i] =  new Card(i-11,'D');
			}
			else if (i<39)
			{
				deck[i] =  new Card(i-24,'C');
			}
			else
				deck[i] =  new Card(i-37,'S');
		}
	}
	
	public void shuffle()
	{
		Random randomNumbers = new Random();
		
		//looping through the 52 array spots
		for (int i =0; i<52; i++)
		{
			//picking a randing number between 0-52 including 0, excluding 52
			int number = randomNumbers.nextInt(52);
			//putting current loop int and random in in the swap method
			swap(i, number);
		}
	}
	
	public Card draw()
	{
		//increase the top value
		top++;
		
		//returning top-1 (the -1 because you increased it the first time without drawing a card)
		return deck[top-1];
	}
	
	public boolean isEmpty()
	{
		//when top is 52 it means you have used all cards so returns true for the isempty method
		if (top == 52)
			return true;
		else
			//if it top is not 52 it'll return false
			return false;
	}
	
	private void swap(int i, int j)
	{
		//store what ever is in "i" into "swap"
		Card swap = deck[i];
		//store what ever is in "j" into "i"
		deck[i] = deck[j];
		//store what ever is in "swap" into "j"
		deck[j] = swap;
		
	}
	
}