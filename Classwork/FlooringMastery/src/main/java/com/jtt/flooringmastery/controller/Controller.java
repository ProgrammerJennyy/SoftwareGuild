/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jtt.flooringmastery.controller;

import com.jtt.flooringmastery.dto.OrderDTO;
import com.jtt.flooringmastery.service.Service;
import com.jtt.flooringmastery.view.view;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
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
    private boolean CheckDate(String val)
    {
        boolean validDate=false;
        // valid date?
        SimpleDateFormat dateForm = new SimpleDateFormat("MMddyyyy");
        dateForm.setLenient(false);
        try {
            dateForm.parse(val.trim());
            validDate=true;
        } catch (ParseException ex) {
            validDate=false;
        }
        // in future
        if(validDate)
        {
            LocalDate today = LocalDate.now();
              DateTimeFormatter formating = DateTimeFormatter.ofPattern("MMddyyyy");
            LocalDate val_date = LocalDate.parse(val, formating);
           if( today.compareTo(val_date)<0)
           {
               validDate=true;
           }
           else
           {
               validDate=false;
           }
        }
        return validDate;
    }
    private OrderDTO doCalculations(OrderDTO order)
    {
          //MaterialCost = (Area * CostPerSquareFoot)
                    BigDecimal tempmaterialcost = new BigDecimal(0); 
                    tempmaterialcost = order.getM_Area().multiply(order.getM_CostPerSquareFoot()); 
                    order.setM_MaterialCost(tempmaterialcost);
                                    
                    //LaborCost = (Area * LaborCostPerSquareFoot)
                    BigDecimal templaborcost = new BigDecimal(0); 
                    templaborcost = order.getM_Area().multiply(order.getM_LaborCostPerSquareFoot()); 
                    order.setM_LaborCost(templaborcost);
                    
                    //Tax = (MaterialCost + LaborCost) * (TaxRate/100)
                    BigDecimal temptaxcost = new BigDecimal(0); 
                    temptaxcost = order.getM_MaterialCost().add(order.getM_LaborCost()); 
                    temptaxcost = temptaxcost.multiply(order.getM_TaxRate());
                    temptaxcost = temptaxcost.divide(new BigDecimal("100").setScale(2, RoundingMode.HALF_UP));
                    order.setM_Tax(temptaxcost);
                    
                    //Total = (MaterialCost + LaborCost + Tax)
                    BigDecimal temptotal = new BigDecimal(0); 
                    temptotal = order.getM_MaterialCost().add(order.getM_LaborCost()); 
                    temptotal = temptotal.add(order.getM_Tax()); 
                    order.setM_Total(temptotal); 
                    return order;
    }
    
    private void Add() {
        // m_service.Add();
        OrderDTO order = new OrderDTO();
        String completeOrder="Np";
            // get date in future
            do{
                m_sDate = m_view.GetDisplay();
            }while(!CheckDate(m_sDate));
            order.setM_orderDate(m_sDate);
            // is it existing or new data file.
            // get a customer name
            m_view.ShowString("Enter  Customer Name");
            order.setM_CustomerName(m_view.GetString());

            // get a state - refactor into private method
            {
                //State;                
                BigDecimal tr = new BigDecimal(-1);
                BigDecimal invalidnum = new BigDecimal(-1);

                String stateInput = "";
                //prompt user to change state 
                do {
                    m_view.ShowString(m_service.getTaxesInfoList());
                    m_view.ShowString("Enter  State Abbreviation");
                    stateInput = m_view.GetString();
                    tr = m_service.getM_TaxRate(stateInput);
                    //check state for -1 (if we can find one) tax rate..
                } while (tr.equals(invalidnum));
                order.setM_State(stateInput);
                order.setM_TaxRate(tr);
            }
            // get a prod type - refactor into private method
            {
                BigDecimal tr = new BigDecimal(-1);
                BigDecimal invalidnum = new BigDecimal(-1);

                String prodTyper = "";
                //prompt user to change type 
                do {
                    m_view.ShowString(m_service.getProductsInfoList());
                    m_view.ShowString("Please Enter the product type");
                    prodTyper = m_view.GetString();
                    tr = m_service.getCostPerSquareFoot(prodTyper);
                    //check for -1 (if we can find one) product type cost per sq ft 
                } while (tr.equals(invalidnum));
                order.setM_ProductType(prodTyper);
                order.setM_CostPerSquareFoot(tr);
                order.setM_LaborCostPerSquareFoot(m_service.getLaborCostPerSquareFoot(prodTyper));
            }
            // get an area - refactor into private method
            {
                  //m_view.ShowString("Enter Updated Area");
                                     //getbigdecimal 
                    order.setM_Area(m_view.GetBigDecimal());
                                          
             }
            // generate order # - refactor into private method
            order.setM_OrderNumber(-1); // fix when saving in DAO
            // do calcs - refactor into private method
                 order = doCalculations( order);
                    
                    // SHOW THE ORDER
                    m_view.ShowString(order.Show());
                    // ASK TO KEEP
                    m_view.ShowString("Do you want complete the Order?(YES/No)");
                    completeOrder= m_view.GetString();
                    if(completeOrder.equalsIgnoreCase("YES"))
                    {
                    m_service.AddOrderDTO(order);
                    String mylist = m_service.Display();
                    m_view.ShowString(mylist);
                    }
    
    }

    private void Edit() {
        m_sDate = m_view.GetDisplay();
        String mylist = m_service.Display(m_sDate);
        m_view.ShowString(mylist);
        if (mylist.length() > 30) {
            Integer choice = m_view.GetOrderInteger();
            OrderDTO edited = m_service.Edit(choice);
            if (edited.getM_OrderNumber() == -1) {
                //invalid choice 
                m_view.ShowString("Order not found.");
            } else {
                editOrderDTO(edited);
            }
        }
    }
private void editOrderDTO(OrderDTO order){
int choice =0;
    do {
            String currOrder="";
            // service layer stuff
            currOrder=m_service.DisplayOrder(order);
            m_view.ShowString(currOrder);
            m_view.GetEditChoice(); 
            choice = m_view.GetSelection();
            switch (choice) {
                case 1:
                    //Customer Name();
                    m_view.ShowString("Enter Updated Customer Name");
                    order.setM_CustomerName (m_view.GetString());
                    break;
                case 2:
                {
                    //State;                
                   BigDecimal tr = new BigDecimal(-1); 
                   BigDecimal invalidnum= new BigDecimal(-1);

                   String stateInput="";
                   //prompt user to change state 
                   do{
                    m_view.ShowString(m_service.getTaxesInfoList());
                    m_view.ShowString("Enter Updated State Abbreviation");
                    stateInput = m_view.GetString(); 
                    tr=m_service.getM_TaxRate(stateInput);
                    //check state for -1 (if we can find one) tax rate..
                    }while(tr.equals(invalidnum));
                    order.setM_State(stateInput);
                    order.setM_TaxRate(tr);
                    order=doCalculations(order); 
                    
                    // will change your tax rate 
                    //call state 
            }
                    break;
                case 3:
                    //Product Type();
                    
                                {
                   BigDecimal tr = new BigDecimal(-1); 
                   BigDecimal invalidnum= new BigDecimal(-1);

                   String prodTyper="";
                   //prompt user to change type 
                   do{
                        m_view.ShowString(m_service.getProductsInfoList());
                        m_view.ShowString("Please Enter the product type");
                        prodTyper = m_view.GetString(); 
                        tr=m_service.getCostPerSquareFoot(prodTyper);
                        //check for -1 (if we can find one) product type cost per sq ft 
                    }while(tr.equals(invalidnum));
                    order.setM_ProductType(prodTyper);
                    order.setM_CostPerSquareFoot(tr);
                    order.setM_LaborCostPerSquareFoot(m_service.getLaborCostPerSquareFoot(prodTyper));
                    order=doCalculations(order); 
                   }
                break;
                case 4:
                {
                    //Area
                    //getbigdecimal 
                    order.setM_Area(m_view.GetBigDecimal());
                    //recaluclations - cost - tax 
                    order=doCalculations(order); 
                }
                    break;
                case 5:
                    //Save
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
        m_sDate = m_view.GetDisplay();
        String list = m_service.Display(m_sDate);
        m_view.ShowString(list);
        if (list.length() > 30) {
            m_view.ShowString("Enter number to remove");
            String choice = m_view.GetString();
            String result = m_service.Remove(choice);
            m_view.ShowString(result);
        }
    }

    private BigDecimal BigDecimal(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void ExampleAddWorkflow(){
        OrderDTO order = new OrderDTO();
        //Get Date / Set Property
        GetDate();
        //Get Name
        
        //Get Product
        
        //Get State
        
        //Get Area
        
        //Calculate
        
        //Confirm With User
        
        //Save To File
    }
    
    private void GetDate(){
        //Asks User For Date
        //Confirms Is valid Date
        //Returns if so - else repeat
    }
}
