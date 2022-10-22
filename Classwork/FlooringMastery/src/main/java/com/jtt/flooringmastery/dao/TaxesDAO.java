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

    public TaxesDAO() {
        m_list = new ArrayList<TaxesDTO>();
    }

    public void LoadFile(String filename, String delimeter) {
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
                    m_Taxes += counter + ": ";
                }
                m_Taxes += temp[0] + " \t" + temp[1] + " \t" + temp[2] + "\n";
                counter = counter + 1;
            }
            readFile.close();
        } // end try // end try
        catch (Exception x) {

        }
    }   // end load

    public String getTaxesInfo() {
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

}
