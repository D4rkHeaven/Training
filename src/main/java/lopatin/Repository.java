package lopatin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
// Репозиторий для работы с dto
public class Repository<T extends Human> {
    /* Костыль для генерации случайных строк */
    private String stringGen() {
        String string = "randomletters";
        StringBuilder randString = new StringBuilder();
        int count = (int) (Math.random() * 8 + 2);
        for (int i = 0; i < count; i++)
            randString.append(string.charAt((int) (Math.random() * string.length())));
        return randString.toString();
    }

    // Генерация одного человека
     Human get(Human human) {
        Human.Address address = new Human().new Address();
        human.setID((int) (Math.random() * 10));
        human.setName(stringGen());
        human.setBirthDate(new Date((long) (Math.random() * 100000)));
        address.setCity(stringGen());
        address.setStreet(stringGen());
        human.setAddress(address);
        return human;
    }

    // Генерация i-го количества людей
     List<Human> getAll(int i) {
        Repository rep = new Repository();
        ArrayList<Human> list = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            Human human = new Human();
            list.add(rep.get(human));
        }
        return list;
    }

    // Сохранение записи в БД
     void save(Human human) {
        System.out.println(human);
    }

    // Сохранение всех людей в БД
     void saveAll(List<Human> humans) {
        for (Human go : humans) {
            System.out.println(go);
        }
    }
}
