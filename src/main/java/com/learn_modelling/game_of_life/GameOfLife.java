package com.learn_modelling.game_of_life;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class GameOfLife {

    private List<Cell> cells;
    private List<Cell> nextGeneration;
    private HashSet<Cell> visited;


    public GameOfLife() {
        this.cells = new ArrayList<>();
        resetTick();
    }

    public void seed(List<Cell> seedCells) {
        this.cells.addAll(seedCells);
    }

    public boolean hasLivingCell(Cell cell) {
        return cells.contains(cell);
    }

    public void tick() {
        initTick();
        updateGeneration();
        resetTick();
    }

    private void initTick() {
        nextGeneration = new ArrayList<>();
        visited = new HashSet<>();
    }

    private void updateGeneration() {
        this.cells.forEach(cell -> {
            updateCell(cell);
            List<Cell> allNeighbours = cell.allNeighbours();
            allNeighbours.forEach(this::updateCell);
        });
        this.cells = nextGeneration;
    }

    private void resetTick() {
        this.nextGeneration = null;
        this.visited = null;
    }

    private void updateCell(Cell cell) {
        if (this.visited.contains(cell)) return;

        this.visited.add(cell);

        List<Cell> allNeighbours = cell.allNeighbours();
        int noOfLivingNeighbours = filterLivingCells(allNeighbours).size();

        if (!hasLivingCell(cell) && noOfLivingNeighbours == 3) {
            this.nextGeneration.add(cell);
            return;
        }

        if (noOfLivingNeighbours == 2 || noOfLivingNeighbours == 3) this.nextGeneration.add(cell);
    }

    private List<Cell> filterLivingCells(List<Cell> cells) {
        return cells.stream().filter(this::hasLivingCell).collect(Collectors.toList());
    }
}
