package lopatin.creational.prototype;

public class Checkbox extends GuiElement {
    public boolean check;

    public Checkbox() {
    }

    public Checkbox(Checkbox target) {
        super(target);
        if (target != null) {
            this.check = target.check;
        }
    }

    @Override
    public GuiElement clone() {
        return new Checkbox(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Checkbox) || !super.equals(object2)) return false;
        Checkbox button2 = (Checkbox) object2;
        return button2.check == check;
    }

}
