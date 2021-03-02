package com.ynz.challenge.boardgame.rules;

import com.ynz.challenge.boardgame.domain.Cup;
import com.ynz.challenge.boardgame.domain.Dice;
import com.ynz.challenge.boardgame.rules.context.BoardGameContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
class ThrowAgainStateTest {

    @MockBean
    private Cup cup;

    @Test
    void givenScore6_FollowedBy4_GoBackToUnqualifiedState() {
        Dice dice = new Dice();
        dice.setScore(6);

        Dice dice1 = new Dice();
        dice1.setScore(4);

        when(cup.shake()).thenReturn(dice, dice1);

        ThrowAgainState throwAgainState = new ThrowAgainState(cup);
        BoardGameContext context = new BoardGameContext(throwAgainState);

        context.play();

        State nextState = context.getCurrentState();
        assertTrue(nextState instanceof UnqualifiedState);
    }

    @Test
    void givenScore6_KeepCurrentState() {
        Dice dice = new Dice();
        dice.setScore(6);

        when(cup.shake()).thenReturn(dice);

        ThrowAgainState throwAgainState = new ThrowAgainState(cup);
        BoardGameContext context = new BoardGameContext(throwAgainState);

        context.play();

        State nextState = context.getCurrentState();

        assertTrue(nextState instanceof ThrowAgainState);
        assertTrue(context.getTotalScore() > 0);
    }


    @Test
    void givenScore4_KeepCurrentStateAndSumNegatively() {
        Dice dice = new Dice();
        dice.setScore(4);

        when(cup.shake()).thenReturn(dice);

        ThrowAgainState throwAgainState = new ThrowAgainState(cup);
        BoardGameContext context = new BoardGameContext(throwAgainState);

        context.play();

        State nextState = context.getCurrentState();

        assertTrue(nextState instanceof ThrowAgainState);
        assertTrue(context.getTotalScore() < 0);
    }

    @Test
    void givenScore2_KeepCurrentStateSumPositively() {
        Dice dice = new Dice();
        dice.setScore(2);

        when(cup.shake()).thenReturn(dice);

        ThrowAgainState throwAgainState = new ThrowAgainState(cup);
        BoardGameContext context = new BoardGameContext(throwAgainState);

        context.play();

        State nextState = context.getCurrentState();

        assertTrue(nextState instanceof ThrowAgainState);
        assertTrue(context.getTotalScore() > 0);
    }

}