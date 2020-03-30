package lopatin.behavioral.state;

import lopatin.behavioral.state.ui.Hero;
import lopatin.behavioral.state.ui.Ui;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero();
        Ui ui = new Ui(hero);
        ui.init();
    }
}
