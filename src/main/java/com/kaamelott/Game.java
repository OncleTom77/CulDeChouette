package com.kaamelott;

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
}
