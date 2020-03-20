package lopatin.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

@Slf4j
public class FileWrite {
    public static void writeLines(String fileName, List<String> lineList) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, false))) {
            for (int i = 0; i < lineList.size() - 1; i++) {
                bufferedWriter.write(lineList.get(i) + "\n");
            }
            bufferedWriter.write(lineList.get(lineList.size() - 1));
        } catch (Exception e) {
            log.error(e.getMessage());
            System.out.println("Ошибка при записи в файл");
        }
    }
}
