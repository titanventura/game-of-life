package com.learn_modelling.game_of_life;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cell {

    private final int x;
    private final int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return x == cell.x && y == cell.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public List<Cell> allNeighbours() {

        List<Cell> allNeighbours = new ArrayList<>();
        int[] offsets = new int[]{-1, 0, 1};

        for (Integer x : offsets) {
            for (Integer y : offsets) {
                if (x == 0 && y == 0)
                    continue;

                allNeighbours.add(new Cell(this.x + x, this.y + y));
            }
        }

        return allNeighbours;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
