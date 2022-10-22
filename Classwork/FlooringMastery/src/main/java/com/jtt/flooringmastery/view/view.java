/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jtt.flooringmastery.view;

/**
 *
 * @author Jenny
 */
public class view {

    private UserIO m_userio;

    public view(UserIO val) {
        this.m_userio = val;
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
}
