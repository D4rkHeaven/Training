package lopatin.behavioral.state.states;

import lopatin.behavioral.state.ui.Hero;

/**
 * Состояние покоя для героя. В этом состоянии он может перейти в режим боя или начать двигаться.
 */
public class StoppedState extends State {

    public StoppedState(Hero hero) {
        super(hero);
    }

    @Override
    public String onStop() {
       return "Hero already stopped";
    }

    @Override
    public String onMove() {
        hero.changeState(new MovingState(hero));
        return "Moving";
    }

    @Override
    public String onAttack() {
        hero.changeState(new FightingState(hero));
        return "Hero ready to fight";
    }

    @Override
    public String onBlock() {
        hero.changeState(new FightingState(hero));
        return "Hero ready to fight";
    }
}
