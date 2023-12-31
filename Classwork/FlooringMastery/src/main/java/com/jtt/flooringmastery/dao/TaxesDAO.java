/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jtt.flooringmastery.dao;

import com.jtt.flooringmastery.dto.TaxesDTO;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jenny
 */
public class TaxesDAO {

    private ArrayList<TaxesDTO> m_list;
    private String m_Taxes="";
    private String filename="";
    public TaxesDAO() {
        m_list = new ArrayList<TaxesDTO>();
        filename="Data\\Taxes.txt";
        LoadFile(",");
    }
    private void LoadFile( String delimeter) {
        try {
            File myfile = new File(filename);
            Scanner readFile = new Scanner(myfile);
            int counter = 0;
            while (readFile.hasNextLine()) {
                TaxesDTO data = new TaxesDTO();
                String row;
                row = readFile.nextLine();
                String temp[] = row.split(delimeter);
                if (counter > 0) { // Dont add header to listarray

                    data.setM_StateAbbreviation(temp[0]);
                    data.setM_StateName(temp[1]);
                    BigDecimal rate = new BigDecimal(temp[2]);
                    data.setM_TaxRate(rate);
                    m_list.add(data);
                   // m_Taxes += counter + ": ";
                }
               String format="%15s  %15s  %15s\n";
               m_Taxes += String.format(format,temp[0],temp[1],temp[2]);
                counter = counter + 1;
                
                
                
            }
            readFile.close();
        } // end try // end try
        catch (Exception x) {

        }
    }   // end load

    public String getTaxesInfoList() {
        return m_Taxes;
    }

    public BigDecimal getM_TaxRate(int item) {
        BigDecimal retval = new BigDecimal(-1.0);
        if (item > m_list.size()) {
            TaxesDTO temp = m_list.get(item - 1);
            retval = temp.getM_TaxRate();
        }
        return retval;
    }
    
    public BigDecimal getM_TaxRate(String item) {
        BigDecimal retval = new BigDecimal(-1.0);
        for (int i = 0; i < m_list.size(); i++) {
            TaxesDTO temp = m_list.get(i);
            if (item.compareTo(temp.getM_StateAbbreviation()) == 0) {
                retval = temp.getM_TaxRate();
            }
        }
        return retval;
    }

}
