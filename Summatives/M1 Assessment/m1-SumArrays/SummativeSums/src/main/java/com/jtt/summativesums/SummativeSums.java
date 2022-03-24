/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.jtt.summativesums;

/**
 *
 * @author Jennifer
 */
public class SummativeSums {

    /**
     * @param args the command line arguments
     */
    
    private static int sum(int[] val)
    {
        int returnValue=0;
        for(int i=0;
                i<val.length;
                i++){
            returnValue+=val[i];
        }
        return returnValue;    
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int A[]={ 1, 90, -33, -55, 67, -16, 28, -55, 15 };
        int B[]={ 999, -60, -77, 14, 160, 301 };
        int C[]={ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 
                    140, 150, 160, 170, 180, 190, 200, -99 } ;
        
        System.out.println("#1 Array Sum:" + sum(A));
        System.out.println("#2 Array Sum:" + sum(B));
        System.out.println("#3 Array Sum:" + sum(C));
    }
    
}
