package lopatin.util;

import java.util.List;

public class FilePrint {
    public static void printAll(String fileName) {
        List<String> lines = FileParser.parseToLines(fileName);
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public static void printLine(String fileName, int line) {
        List<String> lines = FileParser.parseToLines(fileName);
        System.out.println(lines.get(line - 1));
    }

}
