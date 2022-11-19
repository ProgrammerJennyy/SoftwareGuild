/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
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
public interface Service {
   public String Display(String val);
   public String Display(); 
    public void Add();
    public void AddOrderDTO(OrderDTO val); 
    public OrderDTO Edit(Integer choice);
      public BigDecimal getM_TaxRate(String item);
      public String getTaxesInfoList();
          public String getProductsInfoList();
               public BigDecimal getCostPerSquareFoot(String item);
               public BigDecimal getLaborCostPerSquareFoot(String item);



    public String Remove(String choice);    
}
