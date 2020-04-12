package lopatin.raceCondition;

public class FixedRunIncrementor implements Runnable {
    @Override
    public void run() {
        FixedIncrementor incrementor = new FixedIncrementor();
        for (int i = 0; i < 100; i++) {
            incrementor.incrementValue();
            incrementor.getValue();
        }
    }
}
