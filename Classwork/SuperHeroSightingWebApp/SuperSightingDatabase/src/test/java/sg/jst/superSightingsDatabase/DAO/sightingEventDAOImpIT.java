/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package sg.jst.superSightingsDatabase.DAO;

import java.util.List;

import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sg.jst.superSightingsDatabase.DTO.sightingEventDTO;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.jdbc.core.JdbcTemplate;
import sg.jst.superSightingsDatabase.DTO.SuperHeroDTO;
import sg.jst.superSightingsDatabase.DTO.sightingLocationDTO;

/**
 *
 * @author Jenny
 */
// @RunWith(SpringRunner.class)
@SpringBootTest
public class sightingEventDAOImpIT {

    // @Autowired
    public sightingEventDAOImp instance;
    public sightingEventDTO m_dto;

    // @Autowired
    public SuperHeroDAOImp shinstance;
    public SuperHeroDTO m_shdto;

    // @Autowired
    public sightingLocationDAOImp slinstance;
    public sightingLocationDTO m_sldto;

    @Autowired
    public final JdbcTemplate jdbc;

    @Autowired
    public sightingEventDAOImpIT(JdbcTemplate jdbcTemplate) {
        this.jdbc = jdbcTemplate;
        instance = new sightingEventDAOImp(jdbcTemplate);
        shinstance = new SuperHeroDAOImp(jdbcTemplate);
        slinstance = new sightingLocationDAOImp(jdbcTemplate);

    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        System.out.println("setUp");

        m_shdto = new SuperHeroDTO();
        m_shdto.setName("SuperMan");
        m_shdto.setSuperPowerId(1);
        m_shdto.setDescription("flys and strong");
        m_shdto = shinstance.CreateSuperHero(m_shdto);

        m_sldto = new sightingLocationDTO();
        m_sldto.setName("NewYork City");
        m_sldto = slinstance.CreatesightingLocation(m_sldto);

        m_dto = new sightingEventDTO();
        m_dto.setEventDate("2023-5-23");
        m_dto.setSL_ID(m_sldto.getSL_ID());
        m_dto.setSuperHeroId(m_shdto.getSuperHeroId());

    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() {
        System.out.println("tearDown");
        instance.DeletesightingEvent(m_dto);
        shinstance.DeleteSuperHero(m_shdto);
        slinstance.DeletesightingLocation(m_sldto);

    }

    /**
     * Test of CreatesightingEvent method, of class sightingEventDAOImp.
     */
    @org.junit.jupiter.api.Test
    public void testCreatesightingEvent() {
        System.out.println("CreatesightingEvent");
        m_dto.setSightingEventId(0);
        m_dto = instance.CreatesightingEvent(m_dto);
        assertNotEquals(0, m_dto.getSightingEventId());
    }

    /**
     * Test of ReadAll method, of class sightingEventDAOImp.
     */
    @org.junit.jupiter.api.Test
    public void testReadAll() {
        System.out.println("ReadAll");
        if (m_dto.getSightingEventId() == 0) {
            testCreatesightingEvent();
        }
        int pass = 0;
        List<sightingEventDTO> result = instance.ReadAll();
        for (sightingEventDTO dto : result) {
            if (dto.getSightingEventId() == m_dto.getSightingEventId()) {
                pass = 1;
            }
        }
        assertEquals(1, pass);

    }

    /**
     * Test of GetsightingEventById method, of class sightingEventDAOImp.
     */
    @org.junit.jupiter.api.Test
    public void testGetsightingEventById() {
        System.out.println("GetsightingEventById");
        if (m_dto.getSightingEventId() == 0) {
            testCreatesightingEvent();
        }
        sightingEventDTO result = instance.GetsightingEventById(m_dto.getSightingEventId());
        assertEquals(m_dto.getSightingEventId(), result.getSightingEventId());
    }

    /**
     * Test of UpdatesightingEvent method, of class sightingEventDAOImp.
     */
    @org.junit.jupiter.api.Test
    public void testUpdatesightingEvent() {
        System.out.println("UpdatesightingEvent");
        if (m_dto.getSightingEventId() == 0) {
            testCreatesightingEvent();
        }
        m_dto.setEventDate("2024-01-01 02:42:03");
        instance.UpdatesightingEvent(m_dto);
        m_dto = instance.GetsightingEventById(m_dto.getSightingEventId());
        int pass = 0;
        String test=m_dto.getEventDate();
        if (test.equals("2024-01-01 02:42:03")) {
            pass = 1;
        }
        assertEquals(1, pass);

    }

    /**
     * Test of DeletesightingEvent method, of class sightingEventDAOImp.
     */
    @org.junit.jupiter.api.Test
    public void testDeletesightingEvent() {
        System.out.println("DeletesightingEvent");
        if (m_dto.getSightingEventId() == 0) {
            testCreatesightingEvent();
        }
        instance.DeletesightingEvent(m_dto);
        sightingEventDTO result = instance.GetsightingEventById(m_dto.getSightingEventId());
        int pass = 0;
        if (null == result) {
            pass = 1;
        }
        assertEquals(1, pass);

    }

}
