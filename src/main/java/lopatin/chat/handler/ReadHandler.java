package lopatin.chat.handler;

import lombok.extern.slf4j.Slf4j;
import lopatin.chat.task.Task;

import java.util.Random;

@Slf4j
public class ReadHandler extends TaskHandler {
    public ReadHandler(Task task, int secFrom, int secTo) {
        super(task, secFrom, secTo);
    }

    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        while (true) {
            try {
                log.info("Reader with name {} read the message: {}", Thread.currentThread().getName(),
                        executeTask(new Random().nextInt(secTo - secFrom) + secFrom));
            } catch (Exception e) {
                log.warn("{}", e.getMessage());
            }
        }
    }
}
