/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jtt.flooringmastery.service;

import com.jtt.flooringmastery.dao.OrderDAO;
import com.jtt.flooringmastery.dao.ProductDAO;
import com.jtt.flooringmastery.dao.TaxesDAO;
import com.jtt.flooringmastery.dto.OrderDTO;
import java.math.BigDecimal;

/**
 *
 * @author Jenny
 */
public class ServiceImpl implements Service {
    
      //Order CreateFlooringOrder(Order currentOrder)
      //Order UpdateFlooringOrder (Order updatedOrder , Datetime orderDate) 
      //void DeleteFlooringOrder (int(or string) orderId, Datetime orderDate)
      //Order ReadFlooringOrderByIdAndDate (int (or string) orderId, Datetme orderDate)
      //List<Order> ReadFlooringOrdersByDate (Datetime orderDate) 
      
      //What CRUD do i need with Products?
      //What CRUD do I need with Taxes?
    
      //How do I calcuate the totals
    
      //What happens if it returns no Order/Orders (or Product and Taxes)
    
      //Only TALKS to the DAO (does not do the DAO work for it - the DAO loads things itself)
    
      private OrderDAO m_order;
      private ProductDAO m_prod;
      private TaxesDAO  m_taxes;
      public ServiceImpl(OrderDAO order, ProductDAO prod, TaxesDAO taxes)
      {
          this.m_order=order;
          this.m_prod=prod;
          this.m_taxes=taxes;
      }
      
    public String DisplayOrder(OrderDTO data)
    {
          String retVal="";
          String format="%15s  %15s  %15s  %15s  %15s  %15s  %22s  %22s  %22s  %15s  %15s  %15s\n";
               retVal = String.format(format,
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
            
            retVal += String.format(format,
            temp[0],temp[1], temp[2], temp[3], temp[4],temp[5],temp[6],temp[7], temp[8],temp[9],temp[10],temp[11]);        
          return retVal;
    }
    public String Display(String val)
    {
        this.m_order.LoadFile(val, ",");
        String list=m_order.getAllOrdersInfoList();
        if(list.length()<5){
            list="Date Contains no orders.";
        }
        return list;
    }
  public String Display()
    {
        String list=m_order.getAllOrdersInfoList();
        if(list.length()<5){
            list="Date Contains no orders.";
        }
        return list;
    }
          public String getProductsInfoList()
          {
              return m_prod.getProductsInfoList();
          }
               public BigDecimal getCostPerSquareFoot(String item)
               {
                   return m_prod.getCostPerSquareFoot(item);
               }
               public BigDecimal getLaborCostPerSquareFoot(String item)
               {
                   return m_prod.getLaborCostPerSquareFoot(item);
               }
 public String getTaxesInfoList()
 {
     return m_taxes.getTaxesInfoList();
 }
    public BigDecimal getM_TaxRate(String item)
    {
        return m_taxes.getM_TaxRate(item);
    }



     public void AddOrderDTO(OrderDTO val){
         
         m_order.AddOrderDTO(val);
         
     }
    
    
    
    public OrderDTO Edit(Integer choice){
     return m_order.Edit(choice); 
        
        
    }
    public String Remove(String choice)
    {
        return m_order.Remove(choice);
    } 

}
