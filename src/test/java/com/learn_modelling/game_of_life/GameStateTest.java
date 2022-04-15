package com.learn_modelling.game_of_life;

import org.junit.jupiter.api.Test;

import static com.learn_modelling.game_of_life.PatternSeedFactory.blinker;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameStateTest {
    @Test
    void shouldCompareOneGameStateToTheOther() {
        GameState state = blinker();
        GameState other = blinker();

        assertEquals(state, other);
        assertEquals(state.hashCode(), other.hashCode());
    }
}
