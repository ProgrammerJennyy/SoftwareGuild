/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.jtt.healthyheart;

/**
 *
 * @author Jennifer
 */
import java.util.Scanner;

public class HealthyHeart {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Scanner input = new Scanner(System.in);

            System.out.println("What is your age?");
            String getAge = input.nextLine();
            int age = Integer.parseInt(getAge);
            if (age < 1 || age > 110) {
                throw new Exception();
            }
            long low= Math.round((220 - age)*0.50);
            long high =Math.round((220 - age)*0.85);
            System.out.println("Your maximum heart rate should be " + (220 - age) + " beats per minute");
            System.out.println("Your target HR Zone is " 
            + low 
            + " - "        
            + high        
            + " beats per minute");

        } catch (Exception x) {
            System.out.println("invalid input.  Exiting Program.");
            return;
        }
    }

}
