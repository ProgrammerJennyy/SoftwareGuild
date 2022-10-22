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
      private OrderDAO m_order;
      private ProductDAO m_prod;
      private TaxesDAO  m_taxes;
      public ServiceImpl(OrderDAO order, ProductDAO prod, TaxesDAO taxes)
      {
          this.m_order=order;
          this.m_prod=prod;
          this.m_taxes=taxes;
      }
    public void Display()
    {
        String filenameprod="Orders\\Orders_06022013.txt";
        this.m_order.LoadFile(filenameprod, ",");
        
    }
    public void Add(){
        
    }
    public void Edit(){
        
    }
    public void Remove()
    {
        
    } 
    public void Initialize()
    {
        String filenameorder="Orders\\Orders_06022013.txt";
        this.m_order.LoadFile(filenameorder, ",");        
        String filenameprod="Data\\Products.txt";
        this.m_prod.LoadFile(filenameprod, ",");
        String filenametaxes="Data\\Taxes.txt";
        this.m_taxes.LoadFile(filenametaxes, ",");
    }
}
