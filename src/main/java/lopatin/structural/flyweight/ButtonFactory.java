package lopatin.structural.flyweight;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ButtonFactory {
    static Map<String, ButtonHash> buttonHashTypes = new HashMap<>();

    public static ButtonHash getButtonHash(String name, Color color, String buttonInfo) {
        ButtonHash result = buttonHashTypes.get(name);
        if (result == null) {
            result = new ButtonHash(name, color, buttonInfo);
            buttonHashTypes.put(name, result);
        }
        return result;
    }
}
