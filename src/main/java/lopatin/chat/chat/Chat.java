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

    private List<Sms> chatSmsList = Collections.synchronizedList(new ArrayList<>());
    private List<Sms> bufferSmsList = Collections.synchronizedList(new ArrayList<>());
    private static final int CAPACITY = 25;
    private Lock lock = new ReentrantLock();

    public String addSMS(String text) {
        lock.lock();
        try {
            if (chatSmsList.size() < CAPACITY) {
                chatSmsList.add(new Sms(text));
                log.info("Добавлено сообщение в чат {}", text);
            } else {
                bufferSmsList.add(new Sms(text));
                log.info("Добавлено сообщение в буфер {}", text);
            }
        } finally {
            lock.unlock();
        }
        return text;
    }

    public String readSms() throws InterruptedException {
        lock.lock();
        try {
            if (!chatSmsList.isEmpty()) {
                Sms sms = chatSmsList.remove(0);
                if (!bufferSmsList.isEmpty()) {
                    chatSmsList.add(bufferSmsList.remove(0));
                }
                log.info("Размер чата: {}", chatSmsList.size());
                log.info("Размер буфера: {}", bufferSmsList.size());
                log.info("Прочитанно сообщение {}", sms.getText());
                return sms.getText();
            }
        } finally {
            lock.unlock();
        }
        throw new InterruptedException("Не удалось считать смс, чат пуст");
    }

    public String updateSms() {
        lock.lock();
        try {

            if (!chatSmsList.isEmpty()) {
                int randomIndex = ThreadLocalRandom.current().nextInt(chatSmsList.size());
                Sms sms = chatSmsList.get(randomIndex);
                sms.setText(sms.getText() + " modified");
                log.info("Измененно сообщение {}", sms.getText());
                return sms.getText();
            }
        } finally {
            lock.unlock();
        }
        throw new EmptyChatException("Изменение сообщения не удалось, список сообщений пуст");

    }
}
