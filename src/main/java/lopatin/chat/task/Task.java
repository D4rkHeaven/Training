package lopatin.chat.task;

import lopatin.chat.chat.Chat;

import java.util.concurrent.Callable;

public abstract class Task implements Callable<String> {
    protected Chat chat;

    public Task(Chat chat) {
        this.chat = chat;
    }
}
