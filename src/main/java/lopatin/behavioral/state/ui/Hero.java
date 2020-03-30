package lopatin.behavioral.state.ui;

import lopatin.behavioral.state.states.State;
import lopatin.behavioral.state.states.StoppedState;

public class Hero {
    private State state;

    public Hero() {
        this.state = new StoppedState(this);
    }

    public void changeState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

}
