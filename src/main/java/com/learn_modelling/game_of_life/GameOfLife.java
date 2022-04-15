package com.learn_modelling.game_of_life;

public class GameOfLife {

    private GameState state;

    public GameState state() {
        return state;
    }

    public GameOfLife(GameState seed) {
        this.state = seed;
    }

    public void tick() {
        this.state = this.state.nextState();
    }
}
