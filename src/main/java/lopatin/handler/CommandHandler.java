package lopatin.handler;

import lopatin.util.InvalidCommandException;

public interface CommandHandler {
    void handle(String command) throws InvalidCommandException;
}
