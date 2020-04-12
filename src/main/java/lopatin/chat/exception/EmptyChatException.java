package lopatin.chat.exception;

public class EmptyChatException extends RuntimeException {
    public EmptyChatException(String message) {
        super(message);
    }
}
