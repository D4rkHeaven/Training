package lopatin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
// Репозиторий для работы с dto
public class Repository<T extends Human> {
    private Logger fileAndConsoleLogger = LoggerFactory.getLogger(Repository.class);
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
     public Human get(Human human) {
        Human.Address address = new Human().new Address();
        human.setID((int) (Math.random() * 10));
        human.setName(stringGen());
        human.setBirthDate(new Date((long) (Math.random() * 100000)));
        address.setCity(stringGen());
        address.setStreet(stringGen());
        human.setAddress(address);
        fileAndConsoleLogger.info("Человек с id = {} сгенерирован", human.getID());
        return human;
    }

    // Генерация i-го количества людей
     public List<Human> getAll(int i) {
        ArrayList<Human> list = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            Human human = new Human();
            list.add(get(human));
        }
        return list;
    }

    // Сохранение записи в БД
     public void save(Human human) {
        System.out.println(human);
         fileAndConsoleLogger.info("Человек с id = {} сохранен", human.getID());
    }


    // Сохранение всех людей в БД
    public void saveAll(List<Human> humans) {
        for (Human go : humans) {
            System.out.println(go);
        }
    }
}
