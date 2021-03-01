package com.ynz.challenge.boardgame.domain;

import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class CupTest {
    @Autowired
    private Cup cup;

    @RepeatedTest(3)
    void testShakeDiceInCup() {
        Dice dice = cup.shake();
        assertAll(
                () -> assertNotNull(dice),
                () -> assertThat(dice.getScore(), is(greaterThan(0))),
                () -> assertThat(dice.getScore(), is(lessThan(7)))
        );
    }

}