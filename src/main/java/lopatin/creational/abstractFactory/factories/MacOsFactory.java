package lopatin.creational.abstractFactory.factories;

import lopatin.creational.abstractFactory.buttons.Button;
import lopatin.creational.abstractFactory.buttons.MacOsButton;
import lopatin.creational.abstractFactory.checkboxes.Checkbox;
import lopatin.creational.abstractFactory.checkboxes.MacOsCheckbox;

public class MacOsFactory implements GuiFactory {

    @Override
    public Button createButton() {
        return new MacOsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOsCheckbox();
    }
}
