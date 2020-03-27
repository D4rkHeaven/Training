package lopatin.structural.flyweight;

import java.awt.*;

public class Main {
    static int CANVAS_SIZE = 500;
    static int BUTTONS_TO_DRAW = 10000000;
    static int BUTTON_HASH_TYPES = 2;

    public static void main(String[] args) {
        Application application = new Application();
        for (int i = 0; i < Math.floor(BUTTONS_TO_DRAW / BUTTON_HASH_TYPES); i++) {
            application.makeButton(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
                    "Green button", Color.GREEN, "Some button info");
            application.makeButton(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
                    "Blue button", Color.BLUE, "Another button info");
        }
        application.setSize(CANVAS_SIZE, CANVAS_SIZE);
        application.setVisible(true);

        System.out.println(BUTTONS_TO_DRAW + " trees drawn");
        System.out.println("---------------------");
        System.out.println("Memory usage:");
        System.out.println("Button size (8 bytes) * " + BUTTONS_TO_DRAW);
        System.out.println("+ ButtonHash size (~30 bytes) * " + BUTTON_HASH_TYPES + "");
        System.out.println("---------------------");
        System.out.println("Total: " + ((BUTTONS_TO_DRAW * 8 + BUTTON_HASH_TYPES * 30) / 1024 / 1024) +
                "MB (instead of " + ((BUTTONS_TO_DRAW * 38) / 1024 / 1024) + "MB)");
    }

    private static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}
