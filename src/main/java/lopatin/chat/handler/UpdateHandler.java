package lopatin.chat.handler;

import lombok.extern.slf4j.Slf4j;
import lopatin.chat.task.Task;

import java.util.Random;
@Slf4j
public class UpdateHandler extends TaskHandler {
    public UpdateHandler(Task task, int period) {
        super(task, period);
    }

    @Override
    public void run() {
        Random rnd = new Random();
        while (true) {
            try {
                String modifiedSmsText = executeTask(period);
                log.info("Изменение Updater : {}", modifiedSmsText);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }
}
