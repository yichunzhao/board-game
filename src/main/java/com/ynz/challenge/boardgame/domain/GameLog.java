package com.ynz.challenge.boardgame.domain;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@Component
public class GameLog {

    private Map<Person, LinkedList<Integer>> personDicesLog = new HashMap<>();

    private GameLog() {
    }

    public static GameLog create() {
        return new GameLog();
    }

    void writePersonScore(Person person, Integer score) {
        if (person == null || score == null) throw new IllegalArgumentException("null values not allowed");

        if (personDicesLog.get(person) == null) personDicesLog.put(person, new LinkedList<>());
        personDicesLog.get(person).add(score);
    }

    LinkedList<Integer> readPersonScore(Person person) {
        if (person == null) throw new IllegalArgumentException("null person not allowed");

        LinkedList<Integer> scores = personDicesLog.get(person);

        if (scores == null) return new LinkedList();

        return new LinkedList(scores);
    }

}
