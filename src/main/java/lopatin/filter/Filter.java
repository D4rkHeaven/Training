package lopatin.filter;

import lombok.extern.slf4j.Slf4j;
import lopatin.handler.*;
import lopatin.util.InvalidCommandException;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Command mapper
 */
@Slf4j
public class Filter {
    HashMap<String, CommandType> commandType;
    HashMap<CommandType, CommandHandler> handlerType;
    Pattern pattern;

    public Filter() {
        pattern = Pattern.compile("(([Aa]dd|[Pp]rint|[Dd]elete) *[\\d]{0,3} *([\\w]+.txt) *(\"[ \\w\\d]*\")?)|([Ee]xit)");
        commandType = new HashMap<>();
        handlerType = new HashMap<>();
        commandType.put("add", CommandType.ADD);
        commandType.put("print", CommandType.PRINT);
        commandType.put("delete", CommandType.DELETE);
        commandType.put("exit", CommandType.EXIT);
        handlerType.put(CommandType.ADD, new Add());
        handlerType.put(CommandType.PRINT, new Print());
        handlerType.put(CommandType.DELETE, new Delete());
        handlerType.put(CommandType.EXIT, new Exit());
    }

    public void execute(String command) throws InvalidCommandException {
        if (pattern.matcher(command).matches()) {
            System.out.println("Команда распознана");
            Scanner scanner = new Scanner(command);
            scanner.useDelimiter(" ");
            CommandType commandType = this.commandType.get(scanner.next().toLowerCase());
            handlerType.get(commandType).handle(command);
        } else {
            log.error("Команда не распознана");
            throw new InvalidCommandException("Команда не распознана");
        }
    }
}
