package lopatin.structural.flyweight;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Application extends JFrame {
    private List<Button> buttonList = new ArrayList<>();

    public void makeButton(int x, int y, String name, Color color, String buttonInfo) {
        ButtonHash type = ButtonFactory.getButtonHash(name, color, buttonInfo);
        Button button = new Button(x, y, type);
        buttonList.add(button);
    }

    @Override
    public void paint(Graphics graphics) {
        for (Button button : buttonList) {
            button.draw(graphics);
        }
    }
}
