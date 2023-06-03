/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package sg.jst.superSightingsDatabase.DAO;

import static org.junit.Assert.*;
import sg.jst.superSightingsDatabase.DTO.sightingLocationDTO;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Jenny
 */
// @RunWith(SpringRunner.class)
@SpringBootTest
public class sightingLocationDAOImpIT {
    
    // @Autowired
    public sightingLocationDAOImp instance;
     
    public final JdbcTemplate jdbc;
    
    @Autowired
    public sightingLocationDAOImpIT(JdbcTemplate jdbcTemplate) {
        this.jdbc = jdbcTemplate;
        instance = new sightingLocationDAOImp(jdbc);
    }    
    
    public sightingLocationDTO m_dto;
    
    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        m_dto = new sightingLocationDTO();
        m_dto.setName("Wells Fargo Bank");
        m_dto.setAddress("381 E Broadway");
        m_dto.setCity("Salt Lake City");
        m_dto.setState("UT");
        m_dto.setDescription("Tallest building in salt lake city.");
        m_dto.setZip("84111");
        m_dto.setLongitude(40.760813);
        m_dto.setLatitude(-111.882190);
        
    }
    
   @org.junit.jupiter.api.AfterEach
    public void tearDown() {
        if(m_dto != null){
         instance.DeletesightingLocation(m_dto);   
        }
    }

    @org.junit.jupiter.api.Test
    public void testCreatesightingLocation() {
        System.out.println("CreatesightingLocation");
        sightingLocationDTO result = instance.CreatesightingLocation(m_dto);
        assertNotEquals(0,result.getSL_ID());
    }

    @org.junit.jupiter.api.Test
    public void testReadAll() {
        System.out.println("ReadAll");
        if(m_dto.getSL_ID()==0){
           testCreatesightingLocation(); 
        }
        int pass = 0;
        List<sightingLocationDTO> result = instance.ReadAll();
        for(sightingLocationDTO dto:result){
            if(dto.getName().equals("Wells Fargo Bank")){
                pass=1;
            }
        }
        assertEquals(1, pass);
    }

    @org.junit.jupiter.api.Test
    public void testGetsightingLocationId() {
        System.out.println("GetsightingLocationId");
        if(m_dto.getSL_ID()==0){
           testCreatesightingLocation(); 
        }
        sightingLocationDTO result = instance.GetsightingLocationId(m_dto.getSL_ID());
        assertEquals(m_dto.getSL_ID(), result.getSL_ID());
        

    }

    @org.junit.jupiter.api.Test
    public void testUpdatesightingLocation() {
        System.out.println("UpdatesightingLocation");
        if (m_dto.getSL_ID() == 0) {
            testCreatesightingLocation();
        }
        m_dto.setDescription("Changing the description");
        instance.UpdatesightingLocation(m_dto);
        sightingLocationDTO result = instance.GetsightingLocationId(m_dto.getSL_ID());
        assertEquals(m_dto.getSL_ID(), result.getSL_ID());
    }

    @org.junit.jupiter.api.Test
    public void testDeletesightingLocation() {
        System.out.println("DeletesightingLocation");
        if (m_dto.getSL_ID() == 0) {
            testCreatesightingLocation();
        }
        instance.DeletesightingLocation(m_dto);
        sightingLocationDTO retval=null;
        retval = instance.GetsightingLocationId(m_dto.getSL_ID());
        int pass=0;
        if(retval==null)
        {
            pass=1;
        }
        assertEquals(1,pass);
    }
    
}
