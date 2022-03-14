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

        int numGames = 0;
        int numComputerWins = 0;
        int numHumanWins = 0;
        int ties = 0;
        try {
            System.out.println("Welcome to Rock Paper Scissors.");
            System.out.println("How Many games do you want to play 1-10:");
            String numGamesStr = input.nextLine();
            numGames = Integer.parseInt(numGamesStr);
            if (numGames < 1 || numGames > 10) {
                throw new Exception();
            }
        } catch (Exception x) {
            System.out.println("invalid input.  Exiting Program.");
            return;
        }

        for (int i = 0; i < numGames; i++) {
            try {  // Start Game
                // Get user input
                System.out.println("***************************");
                System.out.println("1 Rock");
                System.out.println("2 Paper");
                System.out.println("3 Scissors");
                System.out.println("***************************");
                System.out.println("Enter Choice 1-3:");
                String choiceStr = input.nextLine();
                int choice = Integer.parseInt(choiceStr);
                if (choice < 1 || choice > 3) {
                    throw new Exception();
                }
                int compChoice = randNumber.nextInt(3) + 1;
                switch (compChoice) {
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


        }// end try
        catch (Exception x) {
                System.out.println("invalid input.");
                i--; // dont increment game.
            }
    } // end for
        System.out.println("Computer won "+ numComputerWins +" times.");
        System.out.println("Human won "+ numHumanWins +" times.");

    } // end main
} // end class
