/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.jtt.doggenetics;

/**
 *
 * @author Jennifer
 */
import java.util.Scanner;
import java.util.Random;

public class DogGenetics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random randNumber = new Random();
        System.out.println("What is your dog's name?");
        String dogsName = input.nextLine();
        System.out.println("Well then, I have this highly reliable report on "
                + dogsName + "'s prestigious background right here.");
        System.out.println(dogsName + " is:");

        int range=101;
        int bernard =randNumber.nextInt(range);
        double sumTotal = bernard;
        int chihuahua =randNumber.nextInt(range);
        sumTotal += chihuahua;
        int pug =randNumber.nextInt(range);
        sumTotal += pug;
        int cur =randNumber.nextInt(range);
        sumTotal += cur;
        int doberman =randNumber.nextInt(range);
        sumTotal += doberman;

        System.out.println((int)(bernard/sumTotal*100) + "% St. Bernard");
        System.out.println((int)(chihuahua/sumTotal*100) + "% Chihuahua");
        System.out.println((int)(pug/sumTotal*100) + "% Dramatic RedNosed Asian Pug");
        System.out.println((int)(cur/sumTotal*100) + "% Common Cur");
        doberman = 100   // handle integer rounding.
                - (int)(bernard/sumTotal*100)
                - (int)(chihuahua/sumTotal*100)
                - (int)(pug/sumTotal*100)
                - (int)(cur/sumTotal*100) ;
        System.out.println(doberman + "% King Doberman");
        System.out.println("Wow, that's QUITE the dog!    ");
        }        
       
        
        
    }


