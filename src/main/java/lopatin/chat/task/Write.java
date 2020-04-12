package lopatin.chat.task;

import lopatin.chat.chat.Chat;

import java.util.concurrent.atomic.AtomicInteger;

public class Write extends Task {
    private AtomicInteger messageCounter;

    public Write(Chat chat, AtomicInteger messageCounter) {
        super(chat);
        this.messageCounter = messageCounter;
    }

    @Override
    public String call() {
        String text = "Message №" + messageCounter.incrementAndGet();
        return chat.addSMS(text);
    }
}
