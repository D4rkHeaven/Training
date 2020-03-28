package lopatin.behavioral.state.states;

import lopatin.behavioral.state.ui.Hero;

/**
 * Состояние боя для героя. В этом состоянии он может наносить и блокировать удары, а также убежать из боя.
 */
public class FightingState extends State {

    FightingState(Hero hero) {
        super(hero);
    }

    @Override
    public String onStop() {
        hero.changeState(new StoppedState(hero));
        return "Hero flee from battle";
    }

    @Override
    public String onMove() {
        return "Hero can't move then fighting";
    }

    @Override
    public String onAttack() {
        return "Hero deal " + (int) (Math.random() * 10) + " damage.";
    }

    @Override
    public String onBlock() {
        return "Hero block " + (int) (Math.random() * 10) + " damage.";
    }
}
