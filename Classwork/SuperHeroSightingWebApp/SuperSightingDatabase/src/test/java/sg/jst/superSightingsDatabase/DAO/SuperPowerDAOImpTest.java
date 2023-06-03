package sg.jst.superSightingsDatabase.DAO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sg.jst.superSightingsDatabase.DTO.superPowerDTO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SuperPowerDAOImpTest {

    @Autowired
    SuperPowerDAOImp superPowerDAOImp;
    int id =0;
    @BeforeEach
    void setUp() {
        System.out.println("Setup");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
        if(id!=0)
        {
            superPowerDTO test= new superPowerDTO();
            test.setSuperPowerId(id);
            superPowerDAOImp.DeleteSuperPower(test);
        }
    }

    @Test
    void createSuperPower() {
        System.out.println("superPowerDTO testCreateSuperHero");
        int pass=0;
        superPowerDTO test= new superPowerDTO();
        test.setSuperPowerName("Drives Truck");
        test.setSuperPowerId(1);
        superPowerDAOImp.CreateSuperPower(test);
        List<superPowerDTO> dtos = superPowerDAOImp.ReadAll();
        for (superPowerDTO dto : dtos) {
            if(dto.getSuperPowerName().equals("Drives Truck")){
                pass=1;
                id=dto.getSuperPowerId();
                break;
            }
        }
        assertEquals(1,pass);
    }

    @Test
    void readAll() {
        int pass=0;
        List<superPowerDTO> dtos = superPowerDAOImp.ReadAll();
        for (superPowerDTO dto : dtos) {
            System.out.println(dto.getSuperPowerName());
            pass=1;
        }
        assertEquals(1,pass);
    }

    @Test
    void getSuperPowerById() {
        if(id==0)
        {
            createSuperPower();
        }
        superPowerDTO test=superPowerDAOImp.GetSuperPowerById(id);
        assertNotEquals(null,test);
    }

    @Test
    void updateSuperPower() {
        if(id==0)
        {
            createSuperPower();
        }
        superPowerDTO test = superPowerDAOImp.GetSuperPowerById(id);
        test.setSuperPowerName("Changed SuperPower");
        superPowerDAOImp.UpdateSuperPower(test);
        superPowerDTO newtest = superPowerDAOImp.GetSuperPowerById(id);
        assertEquals("Changed SuperPower",newtest.getSuperPowerName());
    }

    @Test
    void deleteSuperPower() {
        if(id==0)
        {
            createSuperPower();
        }
        superPowerDTO test = superPowerDAOImp.GetSuperPowerById(id);
        superPowerDAOImp.DeleteSuperPower(test);
    }
}