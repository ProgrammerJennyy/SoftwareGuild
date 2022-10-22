/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jtt.flooringmastery.dto;

import java.math.BigDecimal;

/**
 *
 * @author Jenny
 */
public class ProductDTO {
private String m_ProductType;
private BigDecimal m_CostPerSquareFoot;
private BigDecimal m_LaborCostPerSquareFoot;

    public String getM_ProductType() {
        return m_ProductType;
    }

    public void setM_ProductType(String m_ProductType) {
        this.m_ProductType = m_ProductType;
    }

    public BigDecimal getM_CostPerSquareFoot() {
        return m_CostPerSquareFoot;
    }

    public void setM_CostPerSquareFoot(BigDecimal m_CostPerSquareFoot) {
        this.m_CostPerSquareFoot = m_CostPerSquareFoot;
    }

    public BigDecimal getM_LaborCostPerSquareFoot() {
        return m_LaborCostPerSquareFoot;
    }

    public void setM_LaborCostPerSquareFoot(BigDecimal m_LaborCostPerSquareFoot) {
        this.m_LaborCostPerSquareFoot = m_LaborCostPerSquareFoot;
    }

}
