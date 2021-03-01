package com.ynz.challenge.boardgame.domain;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * a cup, a dice, a log, a couple of players on and surrounding a table
 */

@Component
@Getter
public class GameBoard {
    private final int MIN_WIN_SCORE = 25;

    private List<Person> allPersons;

    private int count;

    private Cup cup;

    private GameLog log;

    private Deque<Person> players = new LinkedList<>();

    @Autowired
    public GameBoard(@Qualifier("playerCount") Integer count, Cup cup, GameLog log, List<Person> allPersons) {
        if (count > 4 || count < 1)
            throw new IllegalArgumentException("Player count must between 1 and 4 both included");

        this.allPersons = allPersons;
        players.addAll(allPersons.stream().limit(count).collect(toList()));

        this.cup = cup;
        this.log = log;
    }

}
