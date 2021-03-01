package com.ynz.challenge.boardgame.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameLogTest {

    @Test
    void createGameLog() {
        GameLog log = GameLog.create();
        assertNotNull(log);
    }

    @Test
    void writeGameScoresForPersons() {
        Person a = new Person("A");
        Person b = new Person("B");
        Person c = new Person("C");
        Person d = new Person("D");

        GameLog log = GameLog.create();

        //write game score for a,b,c, excluding d
        log.writePersonScore(a, 1);
        log.writePersonScore(b, 2);
        log.writePersonScore(b, 3);
        log.writePersonScore(c, 4);
        log.writePersonScore(c, 5);
        log.writePersonScore(c, 6);

        List<Integer> personAGameLog = log.readPersonScore(a);
        List<Integer> personBGameLog = log.readPersonScore(b);
        List<Integer> personCGameLog = log.readPersonScore(c);
        List<Integer> personDGameLog = log.readPersonScore(d);

        assertAll(
                () -> assertNotNull(personAGameLog),
                () -> assertNotNull(personBGameLog),
                () -> assertNotNull(personCGameLog),
                () -> assertThat(personAGameLog, hasSize(1)),
                () -> assertThat(personBGameLog, hasSize(2)),
                () -> assertThat(personCGameLog, hasSize(3)),
                () -> assertThat(personDGameLog, hasSize(0))
        );

    }

    @Test
    void whenWriteNullPersonAndOrScore_ThrowIllegalArgumentException() {
        GameLog log = GameLog.create();
        Person a = new Person("A");

        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> log.writePersonScore(null, 1)),
                () -> assertThrows(IllegalArgumentException.class, () -> log.writePersonScore(a, null)),
                () -> assertThrows(IllegalArgumentException.class, () -> log.writePersonScore(null, null))
        );
    }

}