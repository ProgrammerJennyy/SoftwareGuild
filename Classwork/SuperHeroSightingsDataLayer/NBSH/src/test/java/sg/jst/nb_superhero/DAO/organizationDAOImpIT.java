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
import sg.jst.nb_superhero.DTO.organizationDTO;


/**
 *
 * @author Jenny
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class organizationDAOImpIT {

    @Autowired 
    SuperHeroDAOImp superHeroDAOImp;
    
    @Autowired
    org_to_superheroDAOImp orgtosupinstance;
      
    @Autowired
    organizationDAOImp DAOinstance;
    
    
    public organizationDTO  DTOinstance;
    
    
    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        System.out.println("setUp");
        DTOinstance= new organizationDTO();
        DTOinstance.setName("WallMart");
        DTOinstance.setAddress("221B Baker Street");
        DTOinstance.setDescription("Hide out");
        DTOinstance.setState("MN");
        DTOinstance.setZip("44421");
        DTOinstance.setCity("Brainard");
        DTOinstance.setPhone("123-555-1212");
        DTOinstance.setOrganizationId(0);
  
    }
    
    @org.junit.jupiter.api.AfterEach
    public void tearDown() {
        System.out.println("tearDown"); 
        testDeleteorganization();
    }

    @org.junit.jupiter.api.Test
    public void testCreateorganization() {
        System.out.println("Createorganization");
        organizationDTO result = DAOinstance.Createorganization(DTOinstance);
        assertNotEquals(0, result.getOrganizationId());
        if(result.getOrganizationId()!=0){
            DTOinstance=result;
        }
            
    }

    @org.junit.jupiter.api.Test
    public void testReadAll() {
        System.out.println("ReadAll");
        int pass=0;
        if(DTOinstance.getOrganizationId()==0){
            testCreateorganization();
        }        
        List<organizationDTO> dtos = DAOinstance.ReadAll();
        for(organizationDTO dto:dtos){
            if(dto.getOrganizationId()==DTOinstance.getOrganizationId())
            {
                pass=1;
            }
        }
        assertEquals(1,pass);        
    }

    @org.junit.jupiter.api.Test
    public void testGetorganizationById() {
        System.out.println("GetorganizationById");
        if(DTOinstance.getOrganizationId()==0){
            testCreateorganization();
        }          
        int id = DTOinstance.getOrganizationId();
        organizationDTO result = DAOinstance.GetorganizationById(id);
        assertEquals(DTOinstance.getOrganizationId(), result.getOrganizationId());
    }

    @org.junit.jupiter.api.Test
    public void testUpdateorganization() {        
        System.out.println("Updateorganization");
        if(DTOinstance.getOrganizationId()==0){
            testCreateorganization();
        }
        int id = DTOinstance.getOrganizationId();
        DTOinstance.setCity("Minneapolis");
        DAOinstance.Updateorganization(DTOinstance);
        organizationDTO result = DAOinstance.GetorganizationById(id);
        assertEquals(DTOinstance.getCity(), result.getCity());
      
    }

    @org.junit.jupiter.api.Test
    public void testDeleteorganization() {
        
        System.out.println("Deleteorganization");
        if(DTOinstance.getOrganizationId()==0){
            testCreateorganization();
        }
        DAOinstance.Deleteorganization(DTOinstance);
         organizationDTO result = DAOinstance.GetorganizationById(DTOinstance.getOrganizationId());
       assertEquals(null, result);
    }
    
}
