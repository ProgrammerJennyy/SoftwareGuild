/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jtt.flooringmastery.view;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author Jenny
 */
public class UserIOConsoleImpl implements UserIO {

    Scanner myInput = new Scanner(System.in);
    private int m_input;
    public String GetString()
    {
        return this.myInput.nextLine();
    }
    public int GetInput() {
        do {
            System.out.println("Enter integer selection: ");
            try {
                String X = myInput.nextLine();
                m_input = Integer.parseInt(X);

            } catch (Exception e) {
                m_input = 0;
                System.out.println("enter correct data please  ");
            }
        } while (m_input == 0 || ValidateInput() == false);
        return m_input;
    }
    
     public int GetOrderNumber() {
        do {
            System.out.println("Enter order number: ");
            try {
                String X = myInput.nextLine();
                m_input = Integer.parseInt(X);

            } catch (Exception e) {
                m_input = 0;
                System.out.println("enter correct order number please  ");
            }
        } while (m_input == 0 || ValidateInput() == false);
        return m_input;
    }
    public BigDecimal GetBigDecimal() {
        BigDecimal retvalue=new BigDecimal(0.0); 
               
        do {
            System.out.println("Enter new area");
            try {
                String X = myInput.nextLine();
                retvalue = new BigDecimal(X);

            } catch (Exception e) {
                System.out.println("enter valid area over 100 sq feet");
            }
        } while (retvalue.compareTo(new BigDecimal (99.9))!=1);
        return retvalue; 
    
    
    
    }
            
            
    public boolean ValidateInput() {
        if (m_input > 0 && m_input < 7) {
            return true;
        } else {
            System.out.println("enter correct data please  ");
            return false;

        }
    }  // end validate   
} // end class 
