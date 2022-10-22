/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jenny
 */
import java.util.ArrayList;



public class View {
    public View()
    {
        m_userio = new UserIO();
    }
    public void Display(DVD dvd)
    {
        System.out.println("Movie Title:"+dvd.getTitle());
        System.out.println("Enter Release Date:"+ dvd.getReleaseDate());
        System.out.println("Enter MPAA Rating:"+ dvd.getMPAARating());
        System.out.println("Enter Directors Name:"+ dvd.getDirector());
        System.out.println("Enter Studio:"+ dvd.getStudio());
        System.out.println("Enter User Comments:"+dvd.getUserRatingorNote());
    }
    public DVD Add()
    {
        DVD temp = new DVD();
        String OK="";
        do {
            System.out.print("Enter Movie Title:");
            temp.setTitle(m_userio.getAString());
            System.out.print("Enter Release Date:");
            temp.setReleaseDate(m_userio.getAString());
            System.out.print("Enter MPAA Rating:");
            temp.setMPAARating(m_userio.getAString());
            System.out.print("Enter Directors Name:");
            temp.setDirector(m_userio.getAString());
            System.out.print("Enter Studio:");
            temp.setStudio(m_userio.getAString());
            System.out.print("Enter User Comments:");
            temp.setUserRatingorNote(m_userio.getAString());
            System.out.print("User input OK (Yes/No):");
            OK=m_userio.getAString();
        }while(!OK.equals("Yes"));
        return temp;
    }
    public void List(ArrayList<String> mylist)
    {
        System.out.println("DVD Title List");
        for (int i=0; i < mylist.size();i++)
        {
            System.out.println(i+ ") "+ mylist.get(i));
        }
    }
     public String Load()
    {
        String temp="";
        System.out.print("Enter filename to load:");
        temp=m_userio.getAString();
        return temp;
    }
    public String UserQuestion(String question)
    {
        String temp="";
        System.out.print(question);
        temp=m_userio.getAString();
        return temp;
    }
    public String Save()
    {
        String temp="";
        System.out.print("Enter filename to save:");
        temp=m_userio.getAString();
        return temp;
    }

    public String Remove()
    {
        String temp="";
        System.out.print("Enter movie title to remove:");
        temp=m_userio.getAString();
        return temp;
    }
    public String ShowMainMenu()
    {
        System.out.println("A) Add a DVD to Library");
        System.out.println("R) Remove a DVD from Library");
        System.out.println("E) Edit a DVD in Library");
        System.out.println("L) List DVDs in Library");
        System.out.println("D) Display a DVD in Library");
        System.out.println("S) Search a DVD by title");
        System.out.println("O) Load a DVD Library file");
        System.out.println("V) saVe a DVD  Library file");
        System.out.println("X) Exit Program");
        System.out.print("Please Enter Choice:");
        return m_userio.getChoice();

    }
    public DVD Edit(DVD dvd)
    {
        String choice="";
        DVD edited=dvd;
        do {
            System.out.println("M) Movie Title:" + edited.getTitle());
            System.out.println("R) Release Date:" + edited.getReleaseDate());
            System.out.println("P) MPAA Rating:" + edited.getMPAARating());
            System.out.println("N) Directors Name:" + edited.getDirector());
            System.out.println("S) Studio:" + edited.getStudio());
            System.out.println("U) User Comments:" + edited.getUserRatingorNote());
            System.out.println("X) Done Editing");
            choice= m_userio.getEditChoice();
            char userChoice=choice.charAt(0);
            switch(userChoice)
            {
                case 'M':
                    edited.setTitle(UserQuestion("Update Movie Title:"));
                    break;
                case'R':
                    edited.setReleaseDate(UserQuestion("Update Release Date:"));
                    break;
                case 'P':
                    edited.setMPAARating(UserQuestion("Update MPAA Rating:"));
                    break;
                case 'N':
                    edited.setDirector(UserQuestion("Update Director Name:"));
                    break;
                case 'S':
                    edited.setStudio(UserQuestion("Update Studio:"));
                    break;
                case'U':
                    edited.setUserRatingorNote(UserQuestion("Update User Notes:"));
                    break;
                default:
            }
        }while(!choice.equals("X"));
        return edited;
    }
    private UserIO m_userio;

}
