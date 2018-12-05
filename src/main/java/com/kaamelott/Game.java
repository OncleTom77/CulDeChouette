package com.kaamelott;

import java.util.Objects;

class Game {

    private GameState state;

    private Game(GameState initialState) {
        this.state = initialState;
    }

    static Game of(GameState initialState) {
        return new Game(initialState);
    }

    void play() {
        while(state.hasNext()) {
            state = state.nextState();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(state, game.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state);
    }

    @Override
    public String toString() {
        return "Game{" +
                "state=" + state +
                '}';
    }
}
