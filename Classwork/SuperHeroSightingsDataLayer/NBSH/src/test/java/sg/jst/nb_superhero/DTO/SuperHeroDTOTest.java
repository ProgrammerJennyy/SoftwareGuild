/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package sg.jst.nb_superhero.DTO;

import static org.junit.jupiter.api.Assertions.*;

class SuperHeroDTOTest {
    private SuperHeroDTO m_dto ;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.out.println("SuperHeroDTOTest setUp");
        m_dto= new SuperHeroDTO();
        m_dto.setDescription("Description");
        m_dto.setSuperHeroId(33);
        m_dto.setName("Jenny");
        m_dto.setSuperPower("Coffee");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("SuperHeroDTOTest tearDown");
        
    }

    @org.junit.jupiter.api.Test
    void getSuperHeroId() {
        System.out.println("SuperHeroDTOTest getSuperHeroId");
        assertEquals(33,m_dto.getSuperHeroId());
    }

    @org.junit.jupiter.api.Test
    void setSuperHeroId() {
        System.out.println("SuperHeroDTOTest setSuperHeroId");
        m_dto.setSuperHeroId(22);
        assertEquals(22,m_dto.getSuperHeroId());
        m_dto.setSuperHeroId(33);
    }

    @org.junit.jupiter.api.Test
    void getName() {
        System.out.println("SuperHeroDTOTest getName");
        assertEquals("Jenny",m_dto.getName());
    }

    @org.junit.jupiter.api.Test
    void setName() {
        System.out.println("SuperHeroDTOTest setName");
         m_dto.setName("NotJenny");
        assertEquals("NotJenny",m_dto.getName());
        m_dto.setName("Jenny");
    }

    @org.junit.jupiter.api.Test
    void getSuperPower() {
        System.out.println("SuperHeroDTOTest getSuperPower");        
        assertEquals("Coffee",m_dto.getSuperPower());
    }

    @org.junit.jupiter.api.Test
    void setSuperPower() {
         System.out.println("SuperHeroDTOTest setSuperPower");        
        m_dto.setSuperPower("NotCoffee");
        assertEquals("NotCoffee",m_dto.getSuperPower());
        m_dto.setSuperPower("Coffee");
    }

    @org.junit.jupiter.api.Test
    void getDescription() {
        System.out.println("SuperHeroDTOTest getDescription");        
        assertEquals("Description",m_dto.getDescription());
    }

    @org.junit.jupiter.api.Test
    void setDescription() {
        System.out.println("SuperHeroDTOTest setDescription");        
        m_dto.setDescription("NotDescription");
        assertEquals("NotDescription",m_dto.getDescription());
        m_dto.setDescription("Description");
    }
}