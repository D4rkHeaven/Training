package lopatin.creational.prototype;

public class Button extends GuiElement {
    public String label;

    public Button() {
    }

    public Button(Button target) {
        super(target);
        if (target != null) {
            this.label = target.label;
        }
    }

    @Override
    public GuiElement clone() {
        return new Button(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Button) || !super.equals(object2)) return false;
        Button button2 = (Button) object2;
        return button2.label.equals(label);
    }

}
