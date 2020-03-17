package lopatin.handler;

import lopatin.util.InvalidCommandException;

public class Exit implements CommandHandler {
    @Override
    public void handle(String command) throws InvalidCommandException {
        System.exit(0);
    }
}