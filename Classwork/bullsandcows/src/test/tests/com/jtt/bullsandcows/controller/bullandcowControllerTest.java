package com.jtt.bullsandcows.controller;

import com.jtt.bullsandcows.dao.bullandcowDao;
import com.jtt.bullsandcows.dao.bullandcowDatabaseDao;
import com.jtt.bullsandcows.dto.bullandcowTurn;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.junit.Assert.*;

public class bullandcowControllerTest {

    private final JdbcTemplate jdbcTemplate;

    public bullandcowController bandcc;
    public   bullandcowDao dao;
    @Before
    public void setUp() throws Exception {
        dao= new bullandcowDatabaseDao();
        bandcc = new bullandcowController(dao);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void all() {
        List<bullandcowTurn> data;
        data= bandcc.all();
    }

    @Test
    public void findById() {
    }

    @Test
    public void findandSortById() {
    }
}