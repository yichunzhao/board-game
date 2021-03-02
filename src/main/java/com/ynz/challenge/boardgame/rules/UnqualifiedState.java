package com.ynz.challenge.boardgame.rules;

import com.ynz.challenge.boardgame.domain.Cup;
import com.ynz.challenge.boardgame.domain.Dice;
import com.ynz.challenge.boardgame.rules.context.AbstractContext;

/**
 * a player is ready to go, but didn't get number 6 yet.
 */
public class UnqualifiedState implements State {
    private Cup cup;

    public UnqualifiedState(Cup cup) {
        this.cup = cup;
    }

    @Override
    public void doAction(AbstractContext context) {
        //throw a dice
        Dice dice = cup.shake();

        //if dice is 6 then go qualified state, otherwise keep at the unqualified state
        if (dice.getScore() == 6) {
            context.setNextState(new QualifiedState(cup));
        }
    }

}
