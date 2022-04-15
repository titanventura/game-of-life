package com.learn_modelling.game_of_life;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class GameOfLife {

    private List<Cell> cells;
    private List<Cell> nextGeneration;
    private HashSet<Cell> visited;

    public static List<Cell> seedForBlockPattern() {
        int[] xs = new int[]{1, 1, 2, 2};
        int[] ys = new int[]{1, 2, 1, 2};
        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < xs.length; i++) {
            cells.add(new Cell(xs[i], ys[i]));
        }
        return cells;
    }

    public GameOfLife() {
        this.cells = new ArrayList<>();
    }

    public void seed(List<Cell> seedCells) {
        this.cells.addAll(seedCells);
    }

    public boolean hasLivingCell(Cell cell) {
        return cells.contains(cell);
    }

    public void nextGeneration() {
        nextGeneration = new ArrayList<>();
        visited = new HashSet<>();

        for (Cell cell : cells) {

            updateCell(cell);
            List<Cell> allNeighbours = cell.allNeighbours();

            for (Cell neighbour : allNeighbours) {
                updateCell(neighbour);
            }
        }

        cells = nextGeneration;

        nextGeneration = null;
        visited = null;
    }

    private void updateCell(Cell cell) {
        if (visited.contains(cell)) return;

        visited.add(cell);

        List<Cell> allNeighbours = cell.allNeighbours();
        int noOfLivingNeighbours = filterLivingCells(allNeighbours).size();

        if (hasLivingCell(cell)) {
            if (noOfLivingNeighbours == 2 || noOfLivingNeighbours == 3) nextGeneration.add(cell);
        } else {
            if (noOfLivingNeighbours == 3) nextGeneration.add(cell);
        }
    }

    private List<Cell> filterLivingCells(List<Cell> cells) {
        return cells.stream().filter(cell -> this.hasLivingCell(cell)).collect(Collectors.toList());
    }
}
