package lopatin.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FileParser {
    public static List<String> parseToLines(String fileName) throws InvalidCommandException {
        File file = new File(fileName);
        List<String> lines = new ArrayList<>();
        if (file.exists()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                while (bufferedReader.ready())
                    lines.add(bufferedReader.readLine());
            } catch (FileNotFoundException e) {
                log.error(e.getMessage());
                System.out.println("Файл не найден");
            } catch (Exception e) {
                log.error(e.getMessage());
                System.out.println("Ошибка при чтении файла");
            }
        } else {
            throw new InvalidCommandException("Файл не найден");
        }
        return lines;
    }
}
