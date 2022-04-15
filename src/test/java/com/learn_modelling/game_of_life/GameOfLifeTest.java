package com.learn_modelling.game_of_life;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.learn_modelling.game_of_life.SeedFactory.blockPattern;
import static com.learn_modelling.game_of_life.SeedFactory.boatPattern;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GameOfLifeTest {
    @Test
    void shouldHaveCellsWhenSeeded() {
        GameOfLife board = new GameOfLife();
        List<Cell> cells = blockPattern();

        board.seed(cells);

        for (Cell cell : cells) {
            assertTrue(board.hasLivingCell(cell));
        }
    }

    @Test
    void shouldStillHaveLifeWhenSeededWithBlockPattern() {
        GameOfLife gameOfLife = new GameOfLife();
        List<Cell> cells = blockPattern();
        gameOfLife.seed(cells);

        gameOfLife.tick();

        for (Cell cell : cells) {
            assertTrue(gameOfLife.hasLivingCell(cell));
        }
    }

    @Test
    void shouldStillHaveLifeWhenSeededWithBoatPattern() {
        GameOfLife gameOfLife = new GameOfLife();
        List<Cell> cells = boatPattern();
        gameOfLife.seed(cells);

        gameOfLife.tick();

        for (Cell cell : cells) {
            assertTrue(gameOfLife.hasLivingCell(cell));
        }
    }
}
