package com.ynz.challenge.boardgame.config;

import com.ynz.challenge.boardgame.domain.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {
    @Value("${game.player.count}")
    private int count;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean("allPlayers")
    public List<Person> players() {
        Person personA = new Person("A");
        Person personB = new Person("B");
        Person personC = new Person("C");
        Person personD = new Person("D");

        return Arrays.asList(personA, personB, personC, personD);
    }

    @Bean("playerCount")
    public int playerCount() {
        return count;
    }

}
