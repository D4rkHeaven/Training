package lopatin.structural.flyweight;

import java.awt.*;

public class Button {
    private int x;
    private int y;
    private ButtonHash type;

    public Button(int x, int y, ButtonHash type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw(Graphics g) {
        type.draw(g, x, y);
    }
}
