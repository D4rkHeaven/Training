package lopatin.handler;

import lombok.extern.slf4j.Slf4j;
import lopatin.util.FileParser;
import lopatin.util.FileWrite;
import lopatin.util.InvalidCommandException;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
@Slf4j
public class Delete implements CommandHandler {
    Pattern pattern;
    @Override
    public void handle(String command) throws InvalidCommandException {
        pattern = Pattern.compile("^(delete) *[\\d]{0,3} *([\\w]+[\\w.]*)$");
        if (!pattern.matcher(command).matches()) {
            log.error("Команда delete введена неверно");
            throw new InvalidCommandException("Команда delete введена неверно");
        }
        Scanner scanner = new Scanner(command);
        scanner.next();
        int lineToDelete = 1;
        boolean hasLineNumber = scanner.hasNextInt();
        if (hasLineNumber) {
            lineToDelete = scanner.nextInt();
        }
        String fileName = scanner.next();
        List<String> lines = FileParser.parseToLines(fileName);
        if (hasLineNumber) {
            if (lineToDelete > lines.size()) {
                log.error("Введён неправильный номер строки");
                throw new InvalidCommandException("Введён неправильный номер строки");
            }
            lines.remove(lineToDelete - 1);
        } else {
            lines.remove(lines.size() - 1);
        }
        FileWrite.writeLines(fileName, lines);
    }
}
