package lopatin;

@Entity
public class Human {
    @Value
    private int age;
    @Value(name = "Sebastian")
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

    }
}
