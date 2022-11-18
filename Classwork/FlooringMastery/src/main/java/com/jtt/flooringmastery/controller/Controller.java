/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jtt.flooringmastery.controller;

import com.jtt.flooringmastery.dto.OrderDTO;
import com.jtt.flooringmastery.service.Service;
import com.jtt.flooringmastery.view.view;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jenny
 */
public class Controller {

    private view m_view;
    private Service m_service;
    private String m_sDate = "";

    public Controller(view vw, Service srvc) {
        this.m_view = vw;
        this.m_service = srvc;
    }

    public void Initialize() {
        Date date = new Date();
        SimpleDateFormat dmyFormat = new SimpleDateFormat("MMddyyyy");
        m_sDate = dmyFormat.format(date);
    }

    public void run() {
        Initialize();
        int choice = 0;
        do {
            m_view.ShowMenu();
            choice = m_view.GetSelection();
            switch (choice) {
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
        } while (choice != 6);
    }

    private void Display() {
        m_sDate = m_view.GetDisplay();
        String mylist = m_service.Display(m_sDate);
        m_view.ShowString(mylist);
    }

    private void Add() {
        m_service.Add();
    }

    private void Edit() {
        m_sDate = m_view.GetDisplay();
        String mylist = m_service.Display(m_sDate);
        m_view.ShowString(mylist);
        Integer choice = m_view.GetOrderInteger();

        OrderDTO edited = m_service.Edit(choice);
        if (edited.getM_OrderNumber() == -1) {

        //invalid choice       
        } else {
            editOrderDTO(edited);
          
        }

    }
private void editOrderDTO(OrderDTO order){
int choice =0;
    do {
            m_view.GetEditChoice(); 
            choice = m_view.GetSelection();
            switch (choice) {
                case 1:
                    //Customer Name();
                    m_view.ShowString("Enter Updated Customer Name");
                    order.setM_CustomerName (m_view.GetString());
                    break;
                case 2:
                    //State();
                    break;
                case 3:
                    //Product Type();
                    break;
                case 4:
                    //Area();
                    break;
                case 5:
                    //Save();
                       //Customer Name();
                    
                   String temp = Integer.toString(order.getM_OrderNumber()); 
                   m_service.Remove(temp);
                   m_service.AddOrderDTO(order); 
                   
                    String mylist = m_service.Display();
                    m_view.ShowString(mylist);
                                   
                                 
                    
                    
                    break;
                case 6:
                    //Discard Changes();
                    break;
                default: 
                break;
            }
        } while (!(choice == 5 || choice == 6));
       
        
}
    private void Remove() {
        String list = m_service.Display(m_sDate);
        m_view.ShowString(list);
        m_view.ShowString("Enter number to remove");
        String choice = m_view.GetString();
        String result = m_service.Remove(choice);
        m_view.ShowString(result);
    }
}
