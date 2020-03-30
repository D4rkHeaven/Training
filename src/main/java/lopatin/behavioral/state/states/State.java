package lopatin.behavioral.state.states;

import lopatin.behavioral.state.ui.Hero;

public abstract class State {
    Hero hero;

    State(Hero hero) {
        this.hero = hero;
    }

    public abstract String onStop();

    public abstract String onMove();

    public abstract String onAttack();

    public abstract String onBlock();
}
