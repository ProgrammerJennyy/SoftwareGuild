/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jtt.flooringmastery.view;

import java.math.BigDecimal;

/**
 *
 * @author Jenny
 */
public interface UserIO {
 
    public int GetInput();
    public boolean ValidateInput();
    public String GetString();
    public int GetOrderNumber(); 
    public BigDecimal GetBigDecimal(); 
}
