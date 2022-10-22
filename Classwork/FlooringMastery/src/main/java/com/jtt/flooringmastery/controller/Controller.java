/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jtt.flooringmastery.controller;

import com.jtt.flooringmastery.service.Service;
import com.jtt.flooringmastery.view.view;

/**
 *
 * @author Jenny
 */
public class Controller {

    private view m_view;
    private Service m_service;
    public Controller(view vw, Service srvc)
    {
        this.m_view=vw;
        this.m_service=srvc;
    }
    public void Initialize()
    {
        m_service.Initialize();
    }
    public void run() {
        Initialize();
        int choice=0;
        do{
            m_view.ShowMenu();
            choice=m_view.GetSelection();
            switch(choice)
            {
                case 1: 
                    Display();
                    break;
                case 2: 
                    Add();
                    break;
                case 3: 
                    Edit();
                    break;
                case 4: 
                    Remove();
                    break;                
                default:
            }
            
        }while(choice !=6);
    }
    
    private void Display()
    {
        m_service.Display();
    }
    private void Add(){
        m_service.Add();
    }
    private void Edit(){
        m_service.Edit();
    }
    private void Remove()
    {
       m_service.Remove();
    }
    
}
