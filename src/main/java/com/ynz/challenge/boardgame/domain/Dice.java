package com.ynz.challenge.boardgame.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Dice implements Serializable {
    private int score;
}
