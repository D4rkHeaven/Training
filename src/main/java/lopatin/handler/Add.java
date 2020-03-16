package lopatin.handler;

import lombok.extern.slf4j.Slf4j;
import lopatin.util.FileParser;
import lopatin.util.FileWrite;
import lopatin.util.InvalidCommandException;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
@Slf4j
public class Add implements CommandHandler {
    Pattern pattern;
    @Override
    public void handle(String command) throws InvalidCommandException {
        pattern = Pattern.compile("[Aa]dd [\\d]* [\\w]+.txt \"[ \\w\\d]*\"");
        if (!pattern.matcher(command).matches()) {
            log.error("Команда add введена неверно");
            throw new InvalidCommandException("Команда add введена неверно");
        }
        Scanner scanner = new Scanner(command);
        scanner.next();
        int lineNumber = 0;
        boolean hasLineNumber = scanner.hasNextInt();
        if (hasLineNumber) {
            lineNumber = scanner.nextInt();
        }
        String fileName = scanner.next();
        String text = scanner.findInLine("\"[\\w ]*\"");
        text = text.replace("\"", "");
        List<String> lines = FileParser.parseToLines(fileName);
        if (hasLineNumber) {
            for (int i = lines.size(); i < lineNumber-1; i++) {
                lines.add("");
            }
            lines.add(lineNumber-1, text);
        } else {
            lines.add(text);
        }
        FileWrite.writeLines(fileName, lines);
    }
}
