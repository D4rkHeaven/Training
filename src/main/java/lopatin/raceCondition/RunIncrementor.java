package lopatin.raceCondition;

public class RunIncrementor implements Runnable {
    @Override
    public void run() {
        Incrementor incrementor = new Incrementor();
        for (int i = 0; i < 100; i++) {
            incrementor.incrementValue();
            incrementor.getValue();
        }
    }
}
