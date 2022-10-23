/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.jtt.flooringmastery;

import com.jtt.flooringmastery.controller.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Jenny
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         ApplicationContext ctx = 
           new ClassPathXmlApplicationContext("applicationContext.xml");
            Controller controller = 
           ctx.getBean("controller", Controller.class);
           controller.run();  
    }
    
}
