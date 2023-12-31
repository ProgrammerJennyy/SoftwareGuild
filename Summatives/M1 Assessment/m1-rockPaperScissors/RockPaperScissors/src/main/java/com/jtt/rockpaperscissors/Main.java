/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jtt.rockpaperscissors;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Jenny
 */
public class Main {

    public static void main(String[] args) {

        /* 
            Get number of games 
         */
        Scanner input = new Scanner(System.in);
        Random randNumber = new Random();
        //classes 

        int numGames = 0;
        int numComputerWins = 0;
        int numHumanWins = 0;
        int ties = 0;
        int choice = 0;
        String playAgain = "N";
        do { // play again- do while loop - conditional check is at the end, will run atleast once 

            System.out.println("Welcome to Rock Paper Scissors.");
            System.out.println("How Many games do you want to play 1-10:");
            String numGamesStr = input.nextLine();

            numGames = Integer.parseInt(numGamesStr);

            if (numGames < 1 || numGames > 10) {
                //if conditional statement 
                System.out.println("Invalid number of games.  Exiting Program.");
                break; // break out of do while loop and exit.
            } //clear variables before each game 
            ties = 0;
            numComputerWins = 0;
            numHumanWins = 0;
            for (int i = 0; i < numGames; i++) {
                // Get user input
                //for loop 
                // i counter for number of games 

                System.out.println("***************************");
                System.out.println("1 Rock");
                System.out.println("2 Paper");
                System.out.println("3 Scissors");
                System.out.println("***************************");
                do { // human choice validation loop
                    System.out.println("Enter Choice 1-3:");
                    String choiceStr = input.nextLine();

                    choice = Integer.parseInt(choiceStr);

                    if (choice < 1 || choice > 3) {
                        System.out.println("Invalid choice try again.");
                    }
                } while (choice < 1 || choice > 3);
                int compChoice = randNumber.nextInt(3) + 1;
                switch (compChoice) {
                    // switch is like a if else statement
                    // compChoice is a variable 
                    case 1: // rock
                        System.out.println(" Computer picks 1 Rock");
                        if (choice == 1) {
                            ties++;
                            System.out.println("Game is a tie");
                        } else if (choice == 2) {
                            numHumanWins++;
                            System.out.println("Human wins");
                        } else {
                            numComputerWins++;
                            System.out.println("Computer wins");
                        }
                        break;
                    case 2:  // paper
                        System.out.println(" Computer picks 2 Paper");
                        if (choice == 2) {
                            ties++;
                            System.out.println("Game is a tie");
                        } else if (choice == 3) {
                            numHumanWins++;
                            System.out.println("Human wins");
                        } else {
                            numComputerWins++;
                            System.out.println("Computer wins");
                        }
                        break;
                    case 3:  // scissors
                        System.out.println(" Computer picks 3 Scissors");
                        if (choice == 3) {
                            ties++;
                            System.out.println("Game is a tie");
                        } else if (choice == 1) {
                            numHumanWins++;
                            System.out.println("Human wins");
                        } else {
                            numComputerWins++;
                            System.out.println("Computer wins");
                        }
                        break;
                    default:
                } // switch

            } // end for
            System.out.println("========== Summary ==================");
            System.out.println("Computer won " + numComputerWins + " times.");
            System.out.println("Human won " + numHumanWins + " times.");
            System.out.println("A tie occured " + ties + " times.");
            if (numComputerWins > numHumanWins) {
                System.out.println("The overall winner is computer.");

            } else if (numComputerWins < numHumanWins) {
                System.out.println("The overall winner is human.");

            } else {
                System.out.println("The overall winner is nobody.");
            }
            System.out.println("=====================================");

            System.out.println("Do you want to play again?(Y/N):");
            playAgain = input.nextLine();
        } while (playAgain.equalsIgnoreCase("Y") || playAgain.equalsIgnoreCase("Yes"));
        System.out.println("Thanks for playing!");
    } // end main
} // end class
