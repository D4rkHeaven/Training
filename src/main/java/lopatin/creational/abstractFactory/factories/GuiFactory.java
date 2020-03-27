package lopatin.creational.abstractFactory.factories;

import lopatin.creational.abstractFactory.buttons.Button;
import lopatin.creational.abstractFactory.checkboxes.Checkbox;

/**
 * Абстрактная фабрика знает обо всех (абстрактных) типах продуктов.
 */
public interface GuiFactory {
    Button createButton();

    Checkbox createCheckbox();
}
