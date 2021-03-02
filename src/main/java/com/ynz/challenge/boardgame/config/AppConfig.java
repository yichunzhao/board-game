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

    @Value("${game.player.name_a}")
    private String nameA;

    @Value("${game.player.name_b}")
    private String nameB;

    @Value("${game.player.name_c}")
    private String nameC;

    @Value("${game.player.name_d}")
    private String nameD;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean("allPlayers")
    public List<Person> players() {
        Person personA = new Person(nameA);
        Person personB = new Person(nameB);
        Person personC = new Person(nameC);
        Person personD = new Person(nameD);

        return Arrays.asList(personA, personB, personC, personD);
    }

    @Bean("playerCount")
    public int playerCount() {
        return count;
    }

}
