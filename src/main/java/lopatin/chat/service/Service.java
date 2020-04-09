package lopatin.chat.service;

import lopatin.chat.chat.Chat;
import lopatin.chat.handler.ReadHandler;
import lopatin.chat.handler.TaskHandler;
import lopatin.chat.handler.UpdateHandler;
import lopatin.chat.handler.WriteHandler;
import lopatin.chat.task.Read;
import lopatin.chat.task.Task;
import lopatin.chat.task.Update;
import lopatin.chat.task.Write;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Service {
    private static final int WRITER_NUMBER = 4;
    private static final int READER_NUMBER = 2;
    private static final int UPDATER_NUMBER = 2;
    private Chat chat;
    private AtomicInteger messageCounter;

    public Service() {
        chat = new Chat();
        messageCounter = new AtomicInteger(0);
    }

    public void startChat() {
        Task writerTask = new Write(chat, messageCounter);
        Task readerTask = new Read(chat);
        Task updaterTask = new Update(chat);
        TaskHandler writerTaskExecutor = new WriteHandler(writerTask, 20, 60);
        TaskHandler readerTaskExecutor = new ReadHandler(readerTask, 30, 50);
        TaskHandler updaterTaskExecutor = new UpdateHandler(updaterTask, 40);
        ExecutorService executorService = Executors.newFixedThreadPool(8);

        for (int i = 0; i < WRITER_NUMBER; i++) {
            executorService.execute(writerTaskExecutor);
        }
        for (int i = 0; i < READER_NUMBER; i++) {
            executorService.execute(readerTaskExecutor);
        }
        for (int i = 0; i < UPDATER_NUMBER; i++) {
            executorService.execute(updaterTaskExecutor);
        }
        executorService.shutdown();
    }
}
