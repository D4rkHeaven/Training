package lopatin.creational.prototype;


import java.util.ArrayList;
import java.util.List;

/**
 * Приложение создаёт 3 элемента Gui, проверяя каждый на идентичность и уникальность.
 */
public class Main {

    public static void main(String[] args) {
        List<GuiElement> elements = new ArrayList<>();
        List<GuiElement> elementsCopy = new ArrayList<>();

        Button button1 = new Button();
        button1.x = 10;
        button1.y = 20;
        button1.name = "button";
        button1.label = "test";
        elements.add(button1);

        Button button2 = (Button) button1.clone();
        elements.add(button2);

        Checkbox checkbox = new Checkbox();
        checkbox.check = true;
        elements.add(checkbox);

        cloneAndCompare(elements, elementsCopy);
    }

    private static void cloneAndCompare(List<GuiElement> elements, List<GuiElement> elementsCopy) {
        for (GuiElement element : elements) {
            elementsCopy.add(element.clone());
        }

        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) != elementsCopy.get(i)) {
                System.out.println(i + ": Shapes are different objects");
                if (elements.get(i).equals(elementsCopy.get(i))) {
                    System.out.println(i + ": And they are identical");
                } else {
                    System.out.println(i + ": But they are not identical");
                }
            } else {
                System.out.println(i + ": Shape objects are the same");
            }
        }
    }
}