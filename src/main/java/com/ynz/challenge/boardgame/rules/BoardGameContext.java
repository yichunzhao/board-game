package com.ynz.challenge.boardgame.rules;

public class BoardGameContext extends AbstractContext {

    public BoardGameContext(State initState) {
        super.currentState = initState;
    }

    @Override
    public State getCurrentState() {
        return super.currentState;
    }

    @Override
    public void setNextState(State nextState) {
        super.currentState = nextState;
    }

    /**
     * play a round a game, like rolling a dice
     */
    public void play() {
        currentState.doAction(this);
    }

}
