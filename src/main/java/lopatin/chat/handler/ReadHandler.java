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
    public void run() {
        Random rnd = new Random();
        while (true) {
            int time = rnd.nextInt(secTo - secFrom) + secFrom;
            try {
                String smsText = executeTask(time);
                log.info("Чтение: Ридер " + Thread.currentThread().getName() + " достал смс: " + smsText);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }
}
