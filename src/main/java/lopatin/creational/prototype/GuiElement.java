package lopatin.creational.prototype;

import java.util.Objects;

public abstract class GuiElement {
    public int x;
    public int y;
    public String name;

    public GuiElement() {
    }

    public GuiElement(GuiElement target) {
        if (target != null) {
            this.x = target.x;
            this.y = target.y;
            this.name = target.name;
        }
    }

    public abstract GuiElement clone();

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof GuiElement)) return false;
        GuiElement element = (GuiElement) object2;
        return element.x == x && element.y == y && Objects.equals(element.name, name);
    }
}
