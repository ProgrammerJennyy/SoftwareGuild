/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jtt.flooringmastery.dao;

import com.jtt.flooringmastery.dto.OrderDTO;
import com.jtt.flooringmastery.dto.TaxesDTO;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jenny
 */
public class OrderDAO {
    private ArrayList<OrderDTO> m_list;
    private String m_Orders=""; 
    
  public OrderDAO() {
        m_list = new ArrayList<OrderDTO>();
    }   
  
   public void LoadFile(String filename, String delimeter) {
        try {
            File myfile = new File(filename);
            Scanner readFile = new Scanner(myfile);
            int counter = 0;
            while (readFile.hasNextLine()) {
                OrderDTO data = new OrderDTO();
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
                 m_Orders += temp[0] + " \t" + temp[1] + " \t" + temp[2] 
                         + " \t" + temp[3]   + " \t" + temp[4] + " \t" + temp[5]
                         + " \t" + temp[6]   + " \t" + temp[7] + " \t" + temp[8]
                         + " \t" + temp[9]   + " \t" + temp[10] + " \t" + temp[11]
                         + "\n";
                counter = counter + 1;
            }
            readFile.close();
        } // end try // end try
        catch (Exception x) {

        }
    }   // end load 
  
     public String getOrderInfo() {
        return this.m_Orders;
    }   
    
}
