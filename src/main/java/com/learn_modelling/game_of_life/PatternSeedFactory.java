package com.learn_modelling.game_of_life;

import java.util.ArrayList;
import java.util.List;

public class PatternSeedFactory {
    public static List<Cell> block() {
        int[] xs = new int[]{1, 1, 2, 2};
        int[] ys = new int[]{1, 2, 1, 2};
        return generateBoardState(xs, ys);
    }

    public static List<Cell> boat() {
        int[] xs = new int[]{0, 1, 2, 0, 1};
        int[] ys = new int[]{1, 0, 1, 2, 2};
        return generateBoardState(xs, ys);
    }


    public static List<Cell> blinker() {
        int[] xs = new int[]{1, 1, 1};
        int[] ys = new int[]{1, 0, 2};
        return generateBoardState(xs, ys);
    }

    public static List<Cell> blinkerOutput() {
        int[] xs = new int[]{1, 0, 2};
        int[] ys = new int[]{1, 1, 1};
        return generateBoardState(xs, ys);
    }

    public static List<Cell> toad() {
        int[] xs = new int[]{1, 1, 1, 2, 2, 2};
        int[] ys = new int[]{1, 2, 3, 2, 3, 4};
        return generateBoardState(xs, ys);
    }

    public static List<Cell> toadOutput() {
        int[] xs = new int[]{0, 1, 1, 2, 2, 3};
        int[] ys = new int[]{2, 1, 4, 1, 4, 3};
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
