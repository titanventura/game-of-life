package com.learn_modelling.game_of_life;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameOfLife {

    Set<LivingCell> cells;

    public static List<LivingCell> seedForBlockPattern() {
        int[] xs = new int[]{1, 1, 2, 2};
        int[] ys = new int[]{1, 2, 1, 2};
        List<LivingCell> cells = new ArrayList<>();
        for (int i = 0; i < xs.length; i++) {
            cells.add(new LivingCell(xs[i], ys[i]));
        }
        return cells;
    }

    public GameOfLife() {
        this.cells = new HashSet<>();
    }

    public void seed(List<LivingCell> seedCells) {
        this.cells.addAll(seedCells);
    }

    public boolean hasLivingCell(LivingCell cell) {
        return cells.contains(cell);
    }
}
