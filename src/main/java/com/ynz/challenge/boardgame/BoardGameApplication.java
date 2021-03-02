package com.ynz.challenge.boardgame;

import com.ynz.challenge.boardgame.domain.GameBoard;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BoardGameApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BoardGameApplication.class, args);
        GameBoard board = context.getBean(GameBoard.class);
        board.playingTogether();
    }

}
