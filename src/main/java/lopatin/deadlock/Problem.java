package lopatin.deadlock;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Problem {

    public static void main(String[] args) {
        final Incrementor a = new Incrementor();
        final Incrementor b = new Incrementor();
        Runnable block1 = () -> {
            synchronized (a) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    log.error("Thread error", e);
                }
                synchronized (b) {
                    log.info("Initial value = {}", a.getValue());
                    a.incrementValue();
                    log.info("value incremented  {}", a.getValue());
                }
            }
        };

        Runnable block2 = () -> {
            synchronized (b) {
                a.incrementValue();
                synchronized (a) {
                    log.info("value incremented  {}", a.getValue());
                }
            }
        };

        new Thread(block1).start();
        new Thread(block2).start();
    }
}

