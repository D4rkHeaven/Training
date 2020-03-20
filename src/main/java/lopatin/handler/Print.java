package lopatin.handler;

import lombok.extern.slf4j.Slf4j;
import lopatin.util.FilePrint;
import lopatin.util.InvalidCommandException;

import java.util.Scanner;
import java.util.regex.Pattern;

@Slf4j
public class Print implements CommandHandler {
    Pattern pattern;

    @Override
    public void handle(String command) throws InvalidCommandException {
        pattern = Pattern.compile("[Pp]rint *[\\d]{0,3} *[\\w]+.txt");
        if (!pattern.matcher(command).matches()) {
            log.error("Команда print введена неверно");
            throw new InvalidCommandException("Команда print введена неверно");
        }
        Scanner scanner = new Scanner(command);
        scanner.next();
        int lineNumber = 0;
        boolean hasLineNumber;
        hasLineNumber = scanner.hasNextInt();
        if (hasLineNumber) {
            lineNumber = scanner.nextInt();
        }
        if (hasLineNumber && lineNumber <= 0) {
            log.error("Введен неправильный номер строки");
            throw new InvalidCommandException("Введен неправильный номер строки");
        }
        String fileName = scanner.next();
        if (hasLineNumber) FilePrint.printLine(fileName, lineNumber);
        else FilePrint.printAll(fileName);

    }
}
