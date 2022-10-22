/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jenny
 */
import java.util.Scanner;

public class UserIO {

    public UserIO(){
        m_scanner = new Scanner(System.in);
    }
    public String getAString(){
        String choice="x";
        boolean goodChoice=false;
        do {
            choice=m_scanner.nextLine();
            if(choice.length()>1 )
            {
                goodChoice = true;
            }

        }while (goodChoice==false);
        return choice;
    }
    public String getChoice(){
        String choice="x";
        boolean goodChoice=false;
        do {
            choice=m_scanner.nextLine();
            if(choice.length()==1 && (
                    choice.equals("A")
                    || choice.equals( "R")
                    || choice.equals( "E")
                    || choice.equals( "L")
                    || choice.equals( "D")
                    || choice.equals( "S")
                    || choice.equals( "O")
                    || choice.equals( "V")
                    || choice.equals( "X")
                    ))
            {
                goodChoice = true;
            }

        }while (goodChoice==false);
        return choice;
    }
    public String getEditChoice(){
        String choice="x";
        boolean goodChoice=false;
        do {
            choice=m_scanner.nextLine();
            if(choice.length()==1 && (
                            choice.equals( "M")
                            || choice.equals( "R")
                            || choice.equals( "P")
                            || choice.equals( "N")
                            || choice.equals( "S")
                            || choice.equals( "U")
                            || choice.equals( "X")
            ))
            {
                goodChoice = true;
            }

        }while (goodChoice==false);
        return choice;
    }

  private Scanner m_scanner;
}
