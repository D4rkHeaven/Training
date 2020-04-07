package lopatin.deadlock;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Solution {

    public static void main(String[] args) {
        final Increment a = new Increment();
        final Increment b = new Increment();
        Runnable block1 = () -> {
            synchronized (b) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    log.error("Thread error", e);
                }
                synchronized (a) {
                    log.info("Initial value i = {}", a.getI());
                    a.incI();
                    log.info("i incremented from a = {}", a.getI());
                }
            }
        };

        Runnable block2 = () -> {
            synchronized (b) {
                a.incI();
                synchronized (a) {
                    log.info("i incremented from b = {}", a.getI());
                }
            }
        };

        new Thread(block1).start();
        new Thread(block2).start();
    }
}

