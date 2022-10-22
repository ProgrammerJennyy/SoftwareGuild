/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jenny
 */
public class DVDLibraryController {

    DVDLibraryController(){
        m_view = new View();
        m_dvddao = new DVDDao();
    }

    public void execute()
    {
        char userChoice;
        String choice;
        System.out.println("Welcome to DVD Library");

        do{
            choice=m_view.ShowMainMenu();
           userChoice=choice.charAt(0);
           switch(userChoice)
           {
               case 'X':
                   System.out.println("Exiting Program.");
                   break;
               case 'A':
                   DVD x=m_view.Add();
                   m_dvddao.Add(x);
                   break;
               case 'E':
                   String edit=m_view.UserQuestion("Enter movie to edit:");
                   DVD editdvd= m_dvddao.Search(edit);
                   if(editdvd == null)
                   {
                       System.out.println("Dvd "+ edit+ " not found.");
                   }
                   else {
                       m_dvddao.Remove(edit);
                       editdvd=m_view.Edit(editdvd);
                       m_dvddao.Add(editdvd);
                   }
                   break;
               case 'R':
                   String remove=m_view.Remove();
                   m_dvddao.Remove(remove);
                   break;
               case 'L':
                    m_view.List(m_dvddao.List());
                   break;
               case 'D':
                   String display=m_view.UserQuestion("Enter movie to Display?");
                   DVD displaydvd= m_dvddao.Search(display);
                   if(displaydvd == null)
                   {
                        System.out.println("Dvd "+ display+ " not found.");
                   }
                   else {
                       m_view.Display(displaydvd);
                   }
                   break;
               case 'O':
                   String load = m_view.Load();
                   m_dvddao.Load(load);
                   break;
               case 'V':
                   String save = m_view.Save();
                   m_dvddao.Save(save);
                   break;
               case 'S':
                   String search=m_view.UserQuestion("Enter movie to search for:");
                   DVD Searchdvd= m_dvddao.Search(search);
                   if(Searchdvd == null)
                   {
                       System.out.println("Title "+ search+ " not found.");
                   }
                   else {
                       System.out.println("Title "+ search+ "  found.");
                   }
                   break;
               default:
           };

        }while(userChoice !='X');

    } // end main
    private View m_view;
    private DVDDao m_dvddao;


}
