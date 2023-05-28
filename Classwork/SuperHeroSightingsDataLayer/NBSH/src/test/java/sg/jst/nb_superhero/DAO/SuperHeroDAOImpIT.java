/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package sg.jst.nb_superhero.DAO;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sg.jst.nb_superhero.DTO.SuperHeroDTO;

/*
 * @author jenny
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SuperHeroDAOImpIT {

    @Autowired
    SuperHeroDAOImp superHeroDAOImp;
    int id =0;
    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        System.out.println("SuperHeroDAOImp Setup");

    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() {
        System.out.println("SuperHeroDAOImp tearDown");
        if(id!=0)
        {
            SuperHeroDTO test= new SuperHeroDTO();
            test.setSuperHeroId(id);
            superHeroDAOImp.DeleteSuperHero(test);
        }
        
    }

    @org.junit.jupiter.api.Test
    public void testCreateSuperHero() {
        System.out.println("SuperHeroDAOImp testCreateSuperHero");
        int pass=0;
        SuperHeroDTO test= new SuperHeroDTO();
        test.setName("AmazonMan");
        test.setDescription("Drives Truck");
        test.setSuperPower("Losing Packages");
        superHeroDAOImp.CreateSuperHero(test);
        List<SuperHeroDTO> dtos = superHeroDAOImp.ReadAll();
        for (SuperHeroDTO dto : dtos) {
            if(dto.getName().equals("AmazonMan")){
                pass=1;
                id=dto.getSuperHeroId();
                break;
            }
        }
        assertEquals(1,pass);        
    }

    @org.junit.jupiter.api.Test
    public void testReadAll() {
        System.out.println("SuperHeroDAOImp testReadAll");
        int pass=0;
        List<SuperHeroDTO> dtos = superHeroDAOImp.ReadAll();
        for (SuperHeroDTO dto : dtos) {
            System.out.println(dto.getName());
            pass=1;
        }
        assertEquals(1,pass);
    }
    @org.junit.jupiter.api.Test
    public void GetSuperHeroById()
    {
         System.out.println("SuperHeroDAOImp GetSuperHeroById");
        if(id==0)
        {
            testCreateSuperHero();
        }
       SuperHeroDTO test= new SuperHeroDTO();
        List<SuperHeroDTO> dtos = superHeroDAOImp.ReadAll();
        for (SuperHeroDTO dto : dtos) {
            
            if(dto.getName().equals("AmazonMan")){
                System.out.println(dto.getName());
                id=dto.getSuperHeroId();
                test = superHeroDAOImp.GetSuperHeroById(id);
          
            }
        }
        assertEquals("AmazonMan",test.getName());       
    }

    @org.junit.jupiter.api.Test
    public void UpdateSuperHero()
    {
        System.out.println("SuperHeroDAOImp UpdateSuperHero");
        if(id==0)
        {
            testCreateSuperHero();
        }
       SuperHeroDTO test= new SuperHeroDTO();
        List<SuperHeroDTO> dtos = superHeroDAOImp.ReadAll();
        for (SuperHeroDTO dto : dtos) {
            
            if(dto.getName().equals("AmazonMan")){
                System.out.println(dto.getName());
                id=dto.getSuperHeroId();
                dto.setSuperPower("Delivery");
                superHeroDAOImp.UpdateSuperHero(dto);
                break;
            }
        }
         test = superHeroDAOImp.GetSuperHeroById(id);
        assertEquals("Delivery",test.getSuperPower()); 
    }
    
    @org.junit.jupiter.api.Test
    public void DeleteSuperHero()
    {
          System.out.println("SuperHeroDAOImp DeleteSuperHero");
        int id=0;
       SuperHeroDTO test= new SuperHeroDTO();
        List<SuperHeroDTO> dtos = superHeroDAOImp.ReadAll();
        for (SuperHeroDTO dto : dtos) {
            
            if(dto.getName().equals("AmazonMan")){
                System.out.println(dto.getName());
                id=dto.getSuperHeroId();
                superHeroDAOImp.DeleteSuperHero(dto);
                break;
            }
        }
         test = superHeroDAOImp.GetSuperHeroById(id);
        assertEquals(null,test);        
    }
    
    
} // end class
