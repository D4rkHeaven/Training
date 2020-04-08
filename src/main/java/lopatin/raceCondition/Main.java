package lopatin.raceCondition;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunIncrementor());
        Thread thread2 = new Thread(new RunIncrementor());
        // Thread thread1 = new Thread(new FixedRunIncrementor());
        // Thread thread2 = new Thread(new FixedRunIncrementor());
        thread1.start();
        thread2.start();
    }
}
