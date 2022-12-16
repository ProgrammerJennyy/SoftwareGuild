/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jtt.flooringmastery.view;

import java.math.BigDecimal;

/**
 *
 * @author Jenny
 */
public class view {

    private UserIO m_userio;
    public void GetEditChoice(){
        
       System.out.println(
   "   * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n"    
   +"* <<Edit Flooring Order>>\n"
   +"* 1. Customer Name\n"
   +"* 2. State\n"
   +"* 3. Product Type\n"
   +"* 4. Area\n"
   +"* 5. Keep Changes\n"
   +"* 6. Cancel Discard Changes\n"
   +"*\n"
   +"* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * \n"
    ); 
    
    }
    public view(UserIO val) {
        this.m_userio = val;
    }
    public void ShowString(String val)
    {
        System.out.println(val);
    }
    public void ShowMenu() {
   System.out.println(
   "   * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n"    
   +"* <<Flooring Program>>\n"
   +"* 1. Display Orders\n"
   +"* 2. Add an Order\n"
   +"* 3. Edit an Order\n"
   +"* 4. Remove an Order\n"
   +"* 5. Export All Data(unavailable)\n"
   +"* 6. Quit\n"
   +"*\n"
   +"* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * \n"
    );        
    }
    public Integer GetSelection() {
       return m_userio.GetInput();
    }
    
    public BigDecimal GetBigDecimal(){
        return m_userio.GetBigDecimal(); 
        
              
    }
    
    public String GetDisplay()
    {
        System.out.println("Please enter a date MMDDYYYY:");
       return  m_userio.GetString();
    }
    public String GetString()
    {
        return m_userio.GetString();
    }
public Integer GetOrderInteger()
{
    return m_userio.GetOrderNumber(); 
    
}

        }
