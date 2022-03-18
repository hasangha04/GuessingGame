// Programmer: Harpreet Sangha 
// Class: CS &141 Hybrid
// Date: 01/18/2022
// Assignment: Lab 1 Guessing Game
// Purpose: To create a simple guessing game that allows the user to guess a given integer for however many times
// until they get it right. The only problem that I have is that after the right answer is given the print statement
// Too low guess again prints out when it is not needed to other than that everything is good  

import java.util.Scanner;
import java.util.*;

public class HSGuess
{
   public static void main(String[] args)
   {
      int numTries;
      int bestGuess = 1000;
      int gameCount = 0;
      int sum = 0;

      instructions(); // print out the intro for the game
      
      System.out.print("\nWould you like to play: ");
      
      // creates new scanner object called ask 
      Scanner ask = new Scanner(System.in);
      // gets user input for whether they want to play or continue playing
      char again = ask.next().charAt(0); 

      // loops if the first letter of the scanner input is Y or y
      while (again == 'Y'|| again == 'y') 
      {
         numTries = playGame(); // calls the method playGame
         if (numTries < bestGuess)
         {
            // this changes the value of bestGuess to get the total number of guesses
            bestGuess = numTries; 
         }
         sum += numTries; // this changes the sum into the best game
         gameCount++;
         
         System.out.println("Would you like to play again");
         again = ask.next().charAt(0);
      } // end of while 
      summary(gameCount, bestGuess, sum);
   }
     
   public static void instructions()
   {
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and");
      System.out.println("100 and will allow you to guess until");
      System.out.println("you get it. For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.println("than your guess.");
   } // end of instructions method 
   
   public static int playGame()
   {
      int max = 100; // the max that the random number can go to
      int numTries = 0; // initialzie the number of tries to 0 
      int guess = 0; // initializes the guess to 0 so that it can be changed later
      
      Random rand = new Random();
      int randomNumber = rand.nextInt(max) + 1; 
      
      Scanner inputguess = new Scanner(System.in);
          
      System.out.print("\nI'am thinking of a number between 1 and " + max + ": "); 
      
      while (guess != randomNumber) 
      {
         guess = inputguess.nextInt();
         if (guess > randomNumber) 
         {
            System.out.println("Too high guess again");
            numTries++; 
         } 
         if (guess < randomNumber)
         {  
            System.out.println("Too low guess again");
            numTries++; 
         } // end of if/else 
      } // end of while 
      
      System.out.println("Congratulations you got it right in " + numTries + " tries");
      return numTries; 
      
   } // end of playGame method 
   
   public static void summary(int gameCount, int sum, int bestGuess)
   {
      double average = (((double)bestGuess/(double)gameCount)); 
      System.out.println("Total games: " + gameCount);
      System.out.println("Total guesses: " + bestGuess);
      System.out.println("Best Guess: " + sum);
      System.out.printf("Your Average is: %.1f", average);  
   }
}