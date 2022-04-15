package com.learn_modelling.game_of_life;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.learn_modelling.game_of_life.PatternSeedFactory.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GameOfLifeTest {
    @Test
    void shouldHaveCellsWhenSeeded() {
        GameOfLife gameOfLife = new GameOfLife();
        List<Cell> cells = block();

        gameOfLife.seed(cells);

        assertTrue(cells.stream().allMatch(gameOfLife::hasLivingCell));
    }

    @Test
    void shouldStillHaveLifeWhenSeededWithBlock() {
        GameOfLife gameOfLife = new GameOfLife();
        List<Cell> cells = block();
        gameOfLife.seed(cells);

        gameOfLife.tick();

        assertTrue(cells.stream().allMatch(gameOfLife::hasLivingCell));
    }

    @Test
    void shouldStillHaveLifeWhenSeededWithBoat() {
        GameOfLife gameOfLife = new GameOfLife();
        List<Cell> cells = boat();
        gameOfLife.seed(cells);

        gameOfLife.tick();

        assertTrue(cells.stream().allMatch(gameOfLife::hasLivingCell));
    }

    @Test
    void shouldOscillateWhenSeededWithBlinker() {
        GameOfLife gameOfLife = new GameOfLife();
        List<Cell> cells = blinker();
        List<Cell> expected = blinkerOutput();
        gameOfLife.seed(cells);

        gameOfLife.tick();

        assertTrue(expected.stream().allMatch(gameOfLife::hasLivingCell));
    }

    @Test
    void shouldOscillateInTwoPhaseWhenSeededWithToad() {
        GameOfLife gameOfLife = new GameOfLife();
        List<Cell> cells = toad();
        List<Cell> expected = toadOutput();
        gameOfLife.seed(cells);

        gameOfLife.tick();

        assertTrue(expected.stream().allMatch(gameOfLife::hasLivingCell));
    }
}
