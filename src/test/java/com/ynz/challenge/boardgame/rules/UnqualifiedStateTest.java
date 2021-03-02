package com.ynz.challenge.boardgame.rules;

import com.ynz.challenge.boardgame.domain.Cup;
import com.ynz.challenge.boardgame.domain.Dice;
import com.ynz.challenge.boardgame.rules.context.BoardGameContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class UnqualifiedStateTest {
    @MockBean
    private Cup cup;

    @Test
    void whenGivenUnqualifiedState_Dice6_TriggerToQualifiedState() {
        Dice dice = new Dice();
        dice.setScore(6);
        Mockito.when(cup.shake()).thenReturn(dice);

        UnqualifiedState unqualifiedState = new UnqualifiedState(cup);
        BoardGameContext context = new BoardGameContext(unqualifiedState);

        context.play();
        State nextState = context.getCurrentState();

        assertTrue(nextState instanceof QualifiedState);
    }

    @Test
    void whenGivenUnqualifiedState_Dice4_KeepCurrentState() {
        Dice dice = new Dice();
        dice.setScore(4);
        Mockito.when(cup.shake()).thenReturn(dice);

        UnqualifiedState unqualifiedState = new UnqualifiedState(cup);
        BoardGameContext context = new BoardGameContext(unqualifiedState);

        context.play();
        State nextState = context.getCurrentState();

        assertTrue(nextState instanceof UnqualifiedState);
    }

    @Test
    void whenGivenUnqualifiedState_Dice1_KeepCurrentState() {
        Dice dice = new Dice();
        dice.setScore(1);
        Mockito.when(cup.shake()).thenReturn(dice);

        UnqualifiedState unqualifiedState = new UnqualifiedState(cup);
        BoardGameContext context = new BoardGameContext(unqualifiedState);

        context.play();
        State nextState = context.getCurrentState();

        assertTrue(nextState instanceof UnqualifiedState);
    }

}