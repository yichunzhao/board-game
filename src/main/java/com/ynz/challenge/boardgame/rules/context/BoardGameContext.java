package com.ynz.challenge.boardgame.rules.context;

import com.ynz.challenge.boardgame.rules.State;

/**
 * Play a rule-based game, a player may switch among states.
 */
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
     * play a round, like rolling a dice
     */
    public void play() {
        currentState.doAction(this);
    }

}
