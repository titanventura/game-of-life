package com.learn_modelling.game_of_life;

import org.junit.jupiter.api.Test;

import static com.learn_modelling.game_of_life.PatternSeedFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GameOfLifeTest {
    @Test
    void shouldHaveCellsWhenSeeded() {
        GameState seed = block();
        GameOfLife gameOfLife = new GameOfLife(seed);

        assertEquals(seed, gameOfLife.state());
    }

    @Test
    void shouldStillHaveLifeWhenSeededWithBlock() {
        GameState seed = block();
        GameOfLife gameOfLife = new GameOfLife(seed);

        gameOfLife.tick();

        assertEquals(seed, gameOfLife.state());
    }

    @Test
    void shouldStillHaveLifeWhenSeededWithBoat() {
        GameState seed = boat();
        GameOfLife gameOfLife = new GameOfLife(seed);

        gameOfLife.tick();

        assertEquals(seed, gameOfLife.state());
    }

    @Test
    void shouldOscillateWhenSeededWithBlinker() {
        GameState seed = blinker();
        GameOfLife gameOfLife = new GameOfLife(seed);
        GameState expected = blinkerOutput();

        gameOfLife.tick();

        assertEquals(expected, gameOfLife.state());
    }

    @Test
    void shouldOscillateInTwoPhaseWhenSeededWithToad() {
        GameState seed = toad();
        GameOfLife gameOfLife = new GameOfLife(seed);
        GameState expected = toadOutput();

        gameOfLife.tick();

        assertEquals(expected, gameOfLife.state());
    }
}
