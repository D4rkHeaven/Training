package lopatin.chat.handler;

import lombok.extern.slf4j.Slf4j;
import lopatin.chat.task.Task;

@Slf4j
public class UpdateHandler extends TaskHandler {
    public UpdateHandler(Task task, int period) {
        super(task, period);
    }

    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        while (true) {
            try {
                log.info("Updater with name {} update the message: {}",
                        Thread.currentThread().getName(), executeTask(period));
            } catch (Exception e) {
                log.warn("{}", e.getMessage());
            }
        }
    }
}
