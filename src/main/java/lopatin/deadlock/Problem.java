package lopatin.deadlock;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Problem {

    public static void main(String[] args) {
        final Increment a = new Increment();
        final Increment b = new Increment();
        Runnable block1 = () -> {
            synchronized (a) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    log.error("Thread error", e);
                }
                synchronized (b) {
                    log.info("Initial value i = {}", a.getI());
                    a.incI();
                    log.info("i incremented  {}", a.getI());
                }
            }
        };

        Runnable block2 = () -> {
            synchronized (b) {
                a.incI();
                synchronized (a) {
                    log.info("i incremented  {}", a.getI());
                }
            }
        };

        new Thread(block1).start();
        new Thread(block2).start();
    }
}

