/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jtt.flooringmastery.service;

import com.jtt.flooringmastery.dao.OrderDAO;
import com.jtt.flooringmastery.dao.ProductDAO;
import com.jtt.flooringmastery.dao.TaxesDAO;
import com.jtt.flooringmastery.dto.OrderDTO;

/**
 *
 * @author Jenny
 */
public interface Service {
   public String Display(String val);
    public void Add();
        
    public OrderDTO Edit(Integer choice);
    
    public String Remove(String choice);    
}
