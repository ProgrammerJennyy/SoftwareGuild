/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package sg.jst.nb_superhero.DAO;

import java.util.List;
import sg.jst.nb_superhero.DTO.org_to_superheroDTO;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sg.jst.nb_superhero.DTO.SuperHeroDTO;
import sg.jst.nb_superhero.DTO.organizationDTO;
/**
 *
 * @author Jenny
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class org_to_superheroDAOImpIT {
    
    @Autowired
    org_to_superheroDAOImp instance;
    
    @Autowired
    SuperHeroDAOImp superinstance;
     
    @Autowired
    organizationDAOImp orginstance;
    

    int shId=0;
    int orgId=0;
    int orgId2=0;
    
    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
       System.out.println("org_to_superheroDAOImpIT setUp");
       // create superhero and organization
       SuperHeroDTO sTest= new SuperHeroDTO();
       sTest.setName("Jenny");
       sTest.setDescription("developer");
       sTest.setSuperPower("Coffee");
       sTest=superinstance.CreateSuperHero(sTest);
       shId=sTest.getSuperHeroId();

       // organization  
       organizationDTO oTest = new organizationDTO();
       oTest.setName("Costco");
       oTest.setAddress("123 Main Street");
       oTest.setCity("Somewhere");
       oTest.setState("MN");
       oTest.setZip("55316");
       oTest.setDescription("good Costco");
       oTest.setPhone("651-555-1212");
       oTest=orginstance.Createorganization(oTest);
       orgId=oTest.getOrganizationId();
       oTest.setName("Sams");
       oTest.setAddress("456 Main Street");
       oTest.setCity("noWhere");
       oTest.setState("MN");
       oTest.setZip("56416");
       oTest.setDescription("bad Sams");
       oTest.setPhone("407-555-1212");       
       oTest=orginstance.Createorganization(oTest);
       orgId2=oTest.getOrganizationId();       
     

    }
    
    @org.junit.jupiter.api.AfterEach
    public void tearDown() {
       System.out.println("org_to_superheroDAOImpIT tearDown");
       SuperHeroDTO sTest= new SuperHeroDTO();
       organizationDTO oTest = new organizationDTO();
       org_to_superheroDTO otsTest = new org_to_superheroDTO();

       sTest=superinstance.GetSuperHeroById(shId);
       superinstance.DeleteSuperHero(sTest);
       oTest=orginstance.GetorganizationById(orgId);
       orginstance.Deleteorganization(oTest);
       oTest=orginstance.GetorganizationById(orgId2);
       orginstance.Deleteorganization(oTest);
       // no need to delete org to sup should already be deleted.
       
    }

    @org.junit.jupiter.api.Test
    public void testCreateOrgToSuperhero() {
       System.out.println("org_to_superheroDAOImpIT CreateOrgToSuperhero");
       org_to_superheroDTO otsTest = new org_to_superheroDTO();
       otsTest.setSuperHeroId(shId);
       otsTest.setOrganizationId(orgId);
       otsTest = instance.CreateOrgToSuperhero(otsTest);
       otsTest=instance.OrgToSuperheroById(otsTest.getOrgToShID());
       assertNotEquals(null,otsTest);
       
       // 2nd test
       otsTest.setOrganizationId(orgId2);
       otsTest = instance.CreateOrgToSuperhero(otsTest);
       otsTest=instance.OrgToSuperheroById(otsTest.getOrgToShID());
       assertNotEquals(null,otsTest);       
    }

    @org.junit.jupiter.api.Test
    public void testReadAll() {
        int pass=0;
        System.out.println("org_to_superheroDAOImpIT ReadAll");
        // create 2 entries
        testCreateOrgToSuperhero();
        List<org_to_superheroDTO>dtos = instance.ReadAll();
        for(org_to_superheroDTO dto:dtos){
            if(dto.getSuperHeroId()==shId && dto.getOrganizationId()==orgId)
            {
                pass=1;
            }
        }
        assertEquals(1,pass);
    }

    @org.junit.jupiter.api.Test
    public void testOrgToSuperheroById() {
        System.out.println("org_to_superheroDAOImpIT OrgToSuperheroById");
        int pass=0;
        // create 2 entries
        org_to_superheroDTO first=new org_to_superheroDTO();
       org_to_superheroDTO second =null;
        
        testCreateOrgToSuperhero();
        List<org_to_superheroDTO>dtos = instance.ReadAll();
        for(org_to_superheroDTO dto:dtos){
            if(dto.getSuperHeroId()==shId && dto.getOrganizationId()==orgId)
            {
                first=dto;
                break;
            }
        }
        second=instance.OrgToSuperheroById(first.getOrgToShID());
        assertNotEquals(null,second);        
    }

    @org.junit.jupiter.api.Test
    public void testUpdateOrgToSuperhero() {
        System.out.println("org_to_superheroDAOImpIT UpdateOrgToSuperhero");
        int pass=0;
        // create 2 entries
        org_to_superheroDTO first=new org_to_superheroDTO();
       org_to_superheroDTO second =null;
        
        testCreateOrgToSuperhero();
        List<org_to_superheroDTO>dtos = instance.ReadAll();
        for(org_to_superheroDTO dto:dtos){
            if(dto.getSuperHeroId()==shId && dto.getOrganizationId()==orgId)
            {
                first=dto;
                first.setOrganizationId(orgId2);
                instance.UpdateOrgToSuperhero(first);
                break;
            }
        }
        second=instance.OrgToSuperheroById(first.getOrgToShID());
        assertEquals( orgId2,second.getOrganizationId());        
    }
    
    @org.junit.jupiter.api.Test
    public void testDeletOrgToSuperhero() {
        System.out.println("org_to_superheroDAOImpIT DeletOrgToSuperhero");
       org_to_superheroDTO otsTest = new org_to_superheroDTO();
       otsTest.setSuperHeroId(shId);
       otsTest.setOrganizationId(orgId);
       otsTest = instance.CreateOrgToSuperhero(otsTest);
       otsTest=instance.OrgToSuperheroById(otsTest.getOrgToShID());
       assertNotEquals(null,otsTest);
       instance.DeletOrgToSuperhero(otsTest);
       otsTest=instance.OrgToSuperheroById(otsTest.getOrgToShID());
       assertEquals(null,otsTest);       
    }
    
} // end class 
