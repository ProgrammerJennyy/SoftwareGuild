package com.jtt.bullsandcows.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class bullandcowServiceTest {
    public bullandcowService bcs;
    @Before
    public void setUp() throws Exception {
        bcs=new bullandcowService();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getTime() {
        assertNotEquals(bcs.GetTime(),"");
    }

    @Test
    public void createSecret() {

        assertNotEquals(bcs.GetTime(),"");
    }

    @Test
    public void checkGuess() {
        assertEquals(bcs.CheckGuess("1234","1234"),"e:4:p:0");
        assertEquals(bcs.CheckGuess("1234","5678"),"e:0:p:0");

    }
}