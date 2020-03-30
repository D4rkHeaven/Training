package lopatin.behavioral.state.states;

import lopatin.behavioral.state.ui.Hero;

/**
 * Состояние движения для героя. В этом состоянии он не может атаковать, возможно лишь остановиться.
 */
public class MovingState extends State {

    MovingState(Hero hero) {
        super(hero);
    }

    @Override
    public String onStop() {
        hero.changeState(new StoppedState(hero));
        return "Hero stopped";
    }

    @Override
    public String onMove() {
        return "Hero can't move faster!";
    }

    @Override
    public String onAttack() {
        return "Hero can't attack when moving";
    }

    @Override
    public String onBlock() {
        return "Hero can't block when moving";
    }
}
