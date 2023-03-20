package com.jtt.bullsandcows.dto;

public class bullandcowTurn {

    private int gameId;
    private String roundTime;
    private String guess;
    private String secret;
    private boolean finished;

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getRoundTime() {
        return roundTime;
    }

    public void setRoundTime(String todo) {
        this.roundTime = todo;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}