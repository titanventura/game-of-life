package com.learn_modelling.game_of_life;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.learn_modelling.game_of_life.GameOfLife.seedForBlockPattern;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GameOfLifeTest {
    @Test
    void shouldHaveCellsWhenSeeded() {
        GameOfLife board = new GameOfLife();
        List<Cell> cells = seedForBlockPattern();

        board.seed(cells);

        for (Cell cell : cells) {
            assertTrue(board.hasLivingCell(cell));
        }
    }

    @Test
    void shouldStillHaveLifeWhenSeededWithBlockPattern() {
        GameOfLife gameOfLife = new GameOfLife();
        List<Cell> cells = seedForBlockPattern();
        gameOfLife.seed(cells);

        gameOfLife.nextGeneration();

        for (Cell cell : cells) {
            assertTrue(gameOfLife.hasLivingCell(cell));
        }
    }
}
