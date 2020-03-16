package lopatin.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
@Slf4j
public class FileWrite {
    public static void writeLines(String fileName, List<String> lines){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, false))){
            for (int i=0 ; i<lines.size() - 1; i++) {
                bufferedWriter.write(lines.get(i) + "\n");
            }
            bufferedWriter.write(lines.get(lines.size()-1));
        } catch (Exception e){
            log.error(e.getMessage());
            System.out.println("Ошибка при записи в файл");
        }
    }
}
