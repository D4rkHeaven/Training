package lopatin.raceCondition;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FixedIncrementor {
    private static int value = 0;

    public void getValue() {
        log.info("value = {}", value);
    }

    public synchronized void incrementValue() {
        int tempValue = value;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Thread error", e);
        }
        tempValue++;
        value = tempValue;
    }
}
