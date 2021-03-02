package com.ynz.challenge.boardgame.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Component
@RequiredArgsConstructor
@Slf4j
public class Cup {
    private final RestTemplate restTemplate;

    @Value("${game.dice.url}")
    private String url;

    private Lock lock = new ReentrantLock();

    public Dice shake() {
        lock.lock();
        try {
            Dice dice = restTemplate.getForObject(url, Dice.class);
            log.info(" immediately after rolling dice, Current Value of Dice: " + dice.getScore());
            return dice;
        } finally {
            lock.unlock();
        }
    }

}
