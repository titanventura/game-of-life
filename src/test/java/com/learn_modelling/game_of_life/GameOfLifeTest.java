package com.learn_modelling.game_of_life;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.learn_modelling.game_of_life.GameOfLife.seedForBlockPattern;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GameOfLifeTest {
    @Test
    void shouldHaveCellsWhenSeeded() {
        GameOfLife board = new GameOfLife();
        List<LivingCell> cells = seedForBlockPattern();

        board.seed(cells);

        for (LivingCell cell : cells) {
            assertTrue(board.hasLivingCell(cell));
        }
    }
}