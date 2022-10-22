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
public class TaxesDTO {
private String m_StateAbbreviation;
private String m_StateName;
private BigDecimal m_TaxRate ; 

    public String getM_StateAbbreviation() {
        return m_StateAbbreviation;
    }

    public void setM_StateAbbreviation(String m_StateAbbreviation) {
        this.m_StateAbbreviation = m_StateAbbreviation;
    }

    public String getM_StateName() {
        return m_StateName;
    }

    public void setM_StateName(String m_StateName) {
        this.m_StateName = m_StateName;
    }

    public BigDecimal getM_TaxRate() {
        return m_TaxRate;
    }

    public void setM_TaxRate(BigDecimal m_TaxRate) {
        this.m_TaxRate = m_TaxRate;
    }


}
