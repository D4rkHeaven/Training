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
        pattern = Pattern.compile("[Dd]elete *[\\d]{0,3} *[\\w]+.txt");
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
        List<String> lineList = FileParser.parseToLines(fileName);
        if (hasLineNumber) {
            if (lineToDelete > lineList.size()) {
                log.error("Введён неправильный номер строки");
                throw new InvalidCommandException("Введён неправильный номер строки");
            }
            lineList.remove(lineToDelete - 1);
        } else {
            lineList.remove(lineList.size() - 1);
        }
        FileWrite.writeLines(fileName, lineList);
    }
}
