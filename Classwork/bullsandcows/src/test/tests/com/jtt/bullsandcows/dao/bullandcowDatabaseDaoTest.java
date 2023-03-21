package com.jtt.bullsandcows.dao;

import com.jtt.bullsandcows.dto.bullandcowTurn;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;

import com.jtt.bullsandcows.dto.bullandcowTurn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;


public class bullandcowDatabaseDaoTest {
    private JdbcTemplate jdbcTemplate;
    public bullandcowDatabaseDao bandcdd;
    @Before
    public void setUp() throws Exception {
        this.bandcdd=new bullandcowDatabaseDao(jdbcTemplate) ;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void maxGameId() {
        assertEquals(bandcdd.maxGameId(),6);
    }

    @Test
    public void getAll() {
        List<bullandcowTurn> data;
        data = bandcdd.getAll();
        assertEquals(data.get(0).getGameId(),1);
    }

    @Test
    public void findById() {
        List<bullandcowTurn> data;
        data = bandcdd.findById(1);
        assertEquals(data.get(0).getGameId(),1);
    }
}