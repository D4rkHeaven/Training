package lopatin.creational.abstractFactory;

import lopatin.creational.abstractFactory.buttons.Button;
import lopatin.creational.abstractFactory.checkboxes.Checkbox;
import lopatin.creational.abstractFactory.factories.GuiFactory;

/**
 * Код, использующий фабрику, не волнует с какой конкретно фабрикой он работает.
 * Все получатели продуктов работают с продуктами через абстрактный интерфейс.
 */
public class App {
    private Button button;
    private Checkbox checkbox;

    public App(GuiFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
