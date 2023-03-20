package com.jtt.bullsandcows.service;


import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class bullandcowService {

    public String GetTime()
    {
        String ts = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
        return ts;
    }

    public String CreateSecret()
    {
        Random rnd = new Random();
        String retVal="";
        int index=0;
        ArrayList<Integer> values= new ArrayList<Integer>();
        for(int i=0;i<10;i++) values.add(i);
        index=rnd.nextInt(9);
        retVal= String.valueOf(values.get(index));
        values.remove(index);
        index=rnd.nextInt(8);
        retVal+= String.valueOf(values.get(index));
        values.remove(index);
        index=rnd.nextInt(7);
        retVal+= String.valueOf(values.get(index));
        values.remove(index);
        index=rnd.nextInt(6);
        retVal+= String.valueOf(values.get(index));
        values.remove(index);
        return retVal;
    }
    public String CheckGuess(String Secret,String Guess)
    {
        int p=0;
        int e=0;
        String retVal="";
        if(Guess.length() !=4)
        {
            retVal="Not Checked Invalid Length.";
            return retVal;
        }
        for (int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                if(Secret.charAt(i)==Guess.charAt(j))
                {
                    if(i==j)
                        e++;
                    else
                        p++;
                } // end match
            }// end j
        } // end i
        retVal="e:"+e+":p:"+p;
        return retVal;
    }
}
