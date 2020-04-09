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
    public void run() {
        Random rnd = new Random();
        while (true) {
            int time = rnd.nextInt(secTo - secFrom) + secFrom;
            try {
                String writedSmsText = executeTask(time);
                log.info("Запись Writer :" + Thread.currentThread().getName() + ": Записано: " + writedSmsText);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }
}
