package com.ynz.challenge.boardgame.rules;

import com.ynz.challenge.boardgame.domain.Cup;
import com.ynz.challenge.boardgame.domain.Dice;
import com.ynz.challenge.boardgame.rules.context.AbstractContext;

/**
 * After getting first 6, then this player becoming qualified to accumulate score.
 * <p>
 * The player have to throw the dice again, to determine a starting point, referred as a throwing-again state.
 * <p>
 * On this state:
 * <p>
 * if you throw a 6, then you get an extra throw, but the first 6 is not accumulated.
 * if you throw a 6, then a 4; you have to go back to the unqualified state; you have to achieve a 6 first.
 * if you throw a 4, then sum -4
 * if you throw a 1,2,3,5 then sum positively.
 */
public class ThrowAgainState implements State {
    private Cup cup;

    public ThrowAgainState(Cup cup) {
        this.cup = cup;
    }

    @Override
    public void doAction(AbstractContext context) {
        //throw dice again; to determine the starting point.
        Dice dice = cup.shake();

        int score = dice.getScore();

        //when getting a score 6, getting one extra throw
        if (score == 6) {
            //score 6, getting an extra dice rolling
            int extraScore = cup.shake().getScore();
            //a 6 followed by a 4; have to roll another 6 before start accumulating.
            //so go back to unqualified state
            if (extraScore == 4) {
                context.setNextState(new UnqualifiedState(cup));
                return;
            }

            //Getting a 6 on the first try will give 0; so we only sum the extra score.
            context.sum(extraScore);
            context.setNextState(this);
        }
        //4 leads to a penalty -4
        else if (score == 4) {
            context.sum(-4);
            context.setNextState(this);
        } else {
            //sum up 1,2,3,5
            context.sum(score);
            context.setNextState(this);
        }
    }

}
