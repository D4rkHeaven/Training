package lopatin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface Interface<T extends Human> {
    /* Костыль для генерации случайных строк */
    static String stringGen() {
        String string = "randomletters";
        StringBuilder randString = new StringBuilder();
        int count = (int) (Math.random() * 8 + 2);
        for (int i = 0; i < count; i++)
            randString.append(string.charAt((int) (Math.random() * string.length())));
        return randString.toString();
    }

    // Генерация одного человека
    static Human get(Human human) {
        Human.Address address = new Human.Address();
        human.setID((int) (Math.random() * 10));
        human.setName(stringGen());
        human.setBirthDate(new Date((long) (Math.random() * 100000000)));
        address.setCity(stringGen());
        address.setStreet(stringGen());
        human.setAddress(address);
        return human;
    }

    // Генерация i-го количества людей
    static List<Human> getAll(int i) {
        List<Human> list = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            Human human = new Human();
            list.add(Interface.get(human));
        }
        return list;
    }

    // Вывод инфы об одном человеке
    static void save(Human human) {
        System.out.println(human);
    }

    // Вывод инфы о всех человеках
    static void saveAll(List<Human> persons) {
        for (Human human : persons) {
            System.out.println(human);
        }
    }
}
