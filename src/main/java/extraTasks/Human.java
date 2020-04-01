package extraTasks;

import lopatin.mainTask.Entity;

@Entity
public class Human {
    @Value(pathToFile = "src/main/resources/humanValues.txt")
    private int age;
    @Value(pathToFile = "src/main/resources/humanValues.txt")
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human{age=" + age +
                ", name='" + name + '\'' + '}';
    }

}
