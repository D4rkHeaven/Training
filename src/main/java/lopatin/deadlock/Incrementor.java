package lopatin.deadlock;

public class Incrementor {
    private int value = 0;
    public int getValue() {
        return value;
    }

    public void incrementValue() {
        this.value++;
    }
}
