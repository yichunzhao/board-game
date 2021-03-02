package com.ynz.challenge.boardgame.rules;

public abstract class AbstractContext {
    protected State currentState;
    protected int totalScore;

    public abstract State getCurrentState();

    public abstract void setNextState(State nextState);

    public void sum(int score) {
        this.totalScore += score;
    }

    public int getTotalScore() {
        return totalScore;
    }
}
