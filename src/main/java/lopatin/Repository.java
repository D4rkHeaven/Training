package lopatin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
// Репозиторий для работы с dto
public class Repository<T extends Human> {
    private Logger fileAndConsoleLogger = LoggerFactory.getLogger(Repository.class);
    private final int HIGHEST_ALLOWED_ID = 100;
    private final int RESERVED_ID = 2;

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
    public Human get(Human human) throws EntityNotFound {
        Human.Address address = new Human().new Address();
        human.setID((int) (Math.random() * 10+1));
        human.setName(stringGen());
        human.setBirthDate(new Date((long) (Math.random() * 100000)));
        address.setCity(stringGen());
        address.setStreet(stringGen());
        human.setAddress(address);
        if(human.getID()<HIGHEST_ALLOWED_ID){
            fileAndConsoleLogger.info("Человек с id = {} не найден",human.getID());
            throw new EntityNotFound("Человек с id "+ human.getID()+" не найден");
        }
        fileAndConsoleLogger.info("Человек с id = {} сгенерирован", human.getID());
        return human;
    }

    // Генерация i-го количества людей
    public List<Human> getAll(int i) throws EntityNotFound {
        ArrayList<Human> list = new ArrayList<>();
        for (int j = 0; j < i; j++) {
           try {
               Human human = new Human();
               list.add(get(human));
           }catch (EntityNotFound e){
               fileAndConsoleLogger.info("Невозможно получить список людей");
           }
        }
        return list;
    }

    // Сохранение записи в БД
    public void save(Human human) {
        if(human.getID()<=RESERVED_ID){
            fileAndConsoleLogger.info("Человек с id = {} не может быть сохранен в БД. Этот ID зарезервирован.",human.getID());
            throw new CannotSaveEntity("Человек с id="+human.getID()+" не может быть сохранен в БД. Этот ID зарезервирован.");
        }
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
