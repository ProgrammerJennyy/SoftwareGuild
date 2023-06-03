package sg.jst.superSightingsDatabase.DTO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class superPowerDTOTest {

    private superPowerDTO spDTO;

    @BeforeEach
    void setUp() {
        spDTO = new superPowerDTO();
        spDTO.setSuperPowerName("Losing Packages");
        spDTO.setSuperPowerId(33);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getSuperPower() {
        assertEquals("Losing Packages", spDTO.getSuperPowerName());
    }

    @Test
    void setSuperPower() {
        spDTO.setSuperPowerName("Delivery");
        assertEquals("Delivery", spDTO.getSuperPowerName());

    }

    @Test
    void getSuperPowerId() {
        assertEquals(33, spDTO.getSuperPowerId());
    }

    @Test
    void setSuperPowerId() {
        spDTO.setSuperPowerId(42);
        assertEquals(42, spDTO.getSuperPowerId());

    }
}