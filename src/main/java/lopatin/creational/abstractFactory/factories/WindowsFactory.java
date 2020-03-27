package lopatin.creational.abstractFactory.factories;

import lopatin.creational.abstractFactory.buttons.Button;
import lopatin.creational.abstractFactory.buttons.WindowsButton;
import lopatin.creational.abstractFactory.checkboxes.Checkbox;
import lopatin.creational.abstractFactory.checkboxes.WindowsCheckbox;

public class WindowsFactory implements GuiFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
