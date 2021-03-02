package com.ynz.challenge.boardgame;

import com.ynz.challenge.boardgame.domain.GameBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoardGameApplication implements CommandLineRunner {
    @Autowired
    private GameBoard board;

    public static void main(String[] args) {
        SpringApplication.run(BoardGameApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        board.playingTogether();
    }

}
