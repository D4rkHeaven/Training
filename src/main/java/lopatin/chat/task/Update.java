package lopatin.chat.task;

import lopatin.chat.chat.Chat;

public class Update extends Task {
    public Update(Chat chat) {
        super(chat);
    }

    @Override
    public String call() throws Exception {
        return chat.updateSms();
    }
}
