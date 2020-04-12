package lopatin.chat.chat;

import lombok.extern.slf4j.Slf4j;
import lopatin.chat.exception.EmptyChatException;
import lopatin.chat.entity.Sms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Chat {
    private static final int CAPACITY = 25;
    private List<Sms> chatSmsList = Collections.synchronizedList(new ArrayList<>());
    private List<Sms> bufferSmsList = Collections.synchronizedList(new ArrayList<>());
    private Lock lock = new ReentrantLock();

    public String addSMS(String text) {
        lock.lock();
        try {
            if (chatSmsList.size() < CAPACITY) {
                chatSmsList.add(new Sms(text));
                log.info("New message added: {}", text);
            } else {
                bufferSmsList.add(new Sms(text));
                log.info("New message added to buffer: {}", text);
            }
        } finally {
            lock.unlock();
        }
        return text;
    }

    public String readSms() {
        lock.lock();
        try {
            if (!chatSmsList.isEmpty()) {
                Sms sms = chatSmsList.remove(0);
                if (!bufferSmsList.isEmpty()) {
                    chatSmsList.add(bufferSmsList.remove(0));
                    log.info("Messages left in buffer: {}", bufferSmsList.size());
                }
                log.info("Messages left in chat: {}", chatSmsList.size());
                log.info("Read message: {}", sms.getText());
                return sms.getText();
            }
        } finally {
            lock.unlock();
        }
        throw new EmptyChatException("Can't read the message because message list is empty");
    }

    public String updateSms() {
        lock.lock();
        try {
            if (!chatSmsList.isEmpty()) {
                Sms sms = chatSmsList.get(ThreadLocalRandom.current().nextInt(chatSmsList.size()));
                sms.setText(sms.getText() + " updated");
                log.info("Updated message: {}", sms.getText());
                return sms.getText();
            }
        } finally {
            lock.unlock();
        }
        throw new EmptyChatException("Can't update the message because message list is empty");
    }
}
