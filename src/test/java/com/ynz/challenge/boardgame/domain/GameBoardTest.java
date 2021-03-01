package com.ynz.challenge.boardgame.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GameBoardTest {
    @Autowired
    private GameBoard board;

    @Test
    void testBoardCreation(){
        assertNotNull(board);
        assertNotNull(board.getLog());
        assertNotNull(board.getCup());
        assertNotNull(board.getAllPersons());
    }

}