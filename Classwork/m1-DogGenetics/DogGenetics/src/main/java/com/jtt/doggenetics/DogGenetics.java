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
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        Random randNumber = new Random();
        System.out.println("What is your dog's name?");
        String dogsName = input.nextLine();
        System.out.println("Well then, I have this highly reliable report on "
                + dogsName + "'s prestigious background right here.");
        System.out.println(dogsName + " is:");

        int percentleft = 100;
        if (percentleft > 0) {
            int perbreed = randNumber.nextInt(percentleft) ;
            System.out.println(perbreed + "% St. Bernard");
            percentleft -= perbreed;
        }

        if (percentleft > 0) {
            int perbreed = randNumber.nextInt(percentleft) ;
            System.out.println(perbreed + "% Chihuahua");
            percentleft -= perbreed;
        }
        if (percentleft > 0) {
            int perbreed = randNumber.nextInt(percentleft) ;
            System.out.println(perbreed + "% Dramatic RedNosed Asian Pug");
            percentleft -= perbreed;
        }
        if (percentleft > 0) {
            int perbreed = randNumber.nextInt(percentleft) ;
            System.out.println(perbreed + "% Common Cur");
            percentleft -= perbreed;
        }
        if (percentleft > 0) {
            System.out.println(percentleft + "% King Doberman");
        }        
        System.out.println("Wow, that's QUITE the dog!    ");
        
        
    }

}
