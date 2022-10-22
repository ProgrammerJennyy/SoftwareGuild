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
public class OrderDTO {
private Integer m_OrderNumber;
private String m_CustomerName;
private String m_State;
private BigDecimal m_TaxRate;
private String m_ProductType;
private BigDecimal m_Area;
private BigDecimal m_CostPerSquareFoot;
private BigDecimal m_LaborCostPerSquareFoot;
private BigDecimal m_MaterialCost;
private BigDecimal m_LaborCost;
private BigDecimal m_Tax;
private BigDecimal m_Total;

    public Integer getM_OrderNumber() {
        return m_OrderNumber;
    }

    public void setM_OrderNumber(Integer m_OrderNumber) {
        this.m_OrderNumber = m_OrderNumber;
    }

    public String getM_CustomerName() {
        return m_CustomerName;
    }

    public void setM_CustomerName(String m_CustomerName) {
        this.m_CustomerName = m_CustomerName;
    }

    public String getM_State() {
        return m_State;
    }

    public void setM_State(String m_State) {
        this.m_State = m_State;
    }

    public BigDecimal getM_TaxRate() {
        return m_TaxRate;
    }

    public void setM_TaxRate(BigDecimal m_TaxRate) {
        this.m_TaxRate = m_TaxRate;
    }

    public String getM_ProductType() {
        return m_ProductType;
    }

    public void setM_ProductType(String m_ProductType) {
        this.m_ProductType = m_ProductType;
    }

    public BigDecimal getM_Area() {
        return m_Area;
    }

    public void setM_Area(BigDecimal m_Area) {
        this.m_Area = m_Area;
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

    public BigDecimal getM_MaterialCost() {
        return m_MaterialCost;
    }

    public void setM_MaterialCost(BigDecimal m_MaterialCost) {
        this.m_MaterialCost = m_MaterialCost;
    }

    public BigDecimal getM_LaborCost() {
        return m_LaborCost;
    }

    public void setM_LaborCost(BigDecimal m_LaborCost) {
        this.m_LaborCost = m_LaborCost;
    }

    public BigDecimal getM_Tax() {
        return m_Tax;
    }

    public void setM_Tax(BigDecimal m_Tax) {
        this.m_Tax = m_Tax;
    }

    public BigDecimal getM_Total() {
        return m_Total;
    }

    public void setM_Total(BigDecimal m_Total) {
        this.m_Total = m_Total;
    }

}
