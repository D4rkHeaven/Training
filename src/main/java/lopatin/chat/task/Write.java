package lopatin.chat.task;

import lopatin.chat.chat.Chat;

import java.util.concurrent.atomic.AtomicInteger;

public class Write extends Task {
    private AtomicInteger atomicInteger;

    public Write(Chat chat, AtomicInteger atomicInteger) {
        super(chat);
        this.atomicInteger = atomicInteger;
    }

    @Override
    public String call() {
        String text = "сообщение №" + atomicInteger.incrementAndGet();
        return chat.addSMS(text);
    }
}
