package com.learn_modelling.game_of_life;

import java.util.ArrayList;
import java.util.List;

public class SeedFactory {
    public static List<Cell> blockPattern() {
        int[] xs = new int[]{1, 1, 2, 2};
        int[] ys = new int[]{1, 2, 1, 2};
        return generateBoardState(xs, ys);
    }

    private static List<Cell> generateBoardState(int[] xs, int[] ys) {
        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < xs.length; i++) {
            cells.add(new Cell(xs[i], ys[i]));
        }
        return cells;
    }
}
