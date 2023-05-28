/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package sg.jst.nb_superhero;

import sg.jst.nb_superhero.DAO.SuperHeroDAOImp;
import sg.jst.nb_superhero.DTO.SuperHeroDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jenny
 */

@SpringBootApplication
//@SpringBootApplication(scanBasePackages="cg.jst.nb_superhero.NB_SuperHero")
public class NB_SuperHero  implements CommandLineRunner{

    @Autowired
    public JdbcTemplate jdbc;
    
    public static void main(String args[]) {
        System.out.println("Hello World!");
        //SpringApplication.run(NB_SuperHero.class, args);
        SpringApplication app = new SpringApplication(NB_SuperHero.class);
	app.run(args);         
    }
    
    
    public void TestTheSuperHeroTable()
    {
             System.out.println("Calling DAO");
            SuperHeroDAOImp shdao = new SuperHeroDAOImp(jdbc);
            List<SuperHeroDTO> retvals=shdao.ReadAll();
            
            for(SuperHeroDTO i: retvals)
            {
                System.out.println("Listing SuperHeros");
                System.out.println(i.getName());
                System.out.println(i.getSuperHeroId());
                System.out.println(i.getSuperPower());
                System.out.println(i.getDescription());
                
            }
            SuperHeroDTO test = new SuperHeroDTO();
            test.setName("Jenny");
            test.setSuperPower("Coffee");
            test.setDescription("SomeDescription");
            test=shdao.CreateSuperHero(test);
            {
                SuperHeroDTO i=test;
                System.out.println("Create SuperHeros");
                System.out.println(i.getName());
                System.out.println(i.getSuperHeroId());
                System.out.println(i.getSuperPower());
                System.out.println(i.getDescription());
             }  
            test.setDescription("SomeChange");
            shdao.UpdateSuperHero(test);
            test=shdao.GetSuperHeroById(test.getSuperHeroId());
            {
                SuperHeroDTO i=test;
                System.out.println("update SuperHeros");
                System.out.println(i.getName());
                System.out.println(i.getSuperHeroId());
                System.out.println(i.getSuperPower());
                System.out.println(i.getDescription());
             } 
            shdao.DeleteSuperHero(test);
            System.out.println("deleted SuperHeros");
   }
    
    
    @Override
    public void run(String... args) throws Exception {
           // TestTheSuperHeroTable();
    }   
        
} // end class
