package com.ynz.challenge.boardgame.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Component
@RequiredArgsConstructor
public class Cup {
    private final RestTemplate restTemplate;

    @Value("${game.dice.url}")
    private String url;

    private Lock lock = new ReentrantLock();

    public Dice shake() {
        lock.lock();
        try {
            return restTemplate.getForObject(url, Dice.class);
        } finally {
            lock.unlock();
        }
    }

}
