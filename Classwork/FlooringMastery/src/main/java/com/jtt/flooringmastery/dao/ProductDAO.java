/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jtt.flooringmastery.dao;

import com.jtt.flooringmastery.dto.ProductDTO;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jenny
 */
public class ProductDAO {

    private ArrayList<ProductDTO> m_list;
    private String m_Products="";
    private String filename = "";
    
    //How do I get all of them from the DAO?

    public ProductDAO() {
        m_list = new ArrayList<ProductDTO>();
        filename="Data\\Products.txt";
        //Load File Here
        LoadFile(",");
    }
    
    //Does not need to be part of the interface because it is ONLY part of an implementation
    private void LoadFile( String delimeter) {
        try {
            File myfile = new File(filename);
            Scanner readFile = new Scanner(myfile);
            int counter = 0;
            while (readFile.hasNextLine()) {
                ProductDTO data = new ProductDTO();
                String row;
                row = readFile.nextLine();
                String temp[] = row.split(delimeter);
                //Use Loop Here
                if (counter > 0) { // Dont add header to listarray
                    data.setM_ProductType(temp[0]);
                    BigDecimal num = new BigDecimal(temp[1]);
                    data.setM_CostPerSquareFoot(num);
                    BigDecimal labor = new BigDecimal(temp[2]);
                    data.setM_LaborCostPerSquareFoot(labor);
                    m_list.add(data);
                    m_Products += counter + ": ";
                }
                m_Products += temp[0] + " \t" + temp[1] + " \t" + temp[2] + "\n";
                counter = counter + 1;
            }
            readFile.close();
        } // end try // end try
        catch (Exception x) {
            System.out.println("caught exception in productdto fileload ");
        }
    }   // end load
    
    //How does it know which one to get?
    // its all items with returns in 1 string
    public String getProductInfo() {
        return m_Products;
    }
    
    //Need Only 1 To Get a Single One
    public BigDecimal getCostPerSquareFoot(int item) {
        BigDecimal retval = new BigDecimal(-1.0);
        if (item > m_list.size()) {
            ProductDTO temp = m_list.get(item - 1);
            retval = temp.getM_CostPerSquareFoot();
        }
        return retval;
    }

    public BigDecimal getLaborCostPerSquareFoot(int item) {
        BigDecimal retval = new BigDecimal(-1.0);
        if (item > m_list.size()) {
            ProductDTO temp = m_list.get(item - 1);
            retval = temp.getM_LaborCostPerSquareFoot();
        }
        return retval;
    }

} // end class

