package com.ynz.challenge.boardgame.rules;

import com.ynz.challenge.boardgame.rules.context.AbstractContext;

public interface State {

    void doAction(AbstractContext context);
}
