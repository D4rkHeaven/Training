package lopatin.task2;

/**
 * Написать код, который будет выбрасывать java.lang.StackOverflowError
 */
public class Main {
    public static void main(String[] args) {
        int counter = 0;
        recursion(counter);
    }

    private static void recursion(int counter) {
        recursion(counter ++);
    }
}
