package com.learn_modelling.game_of_life;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GameState {
    private final List<Cell> cells;
    private List<Cell> nextGeneration;
    private HashSet<Cell> visited;

    public GameState(List<Cell> cells) {
        this.cells = new ArrayList<>(cells);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameState gameState = (GameState) o;
        List<Cell> otherCells = gameState.cells;
        return cells.containsAll(otherCells) && otherCells.containsAll(cells);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cells);
    }

    public GameState nextState() {
        initTick();
        computeNextGeneration();
        GameState nextState = new GameState(this.nextGeneration);
        resetTick();
        return nextState;
    }

    private boolean hasLivingCell(Cell cell) {
        return cells.contains(cell);
    }

    private void initTick() {
        nextGeneration = new ArrayList<>();
        visited = new HashSet<>();
    }

    private void computeNextGeneration() {
        this.cells.forEach(cell -> {
            updateCell(cell);
            List<Cell> allNeighbours = cell.allNeighbours();
            allNeighbours.forEach(this::updateCell);
        });
    }


    private void updateCell(Cell cell) {
        if (visited(cell)) return;

        this.visited.add(cell);

        List<Cell> allNeighbours = cell.allNeighbours();
        int noOfLivingNeighbours = filterLivingCells(allNeighbours).size();

        if (!hasLivingCell(cell)) {
            if (noOfLivingNeighbours == 3) this.nextGeneration.add(cell);
            return;
        }

        if (noOfLivingNeighbours == 2 || noOfLivingNeighbours == 3) this.nextGeneration.add(cell);
    }

    private boolean visited(Cell cell) {
        return this.visited.contains(cell);
    }

    private List<Cell> filterLivingCells(List<Cell> cells) {
        return cells.stream().filter(this::hasLivingCell).collect(Collectors.toList());
    }


    private void resetTick() {
        this.nextGeneration = null;
        this.visited = null;
    }
}
