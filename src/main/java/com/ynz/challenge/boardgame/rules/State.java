package com.ynz.challenge.boardgame.rules;

import com.ynz.challenge.boardgame.domain.Dice;

public interface State {

    void doAction(AbstractContext context);
}
