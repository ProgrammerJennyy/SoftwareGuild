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
        
    }
    public void Add(){
        
    }
    public void Edit(){
        
    }
    public void Remove()
    {
        
    } 
    
}
