/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package sg.jst.nb_superhero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.time.LocalDateTime;
import java.util.List;
    
/**
 *
 * @author Jenny
 */
 
@SpringBootApplication
public class NB_SuperHero  {
        
  
    public static void main(String args[]) {
        System.out.println("Hello World!");
        SpringApplication.run(NB_SuperHero.class, args);
        
    }
    
  
        
} // end class
