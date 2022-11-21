/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jtt.flooringmastery.dao;

import com.jtt.flooringmastery.dto.OrderDTO;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jenny
 */
//OrderDAOFileImpl
//OrderDAOStubImpl (mock)
//OrderDAO - should be interface
public class OrderDAO {
/** 
 * Define interface for OrderDAO and ProductDao for all 3 interfaces 
 */
    private ArrayList<OrderDTO> m_list;
    private String m_Orders = "";
    private String m_Filename = ""; //Put the File Base Name Here

    //How do I update here?
    //How do I get a specific one?
    //How do I add one? (need the date)
    public OrderDAO() {
        m_list = new ArrayList<OrderDTO>();
    }

    public String Remove(String choice) {
        String result = "Order " + choice + " was not found";
        String thedate = "";
        try {
            int ichoice = Integer.parseInt(choice);
            for (int i = 0; i < m_list.size(); i++) {
                OrderDTO data = m_list.get(i);
                if (ichoice == data.getM_OrderNumber()) {
                    thedate=data.getM_orderDate();
                    m_list.remove(i);
                    result="Order removed\n";
                    RebuildDailyOrdersList();
                    result+=m_Orders;
                    // call save here
                    SaveFile(thedate);
                }
            }
        } catch (Exception e) {
            result = "Order " + choice + " was not a valid positive integer";
        }
        return result;
    }
    
     public void AddOrderDTO(OrderDTO val)
     {
         String filenameprod=val.getM_orderDate();
         LoadFile(filenameprod,",");
         m_list.add(val);
         RebuildDailyOrdersList();
         SaveFile(filenameprod);
     }
    

    //Needs to Not be part of the interface and ONLY happen in this class
    public void LoadFile(String filenameDate, String delimeter) {
        try {
            String filename="Orders\\Orders_"+filenameDate+".txt";
             File myfile = new File(filename);
            m_Filename = filename;
            m_list.clear();
            m_Orders = "";
            Scanner readFile = new Scanner(myfile);
            int counter = 0;
            while (readFile.hasNextLine()) {
                OrderDTO data = new OrderDTO();
                data.setM_orderDate(filenameDate);
                String row;
                row = readFile.nextLine();
                String temp[] = row.split(delimeter);
                if (counter > 0) { // Dont add header to listarray

                    data.setM_OrderNumber(Integer.parseInt(temp[0]));
                    data.setM_CustomerName(temp[1]);
                    data.setM_State(temp[2]);
                    BigDecimal taxrate = new BigDecimal(temp[3]);
                    data.setM_TaxRate(taxrate);
                    data.setM_ProductType(temp[4]);
                    BigDecimal area = new BigDecimal(temp[5]);
                    data.setM_Area(area);
                    BigDecimal costsq = new BigDecimal(temp[6]);
                    data.setM_CostPerSquareFoot(costsq);
                    BigDecimal lbrcostsq = new BigDecimal(temp[7]);
                    data.setM_LaborCostPerSquareFoot(lbrcostsq);
                    BigDecimal mcost = new BigDecimal(temp[8]);
                    data.setM_MaterialCost(mcost);
                    BigDecimal lcost = new BigDecimal(temp[9]);
                    data.setM_LaborCost(lcost);
                    BigDecimal tax = new BigDecimal(temp[10]);
                    data.setM_Tax(tax);
                    BigDecimal total = new BigDecimal(temp[11]);
                    data.setM_Total(total);
                    data.setM_Area(area);
                    m_list.add(data);
                }
               String format="%15s  %15s  %15s  %15s  %15s  %15s  %22s  %22s  %22s  %15s  %15s  %15s\n";
               m_Orders += String.format(format,temp[0],temp[1],temp[2],
                         temp[3],temp[4],temp[5],
                        temp[6], temp[7],temp[8]
                        ,temp[9], temp[10], temp[11]);
                counter = counter + 1;
            }
            readFile.close();
        } // end try // end try
        catch (Exception x) {

        }
    }   // end load 

    //Needs to Load Orders/File First
    public String getAllOrdersInfoList() {
        return this.m_Orders;
    }
    public OrderDTO Edit(Integer choice) {

        try {
            int ichoice = choice;
            for (int i = 0; i < m_list.size(); i++) {
                OrderDTO data = m_list.get(i);
                if (ichoice == data.getM_OrderNumber()) {
                    return data;
                }
            }
        } catch (Exception e) {
        }
        OrderDTO notfound = new OrderDTO();
        notfound.setM_OrderNumber(-1);
        return notfound;
    }
    public void SaveFile(String filenameDate) {
        String delimeter=",";
        try {
            String filename="Orders\\Orders_"+filenameDate+".txt";
            FileWriter mywriter = new FileWriter(filename);
          String format="%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n";
          String header = String.format(format,
                       "OrderNumber",
                       "CustomerName",
                       "State", 
                       "TaxRate", 
                       "ProductType", 
                       "Area", 
                       "CostPerSquareFoot",
                       "LaborCostPerSquareFoot",
                       "MaterialCost",
                       "LaborCost",
                       "Tax",
                       "Total"); 
             mywriter.write(header);
       String[] temp= new String[14];
       int LargestOrderNumber=0;
        for (int i = 0; i < m_list.size(); i++) {
            OrderDTO data = m_list.get(i);
            if(data.getM_OrderNumber()>LargestOrderNumber)
            {
                LargestOrderNumber=data.getM_OrderNumber();
            }
            {
                data.setM_OrderNumber(LargestOrderNumber+1);
                LargestOrderNumber++;
                RebuildDailyOrdersList();
            }
            temp[0] = data.getM_OrderNumber().toString();
            temp[1] = data.getM_CustomerName();
            temp[2] = data.getM_State();
            temp[3] = data.getM_TaxRate().toString();
            temp[4] = data.getM_ProductType().toString();
            temp[5] = data.getM_Area().toString();
            temp[6] = data.getM_CostPerSquareFoot().toString();
            temp[7] = data.getM_LaborCostPerSquareFoot().toString();
            temp[8] = data.getM_MaterialCost().toString();
            temp[9] = data.getM_LaborCost().toString();
            temp[10] = data.getM_Tax().toString();
            temp[11] = data.getM_Total().toString();
            
            String oneOrder = String.format(format,
            temp[0],temp[1], temp[2], temp[3], temp[4],temp[5],temp[6],temp[7], temp[8],temp[9],temp[10],temp[11]);        
             mywriter.write(oneOrder);
                
         }
            mywriter.close();
        } // end try
        catch (Exception x) {

        }
    }
    private void RebuildDailyOrdersList() {
        
          String format="%15s  %15s  %15s  %15s  %15s  %15s  %22s  %22s  %22s  %15s  %15s  %15s\n";
               m_Orders = String.format(format,
                       "OrderNumber",
                       "CustomerName",
                       "State", 
                       "TaxRate", 
                       "ProductType", 
                       "Area", 
                       "CostPerSquareFoot",
                       "LaborCostPerSquareFoot",
                       "MaterialCost",
                       "LaborCost",
                       "Tax",
                       "Total"
                       
               );   
                     
        String[] temp= new String[14];
        for (int i = 0; i < m_list.size(); i++) {
            OrderDTO data = m_list.get(i);

            temp[0] = data.getM_OrderNumber().toString();
            temp[1] = data.getM_CustomerName();
            temp[2] = data.getM_State();
            temp[3] = data.getM_TaxRate().toString();
            temp[4] = data.getM_ProductType().toString();
            temp[5] = data.getM_Area().toString();
            temp[6] = data.getM_CostPerSquareFoot().toString();
            temp[7] = data.getM_LaborCostPerSquareFoot().toString();
            temp[8] = data.getM_MaterialCost().toString();
            temp[9] = data.getM_LaborCost().toString();
            temp[10] = data.getM_Tax().toString();
            temp[11] = data.getM_Total().toString();
            
            m_Orders += String.format(format,
            temp[0],temp[1], temp[2], temp[3], temp[4],temp[5],temp[6],temp[7], temp[8],temp[9],temp[10],temp[11]);        
                 
         }
    }
}
