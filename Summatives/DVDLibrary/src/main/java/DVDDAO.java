/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jenny
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;  // Import the File class
import java.io.File;
import java.util.Scanner;
import java.io.IOException;  // Import the IOException class to handle errors

public class DVDDao {
    DVDDao()
    {
        m_hashMap = new HashMap<String,DVD>();
        m_filename="";
        m_fieldDelimiter="::";
    }
    public void Add(DVD movie)
    {
        m_hashMap.put(movie.getTitle(),movie);
    }

    public void Remove(String title)
    {
        m_hashMap.remove(title);
    }
    public DVD Search(String title)
    {
       DVD temp= m_hashMap.get(title);
       return temp;
    }
    public void Load(String filename)
    {
        try {
            File myfile = new File(filename);
            Scanner readFile = new Scanner(myfile);
            m_hashMap.clear();
            while (readFile.hasNextLine())
            {
                DVD data = new DVD();
                String row;
                row = readFile.nextLine();
                String temp[] = row.split(m_fieldDelimiter);
                data.setTitle(temp[0]);
                data.setReleaseDate(temp[1]);
                data.setDirector(temp[2]);
                data.setMPAARating(temp[3]);
                data.setStudio(temp[4]);
                data.setUserRatingorNote(temp[5]);
                m_hashMap.put(data.getTitle(),data);
            }
            readFile.close();
        } // end try
        catch(Exception x)
        {

        }
    }

    public void Save(String filename)
    {
        try {
            FileWriter mywriter = new FileWriter(filename);
                for (Map.Entry<String, DVD> library : m_hashMap.entrySet()) {
                    DVD data;
                    String row;
                    data = library.getValue();
                    row = data.getTitle() + m_fieldDelimiter
                            + data.getReleaseDate() + m_fieldDelimiter
                            + data.getDirector() + m_fieldDelimiter
                            + data.getMPAARating() + m_fieldDelimiter
                            + data.getStudio() + m_fieldDelimiter
                            + data.getUserRatingorNote()+ m_fieldDelimiter
                            + "\n";
                    mywriter.write(row);
                }
            mywriter.close();
        } // end try
        catch(Exception x)
        {

        }
    }


    public ArrayList<String> List()
    {
        ArrayList<String> retval = new ArrayList<String>();

        for(String i :m_hashMap.keySet())
        {
            retval.add(i);
        }
        return retval;
    }

    private HashMap<String,DVD> m_hashMap;
    private String m_filename;
    private String m_fieldDelimiter;
} // end DVDDao class.
