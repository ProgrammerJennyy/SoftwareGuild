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
        // m_service.Add();
        OrderDTO order = new OrderDTO();
        String completeOrder="Np";
            // get date in future
            m_sDate = m_view.GetDisplay();
            // is it existing or new data file.
            // get a customer name
            m_view.ShowString("Enter  Customer Name");
            order.setM_CustomerName(m_view.GetString());

            // get a state
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
            // get a prod type
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
            // get an area
            {
                  //m_view.ShowString("Enter Updated Area");
                                     //getbigdecimal 
                    order.setM_Area(m_view.GetBigDecimal());
                                          
             }
            // generate order #
            order.setM_OrderNumber(33);
            // do calcs
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
                    
                                }
                break;
                case 4:
                {
                    //Area
                   
                    //getbigdecimal 
                    order.setM_Area(m_view.GetBigDecimal());
                                                                        
                    
                    //recaluclations - cost - tax 
                                                                   
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
                                                        
                    //Tax rates are stored as whole numbers
                    

                    //Total = (MaterialCost + LaborCost + Tax)
                    BigDecimal temptotal = new BigDecimal(0); 
                    temptotal = order.getM_MaterialCost().add(order.getM_LaborCost()); 
                    temptotal = temptotal.add(order.getM_Tax()); 
                    order.setM_Total(temptotal);  
                    
                                     
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
        String list = m_service.Display(m_sDate);
        m_view.ShowString(list);
        m_view.ShowString("Enter number to remove");
        String choice = m_view.GetString();
        String result = m_service.Remove(choice);
        m_view.ShowString(result);
    }

    private BigDecimal BigDecimal(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
