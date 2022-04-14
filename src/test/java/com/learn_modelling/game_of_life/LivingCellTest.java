package com.learn_modelling.game_of_life;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LivingCellTest {
    @Test
    void shouldHaveValuesWhenInitialized() {
        LivingCell cell = new LivingCell(2, 3);

        assertEquals(cell.getX(), 2);
        assertEquals(cell.getY(), 3);
    }

    @Test
    void shouldCompareOneCellToAnother() {
        LivingCell cell = new LivingCell(2, 3);
        LivingCell anotherCell = new LivingCell(2, 3);

        assertEquals(cell, anotherCell);
    }
}
