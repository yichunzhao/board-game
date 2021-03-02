package com.ynz.challenge.boardgame.rules;

import com.ynz.challenge.boardgame.domain.Cup;
import com.ynz.challenge.boardgame.rules.context.AbstractContext;

/**
 *  after a player achieving the first 6, he become a qualified player.
 */
public class QualifiedState implements State {
    private Cup cup;

    public QualifiedState(Cup cup) {
        this.cup = cup;
    }

    @Override
    public void doAction(AbstractContext context) {
        context.setNextState(new ThrowAgainState(cup));

    }

}
