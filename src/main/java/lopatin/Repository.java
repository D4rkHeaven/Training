package lopatin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Repository for working with human
 */
public class Repository<T extends Human> {
    private Logger fileAndConsoleLogger = LoggerFactory.getLogger(Repository.class);
    private static final int HIGHEST_ALLOWED_ID = 100;
    private static final int RESERVED_ID = 2;

    /**
     * Generate one person with random fields
     *
     * @param human generated person
     * @return human object
     */
    public Human get(Human human) throws EntityNotFound {
        Human.Address address = new Human().new Address();
        human.setId((int) (Math.random() * 10 + 1));
        human.setName(stringGen());
        human.setBirthDate(new Date((long) (Math.random() * 100000)));
        address.setCity(stringGen());
        address.setStreet(stringGen());
        human.setAddress(address);
        if (human.getId() > HIGHEST_ALLOWED_ID) {
            fileAndConsoleLogger.warn("Человек с id = {} не найден", human.getId());
            throw new EntityNotFound("Человек с id " + human.getId() + " не найден");
        }
        fileAndConsoleLogger.info("Человек с id = {} сгенерирован", human.getId());
        return human;
    }

    /**
     * Generate list with i persons
     *
     * @param i number of persons
     * @return list of persons
     */
    public List<Human> getAll(int i) throws EntityNotFound {
        ArrayList<Human> humanList = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            try {
                Human human = new Human();
                humanList.add(get(human));
            } catch (EntityNotFound e) {
                fileAndConsoleLogger.warn("Невозможно получить список людей");
                throw new EntityNotFound("Невозможно получить список людей");
            }
        }
        return humanList;
    }

    /**
     * Save human in DB
     *
     * @param human object human
     */
    public void save(Human human) {
        if (human.getId() <= RESERVED_ID) {
            fileAndConsoleLogger.warn("Человек с id = {} не может быть сохранен в БД. Этот ID зарезервирован.", human.getId());
            throw new CannotSaveEntity("Человек с id=" + human.getId() + " не может быть сохранен в БД. Этот ID зарезервирован.");
        }
        System.out.println(human);
        fileAndConsoleLogger.info("Человек с id = {} сохранен", human.getId());
    }

    /**
     * Save list of humans in DB
     *
     * @param humanList list of humans
     */
    public void saveAll(List<Human> humanList) {
        for (Human human : humanList) {
            System.out.println(human);
        }
    }

    private String stringGen() {
        String string = "randomletters";
        StringBuilder randString = new StringBuilder();
        int count = (int) (Math.random() * 8 + 2);
        for (int i = 0; i < count; i++)
            randString.append(string.charAt((int) (Math.random() * string.length())));
        return randString.toString();
    }
}
