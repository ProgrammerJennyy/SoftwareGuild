/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jtt.flooringmastery.service;

import com.jtt.flooringmastery.dao.OrderDAO;
import com.jtt.flooringmastery.dao.ProductDAO;
import com.jtt.flooringmastery.dao.TaxesDAO;

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
    public String Display(String val)
    {
        String filenameprod="Orders\\Orders_"+val+".txt";
        this.m_order.LoadFile(filenameprod, ",");
        String list=m_order.getOrderInfo();
        if(list.length()<5){
            list="Date Contains no orders.";
        }
        return list;
    }
    public void Add(){
        
    }
    public void Edit(){
        
    }
    public String Remove(String choice)
    {
        return m_order.Remove(choice);
    } 
    public void Initialize()
    {
    
        String filenameprod="Data\\Products.txt";
        this.m_prod.LoadFile(filenameprod, ",");
        String filenametaxes="Data\\Taxes.txt";
        this.m_taxes.LoadFile(filenametaxes, ",");
    }
}
