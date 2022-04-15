package com.learn_modelling.game_of_life;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {
    @Test
    void shouldHaveValuesWhenInitialized() {
        Cell cell = new Cell(2, 3);

        assertEquals(cell.getX(), 2);
        assertEquals(cell.getY(), 3);
    }

    @Test
    void shouldCompareOneCellToAnother() {
        Cell cell = new Cell(2, 3);
        Cell anotherCell = new Cell(2, 3);

        assertEquals(cell, anotherCell);
    }
}
