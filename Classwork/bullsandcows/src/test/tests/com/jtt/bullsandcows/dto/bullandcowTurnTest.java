package com.jtt.bullsandcows.dto;
import com.jtt.bullsandcows.dto.bullandcowTurnTest;
import static org.junit.Assert.*;

public class bullandcowTurnTest {
    public bullandcowTurn bct;
    @org.junit.Before
    public void setUp() throws Exception {
        bct = new bullandcowTurn();
        bct.setFinished(false);
        bct.setGameId(33);
        bct.setSecret("1234");
        bct.setGuess("5679");
        bct.setRoundTime("2021-03-19_12:55:44");
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void getGuess() {
        assertEquals(bct.getGuess(),"5679");
        assertNotEquals(bct.getGuess(),"9876");

    }

    @org.junit.Test
    public void setGuess() {
        bct.setGuess("1234");
        assertEquals(bct.getGuess(),"1234");
        bct.setGuess("5679");
    }

    @org.junit.Test
    public void getGameId() {
        assertEquals(bct.getGameId(),33);
        assertNotEquals(bct.getGameId(),21);
    }

    @org.junit.Test
    public void setGameId() {
        bct.setGameId(44);
        assertEquals(bct.getGameId(),44);
        bct.setGameId(33);
    }

    @org.junit.Test
    public void getRoundTime() {
        assertEquals(bct.getRoundTime(),"2021-03-19_12:55:44");
        assertNotEquals(bct.getRoundTime(),"2021-03-19_12:55:45");
    }

    @org.junit.Test
    public void setRoundTime() {
        bct.setRoundTime("2021-03-19_12:55:45");
        assertEquals(bct.getRoundTime(),"2021-03-19_12:55:45");
        bct.setRoundTime("2021-03-19_12:55:44");
    }

    @org.junit.Test
    public void getSecret() {
        assertEquals(bct.getSecret(),"1234");
        assertNotEquals(bct.getSecret(),"9876");
    }

    @org.junit.Test
    public void setSecret() {
        bct.setSecret("5679");
        assertEquals(bct.getSecret(),"5679");
        bct.setSecret("1234");
    }

    @org.junit.Test
    public void isFinished() {
        assertEquals(bct.isFinished(),false);
        assertNotEquals(bct.isFinished(),true);
    }

    @org.junit.Test
    public void setFinished() {
        bct.setFinished(true);
        assertEquals(bct.isFinished(),true);
        bct.setFinished(false);



    }
}