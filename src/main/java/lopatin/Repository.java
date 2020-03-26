package lopatin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Repository for working with human
 */
public class Repository {
    /**
     * Generate one person with random fields
     *
     * @param human generated person
     * @return human object
     */
    public Human get(Human human) {
        Human.Address address = new Human().new Address();
        human.setId((int) (Math.random() * 10));
        human.setName(stringGen());
        human.setBirthDate(new Date((long) (Math.random() * 100000)));
        address.setCity(stringGen());
        address.setStreet(stringGen());
        human.setAddress(address);
        return human;
    }

    /**
     * Generate list with i persons
     *
     * @param i number of persons
     * @return list of persons
     */
    public List<Human> getAll(int i) {
        ArrayList<Human> list = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            Human human = new Human();
            list.add(get(human));
        }
        return list;
    }

    /**
     * Save human in DB
     *
     * @param human object human
     */
    public void save(Human human) {
        System.out.println(human);
    }

    /**
     * Save list of humans in DB
     *
     * @param humans list of humans
     */
    public void saveAll(List<Human> humans) {
        for (Human human : humans) {
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
