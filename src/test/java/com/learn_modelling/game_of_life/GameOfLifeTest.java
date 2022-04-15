package com.learn_modelling.game_of_life;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.learn_modelling.game_of_life.PatternSeedFactory.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GameOfLifeTest {
    @Test
    void shouldHaveCellsWhenSeeded() {
        GameOfLife board = new GameOfLife();
        List<Cell> cells = block();

        board.seed(cells);

        for (Cell cell : cells) {
            assertTrue(board.hasLivingCell(cell));
        }
    }

    @Test
    void shouldStillHaveLifeWhenSeededWithBlock() {
        GameOfLife gameOfLife = new GameOfLife();
        List<Cell> cells = block();
        gameOfLife.seed(cells);

        gameOfLife.tick();

        for (Cell cell : cells) {
            assertTrue(gameOfLife.hasLivingCell(cell));
        }
    }

    @Test
    void shouldStillHaveLifeWhenSeededWithBoat() {
        GameOfLife gameOfLife = new GameOfLife();
        List<Cell> cells = boat();
        gameOfLife.seed(cells);

        gameOfLife.tick();

        for (Cell cell : cells) {
            assertTrue(gameOfLife.hasLivingCell(cell));
        }
    }

    @Test
    void shouldOscillateWhenSeededWithBlinker() {
        GameOfLife gameOfLife = new GameOfLife();
        List<Cell> cells = blinker();
        List<Cell> expected = blinkerOutput();
        gameOfLife.seed(cells);

        gameOfLife.tick();

        for (Cell cell : expected) {
            assertTrue(gameOfLife.hasLivingCell(cell));
        }
    }

    @Test
    void shouldOscillateInTwoPhaseWhenSeededWithToad() {
        GameOfLife gameOfLife = new GameOfLife();
        List<Cell> cells = toad();
        List<Cell> expected = toadOutput();
        gameOfLife.seed(cells);

        gameOfLife.tick();

        for (Cell cell : expected) {
            assertTrue(gameOfLife.hasLivingCell(cell));
        }
    }
}
