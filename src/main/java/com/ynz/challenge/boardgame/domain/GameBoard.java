package com.ynz.challenge.boardgame.domain;

import com.ynz.challenge.boardgame.rules.UnqualifiedState;
import com.ynz.challenge.boardgame.rules.context.BoardGameContext;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * a cup, a dice, a couple of players and rules, on a board.
 * <p>
 * the game is driven by rules; so it is running with in a state(rule) context.
 */

@Component
@Slf4j
public class GameBoard {
    private static final int MIN_WIN_SCORE = 25;

    private final List<Person> allPersons;

    private final int count;

    private final Cup cup;

    private final List<Person> players = new LinkedList<>();

    private final Map<Person, BoardGameContext> personBoardGameContextMap = new HashMap<>();

    @Getter
    private Person winner;

    @Autowired
    public GameBoard(@Qualifier("playerCount") Integer count, Cup cup, List<Person> allPersons) {
        if (count > 4 || count < 2)
            throw new IllegalArgumentException("Player count must between 2 and 4 both included");

        this.cup = cup;
        this.count = count;
        this.allPersons = allPersons;

        populatePlayers();
        createGamingRuleContextForPersons();
    }

    private void createGamingRuleContextForPersons() {
        for (Person person : allPersons) {
            personBoardGameContextMap.put(person, new BoardGameContext(new UnqualifiedState(cup)));
        }
    }

    private void populatePlayers() {
        players.addAll(allPersons.stream().limit(count).collect(toList()));
    }

    public void playingTogether() {
        while (!hasWinner()) {
            for (Person person : players) {
                BoardGameContext context = personBoardGameContextMap.get(person);
                log.info(" Player: " + person.getName() + " >> start to play ...");
                context.play();
                log.info(" Total score: " + context.getTotalScore());
            }
        }
    }

    private boolean hasWinner() {
        boolean result = false;

        for (Person person : players) {
            if (personBoardGameContextMap.get(person).getTotalScore() >= MIN_WIN_SCORE) {
                result = true;
                this.winner = person;
                log.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                log.info("%%%%%% THE WINNER IS : " + person.getName() + " %%%%%%%%%%");
                log.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                break;
            }
        }

        return result;
    }

}
