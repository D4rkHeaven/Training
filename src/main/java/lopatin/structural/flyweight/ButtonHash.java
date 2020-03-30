package lopatin.structural.flyweight;

import java.awt.*;

/**
 * Закешированные одинаковые свойства для кнопок в отдельном объекте
 */
public class ButtonHash {
    private String name;
    private Color color;
    private String buttonInfo;

    public ButtonHash(String name, Color color, String otherTreeData) {
        this.name = name;
        this.color = color;
        this.buttonInfo = otherTreeData;
    }

    public void draw(Graphics g, int x, int y) {
        g.setColor(color);
        g.fillRect(x - 1, y, 10, 5);
    }
}
