package lopatin.creational.abstractFactory;

import lopatin.creational.abstractFactory.factories.GuiFactory;
import lopatin.creational.abstractFactory.factories.MacOsFactory;
import lopatin.creational.abstractFactory.factories.WindowsFactory;

/**
 * Приложение выбирает тип и создаёт конкретные фабрики динамически исходя
 * из конфигурации или окружения.
 */
public class Main {
    public static void main(String[] args) {
        App app = configureApplication();
        app.paint();
    }

    private static App configureApplication() {
        App app;
        GuiFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOsFactory();
            app = new App(factory);
        } else {
            factory = new WindowsFactory();
            app = new App(factory);
        }
        return app;
    }
}
