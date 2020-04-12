package lopatin.chat.handler;

import lombok.extern.slf4j.Slf4j;
import lopatin.chat.task.Task;

import java.util.Random;

@Slf4j
public class WriteHandler extends TaskHandler {
    public WriteHandler(Task task, int secFrom, int secTo) {
        super(task, secFrom, secTo);
    }

    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        while (true) {
            try {
                log.info("Writer with name {} write the message: {}", Thread.currentThread().getName(),
                        executeTask(new Random().nextInt(secTo - secFrom) + secFrom));
            } catch (Exception e) {
                log.warn("{}", e.getMessage());
            }
        }
    }
}
