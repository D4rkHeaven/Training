package lopatin.chat.handler;

import lombok.extern.slf4j.Slf4j;
import lopatin.chat.task.Task;

import java.util.concurrent.*;
@Slf4j
public abstract class TaskHandler implements Runnable {
    protected Task task;
    protected ExecutorService executorService;
    protected int secFrom;
    protected int secTo;
    protected int period;


    public TaskHandler(Task task, int secFrom, int secTo) {
        this.executorService = Executors.newSingleThreadExecutor();
        this.task = task;
        this.secFrom = secFrom;
        this.secTo = secTo;
    }

    public TaskHandler(Task task, int period) {
        this.executorService = Executors.newSingleThreadExecutor();
        this.task = task;
        this.period = period;
    }

    public String executeTask(int time) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(task);
        log.info("Time "+getClass().getSimpleName()+": "+Thread.currentThread().getName()+": time=" + time);
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(time));
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        executorService.execute(futureTask);
        return futureTask.get();
    }
}
