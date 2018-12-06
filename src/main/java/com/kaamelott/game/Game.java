package com.kaamelott.game;

import java.util.Objects;

public class Game {

    private GameState state;
    private final GameOutput gameOutput;

    private Game(GameState initialState, GameOutput gameOutput) {
        this.state = initialState;
        this.gameOutput = gameOutput;
    }

    static Game of(GameState initialState) {
        return of(initialState, (s) -> {});
    }

    public static Game of(GameState initialState, GameOutput gameOutput) {
        return new Game(initialState, gameOutput);
    }

    public void play() {
        while(state.hasNext()) {
            gameOutput.print(state.toString());
            state = state.nextState();
        }
        gameOutput.print(state.toString());
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
