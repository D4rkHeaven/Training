package lopatin.deadlock;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Solution {

    public static void main(String[] args) {
        final Incrementor a = new Incrementor();
        final Incrementor b = new Incrementor();
        Runnable block1 = () -> {
            synchronized (b) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    log.error("Thread error", e);
                }
                synchronized (a) {
                    log.info("Initial value i = {}", a.getValue());
                    a.incrementValue();
                    log.info("i incremented from a = {}", a.getValue());
                }
            }
        };

        Runnable block2 = () -> {
            synchronized (b) {
                a.incrementValue();
                synchronized (a) {
                    log.info("i incremented from b = {}", a.getValue());
                }
            }
        };

        new Thread(block1).start();
        new Thread(block2).start();
    }
}

