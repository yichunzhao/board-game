package com.ynz.challenge.boardgame.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@Slf4j
class GameBoardTest {

    @Autowired
    private GameBoard board;

    @Test
    void testPlayThisBoardGameTogether() {
        assertNull(board.getWinner());
        board.playingTogether();
        assertNotNull(board.getWinner());
    }

}